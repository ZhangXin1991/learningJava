package BiXiangDong.Regex_Learning;

/**
 * 正则表达式
 * 特点:
 *   正则表达式用于操作字符串数据
 *   通过一些特定的符号来体现的
 *   虽然简化了, 但阅读性奇差
 *
 */
public class L1_Regex_Demo {
    public static void main(String[] args) {
        /**
         * 需求:
         * 定义一个功能对QQ号进行校验
         * 要求:
         * 长度5~15位, 只能是数字, 0不能开头
         */
        String qq = "654042";
        /**
         * 正则表达式
         * String.matches(String Regex)    matches:匹配
         * 所以为了掌握正则表达式, 必须学习一些符号
          */
        //  字符的范围
        String regex = "[1-9][0-9]{4,14}";
        boolean b = qq.matches(regex);
        System.out.println(qq+":"+b);
        //  字符的数量
        String aob = "aooooob";
        String regex1 = "ao?b";//a与b之间有没有1个o不一定
        String regex2 = "ao+b";//a与b之间有1个或者多个o
        String regex3 = "ao*b";//a与b之间一个没有或者有多个o
        String regex4 = "ao{4}b";//a与b之间固定有4个o
        String regex5 = "ao{4,}b";//a与b之间有4个或4个以上个o
        String regex6 = "ao{4,8}b";//a与b之间有4个至8个个o
        boolean b3 = aob.matches(regex3);
        System.out.println(b3);

    }


}
