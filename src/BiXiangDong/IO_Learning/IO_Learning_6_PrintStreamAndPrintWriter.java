package BiXiangDong.IO_Learning;

import java.io.*;

/**
 * IO类当中的操作流的PrintStream类和PrintWriter类
 * PrintStream:
 *  1, 提供了打印方法, 可以对多种数据类型进行打印, 并保持数据的表示形式
 *  2, 它不抛IOException异常
 *
 *  构造函数接收三种类型的值:
 *      1, 字符串路径
 *      2, File对象
 *      3, 字节输出流
 *
 * PrintWriter:         具体看API吧... 极其简单...
 *  构造函数参数:
 *      1, 字符串路径
 *      2, File对象
 *      3, 字节输出流
 *      4, 字符输出流
 */
public class IO_Learning_6_PrintStreamAndPrintWriter {
    public static void main(String[] args) throws FileNotFoundException {
//        printStream_Demo();
        printWriter_Demo();
    }

    private static void printStream_Demo() throws FileNotFoundException {
        PrintStream printStream = new PrintStream(
                "C:\\Users\\65404\\Desktop\\learningJava\\test\\PrintStreamDemo");
//        printStream.write(97);  // a    只写入字符的最低8位 忽略高位24位
//        printStream.print(97);  //  97  先转字符串 new String(97) 再写入
        printStream.close();
    }

    private static void printWriter_Demo() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter printWriter = new PrintWriter(System.out);
    }
}
