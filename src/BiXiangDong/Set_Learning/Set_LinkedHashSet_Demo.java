package BiXiangDong.Set_Learning;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;

/*
Set 接口 开发中常用的已知实现类:

    - LinkedHashSet
        |- 具有可预知迭代顺序的Set接口的哈希表和链接列表实现
            此实现与HashSet的不同在于, 后者维护者一个运行于所有条目的双重链接列表
            此链接列表定义了迭代顺序, 即按照将元素插入到Set中的顺序(插入顺序)进行
        迭代.
        |- 注意 : 插入顺序不受在Set中重新插入的元素的影响.
            如果在set.contains(element)返回true后立即条用set.add(element)
            则元素element会被重新插入set中
*/
public class Set_LinkedHashSet_Demo {
    public static void main(String[] args) {
        LinkedHashSet linkedSet = new LinkedHashSet();
        linkedSet.add("赵毅");
        linkedSet.add("范英博");
        linkedSet.add("张欣");
        linkedSet.add("来福");
        linkedSet.add("旺财");
        for (Iterator iterator = linkedSet.iterator(); iterator.hasNext();) {
            System.out.print(iterator.next());
        }// 赵毅范英博张欣来福旺财

        //  多态
        HashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.add("赵毅");
        linkedHashSet.add("范英博");
        linkedHashSet.add("张欣");
        linkedHashSet.add("来福");
        linkedHashSet.add("旺财");

        for (Iterator it = linkedHashSet.iterator(); it.hasNext();) {
            System.out.print(it.next());
        }// 赵毅范英博张欣来福旺财
    }
}
