package BiXiangDong.IO_Learning;

import java.io.*;
import java.util.*;

/**
 * 文件切割器....
 */
class IO_Test3_File_qiegeqi1 {
    public static void main(String[] args) throws IOException {
        String filename = "C:\\Users\\65404\\Desktop\\learningJava\\test\\00 热くなれ.flac";
        String partDir = "C:\\Users\\65404\\Desktop\\learningJava\\test\\QieGe_partDir";
        //  文件切割...
//        IO_Test3_File_qiegeqi TempDemo = new IO_Test3_File_qiegeqi(filename, partDir, 3);
//        TempDemo.easyMothed();

        //  文件合并...
        IO_Test3_File_hebing Temp1Demo = new IO_Test3_File_hebing(partDir);
        Temp1Demo.hebing_Mothed();
    }
}


class IO_Test3_File_qiegeqi {

    public int num = 1; //  size的倍数
    private int size = 1024 * 1024;//   1M
    private File file;  //  需切割的文件
    private File dir;   //  切割后的文件目录
    private int count;  //  切割后的文件计数器

    IO_Test3_File_qiegeqi(String filename, String partDir) {
        this.file = new File(filename);
        this.dir = new File(partDir);
    }
    IO_Test3_File_qiegeqi(String filename, String partDir, int num) {
        this(filename, partDir);
        if (num > 0) {
            this.num = num;
        } else {
            throw new RuntimeException("数字小于1");
        }
    }

    public void easyMothed(/*File file, File dir*/) throws IOException {
        //  用读取流关联源文件
        FileInputStream fileInputStream = new FileInputStream(this.file);
        //  定义1M的缓冲区
        byte[] buf = new byte[size*num];

        //  创建目的
        FileOutputStream fileOutputStream = null;
        //  判断指定目录是否存在, 如不存在则创建
        if (!dir.exists()) {
            boolean newFile = dir.mkdirs();
        }
        int len = 0;
        int count = 1;
        //  用文件字节流循环读取目标文件, 并将每次读取的数据用文件字节输出流写入新的文件当中, 切割文件计数器++
        while ((len = fileInputStream.read(buf)) != -1) {
            fileOutputStream = new FileOutputStream(new File(dir, (count++) + " " + file.getName() + ".part"));
            fileOutputStream.write(buf);
            fileOutputStream.close();
        }

    /**
     *  添加config文件, 方便合并
     *  记录切割文件的名称
     *  记录切割后文件的数量
     *  下列代码中使用了 Properties集合, FileWriter文件字符输出流
     */
//        File config = new File(dir, "config.ini");
        Properties properties = new Properties();
        properties.setProperty("fileName", this.file.getName());
        properties.setProperty("partCount", String.valueOf(count));
        FileWriter fileWriter = new FileWriter(new File(dir, "config.ini"));
        properties.store(fileWriter, "喵喵喵...");

        fileOutputStream.close();
        fileInputStream.close();
        fileWriter.close();
    }

}

class IO_Test3_File_hebing {
    private File dir ;
    IO_Test3_File_hebing(String pathname){
        this.dir = new File(pathname);
    }
    public void hebing_Mothed() throws IOException {
        //  获取指定目录的子文件
        File[] files = dir.listFiles();


        //  读取配置文件的数据 config.ini
        Properties properties = getProperties();
        //  获取 "fileName"键的值 和 "partCount"键的值
        String fileName = properties.getProperty("fileName");
        int partCount = Integer.parseInt(properties.getProperty("partCount"));


        //  获取文件碎片的数量 并 与config.ini文件中的数据进行比较
        verdictPartCount(partCount);


        //  创建并获取 文件字节读取流对象集合
        ArrayList<FileInputStream> arrayList = getFileInputStreams(files);


        //  将多个流合并成一个序列流
        SequenceInputStream sis = getSequenceInputStream(arrayList);


        //  合并文件
        merge(sis);
    }

    private void merge(SequenceInputStream sis) throws IOException {
        //  创建字节写入流对象, 传入指定目录名+文件名称
        FileOutputStream fileOutputStream = new FileOutputStream(new File(dir, "heihei.flac"));
        //  字节计数器
        int len = 0;
        //  字节容器
        byte[] buf = new byte[1024 * 3];
        //  用合并字节读取流循环读取数据, 并将读取到的数据写入指定文件,刷新
        while ((len = sis.read(buf)) != -1) {
            fileOutputStream.write(buf, 0, len);
            fileOutputStream.flush();
        }

        //  关闭资源...
        sis.close();
        fileOutputStream.close();
    }

    private SequenceInputStream getSequenceInputStream(ArrayList<FileInputStream> arrayList) {
        //  将字符读取流容器转换为集合
        Enumeration<FileInputStream> en = Collections.enumeration(arrayList);
        //  创建合并字节读取流对象, 接收字节读取流集合
        return new SequenceInputStream(en);
    }

    private ArrayList<FileInputStream> getFileInputStreams(File[] files) throws FileNotFoundException {
        //  创建字节读取流容器
        ArrayList<FileInputStream> arrayList = new ArrayList<FileInputStream>();
        //  遍历目录中子文件, 并创建对应的字节读取流, 最后添加到字节读取流容器
        for (File file : files) {
            arrayList.add(new FileInputStream(file.getAbsolutePath()));
        }
        return arrayList;
    }

    private void verdictPartCount(int partCount) {
        File[] fileNums = dir.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".part");
            }});
        if (fileNums.length != (partCount-1)) {
            throw new RuntimeException("合并文件数量异常, 应该是"+(partCount-1));
        }
    }

    private Properties getProperties() throws IOException {
        File[] filesT = this.dir.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.contains("config.ini");
            }
        });
        //  如果config.ini文件的数量!=1,则抛出异常
        if (filesT.length != 1) {
            throw new RuntimeException("config.ini文件异常");
        }
        //  获取过滤出的config.ini文件
        File configFile = filesT[0];
        //  创建文件字节读取流对象, 并关联config.ini文件
        FileInputStream fileReader = new FileInputStream(configFile);
        //  创建属性集合, 并关联文件字节读取流对象
        Properties properties = new Properties();
        properties.load(fileReader);
        return properties;
    }

    private void read_config(String filename, int partCount) throws IOException {
        Properties properties = getProperties();
        filename = properties.getProperty("fileName");
        partCount = Integer.parseInt(properties.getProperty("partCount"));

    }
}
