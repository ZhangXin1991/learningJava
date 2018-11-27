package learning_Cpre_java.interface_lambda_outClass;

import java.util.Arrays;

public class Employee1Test {
    public static void main(String[] args){
        Employee1[] staff = new Employee1[3];
        staff[0] = new Employee1("天机", 3000);
        staff[1] = new Employee1("冰心", 2900);
        staff[2] = new Employee1("弈剑", 2800);

        for (Employee1 e : staff)
            e.raiseSalary(10);

        Arrays.sort(staff);

        for (Employee1 e : staff)
            System.out.println(e.toString());
    }
}
