public class bubble_sort {

    public static void main(String[] args) {
        int[] list0 = {41, 52, 12, 22 , 51, 33, 53, 15};

        int b = (list0.length);
        int w = 0;

        while (w<b) {
            int a = 0;
            for (; a<b-1;) {
                int a1 = a+1;
                if (list0[a]<list0[a1]) {
                    a += 1;
                }
                if (list0[a]>list0[a1]) {
                    int i1 = list0[a1];
                    list0[a1] = list0[a];
                    list0[a] = i1;
                    a+=1;
                }
            }
            w+=1;
        }
        for (int q=0;q<b;q++){System.out.print(list0[q]+" ");}

//        for (int q=0; q<b; q+=1) {
//            System.out.print(list0[q] + " ");
//        }
    }
}
