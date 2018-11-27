package Cpre_java.learning_class_extends;


/*
在子类中可以增加 继承 覆盖超类的域 方法, 但不可以删除继承的任何域 方法
 */


class Manager extends Employee{

    private double bonus;                   //  在子类中增加一个域  奖金(bonus)

    //  子类构造器
    public Manager(String name, double salary, int year, int month, int day){
        //  用super调用Employee类的五个参数的构造器
        //  也就是: public Employee(String name, double salary, int year, int month, int day)这个构造器
        super(name, salary, year, month, day);
        bonus = 0;                          //  暂时无法将bonus直接写入形参内, 如果写入会调用Employee类的getSalary()
    }
    public Manager(String name, double salary, int year, int month, int day, double bonus){
        this(name, salary, year, month, day);
        this.bonus = bonus;
    }

    public void setBonusd(double bonus){
        this.bonus = bonus;
    }

    public double getBonus(){
        return this.bonus;
    }

    public double getSalary(){              //  覆盖超类(Employee)的getSalary()方法
        //  因为salary在Employee类中是私有域, 所以只能使用super.getSalary()来调用Employee中的salary
        double baseSalary = super.getSalary();
        return baseSalary + bonus;          //  返回工资与奖金的和
    }

    public String getInfo(){
        return "id: " + super.getId() + ", 姓名: " + super.getName() + ", 薪酬: " + this.getSalary() +
                ", 入职时间: " + super.getHireDay();
    }

}

public class ManagerTest{
    public static void main(String[] args){
//        Manager boss = new Manager("boss", 10000, 2001, 1, 1);
//        boss.setBonusd(2000);
        Manager boss = new Manager("boss", 10000, 2001, 1, 1, 2000);

        Employee[] staff = new Employee[3];
        staff[0] = boss;
        staff[1] = new Employee("张凯丰", 8000, 2002, 1, 1);
        staff[2] = new Employee("魔达图", 4000, 2003, 1, 1);

        for (Employee i : staff){
            System.out.println(i.getInfo() + "\t\t\t" + i.getSalary());
        }
    }
}

