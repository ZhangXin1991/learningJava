public class PhraseOMatic {
    public static void main(String[] args) {
        String[] wordListOne   = {"天机", "荒火", "翎羽", "魍魉", "龙巫"};
        String[] wordListTwo   = {"力", "魂", "敏", "疾", "体", "念"};
        String[] wordListThree = {"睿智", "脑残", "智障", "手残", "狗蹦子", "菜比", "咸鱼"};

        int oneLength  = wordListOne.length;
        int twoLength  = wordListTwo.length;
        int threeLength = wordListThree.length;

        int rand1 = (int) (Math.random() * oneLength);
        int rand2 = (int) (Math.random() * twoLength);
        int rand3 = (int) (Math.random() * threeLength);

        String phrase = wordListThree[rand3] + "\t" + wordListTwo[rand2] + wordListOne[rand1];
        System.out.println("What we need is a " + phrase);


    }
}
