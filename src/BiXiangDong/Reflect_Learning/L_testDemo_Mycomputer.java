package BiXiangDong.Reflect_Learning;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class L_testDemo_Mycomputer {

    public static void main(String[] args) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        Mainboard mb = new Mainboard();
        mb.run();

        /**
         * 每次添加一个设备都需要修改代码传递一个新建设备对象
         * 需要不修改代码完成此动作
         * 不用new来完成, 而只获取其class文件, 在内部实现新建设备对象的动作
         */
//        mb.PCI(new SoundCard());

        //  创建配置文件对象, 并指定路径
        File configFile = new File("C:\\Users\\65404\\Desktop\\" +
                "learningJava\\test\\Test_reflect\\pci.properties");
        //  创建Properties对象(properties:属性)
        Properties prop = new Properties();
        //  创建用于读取配置文件字节流对象
        FileInputStream fileIn = new FileInputStream(configFile);
        //  将读取配置文件的字节流关联到Properties对象中
        prop.load(fileIn);
        //  遍历properties对象中的键值对, 获取className
        System.out.println(prop.size());
        for (int x = 0; x < prop.size(); x++) {
            String pciName = prop.getProperty("pci" + (x + 1));
            //  用Class去加载这个pci子类
            Class clazz = Class.forName(pciName);
            PCI pci = (PCI) clazz.newInstance();

            mb.PCI(pci);
        }

        fileIn.close();
    }
}
