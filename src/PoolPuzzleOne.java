public class PoolPuzzleOne {
    public static void main(String [] arg) {
        int x = 0;
        while (x < 4) {
            System.out.println("a");
            if (x < 1) {
                System.out.println(" ");
            }
//            x += 2;
            System.out.println("n");
//            if (x > 0) {
            if (x > 1) {
                System.out.println("oyster");
                x += 2;
            }
            if (x == 1) {
                System.out.println("noys");
            }
            if (x < 1) {
                System.out.println("oise");
            }
            System.out.println("");
            x += 1;
        }
    }
}
//a noise            x>0  x<1  x>1  x>3  x<4   x+=1  x+=2  x-=2  x-=1
//annoys
//an oyster