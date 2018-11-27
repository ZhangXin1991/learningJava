package BiXiangDong.Thread_learning;
/*
wait notify方法测试
 */

class AnimalLibrary
{
    private String name;
    private String sex;
    private boolean flag = false;
//    private int x = 0;


    public AnimalLibrary(){}

    public void setName(String name) {
        this.name = name;
    }
    public String getName()
    {
        return this.name;
    }

    public String getSex() {
        return sex;
    }

    public void setFlag(boolean flag)
    {
        this.flag = flag;
    }
    public boolean getFlag()
    {
        return this.flag;
    }

    public void setNameAndSex(String name, String sex)
    {
        this.name = name;
        this.sex = sex;
    }

    public String getNameAndSex()
    {
        return "name: " + this.getName() + ", sex: " + this.getSex();
    }

    public synchronized void out()
    {
        if (!flag)
        {try { this.wait(); } catch (InterruptedException interrupted_exception){}}
        System.out.println(this.getNameAndSex());
        this.setFlag(false);
        this.notify();
    }
    public synchronized void in(String name, String sex)
    {
        if (flag)
        { try { this.wait(); } catch (InterruptedException interrupted_exception) {} }
//        if (x == 0)
////        { this.setNameAndSex("旺财", "狗"); }
////        else
////        { this.setNameAndSex("来福", "猫"); }
////        x = (x+1) % 2;
        this.setNameAndSex(name, sex);
        this.setFlag(true);
        this.notify();
    }

}

class InputAnimal_Library implements Runnable
{
    public AnimalLibrary al;
    private int x = 0;

    public InputAnimal_Library(AnimalLibrary al)
    {
        this.al = al;
    }

    public void run()
    {
        while (true)
        {
            if (x == 0)
            {
                al.in("旺财", "狗");
            }
            else
            {
                al.in("来福", "猫");
            }
            x = (x + 1) % 2;
        }
    }
}

class OutputAnimal_library implements Runnable
{
    public AnimalLibrary al;
    public OutputAnimal_library(AnimalLibrary al)
    {
        this.al = al;
    }

    public void run()
    {
        while (true)
        {
            al.out();
        }
    }
}
public class ThreadWaitNotifyTest0 {
    public static void main(String[] args) {
        //  创建线程对象
        AnimalLibrary al = new AnimalLibrary();

        //  创建任务
        InputAnimal_Library inputal = new InputAnimal_Library(al);
        OutputAnimal_library outputal = new OutputAnimal_library(al);

        //  创建线程
        Thread t0  = new Thread(inputal);
        Thread t1 = new Thread(outputal);

        //  启动线程
        t0.start();
        t1.start();
    }
}
