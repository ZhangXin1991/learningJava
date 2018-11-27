package BiXiangDong.String_Method_Demo;

/*
基本数据类型对象包装类

 */
public class WrapperDemo {
    public static void main(String[] args) {
        /*
        基本数据类型对象包装类
        为了方便操作基本数据类型值, 将其封装成了对象, 在对象中定义了属性和行为丰富了
        该数据的操作
        用于描述该对象的类就称为基本数据类型对象包装类

        byte    Byte
        short   Short
        int     Integer
        long    Long
        float   Float
        double  Double
        char    Character
        boolean Boolean

        改包装对象主要用于基本类型和字符串之间的转换

        基本类型--->字符串
            1,基本类型数值+""
            2,用string类中的静态方法valueOf(基本类型数值);
            3,用Integer的静态方法valueOf(基本类型的数值);

        字符串---->基本类型
            1,使用包装类中的静态方法:
                返回:xxx parsexxx("xxx类型字符串")     parse:转换
                int parseInt("intstring");
                long parseLong("longstring");
                boolean parseBoolean("booleanstring");
                只有Character没有parse方法, 因为字符串就是有char组成的
            2,如果字符串被Integer进行对象的封装
                可以使用另一个非静态的方法: intValue();

         */

        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.toBinaryString(-6));

        int num = 4;
        //  把int类型转换成Integer类型
        Integer i = num;
        System.out.println(i);      //  4

        //  把字符串类型的数字转换成integer类型
        int x = Integer.parseInt("123");
        System.out.println(x);      //  123
        System.out.println(Integer.parseInt("321") + 1);//  322

        char cha = 'A';             //  创建一个char类型的字符
        Character ch = cha;         //  将char类型转换成Character类型
        //  Character.toLowerCase()方法可以将一个character类型转换为小写
        System.out.println(Character.toLowerCase(cha));

        /*
        整数具备不同的禁止体现

        十进制-->其它进制

        其它进制-->十进制
         */

        //  十进制 --> 其它进制
        //  toBinaryString(int i)
        //      - 以二进制(基数2)无符号整数形式返回一个整数参数的字符串表示形式
        System.out.println(Integer.toBinaryString(60)); //  111100

        //  toHexString(int i)
        //      - 以十六进制(基数16)无符号整数形式返回一个整数参数的字符串表示形式
        System.out.println(Integer.toHexString(60));    //  3c

        //  toOctalString(int i)
        //      - 以八进制(基数8)无符号整数形式返回一个整数参数的字符串表示形式
        System.out.println(Integer.toOctalString(60));  //  74

        //  toString(int, radix)
        //      - 以radix进制(基数radix)无符号整数形式返回一个整数参数的字符串表示形式
        System.out.println(Integer.toString(60,4));// 330

        //  其它进制 --> 十进制
        //      - 以radix进制(基数radix)无符号证书形式返回一个整数参数的字符串
        // 表示形式, 第一个字符串参数必须符合radix进制形式 !
        System.out.println(Integer.parseInt("110", 2));//   6

        Integer a = new Integer("3");
        Integer b = new Integer(3);
        //  关键字new 创建的对象不同, 所以a==b返回false
        System.out.println(a==b);       //  false
        //  equals(obj)方法检测内容是否相同, 所以返回true
        System.out.println(a.equals(b));//  true
        //  compareTo(int)方法检测内容是否相同,
        //  相同返回0, int大返回-1(负数), int小返回1(整数)
        System.out.println(a.compareTo(b));//   0

        //  自动装箱, JDK1.5以后, 如果装箱的是一个字节, 那么该数据会被共享.
        //  不会重新开辟内存空间. (一个字节:1-127)
        Integer integera = 127;
        Integer integerb = 127;
        Integer integerc = 128;
        Integer integerd = 128;
        System.out.println(integera == integerb);     //  true
        System.out.println(integerc == integerd);     //  false
        System.out.println(integera.equals(integerb));//    true
        System.out.println(integerc.equals(integerd));//    true
    }
}
