package BiXiangDong.IO_Learning;

import java.io.*;

/**
 * 获取键盘录入的字符串数据,
 * 将这个字符串数据按照指定的UTF-8编码表写入到一个文本文件中,
 * 再用指定的UTF-8编码读取这个文本文件, 并打印出来
 */
public class IO_Learning_3_Charset_In_TxtFile {
    public static void main(String[] args) throws IOException {
        /**
         *  用UTF-8编码表写一个文本文件
         *  文件路径:
         *      C:\Users\65404\Desktop\learningJava\test\
         *      IOCharsetInTxtFile.txt"
         */
        Input_UTF8_To_Txtfile();
    }

    private static void Input_UTF8_To_Txtfile() throws IOException {
        //  获取 读取键盘录入对象
        BufferedReader bufferedReaderKeyboard = new BufferedReader(new InputStreamReader(
                System.in));
        //  创建写入文本文件对象, 确定写入文件路径, 并指定字符编码为UTF-8
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream("C:\\Users\\65404\\Desktop\\learningJava\\test\\" +
                        "IOCharsetInTxtFile.txt"), "UTF-8"));
        //  创建读取单位line , 循环读取, 并判断是否为"over",循环写入并换行, 刷新
        String line = null;
        while ((line = bufferedReaderKeyboard.readLine()) != null) {
            if ("over".equals(line))
                break;
            bufferedWriter.write(line);
            bufferedWriter.newLine();
            bufferedWriter.flush();
        }

        //  创建文件读取对象, 明确读取文件路径, 并指定读取字符编码为UTF-8
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(
                new FileInputStream("" +
                        "C:\\Users\\65404\\Desktop\\learningJava\\test\\" +
                        "IOCharsetInTxtFile.txt"), "UTF-8"));
        //  创建读取字符单位, 创建读取字符计数器, 循环读取并转换为string类型并打印
        char[] buf = new char[10];
//        int len = bufferedReader.read(buf);
        int len = 0;
        while ((len = bufferedReader.read(buf)) != -1) {
            String string = new String(buf, 0, len);
            System.out.println(string);

        }


    }
}
