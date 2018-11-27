package BiXiangDong.IO_Learning;

import java.io.*;

public class IO_Test0_KeyboardToFile {
    public static void main(String[] args) throws IOException {
        /**
         * 练习1:
         * 需求:
         *  将键盘录入的数据写入到一个文本文件当中
         *  文本文件:
         *    "C:\Users\65404\Desktop\learningJava\test\
         *    IO_Test0_KeyboardToFile.txt"
         */
//        KeyboardToFile();
        /**
         * 练习2:
         * 需求:
         *  将文本文件的数据读取并写入到控制台
         *  文本文件:
         *    "C:\Users\65404\Desktop\learningJava\test\
         *    IO_Test1_FileToConsole.txt"
         */
//        FileToConsole();
        /**
         * 练习3:
         * 需求:
         *  将两个文本文件中的数据读取并分先后写入到第三个文件
         *  文本文件0:
         *    "C:\Users\65404\Desktop\learningJava\test\
         *    IO_Test0_KeyboardToFile.txt"
         *  文本文件1:
         *    "C:\Users\65404\Desktop\learningJava\test\
         *    IO_Test1_FileToConsole.txt"
         *  文本文件3:
         *    "C:\Users\65404\Desktop\learningJava\test\
         *    IO_Test2_CopyTwoFileForThisFile.txt"
         */
//        CopyTwoFileForThisFile();
        /**
         * 练习4:
         * 需求:
         *  将桌面上的账单文件读取并写入到账单1文件中
         *  文件:
         *  "C:\Users\65404\Desktop\账单.docx"
         *  "C:\Users\65404\Desktop\账单1.docx"
         */
//        Read_DesktopZDtoConsole();
    }

    private static void KeyboardToFile() throws IOException {
        //  创建 1获取键盘标准输入流对象 2并传给字节流转字符流对象 3并传给字符流读取缓冲区
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //  创建 1将写入文件路径 2并传给字节流写入文件对象 3并传给字符流转字节流对象 4并传给字符流写入缓冲区
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream("" +
                "C:\\Users\\65404\\Desktop\\learningJava\\test\\IO_Test0_KeyboardToFile.txt")));
        //  创建字符串变量 用于接收字符流读取缓冲区每次读取一行的字符数据
        String line = null;
        //  使用字符流读取缓冲区循环读取字符数据并赋值给字符串变量line,
        // 再用字符流写入缓冲区将数据传给文件写入对象来写入, 并换行, 刷新;
        while ((line = bufferedReader.readLine()) != null) {
            if ("over".equals(line))
                break;
            bufferedWriter.write(line.toLowerCase());
            bufferedWriter.newLine();
            bufferedWriter.flush();
        }
//        bufferedReader.close();
//        bufferedWriter.close();
    }

    private static void FileToConsole() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(
                new FileInputStream("" +
                "C:\\Users\\65404\\Desktop\\learningJava\\test\\IO_Test1_FileToConsole.txt")));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            bufferedWriter.write(line.toUpperCase());
            bufferedWriter.newLine();
            bufferedWriter.flush();
        }
    }

    private static void CopyTwoFileForThisFile() throws IOException {
        BufferedReader bufferedReader0 = new BufferedReader(
                new InputStreamReader(new FileInputStream("" +
                        "C:\\Users\\65404\\Desktop\\learningJava\\test\\" +
                        "IO_Test0_KeyboardToFile.txt")));
        BufferedReader bufferedReader1 = new BufferedReader(
                new InputStreamReader(new FileInputStream("" +
                        "C:\\Users\\65404\\Desktop\\learningJava\\test\\" +
                        "IO_Test1_FileToConsole.txt")));
        BufferedWriter bufferedWriter = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream("" +
                        "C:\\Users\\65404\\Desktop\\learningJava\\test\\" +
                        "IO_Test2_CopyTwoFileForThisFile.txt")));
        String line = null;
        while ((line = bufferedReader0.readLine()) != null) {
            bufferedWriter.write(line);
            bufferedWriter.newLine();
            bufferedWriter.flush();
        }
        while ((line = bufferedReader1.readLine()) != null) {
            bufferedWriter.write(line);
            bufferedWriter.newLine();
            bufferedWriter.flush();
        }
    }

    private static void Read_DesktopZDtoConsole() throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(
//                new FileInputStream("C:\\Users\\65404\\Desktop\\账单.docx")));
//        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(
//                new FileOutputStream("C:\\Users\\65404\\Desktop\\账单1.docx")
//        ));
//        int len = 0;
//        char[] ch = new char[1024];
//        while ((len = bufferedReader.read(ch)) != -1) {
//            bufferedWriter.write(ch);
//            bufferedWriter.flush();
//        }
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("" +
                "C:\\Users\\65404\\Desktop\\账单.docx"));
        byte[] bytes = new byte[bufferedInputStream.available()];
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("" +
                "C:\\Users\\65404\\Desktop\\账单1.docx"));
        bufferedInputStream.read(bytes);
        bufferedOutputStream.write(bytes);
        bufferedOutputStream.flush();
//        System.out.println(new String(bytes));

    }

}
