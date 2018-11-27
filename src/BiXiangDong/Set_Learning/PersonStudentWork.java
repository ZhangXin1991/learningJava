package BiXiangDong.Set_Learning;


public class PersonStudentWork {
    public static void main(String[] args) {

        Student s1 = new Student("旺财", 3);
        System.out.println(s1.toString());
    }
}


class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "姓名: " + name +
                ", 年龄: " + age +
                /*", address=" + address +*/
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}

class Student extends Person {
    public Student(String name, int age) {
        super(name, age);
    }
}

class Worker extends Person {
    public Worker(String name, int age) {
        super(name, age);
    }
}

class Address {
    private String address;
    private String quyu;
    private String xiangXi;
    public Address(String address) {
        this(address, "无", "无");
    }

    public Address(String address, String quyu) {
        this(address, quyu, "null");
    }

    public Address(String address, String quyu, String xiangXi) {
        this.address = address;
        this.quyu = quyu;
        this.xiangXi = xiangXi;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {

        this.address = address;
    }

    public String getQuyu() {
        return quyu;
    }

    public void setQuyu(String quyu) {
        this.quyu = quyu;
    }

    public String getXiangXi() {
        return xiangXi;
    }

    public void setXiangXi(String xiangXi) {
        this.xiangXi = xiangXi;
    }

    @Override
    public String toString() {
        return "Address{" +
                "城市: " + address +
                ", 区域: " + quyu +
                ", 详细: " + xiangXi +
                '}';
    }
}

