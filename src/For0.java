public class For0 {
    public static void main(String[] args) {
        int a;
        int b;


        for (a=1; a<10; a++) {
            for (b=1; b<(a+1); b++) {
                System.out.print(a + "*" + b + "=" + a*b + "  ");
            }
            System.out.println("\n");
        }

        for (a=9; a>0; a--) {
            for (b=a; b>0; b--) {
                System.out.print(a + "*" + b + "=" + a*b + "  ");
            }
            System.out.println("\n");
        }
    }
}

