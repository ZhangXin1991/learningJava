package BiXiangDong.String_Method_Demo;

public class StringTest0 {

    public static void main(String[] args) {
        String nba = "nbaadknbasdinbanfis";
        String key = "nba";

        int cont = chazhao(nba, key);

        System.out.println(cont);
    }

    /**
     *
     * @param str   接收被查找的字符串
     * @param key   接收需查找的字符串
     * @return      字符串中需查找的字符串出现的次数
     */
    public static int chazhao(String str, String key) {

        int count = 0;   //  计数器
        int index = 0;  //  记录位置


        while ((index = str.indexOf(key)) != -1){
            //  判断str中是否包含key, 并记录key出现的位置, 如果不包含结束循环
            //  string.indexOf(str) 方法: 返回str在string中第一次出现的位置, 如果string中没有str,返回-1;

            str = str.substring(index + key.length());
            //  string.substring(int) 方法: 返回string的字串,从string中int的位置开始,到string.length()结束;

            count++;
            //  计数器......

        }
        return count;
    }

}


