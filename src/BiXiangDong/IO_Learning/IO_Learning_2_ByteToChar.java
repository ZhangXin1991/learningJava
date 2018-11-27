package BiXiangDong.IO_Learning;

import java.io.*;

/**
 * 读取一个键盘录入的数据, 并打印在控制台上
 *
 * 键盘本身就是一个标准的输入设备
 * 对于java而言, 对于这种输入的设备都有对应的对象
 *
 * java.lang.System
 *  System中的常用对象,类,方法:
 *      - System.in
 *        标准字节输入流
 *        它是默认的输入设备
 *        默认为获取键盘输入的流 的 对象
 *        此对象无法new, 所以一旦关闭无法开启
 *        它会随着系统的消失而消失, 随着系统的出现而出现
 *
 *      - System.out
 *        标准输出流. 此流已打开并准备接收输出数据.
 *        通常, 该流对应于主机环境或用户指定的显示输出或另一输出目的地
 *
 *      - InputStream类
 *        此抽象类是表示输入字节流的所有类的超类
 *          |- inputStream.read()
 *             读取字节流, 返回int类
 *          |- inputStream.available()
 *             返回可以从此输入流中读取(或跳过)的字节数据的估计值,
 *             而不会被下一次调用此输入流的方法堵塞
 *
 *      - OutputStream类
 *          |- outputStream.write(字符/字符串/字符数组的一部分)
 *             静态方法, 写一个字符/字符串/字符数组的一部分
 *          |- outputStream.getEncoding()
 *             返回此流使用的字符编码名称. 返回String类
 *          |- outputStream.flush()
 *             刷新流
 *
 *
 *
 *      - PrintStream类
 *        A PintStream 为另一个输出流添加功能, 即能够方便地打印各种数据值得表示.
 *        还提供了另外两个功能. 与其它输出流不同, PrintStream从不抛出IO异常;
 *        自动刷新,
 *
 *
 *
 *  
 */
public class IO_Learning_2_ByteToChar {
    public static void main(String[] args) throws IOException {
        //  自己创建个键盘读取方法...
//        readKey();
        /**
         * 需求:
         *  获取用户键盘输入的数据
         *  并将数据变成大写显示在控制台上
         *  如果用户输入的是over, 结束键盘录入
         * 思路:
         *  1, 因为键盘录入只读取一个字节, 要判断是否是over,
         *     需要将读取到的字节拼成字符串
         *  2, 那就需要一个容器, StringBuilder类
         *  3, 在用户回车之前将录入的数据变成字符串判断即可
         */
//        readKey2();
        /**
         * 使用InputStreamReader类 接收 system.in对象 将其转换成字符流
         * 再使用字符流缓冲区接收转换后的字符流, 调用readLine()方法, 每次读取一行
         * 将读取的数据进行判断, 如果是"over"则break, 否则变成大写并打印到控制台
         */
//        readKeyToCharStream();
        /**
         * 使用字节流读取一个文本文件, 再把读取的字节数据转换成字符流, 然后输出到控制台
         */
//        readTextToConslo();
        /**
         * 获取键盘输入的字节, 再用字节流转字符流对象读取, 最后用标准字节流输出对象输出到控制台
         * 如果键盘输入 "over" , 则退出程序
         * 这个方法名长的要死.....
         */
        InputStreamReader_To_BufferedReader_for_OutputStreamWriter();
    }

    private static void readKey() throws IOException {
        //  创建获取键盘数据对象
        InputStream in = System.in;
//  读取数据
        //  阻塞式方法, 没有数据就会等待
        int ch = in.read();
        System.out.println(ch);//   97
        int ch1 = in.read();
        System.out.println(ch1);//  13
        int ch2 = in.read();
        System.out.println(ch2);//  10
        /*  输入: aa 换行 输出 97 + 13 + 10
         * 因windows中 换行=\r\n
         * */
    }

    private static void readKey2() throws IOException {
        //  1, 创建字符串容器
        StringBuilder stringBuilder = new StringBuilder();
        //  2, 获取键盘读取流
        InputStream inputStream = System.in;
        //  3, 定义变量读取到的字节, 并循环获取
        int ch = 0;
        while ((ch = inputStream.read()) != -1) {
            //  4, 在存储之前需要判断是否是换行标记, 因为换行标记不存
            if (ch == '\r')
                continue;
            if (ch == '\n') {
                /*  如果是换行标记, 判断这个标记前的字符拼写是否为over
                 *  如果是over 则break并 打印这些字符并 清空字符容器 */
                String temp = stringBuilder.toString();
                if ("over".equals(temp))
                    break;
                System.out.println(temp.toUpperCase());
                stringBuilder.delete(0, stringBuilder.length());
            } else {
                // 5, 将读取到的字节存储到StringBuilder中
                stringBuilder.append((char) ch);
//                System.out.println(ch);
            }
        }
    }

    private static void readKeyToCharStream() throws IOException {
        //  获取键盘输入流的对象 字节流
        InputStream inputStream = System.in;
        //  接收字节流, 转换成字符流
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        //  创建字符流缓冲区, 接收转换后的字符流
        BufferedReader bufferedReader = null;
        bufferedReader = new BufferedReader(inputStreamReader);
        //  读取一行数据
//        bufferedReader.readLine();
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            if ("over".equals(line))
                break;
            System.out.println(line.toUpperCase());
        }

    }

    private static void readTextToConslo() throws IOException {
        //  创建一个读取字节流的对象,并确定读取文件的路径
        FileInputStream fileInputStream =  new FileInputStream("" +
                    "C:\\Users\\65404\\Desktop\\learningJava\\test\\" +
                    "IO_InputStream.txt");
        //  用输入流读取对象 关联 读取字节流对象
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        //  每次读取一行, 循环输出
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }
    }

    private static void InputStreamReader_To_BufferedReader_for_OutputStreamWriter() throws IOException {
//        //  创建 获取键盘输入的 对象
//        InputStream inputStream = System.in;
//        //  因获取键盘输入的对象是以字节流为单位的, 所以创建字节流转字符流对象 并 关联获取键盘输入的对象
//        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
//        //  创建读取字符流的容器, 并关联字节流转字符流的对象
//        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        //  上三行代码的等价代码 :
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String line = null;
//        //  创建读取单位, 每次读取一行字符, 循环输出并打印到控制台, 如果这行字符是"over",则退出程序
//        while ((line = bufferedReader.readLine()) != null) {
//            if ("over".equals(line))
//                break;
//            System.out.println(line.toUpperCase());
//        }

//        //  创建 标准字节流输出的 对象
//        OutputStream outputStream = System.out;
//        //  创建 标准字节流写入的 对象
//        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
//        BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
        //  用字符流容器读取键盘输入, 再用标准字节流对象将数据输出到控制台(console)
        //  上三行代码的等价代码 :
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        while ((line = bufferedReader.readLine()) != null) {
            if ("over".equals(line))
                break;
//            outputStreamWriter.write(line.toUpperCase());
//            outputStreamWriter.write(System.getProperty("line.separator"));
//            outputStreamWriter.flush();
            bufferedWriter.write(line.toUpperCase());
//            bufferedWriter.write(System.getProperty("line.separator"));
            bufferedWriter.newLine();// 调用bufferedWriter类中的换行方法....
            bufferedWriter.flush();
        }
    }

}
