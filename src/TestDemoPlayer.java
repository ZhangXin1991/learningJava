class Player{
    String pid;
    String name;
    Menpai MenPai;
    String DengJi;
    String XingBie;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public Menpai getMenPai() {
        return MenPai;
    }

    public void setMenPai(Menpai menPai) {
        MenPai = menPai;
    }

    public String getDengJi() {
        return DengJi;
    }

    public void setDengJi(String dengJi) {
        DengJi = dengJi;
    }

    public String getXingBie() {
        return XingBie;
    }

    public void setXingBie(String xingBie) {
        XingBie = xingBie;
    }

    public Player(){}
    public Player(String pid, String name, Menpai menpai, String dengJi, String xingBie){
        this.pid = pid;
        this.name = name;
        this.MenPai = menpai;
        this.DengJi = dengJi;
        this.XingBie = xingBie;
    }

    public String getInfo(){
        return "编号: " + this.pid + ", 姓名: " + this.name + ", 门派: " + this.MenPai.getMenpai() +
                ", 等级: " + this.DengJi + ", 性别: " + this.XingBie;
    }
}

class Menpai{
    String mid;
    String menpai;
    Player player;

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getMenpai() {
        return menpai;
    }

    public void setMenpai(String menpai) {
        this.menpai = menpai;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

    public Menpai(){}
    public Menpai(String mid, String menpai){
        this.mid = mid;
        this.menpai = menpai;
    }
    public String getInfo(){
        return "编号: " + this.mid + ", 门派: " + this.menpai ;
    }

}



public class TestDemoPlayer{
    public static void main(String[] args){
        Player zx = new Player();
        Player yr = new Player();
        Player jiu = new Player();
        Player qy = new Player();

        zx.setPid("01");
        yr.setPid("02");
        jiu.setPid("03");
        qy.setPid("04");

        zx.setName("妖风");
        yr.setName("怡然");
        jiu.setName("jiu");
        qy.setName("浅影");

        zx.setDengJi("79");
        yr.setDengJi("80");
        jiu.setDengJi("74");
        qy.setDengJi("69");

        zx.setXingBie("b");
        yr.setXingBie("b");
        jiu.setXingBie("g");
        qy.setXingBie("y");

        Menpai tianJi = new Menpai("01", "天机");
        Menpai bingXin = new Menpai("02", "冰心");
        Menpai yunLu = new Menpai("03","云麓");
        Menpai lingYu = new Menpai("04","翎羽");

        zx.setMenPai(tianJi);
        yr.setMenPai(yunLu);
        jiu.setMenPai(bingXin);
        qy.setMenPai(lingYu);

        tianJi.setPlayer(zx);
        yunLu.setPlayer(yr);
        bingXin.setPlayer(jiu);
        lingYu.setPlayer(qy);

        System.out.println(zx.getInfo() + "\n" + yr.getInfo() + "\n" + jiu.getInfo() + "\n" + qy.getInfo());

        System.out.println(tianJi.player.getName());
        System.out.println(yunLu.player.getName());
        System.out.println(bingXin.player.getName());
        System.out.println(lingYu.player.getName());
    }
}

