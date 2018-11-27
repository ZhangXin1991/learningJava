class shiyan1 {
    private int[] n1;
    public void n3() {
//        for (int x = 0; x<n1.length; x++) {
        for (int x : n1) {
            System.out.println(n1[x]);
        }
    }

    public void setN1(int[] n1) {
        this.n1 = n1;
    }

    public int[] getN1() {
        return this.n1;
    }
    public shiyan1() {}
    public shiyan1(int[] n1) {
        this.n1 = n1;
    }
}

class shiyan2{
    public static void main(String args[]) {
        int [] p1 = new int[] {1, 3, 4, 5};
        shiyan1 s1 = new shiyan1(p1);
        s1.n3();
    }
}