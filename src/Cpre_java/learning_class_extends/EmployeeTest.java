package Cpre_java.learning_class_extends;



import jdk.jfr.Name;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

/*
employee: 职场人员
salary: 工资
hire: 雇佣
hireDay: 雇佣日期
raise: 提高
percent: 百分比
staff: 职员
 */
class Employee extends Person{
    private static int nextID;                  //  声明 静态整数类型的变量 ID  初始值为1

//    private final String name;                  //  声明 姓名
    private final LocalDate hireDay;            //  声明 入职日期
    private double salary;                      //  声明 薪酬
    //    private int id;                             //  声明 id
    private String id;
//    {                                           //  id自增长的初始化块
//        id = nextID;                            //  每次实例化时会把nextId赋值给id
//        nextID ++;                              //  nextId自动+1
//    }

    {                                           //  获取id的初始化块
//        Random random = new Random();           //  实例化随机
//        int i = random.nextInt(10000);          //  声明 随机出个数字, 范围10000
        int b = (int) (Math.random()*9999)+1000;//  声明 随机出个数字, 范围9999-1000
        //  我也不知道我为啥要这么做, 也许是因为太小的编号不好玩吧
        id = String.valueOf(b) + String.valueOf(nextID);//  把随机出的数字和nextID转换成String类型并相加后赋值给id
        nextID ++;                              //  nextID自增长, 保证每次实例化后不重复
    }

    public String getName() {
        return super.getName();
    }
    public double getSalary() {
        return salary;
    }
    public LocalDate getHireDay() {
        return hireDay;
    }
    public String getId(){
        return id;
    }


//    public int setId(){                        //  获取id, id的自增长的方法
////        id = nextID;
//        int r = nextID;
//        nextID ++;
//        return r;
//    }


    public Employee(){
        this.id = "初号...";
//        this.name = "萨摩耶";
        //  无法设定默认姓名   不知道为啥!
//        super();  也无法调用抽象超类Person的无参构造方法
        this.salary = 8848;
        this.hireDay = LocalDate.of(2008, 1,1);
    }
    public Employee(String name){
        this(name, 2800, 2008, 1, 1);
    }
    public Employee(String name, double salary){
        this(name, salary, 2008, 1, 1);
    }
    public Employee(String name, double salary, int year){
        this(name, salary, year, 1, 1);
    }
    public Employee(String name, double salary, int year, int month){
        this(name, salary, year, month, 1);
    }
    public Employee(String name, double salary, int year, int month, int day){
//        this.setId();                           //  id通过setId方法来获取
//        this.id = this.setId();
//        this.name = name;
        super(name);                            //  调用person类的单参构造方法 Person(String name)
        this.salary = salary;
        this.hireDay = LocalDate.of(year, month, day);
    }   //  填入三项信息

    public String getInfo(){                    //  获取全部信息方法
        return "id: " + getId() + ", 姓名: " + getName() + ", 薪酬: " + getSalary() +
                ", 入职时间: " + getHireDay().toString();
    }

    public void raiseSalary(double byPercent){  //  按百分比加薪方法: 传入1个参数  参数%
        double raise = salary * byPercent / 100;
        salary += raise;
    }

    public String getDescription(){             //  描述
        return String.format("an employee with a salary of $%.2f", this.salary);
    }

}






public class EmployeeTest {
    public static void main(String[] args){
//        Employee[] staff = new Employee[3];     //  建立三人的职员数组staff
//        //  添加三个职员信息
//        staff[0] = new Employee("天机", 8000, 1991, 11, 9);
//        staff[1] = new Employee("冰心", 7000, 1991, 7, 29);
//        staff[2] = new Employee("云麓", 7000, 1989, 8, 2);
//
//        //  每人加薪10%
//        for (Employee e : staff)                //  上来就是一个枚举
//            e.raiseSalary(10);
//
//        //  打印加薪之后每人的信息
//        for (Employee e : staff)                //  又是一个枚举
//            System.out.println(e.getInfo());

        //  一下是使用ArrayList数组重写的:
        ArrayList<Employee> staff = new ArrayList<>();
        staff.add(0, new Employee("天机", 8000, 1991, 11, 9));
        Employee BingXin = new Employee("冰心", 7000, 1991, 7, 29);
        Employee YunLu = new Employee("云麓", 7000, 1989, 8, 2);
        staff.add(BingXin);
        staff.add(YunLu);

//        System.out.println(staff.size());                 //  查看列表长度
//        System.out.println(staff.get(2).getInfo());       //  查看下表为2的元素

        for (Employee e : staff)
            e.raiseSalary(10);

        for (Employee e : staff)
            System.out.println(e.getInfo());


    }
}




