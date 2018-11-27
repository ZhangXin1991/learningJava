package BiXiangDong.String_Method_Demo;

/**
 * 十进制转换成十六进制的方法
 */

public class ConversionNumber {
    public static void main(String[] args) {
        toHex(60);
        toBinary(60);
        toOctal(60);
    }

    public static void toHex(int num)
    {
        trans(num, 15, 4);
    }

    public static void toBinary(int num)
    {
        trans(num, 1, 1);
    }
    public static void toOctal(int num)
    {
        trans(num, 7, 3);
    }
    /**
     *
     * @param num   需要处理的十进制数字
     * @param base  十进制的转换规律(十转16: &15; 十转2: &1; 十转8: &7;)
     * @param offset 每次位移的精度(十转16: >>>4; 十转2: >>>1; 十转8: >>>3;
     */
    public static void trans(int num, int base, int offset)
    {
        if (num == 0)
        {
            System.out.println('0');
            return;
        }

        //  定义对应关系表
        char[] chs = {'0', '1', '2', '3',
                        '4', '5', '6',
                        '7', '8', '9',
                        'A', 'B', 'C',
                        'D', 'E', 'F'};

        //  用来保存数据的数组
        char[] arr = new char[8];
        //  指针初始化
        int pos = arr.length;

        while (num != 0)
        {
            int temp = num & base;    //  十进制的转换规律
            arr[--pos] = chs[temp]; //  利用指针(pos)把数据储存到arr数组中的指定位置, 利用查表法输出chs中的数据
            num = num >>> offset;        //  >>>是位移符号, 二进制的运算符; 每次向右位移offset位
        }

        //  利用pos最后停留的角标作为循环的开始
        for (int x = pos; x < arr.length; x++)
        {
            System.out.print(arr[x]);
        }
        System.out.println();
    }
}
