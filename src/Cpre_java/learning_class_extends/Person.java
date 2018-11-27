package Cpre_java.learning_class_extends;

/**
 * 这是一个抽象的超类
 * abstract : 抽象
 */
public abstract class Person {                  //  创建class : 人
    public abstract String getDescription();    //  声明 String类型的 描述
    private String name;                        //  声明 String类型的 姓名

    public Person(){
        this.name = "";
    }

    public Person(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
}
