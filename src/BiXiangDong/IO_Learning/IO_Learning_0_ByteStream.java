package BiXiangDong.IO_Learning;




import java.io.*;
/**
 * IO    (Input Output)
 *   java.io
 *   IO流用来处理设备之间的数据传输
 *   Java对数据的操作是通过流的方式
 *   Java用于操作流的对象都在IO包中
 *   流按操作数据分为两种:
 *       - 字节流(byte
 *       - 字符流(char
 *   流按流向分为:
 *       - 输入流
 *       - 输出流
 * 1, 字符流的由来:
 *     字节流读取文字字节数据后, 不直接操作, 而是先查指定的编码表,
 *     获取对应的文字, 再对这个文字进行操作.
 *     简单说: 字节流+编码表
 * 2, 输入流和输出流对于内存设备而言:
 *     - 输入 : 将外设中的数据读取到内存中
 *     - 输出 : 将内存中的数据写入到外设中
 * 3, 字符流的两个顶层父类:
 *   - Reader    读者
 *   - Writer    作者
 * 4, 字节流的两个顶层父类:
 *   - InputStream   输入流
 *   - OutputStream  输出流
 */
/**
 * 字节流 基本常用类 和 常用方法:
 *  InputStream
 *      - int fileInputStream.available()
 *        返回这个文本文件中存储的字节总数
 */
public class IO_Learning_0_ByteStream {
    public static void main(String[] args) {
        /**
         * 字节流写入演示:
         */
//        IO_OutputStream();
        /**
         * 字节流读取演示;
         */
//        IO_InputStream();
        /**
         * 练习:
         * copy一个flac格式的音乐文件
         * 多媒体文件使用字节流操作...
         *
         * 注意: 千万不要用读一个字节写一个字节的方式复制文件....效率为0...
         * 方法一:
         *  创建一个数据容器, 读取1024b数据, 写入1目标024b数据, 循环操作
         * 方法二:
         *  创建一个数据容器, 读取1024b数据并存入缓冲区, 从缓冲区调取数据再写入目标1024b数据, 循环操作
         */
        //  方法一:
//        IO_Copy_flacMusicFile_Demo();
        //  方法二: 使用字节流缓冲区....
//        IO_Copy_flacMusicFile_Demo2();
    }

    private static void IO_OutputStream() {
        //  1, 创建字节流输出对象, 用于操作文件
        FileOutputStream fileOutputStream = null;
        try {
            //  2, 明确目的地
            fileOutputStream = new FileOutputStream("" +
                    "C:\\Users\\65404\\Desktop\\learningJava\\test\\IO_OutputStream.txt");
            //  3, 写入字节类型(Byte)数据
            //  因为写入的是字节(byte)类型的数据, 所以无需缓冲, 直接写入到目的地
            fileOutputStream.write("abcdefj".getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {

                //  4, 关闭资源动作要完成
                assert fileOutputStream != null;
                fileOutputStream.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private static void IO_InputStream() {
        //  1, 创建一个读取流对象, 和指定的文件关联
        FileInputStream fileInputStream = null;
        try {
            //  2, 明确读取文件路径
            fileInputStream = new FileInputStream("" +
                    "C:\\Users\\65404\\Desktop\\learningJava\\test\\IO_InputStream.txt");
            //  3, 读取文件文本数据, 一次读取一个字节
            //  中文占用两个字节需读取两次
//            int ch = 0;
//            //  创建字节容器
//            byte[] buf = new byte[1024];
//            //  输出一下试试....
//            while ((ch = fileInputStream.read(buf)) != -1) {
////                System.out.println((char) ch);
//                System.out.println(new String(buf, 0, ch));
//            }
            //  使用fileInputStream.available()方法获取文件字节长度
            //  慎用....如果关联的文件过大...会导致内存溢出...
            byte[] buf = new byte[fileInputStream.available()];
            //  读取文件, 并将读取的字节数据存储到buf数组中.
            fileInputStream.read(buf);
            //  输出一下试试...
            System.out.println(new String(buf));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //  4, 关闭资源
                assert fileInputStream != null;
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void IO_Copy_flacMusicFile_Demo() {
        //  创建读取对象和写入对象
        FileInputStream fins = null;
        FileOutputStream fot = null;
        try {
            //  明确读取路径与写入路径
            fins = new FileInputStream("C:\\Use" +
                    "rs\\65404\\Desktop\\learningJava\\test\\00 热くなれ.flac");
            fot = new FileOutputStream("C:\\Use" +
                    "rs\\65404\\Desktop\\learningJava\\test\\复制00 热くなれ.flac");
            //  创建数据容器
            byte[] buf = new byte[1024];
            //  创建数据计数器
            int len = 0;
            //  循环读取, 写入操作
            while ((len = fins.read(buf)) != -1) {
                fot.write(buf);
            }
        } catch (IOException e) {
            //  打开文件/读取数据/写入数据 的异常处理
            throw new RuntimeException("发生未知错误...");
        } finally {
            try {
                //  关闭读取与写入资源
                assert fins != null;
                fins.close();
                assert fot != null;
                fot.close();
            } catch (IOException e) {
                //  处理关闭异常
                throw new RuntimeException("关闭错误");
            }
        }

    }

    private static void IO_Copy_flacMusicFile_Demo2() {
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;

        try {
            fileInputStream = new FileInputStream("" +
                    "C:\\Users\\65404\\Downloads\\bilibiliDownload\\毕向东35天Java自学基础视频\\" +
                    "1.01-计算机语言概述(Av15004661,P1).flv");
            fileOutputStream = new FileOutputStream("" +
                    "C:\\Users\\65404\\Desktop\\learningJava\\test\\" +
                    "被复制过来的_1.01-计算机语言概述(Av15004661,P1).flv");
            bufferedInputStream = new BufferedInputStream(fileInputStream);
            bufferedOutputStream = new BufferedOutputStream(fileOutputStream);

            int len = 0;
            byte[] buf = new byte[1024];
            while ((len = bufferedInputStream.read(buf)) != -1) {
//                bufferedOutputStream.write(buf, 0, len);
                bufferedOutputStream.write(buf);
//                bufferedOutputStream.flush();
            }
            //  下面的方法如果文件过大, 容易导致内存溢出
//            byte[] buf = new byte[fileInputStream.available()];
//            bufferedInputStream.read(buf);
//            bufferedOutputStream.write(buf);


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                assert bufferedInputStream != null;
                bufferedInputStream.close();
                assert bufferedOutputStream != null;
                bufferedOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
