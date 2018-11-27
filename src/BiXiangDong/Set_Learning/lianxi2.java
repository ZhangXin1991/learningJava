package BiXiangDong.Set_Learning;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/*
练习:     Map集合框架应用
"fdga_vcbsa  cd f+s" 获取该字符串中, 每一个字母出现的次数
要求打印结果是: a(2)b(1)
思路:
    对于结果的分析发现, 字母和次数之间存在着映射关系. 而且这种关系很多
    很多就需要存储, 能存储映射关系的容器有数组和Map集合
    因 关系没有序列编号, 故 使用Map集合
    因 可以保证唯一性的一方具备顺序, 如:字母字典顺序
    故 使用TreeMap集合
    这个集合最终应该存储的是字母和次数的对应关系
    1, 因为操作的是字符串中的字母, 所以先将字符串变成字符数组
    2, 遍历字符数组, 用每一个字母作为键去查Map这个表
        如果该字母键不存在, 就将该字母作为键,1作为值存储到Map将集合中
        如果该字母键存在, 就将该字母键对应的值取出并+1, 再将该字母和+1后的值
        存储到Map集合中, 键相同值会覆盖. 这样就记录了该字母的次数
    3, 遍历结束, Map集合就记录所有字母的出现次数.
* */
public class lianxi2 {
    public static void main(String[] args) {
        String str = "fdga_vcbsa  cd f+s";
        //  获取字符长度
        Map<Character, Integer> strs = getCharCount(str);
        System.out.println(strs);

        //  取出键值插入括号
        String kvstrs = setkuohao(strs);
        System.out.println(kvstrs);

    }

    /**
     * 抽取字符串中的字符, 将它们计数并存入键值对集合
     * @param str   传入需要整理的字符串
     * @return  返回字符和字符出现次数的Map集合
     */
    public static Map<Character, Integer> getCharCount(String str) {
        //  将字符串变成字符数组
        char[] chs = str.toCharArray();
        //  定义map集合表
        Map<Character, Integer> map = new TreeMap<Character, Integer>();

        for (int i = 0; i < chs.length; i++) {
            //  过滤 如果不是字母 不计入
            if (!(chs[i] >= 'a' && chs[i] <= 'z' || chs[i] >= 'A' && chs[i] <= 'Z')) {
                continue;
            }
            //  将数组中的字母作为键去查map表
            Integer value = map.get(chs[i]);
            //  判断值是否为null
            if (value == null) {
                //  如果键为空, 存键为chs[i], 存值为1
                map.put(chs[i], 1);
            } else {
                //  不为空, 存键为[i], 存值为value+1, 覆盖之前的键值对
                map.put(chs[i], value+1);
            }
        }
        return map;
    }

    /**
     * 将char与int键值对的集合以固定格式返回
     * @param map 传入键值对集合
     * @return  返回固定格式的字符串
     */
    private static String setkuohao(Map<Character, Integer> map) {
        StringBuilder sb = new StringBuilder();
        Iterator<Character> iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            Character key = iterator.next();
            Integer value = map.get(key);
            sb.append(key + "(" + value + ")");
        }
        return sb.toString();
    }
}


