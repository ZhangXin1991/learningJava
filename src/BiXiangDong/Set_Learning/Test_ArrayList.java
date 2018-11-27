package BiXiangDong.Set_Learning;

import java.util.ArrayList;
import java.util.Iterator;

/*
练习:
    ArrayList的去重操作

思路:
    两种方法

 */
public class Test_ArrayList {
    public static void main(String[] args) {
        //  创建个ArrayList......

        ArrayList arrayList = new ArrayList();

        //  随意添加几个test元素......
        arrayList.add("嘎嘎");
        arrayList.add(7777777);
        arrayList.add(true);
        arrayList.add("嘿嘿");
        arrayList.add(1234567);
        arrayList.add(false);
        arrayList.add(new ListPerson("范英博", 27));
        arrayList.add(new ListPerson("赵毅", 26));
        arrayList.add(new ListPerson("张欣", 27));

        arrayList.add(true);
        arrayList.add("嘿嘿");
        arrayList.add(1234567);
        arrayList.add(false);
        arrayList.add(7777777);
        arrayList.add("嘎嘎");
        arrayList.add("嘎嘎");
        arrayList.add("嘿嘿");
        arrayList.add(1234567);
        arrayList.add(true);
        arrayList.add(true);
        arrayList.add(false);
        arrayList.add(new ListPerson("范英博", 27));
        arrayList.add(new ListPerson("范英博", 27));
        arrayList.add(new ListPerson("张欣", 27));
        arrayList.add(new ListPerson("张欣", 27));
        arrayList.add(new ListPerson("赵毅", 26));
        arrayList.add(new ListPerson("赵毅", 26));
        arrayList.add(new ListPerson("赵毅", 26));




        System.out.println(arrayList);
        arrayList = quChong(arrayList);
//        arrayList = quChong1(arrayList);
        System.out.println(arrayList);

    }

    /**
     * 方法一:
     *      无法对包含自定义对象的arrayList去重
     *      用for循环遍历 arrayList, 此方法会导致原有的arrayList消亡
     * 注意:
     *      由于此方法最后会把传入的arrayList删除至空, 所以最后返回时把arrayList指向了新建的a1
     * @param arrayList 传入的ArrayList
     * @return  把arrayList指向了去重后的a1, 原有的arrayList消亡
     */
    public static ArrayList quChong(ArrayList arrayList) {
        ArrayList a1 = new ArrayList();
        int x ;     //  arrayList角标
        int y = 0;  //  a1角标
        //  循环arrayList
        for (x = 0; x < arrayList.size(); x++) {
            //  a1添加 arrayList删除的x
            a1.add(arrayList.remove(x));
            x -= 1;     //  因arrayList删除了一个 , 故arrayList的角标-1
            //  如果arrayList中 有 a1刚刚添加的元素, 那么arrayList删除这个元素
            while (arrayList.contains(a1.get(y))) {
                arrayList.remove(a1.get(y));
            }
            y += 1; //  a1的角标+1
        }
        arrayList = a1;
        return arrayList;
    }

    /**
     * 方法二:
     *      无法对包含自定义对象的arrayList去重
     *      用迭代器遍历 arrayList, 原有的arrayList不变
     * @param arrayList 传入的ArrayList
     * @return  去重后的另一个ArrayList
     */
    public static ArrayList quChong1(ArrayList arrayList) {
        ArrayList a2 = new ArrayList();

        //  建立arrayList的迭代器
        Iterator it = arrayList.iterator();

        //  循环此迭代器
        while (it.hasNext()) {
            //  将迭代到的元素赋值给obj
            Object obj = it.next();
            //  如果a2没有此元素, a2接收此元素; 如果有, 则啥也不干
            if (! a2.contains(obj)) {
                a2.add(obj);
            }
        }
        return a2;
    }



}
