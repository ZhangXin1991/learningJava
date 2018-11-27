package BiXiangDong.Set_Learning;

import java.util.*;

/*

* Map的特点:
*   1, Map 也称为双列集合. 与Collection不同, Map集合一次添加一对元素
*   2, Map集合中存储的是键值对, 将键映射到值的对象, 一个映射不能包含重复的键
*       每个键最多只能映射一个值, 必须保证键的唯一性!
*
* Map: 图
* java.util:Java工具包   接口: Map<K, V>
*
* Map常用的子类:
*   |- Hashtable
*       ||- 内部结构是哈希表, 是同步的, 不支持null对象作为键或值!
*       ||- 子类: Properties: 用来存储键值对型的配置文件的信息, 可以和IO
*            技术相结合
*   |- HashMap
*       ||- 内部结构是哈希表, 不是同步的, 支持null对象作为键或值
*   |- TreeMap
*       ||- 内部结构是二叉树, 不是同步的, 可以对Map集合中的键进行排序
*
* Map的常见方法:
*   1, 添加
*       - Value put(K key, V value)
*           将指定的值与此映射中的指定键关联(可选操作), 返回以前与key关联的值,
*           如果以前没有与此key关联的值则返回null
*   2, 删除
*       - Value remove(Object key)
*           如果存在一个键的映射关系, 则将其从此映射删除, 返回这个删除的值
*       - void clear()
*           从此映射中移除所有映射关系(可选操作)
*   3, 判断
*       - boolean containsKsy(key)
*           是否包含此键
*       - boolean containsValue(value)
*           是否包含此值
*       - boolean isEmpty()
*           是否为有键值映射关系(是否为空)
*   4, 获取
*       - value get(key)
*           通过键获取值, 如果没有该键则反null
*           也可以通过此方法来判断是否包含指定键
*       - int size()
*           获取键值对的个数
*       - Set<Key> keySet()
*           返回此映射中所包含的键的Set视图.
*       - Set<Map.Entry<K,V>> entrySet()
*           返回此映射所有包含的键值对映射关系的Set视图.
*           Map.Entry类型是Map接口的内部接口, 此接口包含的方法有:
*               |- getKey()    获取key
*               |- getValue()  获取value
*               |- setValue()  设置value
*               |- equals()    返回比较结果
*               |- hashCode()  获取哈希值
*               |- values()    获取values
*                   Collection<> values = map.values();
*
*/
public class Map_Learning {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<Integer, String>();
//        method(map);
        methodSet(map );
    }

    public static void methodSet(Map<Integer, String> map) {
        map.put(2, "范英博");
        map.put(7, "赵毅");
        map.put(1, "旺财");
        map.put(3, "来福");
        /*
         * 取出map中的所有元素: keySet()方法
         * 原理:
         *  通过keySet方法获取map中所有的键所在的Set集合,
         *  再通过Set的迭代器获取到每一个键,
         *  再对每一个键通过Map集合中的get()方法获取其对应的值即可
         */
//        Set<Integer> keySet = map.keySet();
//        Iterator<Integer> iterator = keySet.iterator();
//        while (iterator.hasNext()) {
//            Integer key = iterator.next();
//            System.out.println(map.get(key));
//        }
        /*
        取出map中的所有元素:    entrySet()方法
        该方法将键和值的映射关系作为对象储存到了Set集合中, 而这个映射关系
        就是Map.Entry类型
         */
        Set<Map.Entry<Integer, String>> entrySet = map.entrySet();
        Iterator<Map.Entry<Integer,String>> iterator = entrySet.iterator();
        while (iterator.hasNext()) {
//            System.out.println(iterator.next());
            Map.Entry<Integer,String> me = iterator.next();
            Integer key = me.getKey();
            String value = me.getValue();
            System.out.println("key: "+key+" ,value: "+value);
        }
        /*
        取出map中所有value:      values()方法
         */
        Collection<String> values = map.values();
        for (Iterator<String> it = values.iterator(); it.hasNext(); ) {
            System.out.println(it.next());
        }
    }

    public static void method(Map<Integer, String> map) {
        //  添加元素
        System.out.println(map.put(8, "旺财"));   // null
        System.out.println(map.put(8, "来福"));   // 旺财
        map.put(2, "范英博");
        map.put(7, "赵毅");

        //  删除
        System.out.println("remove: "+map.remove(2));

        //  判断
        //  是否包含
        System.out.println("containsKey: "+map.containsKey(7));
        //  8是什么
        System.out.println("get: "+map.get(8));


    }
}
