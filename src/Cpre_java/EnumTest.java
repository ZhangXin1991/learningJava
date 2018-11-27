package Cpre_java;

import java.util.Scanner;

/**
 * Enum的范例
 *
 * abbreviation : 缩写
 * .toUpperCase(); 转换成大写字母方法
 */
public class EnumTest {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.print("enter a size: (SMALL, MEDIUM, LARGE, EXTRA_LARGE)");
        String input = in.next().toUpperCase();                         //  将获取的输入转换成大写

        //  创建一个Size类型的size枚举类, 并传入给定类型的枚举常量, 名字
        Size size = Enum.valueOf(Size.class, input);

        System.out.println("size=" + size);
        System.out.println("abbreviation=" + size.getAbbreviation());
        if (size == Size.EXTRA_LARGE)
            System.out.println("Good job--you paid attention to the_.");
    }
}

enum Size{                                                              //  创建枚举类
    SMALL("S"), MEDIUM("M"), LARGE("L"), EXTRA_LARGE("XL");             //  定义四个实例

    private Size(String abbreviation){this.abbreviation = abbreviation;}//  枚举类的构造方法!!!
    public String getAbbreviation(){return this.abbreviation;}          //  get方法...

    private String abbreviation;                                        //  声明 缩写


}
