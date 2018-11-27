package BiXiangDong.IO_Learning;

import java.awt.*;
import java.io.*;
import java.util.Properties;

/**
 * 练习:
 *  需求:
 *      定义功能, 获取一个应用程序的运行次数, 如果使用超过5次,
 *      给出使用次数已经到了请注册的提示. 并不要在运行程序
 *  思路:
 *      1, 应该有计数器
 *          每次程序启动, 计数器在原有的数字上+1
 *      2, 计数器应该是一个常量,
 *      3, 如何使用此计数器
 *          首先, 程序启动时, 应该先读取这个用于记录计数器信息的配置文件
 *          获取上一次的计数器次数, 并进行试用次数的判断
 *          其次, 对该次数进行自增, 并将自增后的次数重新存储到记录计数器信息的配置文件中
 *      4, 文件中的信息该如何进行存储并体现
 *          直接存储次数值可以, 但是不明确该数据的含义, 所以起名就变得很重要
 *          这就有了名字和值得对应, 所以可以使用键值对;
 *          有映射关系用Map集合搞定, 有需要读取硬盘上的数据,
 *          所以 Map + IO = Properties(属性
 *  注意:
 *      简单配置文件(configFile)可以用 ini格式
 *      复杂配置文件(configFile)可以用 xml格式
 */
public class IO_Test1_PropertiesTest {
    public static void main(String[] args) throws IOException {
        getAppCount();
    }

    public static void getAppCount() throws IOException {
        //  将配置文件封装成File对象
        File configFile = new File("C:\\Users\\65404\\Desktop\\" +
                "learningJava\\test\\" +
                "Test_Properties\\count.properties");
        File dir_Test_Properties = new File("C:\\Users\\65404\\Desktop\\" +
                "learningJava\\test\\" +
                "Test_Properties");

        //  健壮性判断, 如果Test_Properties目录不存在, 则创建Test_Properties目录
        if (!dir_Test_Properties.exists()) {
            boolean mkdirs = dir_Test_Properties.mkdirs();
//            System.out.println(mkdirs);
        }
        //  健壮性判断, 如果configFile文件不存在, 则创建configFile文件
        if (! configFile.exists()) {
            boolean b = configFile.createNewFile();
//            System.out.println(b);
        }

        //  创建 字符流 本地默认编码 读取configFile文件 的对象
        FileInputStream fileInputStream = new FileInputStream(configFile);

        //  创建 属性集合 对象
        Properties properties = new Properties();
        //  将 configFile文件的数据 加载到 属性集合对象中
        properties.load(fileInputStream);

        //  从集合中通过 time键 获取 数据
        String value = properties.getProperty("time");

        //  创建计数器, 记录获取到的次数; 用Integer类的parseInt();方法 来解析 字符串value
        int count = 0;
        if (value != null) {
            count = Integer.parseInt(value);
            if (count >= 5) {
//                System.out.println("使用次数已到, 请注册, 给钱...");
                throw new RuntimeException("使用次数已到, 请注册, 给钱...");
            }
        }
        //  记录之后, count++
        count++;

        // 将改变后的次数重新存储到configFile中; 将int类count 转换为 String类
        properties.setProperty("time", /*String.valueOf(count)*/Integer.toString(count));

        //  创建 字符流 本地默认编码 写入configFile文件 的对象
        FileOutputStream fileOutputStream = new FileOutputStream(configFile);

        //  将 字符流写入对象 和 注释 储存到
        properties.store(fileOutputStream, "此处应写些注释");

        //  最后关闭字符流
        fileInputStream.close();
        fileOutputStream.close();

    }
}
