package BiXiangDong.Set_Learning;

import java.util.*;

/*
* 泛型的高级特性:
*   - 泛型的通配符
*       |- ?  ......这个问号就是通配符......代表未知类型
*   - 泛型的限定
*       |- <? extends 类名>   extends : 延申    用于上限
*           此格式中的类型可以是父类名, 此写法只接收此类名或此类的所有子类,
*           并且可以调用此类名的特有方法, 详见 extends 示例 By    line: 82
*       |- < ? super 类名>                      用于下限
*           此格式中的类型可以是上面泛型的子类型, 此方法通常用于取出存储中
*           的元素或对象. 一般不常用.
 *
*/
public class Generic_Leraning2 {
    public static void main(String[] args) {
        ArrayList<String> al = new ArrayList<String>();
        al.add("abc");
        al.add("hehe");

        HashSet<Integer> al2 = new HashSet<Integer>();
        al2.add(3);
        al2.add(2);

        TreeSet<ListPerson> al3 = new TreeSet<ListPerson>();
        al3.add(new ListPerson("张欣", 28));
        al3.add(new ListPerson("赵毅", 27));
        al3.add(new ListPerson("范英博", 28));

        //  调用封装的迭代方法:
//        printCollection(al);
//        printCollection(al2);
        printCollection(al3);


    }

    /**
     * 将迭代封装为方法
     * 由于需要迭代的几个集合中的元素都是String类型, 所以将泛型定义为String
     *      此方法中使用各种集合的父类Collection接收各种集合类型
     * @param List 需要进行迭代的集合
     */
//    private static void printCollection(Collection<String> List) {
//        Iterator<String> iterator = List.iterator();
//        while (iterator.hasNext()) {
//            System.out.println(iterator.next());
//        }
//    }

    /**
     * 由于需要迭代的两个集合中的元素不确定类型, 所以使用通配符?来定义泛型
     *      此方法中可以接收Collection下的各种子类集合框架,
     *      也可以迭代各种子类框架中的各种类型的元素
     * @param List 需要进行迭代的集合
     */
//    private static void printCollection(Collection<?> List) {
//        Iterator<?> iterator = List.iterator();
//        while (iterator.hasNext()) {
////            Object obj = iterator.next()
//            System.out.println(iterator.next());
//        }
//    }

    /**
     *   注意 : 这种写法让 T 可以被操作, 例如让方法直接返回 T 类型的 t
     * 此方法也是静态的, 不需要对象去明确, 和上面的区别不大
     * 虽然可以把iterator.next()赋值给了T str , 但是感觉没什么卵用
     * @param List
     * @param <T>
     */
//    private static<T> void printCollection(Collection<T> List) {
//        Iterator<T> iterator = List.iterator();
//        while (iterator.hasNext()) {
////            System.out.println(iterator.next());
//            T str = iterator.next();
//            System.out.println(str);
//        }
//    }

    /**
     * extends 示例
     * <? extends ListPerson> 这种写法可以通配所有ListPerson类下的子类,
     * 并且可以调用ListPerson的特有方法
     * 因已经将接收的类型限定为ListPerson类或它的子类, 所以可以直接ListPerson p = iterator.next();
     * 格式: < ? extends E >  限定接收 E 类型 或 E的子类. 通常存储用上限!
     *      因为这样取出都是按照类型的上限类型来运算的
     * 格式: < ? super E >    限定接收 E 类型 或 E的父类. 通常取出用下限!
     *      把存入的类型用其父类型接收, 通常对集合中的元素进行取出操作
     * @param List
     */
    private static void printCollection(Collection<? extends ListPerson> List) {
        Iterator<? extends ListPerson> iterator = List.iterator();
        while (iterator.hasNext()) {
            ListPerson p = iterator.next();
            System.out.println(p.getName());
        }
    }
}
