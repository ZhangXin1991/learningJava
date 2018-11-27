package BiXiangDong.IO_Learning;

import java.awt.*;
import java.io.File;

/**
 * 对指定目录进行所有内容列出(包含子目录中的内容)
 * 对目录的深度遍历
 */
public class IO_Learning_5_File_Recursive {
    // 文件+目录计数器
    static int count = 0;
    public static void main(String[] args) {
        File file = new File("C:" + File.separator +
                "Users" + File.separator + "65404" + File.separator +
                "Desktop" + File.separator + "learningJava"+ File.separator +
                "test"+File.separator+"File_delete_AllDIR_test");
        /**
         * 对指定目录进行深度遍历 (递归模式)
         */
//        File_Recursive(file);
        /**
         * 对指定的目录进行深度遍历 , 并打印层级
         */
//        File_Recursive_count(file, 1);
        /**
         * 此递归思路最为清晰正确
         * 删除目录中的所有文件和目录
         * 使用递归方法, 深度遍历目录
         */
        test_delete_AllDIR(file);
    }

    private static void File_Recursive(File dir) {
        //  获取指定目录下当前所有文件/目录对象
//        File[] files;
//        if ((files = dir.listFiles()) != null) {
//            for (int x = 0; x < files.length; x++) {
//                System.out.println(files[x]);
//                File_recursion(files[x]);
//            }
//        }
        File[] files = dir.listFiles();
        for (int x = 0; x < files.length; x++) {
            if (files[x].isDirectory()) {
                File_Recursive(files[x]);
            }
            System.out.println(files[x]);
        }
    }

    private static void File_Recursive_count(File dir, int count) {

        String mark = getString(count);

        File[] files = dir.listFiles();
        for (int x = 0; x < files.length; x++) {
            if (files[x].isDirectory()) {
                System.out.println(mark + files[x].getName());

                File_Recursive_count(files[x], count++);
            } else
                System.out.println(mark + files[x].getName());
        }

    }

    private static void test_delete_AllDIR(File dir) {
        //  创建文件数组, 并获取目录中的所有文件
        File[] files = dir.listFiles();
        //  遍历数组中的所有文件和目录
        for (int x = 0; x < files.length; x++) {
            //  files[x]如果是目录
            if (files[x].isDirectory()) {
                //  递归本方法
                test_delete_AllDIR(files[x]);
            } else {
                //  files[x]如果不是目录, 打印此文件并删除此文件
                System.out.println(files[x] + ":" + files[x].delete());
            }
        }
        //  最后 删除接收的目录
        System.out.println(dir + ":" + dir.delete());

    }



    //  层级计数器 !不太对!
    private static String getString(int count) {
        String mark = "";
        for (int y = 0; y < count; y++) {
//            if (mark.length() == 0) {
//                mark+="|";
//            } else
                mark+="_";
        }
        return mark;
    }

}
