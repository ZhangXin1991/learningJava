package ShangGuiGu.JDBC_Learning;


import org.junit.Test;
import tools.GetStudents;
import tools.JDBCTools;
import tools.Student;

import java.sql.SQLException;

public class L06_test {

    public void addNewStudent(Student student) throws SQLException {
        String sql = "INSERT INTO test(name,gender,age,job,grade)" +
                "VALUES(?,?,?,?,?)";

        JDBCTools.update(sql,student.getName(),
                student.getGender(),student.getAge(),
                student.getJob(),student.getGrade());
    }

    @Test
    public void testAddStudent() throws SQLException {
        Student student = GetStudents.getStudentFromConsole();
        addNewStudent(student);
    }

    public static void main(String[] args) throws SQLException {
        new L06_test().testAddStudent();
    }
}
