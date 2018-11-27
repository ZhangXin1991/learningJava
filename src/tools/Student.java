package tools;

import org.junit.Test;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.Scanner;

public class Student extends Person{
    private int grade;
    public Student() {
    }

    public Student(int id, String name, String gender, int age, String job, int grade) {
        super(id, name, gender, age, job);
        this.grade=grade;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + getId() +
                "name=" + getName() +
                "age=" + getAge() +
                "gender=" + getGender() +
                "job=" + getJob() +
                "grade=" + grade +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Student student = (Student) o;
        return grade == student.grade;
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), grade);
    }
}

