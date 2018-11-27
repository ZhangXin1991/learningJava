package BiXiangDong.Set_Learning;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

/*
List中开发中常用的已知实现类:
    - ArrayList
        |- 内部是数组数据结构, 角标有序
        |- 是不同步的. 替代了Vector, 如果需要同步可以加锁
        |- 查询的速度很快
        |- 该容器判断元素是否相同的依据是equals
一下示例主要演示如何把自定义对象传入集合当中
    如: Person p = new Person("来福", 3);
        ArrayList arrayList = new ArrayList();
        arrayList.add(p);

 */
public class List_ArrayList_Demo {
    public static void main(String[] args) {

        ArrayList arrayList = new ArrayList();
        arrayList.add(new ListPerson("张欣", 28));
        arrayList.add(new ListPerson("赵毅", 27));
        arrayList.add(new ListPerson("范英博", 28));
        //  因JDK1.5版本后可以自动装箱, 所以集合中add()方法可以直接传入int类
//        arrayList.add(3);

//        for (int x = 0; x < arrayList.size(); x++) {
//            System.out.println(arrayList.get(x).toString());
//        }

        //  以下代码出现很多问题
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            /*
            问题一:
                由于iterator.add(Object obj)传入的是obj, 所以
                iterator.next()返回的也是obj,想调用Person类中的
                getName()方法就需要把iterator.next()转换成Person类
            问题二:
                由于iterator.next()方法每次调用都会取下一个对象, 所以在取同一个
                对象的两个属性不可以调用两次iterator.next()方法
                应重新将iterator.next()赋值给Person类的对象, 然后再从这个Person
                类的对象调用Person类自身的方法
             */
//            System.out.println(((ListPerson) iterator.next()).getName()
//            + " " + ((ListPerson) iterator.next()).getAge());
            //  可用:
            ListPerson ps = (ListPerson) iterator.next();
            System.out.println(ps.getName() + " " + ps.getAge());
        }
        //  打印集合中数字的类型, 结果返回Integer
//        String a = arrayList.get(3).getClass().toString();
//        System.out.println(a);    //  class java.lang.Integer
    }
}

class ListPerson implements Comparable{

    private String name;
    private int age;


    public ListPerson(String name, int age) {
        this.name = name;
        this.age = age;
//        this.speak(); // new 初始化时调用speak()方法
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void speak() {
        System.out.println(this.name + "  被调用");
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    //  覆写equals方法和hashCode方法: 用于对比对象或元素之间是否相同
    @Override
    public int hashCode() {

//        return Objects.hash(name, age);
        //  返回name的哈希值+年龄 为listPerson对象的特有哈希值;
        return name.hashCode() + age * 39;
        //  为了防止两个对象的name的哈希值与age不同, 相加之后却恰好相等,
        // 所以将age*39, 这样做是为了减少哈希冲突的几率
    }

    @Override
    public boolean equals(Object o) {
        //  判断地址是否相同
        if (this == o) return true;
        //  判断需比较的对象是否为null, 需比较的对象的类是否与被比较的类一致
        if (o == null || getClass() != o.getClass()) return false;
        //  将需比较的对象赋值给that
        ListPerson that = (ListPerson) o;
        //  返回 被比较的对象 的age 是否等于 需比较的对象 的age 与
        // 被比较的对象 的name 是否等于 需比较的对象 的name
        /*
        因为 age 为int 类型, 所以用 "==" 来判断; 而 name 为String类型,
        所以用Objects.equals(name, that.name); 来进行判断
         */
        return age == that.age &&
                Objects.equals(name, that.name);
    }


    @Override
    public int compareTo(Object o) {
        /**
         * 覆写Comparable中的compareTo方法(比较方法):用于比较对象或元素之间的大小
         * compareTo方法需要三种返回结果: -1(小) 0(相等) 1(大)
         *      注意: 在TreeSet集合框架中, 返回0则会被认为是重复对象, 重复对象
         *          不会被TreeSet存储, 所以需要更详细的判断
         * 返回-1 则this排在被传入参数的前面, 返回1则this排在被传入参数的后面
         */
        //  类型强制转换的健壮性判断
        //如果接收的参数o可以转换成ListPerson,ListPerson p=(ListPerson)o;
        ListPerson p;
        if (o instanceof ListPerson) {
            p = (ListPerson) o;
            //  this大于P 返回1, 按从小到大排序的固定写法
//            if (this.age > p.age) {
//                return 1;
//            }
//            if (this.age < p.age) {
//                return -1;
//            }
//            if (this.age == p.age) {
////                if (this.name.hashCode() > p.name.hashCode()) {
////                    return 1;
////                } else if (this.name.hashCode() < p.name.hashCode()) {
////                    return -1;
////                } else {
////                    return 0;
////                }
//// 上面的写法太烂了...基本类型String有默认的compareTo()方法, 直接调用
//                return this.name.compareTo(p.name);
//            }
//  上面的写法太烂了....基本类型int也有默认的compareTo()方法......
            int temp = this.age - p.age;
//            if (temp == 0) {
//                return this.name.compareTo(p.name);
//            } else {
//                return temp;
//            }
            //  上面if else的等价代码:
            // 返回 temp是否==0? 如果true 返回:前的代码, 否则返回:后的代码
            return temp==0? this.name.compareTo(p.name) : temp;
        }
        return 0;   // 如果不是ListPerson类型的对象, 直接返回 0
    }

}

