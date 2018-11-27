package BiXiangDong.Regex_Learning;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则表达式对字符串的常见操作
 * 1, 匹配
 *      使用String类中的matches(Regex re);方法
 *
 * 2, 切割
 *      使用String类中的split(Regex re); split(string);方法
 * 3, 替换
 *      使用String类中的replaceAll(Regex re);方法
 * 4, 获取
 *      Pattern类    Matcher类      pattern:模式  matcher:匹配器
 *      java.util.regex.Matcher
 *      java.util.regex.Pattern
 *        正则表达式的编译表示形式
 *      指定为字符串的正则表达式必须首先被编译为此类的实列.
 *      然后, 可将得到的模式用于创建Matcher(匹配器)对象,
 *      依照正则表达式, 该对象可以与任意字符序列匹配.
 *      执行匹配所涉及的所有状态都著留在匹配器中, 所以多个匹配器
 *      可以共享同一模式
 *
 */
public class L2_Regex_String_Demo {

    public static void main(String[] args) {
        //  匹配
//        MatchesRegex();

        //  切割
//        MatchesSpilt();

        //  替换
//        MatchesReplaceAll();

        //  获取
        PatternAndMatcher();

    }

    private static void PatternAndMatcher() {
        //  将增则规则进行对象的封装
        Pattern p = Pattern.compile("a*b");
        //  通过正则对象的matcher方法字符串象关联. 获取要对字符串操作的匹配器对象Matcher
        Matcher m = p.matcher("aaaab");
        //  通过Matcher匹配器对象的方法对字符串进行操作
        boolean b = m.matches();

        String string = "da jia hao ming tian bu fang jia!";
        String regex = "\\b[a-z]{3}\\b";    //  \\b表示单词边界
        //1, 将正则封装成对象
        Pattern pattern = Pattern.compile(regex);
        //2, 通过正则对象获取匹配器
        Matcher matcher = pattern.matcher(string);
        //使用Matcher对象的方法对字符串进行操作
        //祭坛要获取三个字母组成的单词
        //查找, find(); 获取, group();
        //子串起始位置start(), 子串结束位置end();
        while (matcher.find()) {
            System.out.println(matcher.group());
        }

    }

    private static void MatchesRegex() {
        /**
         * 匹配手机号码是否正确
         * 匹配固定规则再进行判断
         */
        String tel = "15245083842";
        //  匹配 : 第一位数字固定1, 第二位数字固定34578, 后9位0至9;
        String regex_tel = "1[34578][0-9]{9}";
        //  匹配 : 第一位数字固定1, 第二位数字固定34578, 后9位为数字;
        String regex_tel1 = "1[34578]\\d{9}";
        boolean b_tel = tel.matches(regex_tel);
        System.out.println("tel: "+b_tel);
    }

    private static void MatchesSpilt() {
        /**
         * 切割
         * 取字符串中的人名
         */
        String string = "zhangxin   zhaoyi      fanyingbo";
        //  遇到一个空格切割
        String regex0 = " ";
        //  遇到一个或多个空格切割
        String regex1 = " +";
        String[] names = string.split(regex1);
        for (String name : names) {
            System.out.println(name);
        }
        System.out.println("=========================");

        String string1 = "zhangxin.zhaoyi..fanyingbo";
        //  切割掉所有"."
        String[] string1_2 = string1.split("\\.");
        for (String s : string1_2) {
            System.out.println(s);
        }
        System.out.println("=========================");


        /*  用"()"来确定一组, 第一个"()"默认组标号\\1
          示例:
            在表达式((A)(B(C)))中, 存在四个组
            1   ((A)(B(C)))
            2   \A
            3   (B(C))
            4   (C)
          注意:
            组零始终代表整个表达式
        */
        String string3 = "zhangxinttzhaoyitttfanyingbo";
        //  切割掉叠词1个
        String[] names3 = string3.split("(.)\\1");
        for (String name_t : names3) {
            System.out.println(name_t);
        }
    }

    private static void MatchesReplaceAll() {
        String string = "zhangxinQQQQzhaoyiQQQQfanyingbo";
        //  将字符串中的叠词替换成" "
        String names = string.replaceAll("(.)\\1+", " ");
        System.out.println(names);
        //  将字符床中的叠词替换成单个
        //  $1 : 第一组带表的内容  (.)\\1
        String names1 = string.replaceAll("(.)\\1+", "$1");
        System.out.println(names1);
        //  15245012345 --> 152****2345
        String tel = "15245012345";
        tel = tel.replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2");
        System.out.println(tel);


    }
}
