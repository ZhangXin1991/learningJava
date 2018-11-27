package tools;

import org.junit.Test;

import java.io.IOException;
import java.util.Scanner;

public class GetStudents {
    public static void main(String[] args) {
        new GetStudents().testAddNewStudent();

    }
    public void testAddNewStudent() {
        Student student = getStudentFromConsole();
        System.out.println(student.toString());
    }

    /**
     * 从控制台输入学生的信息
     * @return
     */
    public static Student getStudentFromConsole() {
        Scanner scanner = new Scanner(System.in);
        Student student = new Student();
//        System.out.println("flow id");
//        student.setId(scanner.nextInt());

        System.out.println("flow name");
        student.setName(scanner.next());

        System.out.println("flow gender");
        student.setGender(scanner.next());

        System.out.println("flow age");
        student.setAge(scanner.nextInt());

        System.out.println("flow job");
        student.setJob(scanner.next());

        System.out.println("flow grade");
        student.setGrade(scanner.nextInt());

        return student;
    }

}
