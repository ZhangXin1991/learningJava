package Cpre_java.learning_class_extends;

public class PersonTest {
    public static void main(String[] args){
        Person[] people = new Person[2];

        people[0] = new Employee("天机", 8000, 2006, 9, 10);
        people[1] = new Student("冰心", "治疗");

        for (Person e : people)
            System.out.println("姓名: " + e.getName() + ", 描述: " + e.getDescription());
    }
}
