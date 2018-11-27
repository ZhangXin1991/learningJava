package BiXiangDong.Set_Learning;


import java.util.*;

/*generic
* 泛型:
*   JDK 1.5 出现的安全新特性
*
* 好处:
*   - 1, 将运行时期的问题ClassCastException转到了编译时期
*   - 2, 避免了强制转换类型的麻烦
*
* 用法:
*   - <> 当操作引用数据类型不确定的时候, 就是用<>将要操作的引用数据类型传入即可
*      其实<>就是一个用于接收具体引用数据类型的参数范围, 可以传入 类名 / 接口名
*   - 在程序中只要用到了带有<>的类或者接口, 就要明确传入的具体引用数据类型
*   - 泛型技术是给编译器使用的基数, 用于编译时期, 确保了类型的安全
*   - 泛型的擦除:
*       为了兼容类加载器, 运行时会将泛型去掉, 生成的class文件中是不带泛型的
*   - 泛型的补偿:
*       在运行时, 通过获取元素的类型进行转换动作, 不用使用者再强制转换了
*
*   - 自定义泛型类:   示例三 ：自定义泛型类，泛型方法，泛型static方法
*       |- 在JDK 1.5后, 使用泛型来接收类中要操作的引用数据类型
*       |- 当类中操作的引用数据类型不确定的时候就是用泛型来表示
*   - 泛型接口：      示例四 ：
*       |-
*
*/
public class Generic_Learning {
    public static void main(String[] args) {
        /**
        * 示例一:
        * ArrayList中的泛型
        */
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("旺财");
        arrayList.add("来福");
//        arrayList.add(3123);

        //  输出:
//        for (Iterator<String> iterator = arrayList.iterator(); iterator.hasNext();) {
//            System.out.println(iterator.next());
//        }

        /**
         * 示例二:
         * TreeSet中的泛型, iterator中的泛型, compare中的泛型
         */
        TreeSet<ListPerson> treeSet = new TreeSet<ListPerson>(new ComparatorByGeneric_Learning());
        treeSet.add(new ListPerson("张欣", 28));
        treeSet.add(new ListPerson("范英博", 28));
        treeSet.add(new ListPerson("赵毅", 27));
        //  输出:
//        for (Iterator<ListPerson> iterator = treeSet.iterator(); iterator.hasNext(); ) {
//            System.out.println(iterator.next());
//        }
//        Iterator<ListPerson> it = treeSet.iterator();
//        while (it.hasNext()) {
//            System.out.println(it.next());
//        }

        //  示例三的输出:
//        Tool tool = new Tool();
//        tool.setTool(new ListPerson("张欣", 28));
//        System.out.println(tool.getTool());
//        tool.show(tool.getTool());
//        Tool.method("haha");
//        Tool.method(new Integer(10));
//        tool.setTool(1);
//        System.out.println(tool.getTool());
    }
}

class Tool<ListPerson> {
    /**
     * 示例三:
     * 将泛型定义在类上
     * 将泛型定义在方法上
     * 注意： 这个类上定义的泛型名字（ListPerson）与ListPerson类没有一毛钱关系
     *          往里传啥类型的引用数据都可以！
     */
    private ListPerson tool;

    public void setTool(ListPerson tool) {
        this.tool = tool;
    }

    public ListPerson getTool() {
        return this.tool;
    }

    //  在已经定义泛型的类中, 接收其它类型的方法写法如下:
    //  将泛型定义在方法上:
    public <ListPerson> void show(ListPerson tool) {
        System.out.println("show: " + this.tool.toString());
    }

    //  当方法是static时, 不能访问类上定义的泛型, 如果静态方法使用泛型,
    //  只能将泛型定义在方法上
    public static <ListPerson>void method(ListPerson tool) {
        System.out.println("method: " + tool);
    }
}

class ComparatorByGeneric_Learning implements Comparator<ListPerson> {
    /**
     * 这是个自定义的比较器, 用于传入TreeSet集合框架的
     * 使TreeSet集合框架将ListPerson对象按年龄排序, 如果年龄相同就按姓名排序
     * @param o1
     * @param o2
     * @return  正序
     */
    @Override
    public int compare(ListPerson o1, ListPerson o2) {
        int temp = o1.getAge() - o2.getAge();

        return temp==0? o1.getName().compareTo(o2.getName()) : temp;
    }
}

/**
 * 示例四 ：
 * 泛型接口
 * 泛型接口， 将泛型定义在接口上
 * @param <T>
 */
interface Inter<T> {
    public void show(T t);
}

//  使用泛型接口
class InterImpl implements Inter<String> {
    public void show(String string) {

    }
}
//  没啥意思。。。。。
interface Inter0<Q> {
    public void show(Q q);
}

class Inter0Impl<Q> implements Inter0<Q> {

    @Override
    public void show(Q q) {

    }
}

