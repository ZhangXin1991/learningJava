package learning_Cpre_java.interface_lambda_outClass;

/**
 * 学习为类添加接口
 * implements : 工具; 手段
 * Comparable : 比较
 * 本例为Employee提供了一个Comparable接口, 如果需要提供多个接口可以用","分割; 如:implements Comparable, Cloneable
 * Comparable的接口代码:
 * public interface Comparable{
 *     int compareTo(Object other);
 * }
 */

public class Employee1 implements Comparable<Employee1> {
    private String name;
    private double salary;
    private int id;

    private static int nextId = 0;
    {
        id = nextId;
        nextId ++;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public Employee1(String name, double salary){
        this.name = name;
        this.salary = salary;
    }

    public String toString(){
        return "编号: " + this.getId() + ", 名字: " + getName() + ", 薪酬: " + getSalary();
    }

    public void raiseSalary(double byPercent){
        salary += salary / 100 * byPercent;
    }

    public int compareTo(Employee1 other){      //  接口
        return Double.compare(salary, other.salary);
    }
}

