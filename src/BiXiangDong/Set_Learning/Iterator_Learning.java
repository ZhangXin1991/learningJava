package BiXiangDong.Set_Learning;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/*
接口:
    iterator
    迭代器

    iterator中的方法:
    boolean hasNext();
        检测下一个是否为空
    obj next();
        输出迭代器中下一个元素

 */
public class Iterator_Learning {

    /**
     * @param args
     */
    public static void main(String[] args) {

        Collection coll = new ArrayList();

        coll.add("abc1");
        coll.add("abc2");
        coll.add("abc3");
        coll.add("abc4");

        //  使用了Collection中的iterator()方法,
        //  调用集合中的迭代器方法, 是为了获取集合中的迭代器对象
//        Iterator it = coll.iterator();
//        System.out.println(it.next());//    abc1
//        System.out.println(it.next());//    abc2
//        System.out.println(it.next());//    abc3
//        System.out.println(it.next());//    abc4
//        System.out.println(it.next());
//        //    报错: java.util.NoSuchElementException
//        while (it.hasNext()) {
//            System.out.println(it.next());
//            //abc1
//            //abc2
//            //abc3
//            //abc4
//        }
        //  优化后代码:
        // 无需上面Iterator it = coll.iterator();, 运行后自动消亡
        for (Iterator iterator = coll.iterator(); iterator.hasNext();) {
            System.out.println(iterator.next());
        }
    }
}
