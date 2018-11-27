package BiXiangDong.IO_Learning;

import java.io.UnsupportedEncodingException;

/**
 * 编码表
 *
 */
public class IO_Learning_9_Charset {
    public static void main(String[] args) throws UnsupportedEncodingException {

        /**
         * 简单的编码节码:
         *  字符串--> 字节数组 : 编码
         *  字符数组--> 字符串 : 解码
         */
//        stringWithByte();

        /**
         * 按字节截取字符串:
         *  定义一个方法, 按照最大的字节数来取子串
         *  如: 对于"ab你好", 如果取三个字节, 那么子串就是"ab"与"你"字的半个,
         *  那么半个就要舍弃, 如果是取四个字节就是"ab你", 取五个字节还是"ab你".
         */
        String string = "ab你好";
        int len = string.length();
        String s1 = cutStringByByte(string, len);
        System.out.println(s1);
    }

    /**
     *
     * @param string 接收需截取的字符串
     * @param len    字符串中的字符的数量
     * @return       返回截取后的字符串
     * @throws UnsupportedEncodingException
     */
    private static String cutStringByByte(String string, int len) throws UnsupportedEncodingException {
        //  将字符串转为字节数组
        byte[] buf = string.getBytes("GBK");

        //  字节数组角标计数器
        int count = 0;

        //  遍历字节数组,
        for (int x = len - 1; x >= 0; x--) {
            //  如果buf[x]小于0, 说明这个8位字节是1开头, 需继续往前读.
            if (buf[x] < 0)
                count++;
            //  如果buf[x]不小于0, 说明这个8位字节是0开头, 无需继续往前读
            else
                break;
        }

        //  因GBK编码是每两个字节组成一个字符, 所以当 字节计数器%2==0, 则返回所有字节转字符
        if (count % 2 == 0)
            return new String(buf, 0, len, "GBK");
        //  如果当 字节计数器%2!=0, 则舍弃一个字节, 返回剩余的字节转字符
        else
            return new String(buf, 0, len-1, "GBK");
    }

    private static void stringWithByte() throws UnsupportedEncodingException {
        String string = "嘿嘿";
        /**
         * 编码:
         */
        byte[] buf0 = string.getBytes("GBK");//-70 -39 -70 -39
        byte[] buf1 = string.getBytes("UTF-8");//-27 -104 -65 -27 -104 -65
//        printBytes(buf);

        /**
         * 解码:
         */
        String string0 = new String(buf0, "GBK");
        String string1 = new String(buf1, "UTF-8");
        System.out.println(string0+string1);//  嘿嘿嘿嘿......
    }

    private static void printBytes(byte[] buf) {
        for (byte b : buf) {
            System.out.println(b);
        }
    }
}
