package Cpre_java.learning_class_extends;

/**
 * 继承 抽象超类 Person
 */

class Student extends Person{

    private String major;                           //  声明 专业

    public Student(String name, String major){
        super(name);                                //  超类构造器 传入姓名
        this.major = major;
    }

    public String getDescription(){                 //  描述
        return "a student majoring in " + major;
    }

    public String getMajor() {
        return this.major;
    }
}
