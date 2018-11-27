package BiXiangDong.Regex_Learning;

import java.util.TreeSet;

public class Test0_regex_string {
    public static void main(String[] args) {
        /**
         * 切出ip并排序
         */
//        test_1();
        /**
         * 对邮箱地址进行校验
         */
        test_2();
    }

    private static void test_2() {
        String mail = "abc1@sina.com.cn";
        String regex = "[a-zA-Z0-9_]+@[a-zA-Z0-9]+(\\.[a-zA-Z]{2,4})+"/*二到四次*/;
        boolean b = mail.matches(regex);
        System.out.println(mail+":"+b);
    }

    private static void test_1() {
//        String str = "200000018888888888年年年年年年11月6日, 下午十十十十十六点二十三分";
//        //  去重
//        str = str.replaceAll("(.)\\1+", "$1");
//        System.out.println(str);

        //  ip地址排序

        String ip = "192.168.2.101 127.0.0.1 105.70.11.55 3.3.3.3";
        //1, 为了让ip可以按照字符串顺序比较, 需要让ip的每一段的位数相同
        //所以, 补零, 按照每一位所需最多0进行补充. 每一段都加两个0
        ip = ip.replaceAll("(\\d+)", "00$1");
        System.out.println(ip);

        //  每段数字前没有0或多个0, 每段数字保留3位
        ip = ip.replaceAll("0*(\\d{3})", "$1");
        System.out.println(ip);

        // 将ip切出来
        String[] ips = ip.split(" +");
        TreeSet<String> treeSet = new TreeSet<String>();
        for (String ip_t : ips) {
            treeSet.add(ip_t);
        }
        for (String ip_t : treeSet) {
            System.out.println(ip_t.replaceAll("0*(\\d)", "$1"));
        }
//        //1, 将ip地址切出
//        String[] strings = ip.split(" +");
//        //2, 对象排序, 此处使用TreeSet集合, 因TreeSet集合基本类型自动排序
//        TreeSet<String> treeSet = new TreeSet<String>();
//        for (String s : strings) {
//            treeSet.add(s);
//        }
//        for (String ip_t : treeSet) {
//            System.out.println(ip_t);
//        }


    }
}
