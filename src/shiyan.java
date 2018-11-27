public class shiyan {
    public static void main(String[] args) {
        System.out.println("this is my first line code");
        System.out.println("bitch java grammar!");
        int x = 3;
        String name = "dirk";
        x = x * 17;
        System.out.println("x is " + x);
        double d = Math.random();
        System.out.println("垃圾书, 没将Math, 更没有讲Math中的random方法!\n" +
                "声明的字符串变量name也没用到, \t" +
                "声明的double两位小数的变量d也没用到!\n" +
                "到底行不行啊!");
        while (x > 12) {
            x = x -1;
        }

        for (int x1 = 0; x1 < 10; x1 = x1 + 1) {
            System.out.println("x is now " + x1 + "\t\t第" + (x1+1) + "次循环");
        }
        System.out.println("这个for循环是从X1=0开始循环, 每循环一次" +
                "执行x1=x1+1, 直到x1不小于10为止, 共执行了10次\n" +
                "其中的x1变量为局域变量, 并不能在这条代码中使用, " +
                "目前也不知到如何把局域变量改成全局变量");
    }
}