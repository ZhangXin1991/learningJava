package BiXiangDong.IO_Learning;

import java.io.*;
import java.nio.Buffer;

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
* 字符流 基本常用类 和 类中方法 :
*   java.io.Writer
*       - java.io.OutputStreamWriter
*         此类是从字符流到字节流的桥接
*           |- java.io.FileWriter
*              用来写入文件的便捷类
*             |-- 创建写入字符数据对象
*                 FileWriter fileWriter = new FileWriter("文件绝对路径");
*             |-- 写入字符数据
*                 fileWriter.write("string");
*             |-- 刷新缓存数据, 将缓存数据直接写入文件
*                 fileWriter.flush();
*       - java.io.BufferedWriter    此类用装饰设计模式增强了FileWriter类
*         将文本写入字符输出流, 缓冲字符, 以便有效地写入单个字符, 数组和字符串
*           |- BufferedWriter(Writer out)
*              创建一个使用默认大小输出缓冲区的缓冲字符输出流
*           |- BufferedWriter(Writer out, int size)
*              创建一个使用给定大小输出缓冲区的新缓冲字符输出流
*           |- void close()
*              关闭此流, 但要先刷新它
*           |- void flush()
*              刷新该流的缓冲
*           |- void newLine()
*              写入一个行分隔符
*           |- void write(char[] cbuf, int off, int len)
*              写入一个字符数组的某一部分
*           |- void write(int c)
*              写入单个字符
*           |- void write(String s, int off, int len)
*              写入一个字符串的某一部分
*
*   java.io.Reader
*       - java.io.InputStreamReader
*         此类是从字节流到字符流的桥接器
*           |- java.io.FileReader
*              用来读取文件的便捷类
*             |-- 创建读取字符数据的对象
*                 FileReader fileReader = new FileReader("文件绝对路径")
*             |-- 读一个字符, 返回int类型, 如果没有读取到数据则返回-1
*                 fileReader.read();
*             |-- 将字符读入数组, 返回int类型
*                 fileReader.read(char[] cbuf, int offset, int length);
*                 注意: 重复调用read()方法会读取下文, 不会重复读取
*             |-- 判断此流是否可以读取, 返回boolean
*                 fileReader.ready();
*       - java.io.BufferedReader    此类用装饰设计模式增强了FileReader类
*         从字符输入流中读取文本, 缓冲字符, 以便有效地读取字符, 数组和行
*           |- void close()
*              关闭该流并释放与之关联的所有资源
*           |- void mark(int readAheadLimit)
*              标记流中的当前位置
*           |- boolean markSupported()
*              判断此流是否支持mark()操作.(它一定支持)
*           |- int read()
*              读取单个字符
*           |- int read(char[] cbuf, int off, int len)
*              将字符读入数组的某一部分
*           |- String readLine()
*              读取一个文本行
*           |- boolean ready()
*              判断此流是否已准备好被读取
*           |- void reset()
*              将流重置到最新的标记
*           |- long skip(long n)
*              跳过字符
* */
public class IO_Learning_1_CharStream {
    //  创建换行字符
    private static final String
            LINE_SEPARATOR = System.getProperty("line.separator");//separator:分离器

    public static void main(String[] args) {
        /**
         * 需求:
         *  将一些文字存储到硬盘的一个文件中
         *  思路:
         *  如果要操作文字数据, 建议优先考虑字符流,
         *  而且要将数据从内存写道硬盘上,
         *  要使用字符流中的输出流. Writer类
         *  硬盘的基本数据体现是文件, 希望找到一个可以操作文件的Writer
         */
//        IO_File_Writer();

        /**
         * IO异常的处理
          */
//        IOExceptionDemo();

        /**
         * 需求:
         *  读取一个文本文件, 将读取的字符打印到控制台
         *  同上, 找到了FileReader
         */
//        IO_File_Reader();

        /**
         * 练习:
         *  将一个文本文件的内容复制到另一个文本文件当中
         */
//        IO_File_ReaderAndWriter();

        /**
         * BufferedWriter示例:
         */
//        IO_BufferedWriter_Demo();
        /**
         * BufferedReader示例
         */
//        IO_BufferedReader_Demo();

        /**
         * 练习:
         * 使用缓冲区(BufferedWriter和BufferedReader)
         * 将一个文本文件的内容复制到另一个文本文件洞中
         */
        IO_BufferedReaderAndWriter_Copy_Demo();
    }


    private static void IO_File_Writer() {
        //  创建一个可以往文件中写入字符数据的输出流对象, 抛出或捕捉IO异常
        /*
         * 既然是往一个文件中写入文字数据, 那么再创建时,
         *  就必须明确该文件(目的地)
         *  - 如果文件不存在则创建
         *  - 如果文件已存在则覆盖
         */
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(
                    "C:\\Users\\65404\\Desktop\\learningJava\\test\\IO实验1.txt");
            /*
             * 调用Writer对象中的write(string)方法, 写入数据
             *  写入的数据存储在缓冲区
             */
            fileWriter.write("abcda"+LINE_SEPARATOR+"ADF");
            //  用flush()方法进行刷新, 将数据直接写入目的地
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //  关闭流, 关闭资源. 关闭前会调用flush()刷新缓冲数据到目的地
            //  关闭后再次调用write/flush将出现IO异常
            if (fileWriter != null)
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    throw new RuntimeException("关闭失败");
                }
        }
        /*
         * 如果构造函数加入true, 可以实现对文件进行续写
         */
        FileWriter fileWriter1 = null;
        try {
            fileWriter1 = new FileWriter(
                    "C:\\Users\\65404\\Desktop\\learningJava\\test\\IO实验0" +
                            ".txt", true);
            fileWriter1.write("张欣");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileWriter1 != null) {
                try {
                    fileWriter1.close();
                } catch (IOException e) {
                    throw new RuntimeException("关闭失败");
                }
            }
        }
    }

    private static void IOExceptionDemo() {
        FileWriter fw = null;
        try {
            fw = new FileWriter("C:\\Users\\65404\\Desktop\\learningJava\\test\\IO实验1" +
                    ".txt");
            fw.write("张欣,"+LINE_SEPARATOR+"zhangxin ");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //  如果fw对象没有创建成功, 无需close
            if (fw != null)
                try {
                    fw.close();
                } catch (IOException e) {
                    //  这里还可以写些code....
                    throw new RuntimeException("关闭失败");
                }
        }
    }

    private static void IO_File_Reader() {
        FileReader fileReader = null;
        try {
            /**
             * 1, 创建读取字符数据的流对象
             *  在创建读取流对象时, 必须要明确被读取的文件. 一定要确定该文件是存在的
             *  用一个读取流关联一个已存在文件
             *  如果文件不存在, 就会抛出文件不存在异常 FileNotFoundException
             */
            fileReader = new FileReader("C:\\Users\\65404\\Desktop\\learningJava\\test\\IO实验0.txt");
            /**
             * 用Reader类中的read()方法读取文本文件数据
             */
//            int ch = fileReader.read();
//            System.out.println((char) ch);//    经过类char型转换
//            int ch1 = fileReader.read();
//            System.out.println(ch1);//  不经过类型转换则为二进制码
//            int ch2 = fileReader.read();
//            System.out.println(ch2);//  如果没有数据则返回-1

//            int ch = 0;
//            while ((ch = fileReader.read()) != -1) {
//                System.out.println((char) ch);
//            }
            /**
             * 使用read(char[])方法读取文本文件数据
             */
//            //  创建字符数组  也就是存储字符的容器
//            char[] chr = new char[3];
//            //  将读取到的字符存储到数组中, 返回int,(读取了多少字符), 但会-1则读到结尾
//            int num = fileReader.read(chr);
//            System.out.println(num + ":" + new String(chr));
//
//            //  设定打印的容器内字符的长度
//            System.out.println(num + ":" + new String(chr, 0, num));

            //  创建字符容器, 容量最好是1024的整数倍
            char[] cha = new char[1024];
            //  创建int类变量(字符计数器)
            int len = 0;
            //  如果计数器的值不等于-1, 继续循环;
            //  每次循环打印数组容器中相应位置的字符
            while ((len = fileReader.read(cha)) != -1) {
                System.out.println(new String(cha, 0, len));
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileReader.close();
            } catch (IOException e) {
                throw new RuntimeException("关闭错误");
            }
        }
    }

    private static void IO_File_ReaderAndWriter() {
        /**
         * 思路:
         *  先用Reader类读取需复制的文本文件
         *  然后使用Writer类将复制的内容写入复制出的文件中
         */
        //  创建读取对象
        FileReader fileReader = null;
        //  创建写入对象
        FileWriter fileWriter = null;
        try {
            //  明确读取目标
            fileReader = new FileReader("C:\\Users\\65404\\Desktop\\learn" +
                    "ingJava\\test\\IO实验1.txt");
            //  创建读取字符计数器
            int num = 0;
            //  创建存储读取字符容器
            char[] cha = new char[1024];

            //  明确写入目标
            fileWriter = new FileWriter("C:\\Users\\65404\\Desktop\\learn" +
                    "ingJava\\test\\IO实验3.txt", true);

            //  如果读取到字符, 写入字符串数组, 刷新文本文件将写入的数据从缓存写入硬盘中
            while ((num = fileReader.read(cha)) != -1) {
//                System.out.println(new String(cha, 0, num));
                fileWriter.write(new String(cha, 0, num));
//                fileWriter.flush();
            }
        } catch (IOException e) {
            throw new RuntimeException("读写失败");
        } finally {
            try {
                assert fileReader != null;
                fileReader.close();
                assert fileWriter != null;
                fileWriter.close();
            } catch (IOException e) {
                throw new RuntimeException("关闭失败");
            }
        }
    }

    private static void IO_BufferedWriter_Demo() {
        /*缓冲区BufferedWriter示例*/
        FileWriter fw = null;
        try {

            fw = new FileWriter("C:\\Users\\65404\\Desktop\\learn" +
                    "ingJava\\test\\IO实验BufferedWriter.txt");

            //  为了提高效率, 使用了字符流的缓冲区
            //  创建了一个字符写入流的缓冲区对象, 并和指定联
            BufferedWriter bufw = new BufferedWriter(fw);
            //  使用缓冲区的写入方法, 将数据先写入到缓冲区中
            bufw.write("BufferedWriter\r\n嘿嘿嘿" + LINE_SEPARATOR + "嘿嘿嘿嘿");
            //  换行符方法......
            bufw.newLine();
            bufw.write("hehehe");
            //  使用缓冲区的刷新方法, 将数据刷新至目的地中
            bufw.flush();
            //  关闭缓冲区
            bufw.close();

        } catch (IOException e) {

//            throw new RuntimeExption("写入失败");

        } finally {
            try {

                if (fw != null) {
                    fw.close();

                }
            } catch (IOException e) {

                throw new RuntimeException("关闭操作失败");

            }
        }
    }

    private static void IO_BufferedReader_Demo() {
        /*缓冲区BufferedReader示例*/
        FileReader fr = null;

        //  用FileReader类的read()方法来读取数据
//        IO_BufferedReader_Demo_FileReader(fr);
        //  用BufferedReader缓冲器来读取文本数据
        IO_BufferedReader_Demo_BufferedReader(fr);

    }

    private static void IO_BufferedReaderAndWriter_Copy_Demo() {
        /**
         * 练习:
         * 使用缓冲区进行文本文件数据的读写
         * 从一个文本文件中读取, 写入另一个文本文件
         */
        FileReader fileReader = null;
        FileWriter fileWriter = null;

        try {
            fileReader = new FileReader("C:\\Users\\65404\\Desktop\\learn" +
                    "ingJava\\test\\IO实验BufferedReaderAndWriter_Copy_Demo.txt");
            fileWriter = new FileWriter("C:\\Users\\65404\\Desktop\\learn" +
                    "ingJava\\test\\IO实验BufferedReaderAndWriter_CopyTo_Demo.txt");
            BufferedReader br = new BufferedReader(fileReader);
            BufferedWriter bw = new BufferedWriter(fileWriter);

            String line = null;
            while ((line = br.readLine()) != null) {
                bw.write(line);
                bw.newLine();
                bw.flush();
            }

            br.close();
            bw.close();
        } catch (IOException e) {
            throw new RuntimeException("操作异常");
        }

    }




    //  IO_BufferedReader_Demo()的子方法......
    private static void IO_BufferedReader_Demo_BufferedReader(FileReader fr) {
        try {
            fr = new FileReader("C:\\Users\\65404\\Desktop\\learn" +
                    "ingJava\\test\\IO实验BufferedReader.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        assert fr != null;
        //  创建字符读取流的缓冲区对象, 并和指定关联
        BufferedReader bufr = new BufferedReader(fr);

        try {
            //  读取一行文本数据
//            String line1 = bufr.readLine();
            //  每次读取一行, 读取文本中所有数据
            String line = null;
            while ((line = bufr.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufr.close();
            } catch (IOException e) {
                throw new RuntimeException("操作失败");
            }
        }

    }

    private static void IO_BufferedReader_Demo_FileReader(FileReader fr) {
        try {

            fr = new FileReader("C:\\Users\\65404\\Desktop\\learn" +
                    "ingJava\\test\\IO实验BufferedReader.txt");

            char[] buf = new char[1024];
            int len = 0;
            while ((len=fr.read(buf)) != -1) {
                System.out.println(new String(buf, 0, len));
            }

//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fr != null) fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}


