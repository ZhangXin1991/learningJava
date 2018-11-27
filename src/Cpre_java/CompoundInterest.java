package Cpre_java;

/*
Core Java by page 87;
二维数组;   矩阵
不同利率下的投资增长情况
 */
public class CompoundInterest {
    public static void main(String[] args){
        final double STARTRATE = 10;    //  开始的利率
        final int NRATES = 6;   //  列
        final int NYEARS = 10;  //  行

        double[] interestRate = new double[NRATES];     //  创建利率数组
        for (int j = 0; j < interestRate.length; j ++){ //  递增10%, 循环写入利率数组
            interestRate[j] = (STARTRATE + j) / 100.0;
        }

        double[][] balances = new double[NYEARS][NRATES];   //  创建矩阵数组

        for (int j = 0; j < balances[0].length; j ++)   //  [0][0]保存10000, 循环写入至[0][5]
            balances[0][j] = 10000;

        for (int i = 1; i < balances.length; i ++){
            for (int j = 0; j < balances[i].length; j ++){
                double oldBalance = balances[i - 1][j]; //  保存上一行的同一个位置的value

                double interest = oldBalance * interestRate[j]; //  利息 = 上期余额 * 利率数组对应的利率

                balances[i][j] = oldBalance + interest; //  保存新的余额 = 上期余额 + 利息
            }
        }

        for (int j = 0; j < interestRate.length; j ++)  //  循环 利率数组
            System.out.printf("%9.0f%%", 100 * interestRate[j]);    //  打印每次循环的利率

        System.out.println();   //  换行

        for (double[] row :balances){   //  循环 余额数组中的数组
            for (double b : row)        //  枚举 余额数组中的数组中的元素
                System.out.printf("%10.2f", b); //  把枚举的元素打印出来...

            System.out.println();       //  换行...
        }
    }
}
