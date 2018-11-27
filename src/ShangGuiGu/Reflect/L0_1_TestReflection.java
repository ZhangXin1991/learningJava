package ShangGuiGu.Reflect;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class L0_1_TestReflection {
    //  在有反射以前, 如何创建一个类的对象, 并调用其中的方法, 属性
    @Test
    public void test1() {
        Person p = new Person();
        p.setAge(27);
        p.setName("赵毅");
        p.show();
//        p.display("中国");
        System.out.println(p.toString());
    }
    //  有了反射, 可以通过反射创建一个类的对象, 并调用其中的结构
    @Test
    public void test2() throws IllegalAccessException, InstantiationException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException {
        Class clazz = Person.class;

        //1, 创建clazz对应的运行时类Person类的对象
        Person p = (Person) clazz.newInstance();
        System.out.println(p);
        //2, 通过反射调用运行时类的指定的属性
        // 2.1 获取对象中的public属性 : public String name
        Field f1 = clazz.getField("name");
        //   设置这个对象的属性
        f1.set(p, "范英博");
        System.out.println(p);
        // 2.2 获取对象中的private属性 : privet int age
        Field f2 = clazz.getDeclaredField("age");// declared:声明
        f2.setAccessible(true); //  accessible:可进入的
        f2.set(p, 20);
        System.out.println(p);

        //3, 通过反射调用运行时类的方法
        Method m1 = clazz.getMethod("show");
        m1.invoke(p);

        Method m2 = clazz.getMethod("display", String.class);
        m2.invoke(p, "CHN");
    }
}
