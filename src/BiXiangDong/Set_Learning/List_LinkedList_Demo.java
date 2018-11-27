package BiXiangDong.Set_Learning;


import java.util.*;

/*
List接口 开发中常用的已知实现类
    - LinkedList  链表
        |- 内部是连接列表(链表)数据结构, 有角标
        |- 是不同步的
        |- 增删元素的速度很快
LinkedList中特有的方法:
    - 添加:
        |- void addFirst()
            添加至链表的开头
        |- void addLast()
            添加至链表的结尾
    - 删除:
        |- E removeFirst()
            删除并返回链表的第一个元素
        |- E removeLast()
            删除并返回链表的最后一个元素
    - 查询:
        |- E element()
            获取但不移除此链表的头, 建议使用getFirst()方法
        |- E getFirst()
            返回该链表的第一个元素, 如果链表为空, 抛出异常
        |- E getLast()
            返回该链表的最后一个元素, 如果链表为空, 抛出异常
        |- E peekFirst()
            返回该链表的第一个元素, 如果链表为空, 则返回null
        |- E peekLast()
            返回该链表的最后一个元素, 如果链表为空, 则返回null
    - 判断:
        |- boolean isEmpty()
            判断链表是否为空
 */
public class List_LinkedList_Demo {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();

        linkedList.add("赵毅");
        linkedList.addFirst("范英博");
        linkedList.addLast("张欣");

        //  利用foreach循环输出
        for (Iterator it = linkedList.iterator(); it.hasNext(); ) {
            System.out.println(it.next());
        }

        //  利用while循环与isEmpty()方法删除链表所有的元素
        while (!linkedList.isEmpty()) {
            System.out.println("链表中的元素: " + linkedList);
            //  每次删除链表第一个元素
            System.out.println("删除: " + linkedList.removeFirst());
        }
        System.out.println(linkedList);

        //  实验0:
        Duilie duilie = new Duilie();
        duilie.putIn("赵毅");
        duilie.putIn("范英博");
        duilie.putIn("张欣");
        while (!duilie.isNull()) {
            duilie.getOut();
        }
        duilie.getOut();


    }
}

//  实验0: 做一个接收对象的容器
//  要求: 先进入的对象先取出
class Duilie {
    //  声明一个链表
    private LinkedList link;


    //  调用队列类时, 声明一个链表
    public Duilie() {
        link = new LinkedList();
    }

    public void putIn(Object object) {
        //  存入元素至末尾
        link.addLast(object);
        System.out.println("存入: " + object.toString());
    }

    public void getOut() {
        //  如果链表不为空, 取第一个元素
        if (!link.isEmpty()) {
            System.out.println("取出: " + link.removeFirst());
            ;
        } else {
            System.out.println("队列中没有人类啦!");
        }
    }

    public boolean isNull() {
        return link.isEmpty();
    }
}



