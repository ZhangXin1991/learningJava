public class Exercise {
    public static void main(String[] args) {
        int x = 0;
        int y = 0;
        while (x < 5) {
//            y = x - y;  // 00 11 21 32 42
//            y = y + x;  // 00 11 23 36 410
//            y = y + 2;  //02 14 25 36 47
//            if (y > 4) {
//                y = y - 1;
//            }

            System.out.println(x + " " + y + " ");
            x += 1;
        }

        int p1 = 10;
        Integer p2 = 11;
        int p3 = p1 +p2;
        Integer p4 = p1 + p2;
        System.out.println(p1>p2);
        System.out.println(p3);
        System.out.println(p4);
        //java无法将小容器转换给大容器, 但反过来可以.
        short s = 10;
    }
}