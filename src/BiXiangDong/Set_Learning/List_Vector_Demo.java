package BiXiangDong.Set_Learning;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

/*
List中的实现类: Vector
    |- 内部是数组数据结构
    |- 是同步的, 线程安全的
    |- 增删, 查询都很慢......
Vector中的接口 : Enumeration<E>
    Enumeration : 枚举
    它的功能类似Iterator(迭代器)
    接口中有两个方法:
        - hasMoreElements()
            测试此枚举是否包含更多元素
        - nextElement()
            如果此枚举对象至少还有一个可提供的元素, 则返回此枚举的下一个元素
    此接口的功能和Iterator迭代器的功能是重复的.
    此外,Iterator接口添加了一个可选的移除功能, 并使用了较短的方法名.

    输出时应选择for循环而不是while循环,
    因为while循环需要在循环外部声明迭代器类或枚举类, 循环结束后依然保留(不消亡)
    而foreach循环在循环内部声明迭代器类或枚举类, 循环结束后不保留(消亡)
    因此选择foreach循环最佳
 */
public class List_Vector_Demo {
    public static void main(String[] args) {
        Vector vector = new Vector();

        vector.addElement("abc1");
        vector.addElement("abc2");
        vector.addElement("abc3");
        vector.addElement("abc4");
//        System.out.println(vector.elements().nextElement());
        //  Enumeration 的输出
        Enumeration enumeration = vector.elements();
        while (enumeration.hasMoreElements()) {
            System.out.println(enumeration.nextElement());
        }

        for (enumeration = vector.elements(); enumeration.hasMoreElements(); ) {
            System.out.println(enumeration.nextElement());
        }

        //  Iterator 的输出
        Iterator iterator = vector.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        for (Iterator iterator1 = vector.iterator(); iterator1.hasNext(); ) {
            System.out.println(iterator1.next());
        }




    }
}
