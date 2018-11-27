package BiXiangDong.Set_Learning;


import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/*
Set 接口 开发中常用的已知实现类:
    - TreeSet  树集合(利用红黑树,或叫二叉树
        |- 疾语TreeMap的NavigableSet实现
        |- 不同步
        |- 不可重复
            - 注意: 判断元素的唯一性的方式: 根据对象的compareTo()比较方法的
                    返回结果是否是0, 是0就认为是相同的元素, 不存储.
        |- 使用元素的自然顺序对元素进行排序(字典顺序), 或者根据对象自有的
            compareTo()方法进行排序, 具体取决于元素使用的compareTo()方法.
        |- 使用自定义比较器(Comparator)传入TreeSet集合框架进行排序
            如果不按照对象中已经定义好的compareTo()方法排序或对象中不具备
            compareTo()方法可以让TreeSet集合框架自身具备比较功能, 也就是
            自定义一个比较器传入TreeSet集合框架

    TreeSet中特有的方法:
        |- TreeSet()
            构造一个新的空set, 该set根据其元素的自带compareTo()方法进行排序
            如: 示例一 的基本类型自带compareTo
                示例二 的自定义类型覆写的compareTo
        |- TreeSet(Collection<? extends E> c)
            构造一个包含指定collection(比较器)元素的新 TreeSet, 它按照其元素的
            自带compareTo()方法进行排序
            如: 示例三 的自定义 实现Comparator接口的compare(Object o1,
                Object o2)方法 来传入TreeSet的构造函数中对传入的对象进行排序
        |- TreeSet(SortedSet<E> s)
            构造一个与指定有序set具有相同映射关系和相同排序的新TreeSet




 */
public class Set_TreeSet_Demo {
    public static void main(String[] args) {
        /**
         *  示例一:
         * 传入基本类型数据或元素, 元素自身自带compareTo()方法
         * TreeSet集合框架默认会按照字符串的字典顺序进行排序
         */
        TreeSet treeSet = new TreeSet();

        treeSet.add("赵毅");
        treeSet.add("范英博");
        treeSet.add("张欣");
        treeSet.add("来福");
        treeSet.add("旺财");
        treeSet.add("a");
        treeSet.add("ab");
        treeSet.add("cbv");
        treeSet.add("fcv");
        treeSet.add("hav");
        // 输出:
//        for (Iterator iterator = treeSet.iterator(); iterator.hasNext(); ) {
//            System.out.println(iterator.next());
//        }

        /**
         *  示例二:
         * 传入ListPerson类的实例对象
         * TreeSet集合框架默认排序无效, 需要自定义ListPerson类的CompareTo方法
         * 以ListPerson对象的 age的参数 进行从小到大排序
         * 具体见 :
         *      package     BiXiangDong.Set_Learning
         *      class       ListPerson
         *      method      compareTo
         */
        TreeSet treeSet1 = new TreeSet();
        treeSet1.add(new ListPerson("来福", 3));
        treeSet1.add(new ListPerson("旺财", 4));
        treeSet1.add(new ListPerson("赵毅", 26));
        treeSet1.add(new ListPerson("范英博", 27));
        treeSet1.add(new ListPerson("张欣", 27));

        //  输出:
//        for (Iterator iterator = treeSet1.iterator(); iterator.hasNext(); ) {
//            System.out.println(iterator.next());
//        }

        /**
         *  示例三:
         * 传入ListPerson类的实例对象, 自定义一个比较器传入TreeSet中来排序
         * 具体见 :
         *      package     BiXiangDong.Set_Learning;
         *      class       ComparatorByName
         *
         */
        TreeSet treeSet2 = new TreeSet(new ComparatorByName());
        treeSet2.add(new ListPerson("d来福", 3));
        treeSet2.add(new ListPerson("d旺财", 4));
        treeSet2.add(new ListPerson("b赵毅", 26));
        treeSet2.add(new ListPerson("a范英博", 27));
        treeSet2.add(new ListPerson("c张欣", 27));
        //  输出:
        for (Iterator iterator = treeSet2.iterator(); iterator.hasNext(); ) {
            System.out.println(iterator.next());
        }
    }
}


class ComparatorByName implements Comparator {
    /**
     * 根据 ListPerson类 的 name 进行排序的比较器
     * @param o1 接收原有参数
     * @param o2 接收需比较的参数
     * @return o1小则-1; 相等则0; o1大则1;
     */
    @Override
    public int compare(Object o1, Object o2) {

        ListPerson p1;
        ListPerson p2;
        if (o1 instanceof ListPerson && o2 instanceof ListPerson) {
            p1 = (ListPerson) o1;
            p2 = (ListPerson) o2;
            int temp = p1.getName().compareTo(p2.getName());
            return temp==0? p1.getAge() - p2.getAge() : temp;
        }
        return 0;
    }
}
