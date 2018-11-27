package BiXiangDong.IO_Learning;

import java.io.*;

/**
 * 练习:
 *  需求:
 *      将一个指定目录下, 指定扩展名的文件(包含子目录)写入到一个文本文件当中
 *  思路:
 *      1, 必须进行深度遍历
 *      2, 需要过滤器
 *      3, 需要将结果存储到容器中
 *      4, 将容器的数据写入到文本文件中
 *  注意:
 *      由于要写入文本文件的文件名比较多,
 *      建议过滤之后将结果存储到容器中,
 *      不建议直接进行写入操作!
 */
public class IO_Test2_getDirListName_toTxt {
    public static void main(String[] args) throws IOException {
        String dir = "C:\\Users\\65404\\Desktop\\learningJava\\test";
        String txtFile = "C:\\Users\\65404\\Desktop\\learningJava\\test\\DirName.txt";
        //  将遍历的结果直接写入文本文件中
//        getDirListName_for_txt(dir, txtFile);
        //  将遍历的结果先写入字符容器中, 最后将字符容器中的数据转为字符串再写入文本文件中
        getDirListName_for_txt1(dir, txtFile, ".txt");
//        File file = new File(dir, txtFile);
//        getDirListName_for_txt1(dir, file, ".txt");
    }

    private static void getDirListName_for_txt(String s, String s1) throws IOException {
        //  指定目录对象
        File dir = new File(s);
        //  指定文本文件对象
        File file = new File(s1);
        //  输出流对象
        BufferedWriter bufferedWriter = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(file, true)));
        //  健壮性判断, 指定文本文件是否存在
        if (!file.exists()) {
            file.createNewFile();
        }
        //  调用递归方法
        getDirName_Recursive(dir, bufferedWriter);
        //  输出流刷新
        bufferedWriter.flush();
    }

    private static void getDirName_Recursive(File dir, BufferedWriter bufferedWriter) throws IOException {
        //  获取指定目录的子文件和子目录, 接收文件名过滤器
        File[] files = dir.listFiles(new FilenameFilter_txt("txt"));
        //  遍历子文件和子目录
        for (int x = 0; x < files.length; x++) {
            //  如果是子目录, 调用本方法进行递归动作
            if (files[x].isDirectory()) {
                getDirName_Recursive(files[x], bufferedWriter);
            //  如果是子文件, 将文件的绝对路径写入文本文件, 并写入换行
            } else {
                bufferedWriter.write(files[x].getAbsolutePath());
                bufferedWriter.newLine();
            }
        }
        //  最后, 将此目录的目录名写入文本文件,并写入换行
        bufferedWriter.write(dir.getAbsolutePath());
        bufferedWriter.newLine();
    }

/*__________________________________________________________________________________*/

    /**
     *
     * @param s     指定需遍历的目录
     * @param s1    指定目标文本文件
     * @param s2    接收 过滤器需保留的文件的后缀名
     * @throws IOException
     */
    private static void getDirListName_for_txt1(String s, String s1, String s2) {
        //  指定目录对象
        File dir = new File(s);
        //  指定文本文件对象
        File file = new File(s1);
        //  后缀名
        String suffix = s2;
        //  字符容器
        StringBuilder stringBuilder = new StringBuilder();

        //  输出流对象
        BufferedWriter bufferedWriter = null;
        //  遍历和写入操作...
        try {
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true)));

            //  调用递归方法
            getDirName_Recursive1(dir, stringBuilder, suffix);

            //  将字符容器中的数据写入到文本文件中
            bufferedWriter.write(stringBuilder.toString());
            //  输出流刷新
            bufferedWriter.flush();
        } catch (IOException e) {
            throw new RuntimeException("写入失败");
        } finally {
            try {
                assert bufferedWriter != null;
                bufferedWriter.close();
            } catch (IOException e) {
                throw new RuntimeException("关闭异常");
            }
        }
    }

    private static void getDirName_Recursive1(File dir, StringBuilder stringBuilder, String suffix) throws IOException {
        //  获取指定目录的子文件和子目录, 接收文件名过滤器
        File[] files = dir.listFiles(new FilenameFilter_txt(suffix));
        //  遍历子文件和子目录
        for (int x = 0; x < files.length; x++) {
            //  对遍历到的子目录, 调用本方法进行递归动作
            if (files[x].isDirectory()) {
                getDirName_Recursive1(files[x], stringBuilder, suffix);
                //  对遍历到的文件, 将文件的绝对路径添加到字符容器, 并写入换行
            } else {
                stringBuilder.append(files[x].getAbsolutePath());
                stringBuilder.append(System.getProperty("line.separator"));
            }
        }
        //  最后, 将此目录的目录名添加到字符容器中,并写入换行
        stringBuilder.append(dir.getAbsolutePath());
        stringBuilder.append(System.getProperty("line.separator"));
    }
}

//  用于保留指定文件名后缀的文件的过滤器, 接收文件名后缀字符串.
class FilenameFilter_txt implements FilenameFilter {
    String suffix;
    FilenameFilter_txt(String suffix) {
        super();
        this.suffix = suffix;
    }
    @Override
    public boolean accept(File dir, String name) {
        return name.endsWith(suffix);
    }
}
