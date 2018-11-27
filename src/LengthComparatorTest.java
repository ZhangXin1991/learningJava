import learning_Cpre_java.interface_lambda_outClass.Employee1;

import java.util.Arrays;
import java.util.Comparator;

/**
 * comparator接口的应用
 *
 */

class LengthComparator implements Comparator<String>{
    /**
     * 此类是字符串长度个比较器      下面是比较方法
     * @param first     没啥可注释的....
     * @param second    同上.....
     * @return          ......
     */
    public int compare(String first, String second){
        return first.length() - second.length();
    }
}



public class LengthComparatorTest {
    /**
     * 测试
     * @param args  
     */
    public static void main(String[] args){
        Employee1[] staff = new Employee1[3];
        staff[0] = new Employee1("tianJi", 8000);
        staff[1] = new Employee1("bingXin", 7000);
        staff[2] = new Employee1("yunLu", 6000);

        String[] names = {staff[0].getName(), staff[1].getName(), staff[2].getName()};
        Arrays.sort(names, new LengthComparator());
        for (String s : names)
            System.out.println(s);

        //  具体完成比较时, 需要创建实例
        Comparator<String> name1 = new LengthComparator();

        if (name1.compare(staff[0].getName(), staff[1].getName()) > 0){
            System.out.println("en");
        }else{
            System.out.println(staff[1].getName() + "\t" + staff[0].getName());
        }

    }
}
