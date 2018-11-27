package BiXiangDong.Set_Learning;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/*
TreeMap:
    示例:
        将学生对象和学生的归属地通过键与值存储到TreeMap集合中

 */
public class Map_TreeMap_Demo {
    public static void main(String[] args) {
        TreeMap<Student, Address> treeMap =
                new TreeMap<Student, Address>(new CollpertorByStudent());
        treeMap.put(new Student("范英博", 28), new Address("哈尔滨", "香坊"));
        treeMap.put(new Student("赵毅", 27), new Address("哈尔滨", "道外"));
        treeMap.put(new Student("旺财", 3), new Address("哈尔滨"));
        treeMap.put(new Student("来福", 2), new Address("哈尔滨"));
        treeMap.put(new Student("旺财", 3), new Address("哈尔滨", "狗窝","楼下"));

        methodPreint(treeMap);
    }

    private static void methodPreint(TreeMap<Student, Address> map) {
        Iterator<Map.Entry<Student, Address>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Student,Address> kv = it.next();
            Student key = kv.getKey();
            Address value = kv.getValue();
            System.out.println(key.toString()+ "||" + value.toString());

        }
    }
}

class CollpertorByStudent implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {

        int temp = o1.getAge()-o2.getAge();
        return temp==0? o1.getName().compareTo(o2.getName()):temp;

    }
}
