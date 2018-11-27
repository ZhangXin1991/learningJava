package BiXiangDong.Set_Learning;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/*
HashMap:
    示例:
    添加键值对
        因两个旺财都是新建对象多以地址不相同,认定不是重复键
LinkedHashMap与linkedHashSet差不多....

 */
public class Map_HashMap_Demo {
    public static void main(String[] args) {
        /**
         * 将学生对象和学生的归属地通过键与值存储到HashMap集合中
         */
        HashMap<Student, Address> hashMap = new HashMap<Student, Address>();
        hashMap.put(new Student("范英博", 28), new Address("哈尔滨", "香坊"));
        hashMap.put(new Student("赵毅", 27), new Address("哈尔滨", "道外"));
        hashMap.put(new Student("旺财", 3), new Address("哈尔滨"));
        hashMap.put(new Student("来福", 2), new Address("哈尔滨"));
        hashMap.put(new Student("旺财", 3), new Address("狗窝"));

        methodPrint(hashMap);
    }

    private static void methodPrint(HashMap<Student, Address> map) {
        HashMap<Student, Address> hm = map;
        Set<Student> keySet = hm.keySet();
        for (Iterator<Student> it = keySet.iterator(); it.hasNext(); ) {
            Student key = it.next();
            Address value = hm.get(key);
            System.out.println(key.getName()+ " " + key.getAge() + "|| 地址: " + value.getAddress()
                    + " " + value.getQuyu());
        }
    }
}
