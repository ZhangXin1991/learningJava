package BiXiangDong.IO_Learning;

import javafx.scene.control.Separator;

import java.awt.*;
import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 由于IO流只能操作数据,
 * 所以如果想要操作文件名/文件夹/文件属性等等
 * 就需要File类
 *
 * File
 * 文件   类
 * 已实现的接口:
 *      Serializable, Comparable<File>
 * 此类中常用的构造方法, 字段摘要, 类方法:
 *  构造方法:
 *      - File(File parent, String child)
 *        File从父抽象路径名 和 子路径名字符串 创建新实例(封装成对象
 *      - File(String pathname)
 *        File通过给定的路径名字符串 转换为 抽象路径名 创建新实例(封装成对象
 *      - File(String parent, String child)
 *        File从父路径名字符串 和 子路径名字符串 创建新实例(封装成对象
 *      - File(URI uri)
 *        File通过将给定的 file : URI 转换为抽象路径名 来创建新实例(封装成对象
 *   字段摘要:
 *      - static String
 *        pathSeparator
 *        与系统相关的路径分隔符, 为方便起见, 表示为字符串 ; :
 *      - static char
 *        pathSeparatorChar                           ; :
 *        与系统相关的路径分隔符
 *      - static String
 *        separator                                   \ /
 *        系统相关的默认名称分隔符, 为方便起见, 表示为字符串
 *      - static char
 *        separatorChar                               \ /
 *        系统相关的默认名称分隔符
 *   类方法:
 *      1, 获取
 *          1.1 获取文件名称                      返回String
 *              file.getName();
 *          1.2 获取文件路径                      返回String
 *              file.getAbsolutePath();
 *          1.3 获取文件大小                      返回long
 *              file.length();
 *          1.4 获取文件修改时间                   返回long
 *              file.lastModified();
 *          1.5 获取文件父目录                     返回String
 *              file.getParent();
 *      2, 文件的创建与删除
 *          2.1 将文件对象创建成文件                返回boolean
 *              file.createNewFile();
 *          2.2 在默认临时文件目录下创建一个文件     返回File
 *              File.createTempFile(prefix(文件名), suffix(后缀));
 *          2.3 将文件对象创建的文件删除             返回boolean
 *              file.delete();
 *          2.4 在虚拟机结束时, 删除文件对象的文件   返回void
 *              file.deleteOnExit();
 *      3, 文件夹的创建与删除
 *          3.1 创建目录                           返回boolean
 *              dir.mkdir();
 *          3.2 创建多级目录                       返回boolean
 *              dir.mkdirs();
 *          3.3 删除空目录                           返回boolean
 *              dir.delete();
 *          3.4 删除非空目录
 *              用递归方法对目录进行深度遍历, 从里往外删除
 *      4, 判断
 *          4.1 判断文件是否存在                    返回boolean
 *              file.exists();
 *          4.2 判断文件对象中的抽象路径是否是绝对路径 返回boolean
 *              file.isAbsolute();
 *          4.3 判断文件对象中的文件是否是标准文件    返回boolean
 *              file.isFile();
 *          4.4 判断文件对象中的文件是否是标准目录     返回boolean
 *              file.isDirectory();
 *          4.5 判断文件对象中的文件是否是隐藏文件     返回boolean
 *              file.isHidden();
 *          4.6 判断是否成功重新命名此抽象路径名表示的文件 返回boolean
 *              file.renameTo(File dest(目的地));
 *      5, 其它方法
 *          5.1 判断是否成功重新命名此抽象路径名表示的文件 返回boolean
 *              file.renameTo(File dest(目的地));
 *          5.2 表示文件对象中的抽象路径名表示的目录中的文件名和目录名 返回String[]
 *              file.list();
 *          5.3 为file.list()方法添加过滤器              返回String[]
 *              file.list(FilenameFilter filter);
 *          5.4 表示此抽象路径名表示的目录中的文件, 返回一个抽象路径名对象数组 File[]
 *
 *              file.listFiles();
 *          5.5 表示此抽象路径名表示的目录中满足指定过滤器的文件和目录,
 *              返回一个抽象路径名对象数组                返回File[]
 *              file.listFiles(FileFilter);
 *          5.6 表示此抽象路径名表示的目录中满足指定过滤器的文件和目录,
 *              返回一个抽象路径名对象数组                返回File[]
 *              file.listFiles(FilenameFilter);
 */
public class IO_Learning_4_File {
    public static void main(String[] args) throws IOException {
        /**
         * File构造方法的应用 与 File字段摘要的应用
         * 将一个已存在或者不存在的文件封装成File对象
         * C:\Users\65404\Desktop\learningJava\test\File_Demo
         */
//        create_File_Construction_Demo();
        /**
         * 1, 获取
         *   1.1 获取文件名称     返回String
         *      file.geiName();
         *   1.2 获取文件路径     返回String
         *      file.getAbsolutePath();
         *   1.3 获取文件大小     返回long
         *      file.length();
         *   1.4 获取文件修改时间  返回long
         *      file.lastModified();
         *   1.5 获取文件父目录    返回String
         *      file.getParent();
         */
//        file_method_get_Demo();
        /**
         * 2, 文件的创建与删除
         *   2.1 将文件对象创建成文件             返回boolean
         *      file.createNewFile();
         *   2.2 在默认临时文件目录下创建一个文件  返回File
         *      File.createTempFile(prefix(文件名), suffix(后缀));
         *   2.3 将文件对象创建的文件删除          返回boolean
         *      file.delete();
         *   2.4 在虚拟机结束时, 删除文件对象的文件 返回void
         *      file.deleteOnExit();
         *
         */
//        file_method_CreateAndDelete_Demo();
        /**
         * 3, 文件夹的创建与删除
         *   3.1 创建目录           返回boolean
         *      dir.mkdir();
         *   3.2 创建多级目录        返回boolean
         *      dir.mkdirs();
         *   3.3 删除目录           返回boolean
         *      dir.delete();
         */
//        file_method_DIR_CreateAndDelete_Demo();
        /**
         * 4, 判断
         *   4.1 判断文件是否存在                   返回boolean
         *      file.exists();
         *   4.2 判断文件对象中的抽象路径是否是绝对路径返回boolean
         *      file.isAbsolute();
         *   4.3 判断文件对象中的文件是否是标准文件    返回boolean
         *      file.isFile();
         *   4.4 判断文件对象中的文件是否是标准目录     返回boolean
         *      file.isDirectory();
         *   4.5 判断文件对象中的文件是否是隐藏文件     返回boolean
         *      file.isHidden();
         */
//        file_method_isOrCan_Demo();
        /**
         * 5, 其它方法
         *   5.1 判断是否成功重新命名此抽象路径名表示的文件 返回boolean
         *      file.renameTo(File dest(目的地));
         *   5.2 表示文件对象中的抽象路径名表示的目录中的文件名和目录名 返回String[]
         *      file.list();
         *   5.3 为file.list()方法添加过滤器              返回String[]
         *      file.list(FilenameFilter filter);
         *   5.4 表示此抽象路径名表示的目录中的文件, 返回一个抽象路径名对象数组 File[]
         *
         *      file.listFiles();
         *   5.5 表示此抽象路径名表示的目录中满足指定过滤器的文件和目录,
         *       返回一个抽象路径名对象数组                    返回File[]
         *      file.listFiles(FileFilter);
         *   5.6 表示此抽象路径名表示的目录中满足指定过滤器的文件和目录,
         *       返回一个抽象路径名对象数组                    返回File[]
         *      file.listFiles(FilenameFilter);
         */
//        file_method_Other_Demo();
        //  由于file_method_Other_Demo()方法中所用的过滤器功能过于单一, 故...写个新的...
//        file_method_Filter_Demo();
    }

    private static void create_File__Construction_Demo() {
        //  将一个已存在或者不存在的文件封装成File对象
        File file0 = new File("" +
                "C:\\Users\\65404\\Desktop\\learningJava\\test\\File_Demo.txt");
        //  将一个父路径名 和 这个父路径名的子路径名 封装成File对象
        File file1 = new File("" +
                "C:\\Users\\65404\\Desktop\\learningJava\\test\\", "File_Demo.txt");
        //  将一个父文件对象 和 这个父文件对象的子路径名 封装成File对象
        File file2 = new File("C:\\Users\\65404\\Desktop\\learningJava\\test\\");
        File file3 = new File(file2, "File_Demo.txt");
        //  由于多平台下要考虑兼容问题,
        //  所以要用 System.getProperty("file.separator") 或 File.separator 替换 "\"
        //  用 File.pathSeparator 替换 ";"
        File file4 = new File("C"+ File.pathSeparator + File.separator +
                "Users"+ File.separator +
                "65404"+ File.separator +
                "Desktop"+ File.separator +
                "learningJava"+ File.separator +
                "test"+ File.separator +
                "File_Demo.txt");
    }

    private static void file_method_get_Demo() {
        File file0 = new File("" +
                "C:" + /*File.pathSeparator +*/
                File.separator + "Users"
                + File.separator +
                "65404" + File.separator +
                "Desktop" + File.separator +
                "learningJava" + File.separator +
                "test" + File.separator +
                "File_class.txt");
        String name = file0.getName();
        String absolutePath = file0.getAbsolutePath(); // 绝对路径
        String path = file0.getPath();      //  路径 path() = File构造方法接收的路径名
        long len = file0.length();          //  文件大小
        long time = file0.lastModified();   //  最后一次修改时间
        //  创建时间对象, 并接收time
        Date date = new Date(time);
        //  创建时间格式化对象, 并传入字符摘要设置格式
        DateFormat dateFormat =
                DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
        //  创建String类变量str_time用于接收时间格式化对象格式化的时间
        String str_time = dateFormat.format(date);//    格式化后的最后一次修改时间
        String parent = file0.getParent();  //  接收父目录 无法拿到相对路径的父目录
    }

    private static void file_method_CreateAndDelete_Demo() throws IOException {
        File file = new File("" +
                "C:" + /*File.pathSeparator +*/
                File.separator + "Users"
                + File.separator +
                "65404" + File.separator +
                "Desktop" + File.separator +
                "learningJava" + File.separator +
                "test" + File.separator +
                "File_class.txt");
        //  创建文件对象的文件   如果文件存在 则啥也不干...不会覆盖...
        boolean createNewFile = file.createNewFile();
        //  static 返回File   在默认临时文件目录中创建一个文件.
        // 参数:prefix(接收文件名) 参数:suffix(后缀名)
        File file1 = File.createTempFile("文件名", "txt");
        //  删除文件对象的文件
        boolean deleteFile = file.delete();
        //  在虚拟机结束时, 删除文件对象的文件
        file.deleteOnExit();
    }

    private static void file_method_DIR_CreateAndDelete_Demo() {
        File dir = new File("" +
                "C:" + /*File.pathSeparator +*/
                File.separator + "Users"
                + File.separator +
                "65404" + File.separator +
                "Desktop" + File.separator +
                "learningJava" + File.separator +
                "test" + File.separator +
                "File_DIR");
        //  创建一个目录 make directory
        boolean createNewDIR = dir.mkdir();
        //  //  可以指定要创建的File_DIR文件夹内含有Files文件夹 如:"File_DIR//Files"
        boolean createNewDIRs = dir.mkdirs();
        //  删除文件对象创建的目录, 当文件目录包含时无法删除
        //  如文件创建时是多级目录, 只能删除最后一个目录 如:"File_DIR//Files"中的"Files"
        boolean deleteDIR = dir.delete();
    }

    private static void file_method_isOrCan_Demo() {
        File file = new File("" +
                "C:" + /*File.pathSeparator +*/
                File.separator + "Users"
                + File.separator +
                "65404" + File.separator +
                "Desktop" + File.separator +
                "learningJava" + File.separator +
                "test" + File.separator +
                "File_DIR");
        //  判断文件对象中的文件是否存在  exists: 存在
        boolean fileIsExists = file.exists();
        //  判断文件对象中的抽象路径名是否是绝对路径
        boolean filePathAbsolute = file.isAbsolute();
        //  判断文件对象中的文件是否是标准文件   如果文件不存在返回false
        boolean fileIsFile = file.isFile();
        //  判断文件对象中的文件是否是标准目录   如果文件不存在返回false
        boolean fileIsDirectory = file.isDirectory();
        //  判断文件对象中的文件是否是隐藏文件   如果文件不存在返回false
        boolean fileIsHidden = file.isHidden();
    }

    private static void file_method_Other_Demo() {
        File file = new File("" +
                "C:" + /*File.pathSeparator +*/
                File.separator + "Users"
                + File.separator +
                "65404" + File.separator +
                "Desktop" + File.separator +
                "learningJava" + File.separator +
                "test" + File.separator +
                "File_DIR");
        File file0 = new File("" +
                "C:\\Users\\65404\\Desktop\\learningJava\\test");
        //  重新命名此抽象路径名表示的文件
        boolean fileRenameTo = file.renameTo(file0);

        //  打印当前文件对象内包含的文件和隐藏文件名称
        //  调用此方法前必须确定此文件对象的抽象路径表示的是目录而不是文件, 否则发生空指针异常
        //  如果返回的是空数组, 代表此文件路径表示的目录中是空的
        String[] namelist = file0.list();
        for (int x = 0; x < namelist.length; x++)
            System.out.println(namelist[x]);

        //  添加一个FilenameFilter接口过滤器, 用来筛选list数组中添加的文件名
        //  此处为 只保留含有 "IO" 字符的文件名
        String[] FilterList = file0.list(new FilterByFilenameIO());
        for (String str : FilterList)
            System.out.println(str);

        //  此处为 只保留非隐藏文件的文件名
        String[] FilterList1 = file0.list(new FilterByFilenameHidden());
        for (String string : FilterList1)
            System.out.println(string);
        int num = FilterList1.length;
        System.out.println(num);


        //  表示此抽象路径名表示的目录中的文件, 返回一个抽象路径名对象数组
        //  可以添加一个FileFilter接口的过滤器, 用来筛选listFiles数组中添加的文件
        File[] files = file0.listFiles(new FilterByFileWord());
        for (File tempFile:files)
            System.out.println(tempFile.getName());
        //  TEST: 用 file.listFiles(FileFilter pathname)方法 过滤掉隐藏文件
        File[] files0 = file0.listFiles(new FilterByFileFilterHidden());
        for (File tempFile:files0)
            System.out.println(tempFile);
    }

    private static void file_method_Filter_Demo() {
        File dir = new File("C:"/*+ File.pathSeparator */+ File.separator +
                "Users"+ File.separator +
                "65404"+ File.separator +
                "Desktop"+ File.separator +
                "learningJava"+ File.separator +
                "test"/*+ File.separator +
                "File_Demo.txt"*/);
        //  使用dir.list(FilenameFilter)方法过滤不含"IO"字符的文件
//        String[] fileNames = dir.list(new FilenameFilter_string("IO"));
//        for (String tempFilename:fileNames)
//            System.out.println(tempFilename);
//        File[] files0 = dir.listFiles(new FileFilter_string("IO"));
//        for (File tempFile:files0)
//            System.out.println(tempFile);
//        File[] files1 = dir.listFiles(new FilenameFilter_string("IO"));
//        for (File tempFile:files1)
//            System.out.println(tempFile);
    }
}







////////////////////下列class为FilenameFilter接口 //////////////////////////////////

/**
 * 此类为实现File类中 dir.list(FilenameFilter);方法中的FilenameFilter过滤器接口
 * FilenameFilter接口中只有一个方法:
 * public boolean accept(File dir, String name)
 * 此方法接收 File类抽象目录 和 这个File类抽象目录中包含的 所有File类的String类型的文件名
 * 如accept方法结果return true  则list方法返回包含所需字符的文件列表
 * 如accept方法结果return false 则list方法返回不包含所需字符的文件列表
 *
 * 此FilenameFilter过滤器具体为筛选出文件名中包含 "IO" 的文件
 */
class FilterByFilenameIO implements FilenameFilter{

    @Override
    public boolean accept(File dir, String name) {

        return name.contains("IO");
    }
}

/**
 * 此为FilenameFilter过滤器为过滤隐藏文件, 保留非隐藏文件
 */
class FilterByFilenameHidden implements FilenameFilter{

    @Override
    public boolean accept(File dir, String name) {
//        File file = new File(dir, name);
//        boolean b = file.isHidden();
//        return  ! b ;
        return ! new File(dir, name).isHidden();
    }
}
//  此类为FilenameFilter接口过滤器, 可接收任意字符串, 筛选出包含此字符串的文件;
class FilenameFilter_string implements FilenameFilter {
    String string;
    FilenameFilter_string(String string) {
        super();
        this.string = string;
    }
    @Override
    public boolean accept(File dir, String name) {
        return name.contains(string);
    }
}


////////////////////下列class为FileFilter接口 //////////////////////////////////
/**
 * 此FileFilter过滤器功能同上, 为过滤隐藏文件, 保留非隐藏文件
 */
class FilterByFileFilterHidden implements FileFilter {
    @Override
    public boolean accept(File pathname) {
        return ! pathname.isHidden();
    }
}

/**
 * 此为实现File类中 dir.listFiles(FileFilter);方法,中的FileFilter过滤器接口
 * FileFilter接口中只有一个方法:
 * public boolean accept(FIle pathname)
 * 此方法接收 File类对象(抽象路径名)
 * 如accept方法结果return true  则list方法返回包含所需字符的文件列表
 * 如accept方法结果return false 则list方法返回不包含所需字符的文件列表
 *
 * 此FileFilter过滤器具体为筛选出文件名中包含 "新建 Microsoft Word" 的文件
 */
class FilterByFileWord implements FileFilter {

    @Override
    public boolean accept(File pathname) {
//        pathname.getName().contains("新建 Microsoft Word");
        return pathname.getName().contains("新建 Microsoft Word");
    }
}

//  此类为FileFilter接口过滤器, 可接收任意字符串, 筛选出包含此字符串的文件;
class FileFilter_string implements FileFilter {
    String string;

    FileFilter_string(String string) {
        super();
        this.string = string;
    }
    @Override
    public boolean accept(File pathname) {
        return pathname.getName().contains(string);
    }
}
//  此类为FileFilter接口过滤器, 可接收任意字符串, 筛选出不包含此字符串的文件;
class FileFilter_flaseString implements FileFilter {
    String string;

    FileFilter_flaseString(String string) {
        super();
        this.string = string;
    }
    @Override
    public boolean accept(File pathname) {
        return ! pathname.getName().contains(string);
    }
}