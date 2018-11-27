package Cpre_java;

import java.util.*;

public class shiYan {
    public static void main(String[] args){
//        List<String> strs = new ArrayList<String>();
//        strs.add("abc1");
//        strs.add("abc2");
//        strs.add("abc3");
//
//        for (Iterator<String> st = strs.iterator(); st.hasNext(); ) {
//            System.out.println(st.next());
//        }
//        String[] atr = new String[]{"zhangxin ", "xinzhang"};
//        for (String s : atr) {
//            System.out.println(s);
//        }
//        for (String s : strs) {
//            System.out.println(s);
//        }
        Map<Integer, String> map = new HashMap<Integer, String>();
        map.put(1, "zhangxin");
        map.put(2, "zhaoyi");
        map.put(3, "fanyingbo");
        for (Integer ints : map.keySet()) {
            System.out.println(ints + ":"+map.get(ints));
        }
        for (Map.Entry<Integer, String> me : map.entrySet()) {
            System.out.println(me.getKey()+me.getValue());
        }
        Set s = map.entrySet();
        System.out.println(s);

        int sum = add(1, 2, 3, 4, 5);
        System.out.println(sum);


        Properties p = System.getProperties();
        Set<String> nameset = p.stringPropertyNames();
        for (String s1 : nameset) {
            System.out.println(s1 + ":" + p.getProperty(s1));
        }
    }

    private static int add(int... ints) {
        int sum = 0;
        for (int i = 0; i < ints.length; i++) {
            sum += i;
        }
        return sum;
    }


}
