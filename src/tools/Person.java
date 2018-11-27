package tools;

import java.util.Objects;

public class Person implements Comparable {
    private int id;
    private String name;
    private String gender;
    private int age;
    private String job;

    public Person() {
    super();
    }

    public Person(int id, String name, String gender, int age, String job) {
            this.id = id;
            this.name = name;
            this.gender = gender;
            this.age = age;
            this.job = job;
        }
    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public int compareTo(Object o) {
        Person p ;
        if (o instanceof Person) {
            p = (Person) o;
            int temp = this.age-p.age;
            return temp==0?this.name.compareTo(p.name) : temp;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", job='" + job + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id &&
                age == person.age &&
                Objects.equals(name, person.name) &&
                Objects.equals(gender, person.gender);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, gender, age);
    }
}
