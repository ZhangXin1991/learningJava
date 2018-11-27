package BiXiangDong.Class_Learning;

import ShangGuiGu.Reflect.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 调用运行时类中指定的属性
 */
public class L2_Class_TEST {

    public static void main(String[] args) throws InstantiationException, IllegalAccessException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException {
        Person person = new Person("来福", 28);
        //  调用运行时类的指定的属性
//        test1(person);

        //  调用运行时类的指定的方法
//        test2(person);

        //  调用指定的构造方法
        test3(person);
    }

    private static void test2(Person person) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class clazz = person.getClass();
        Person person1 = (Person) clazz.newInstance();

        //  获得类中非private的方法
        Method methodShow = clazz.getMethod("show");
        //  调用方法
        Object obj = methodShow.invoke(person1);//   方法返回值==show();的返回值
        System.out.println(obj);    //  无返回值则返回null
        Method methodToString = clazz.getMethod("toString");
        Object toStr = methodToString.invoke(person1);
        System.out.println(toStr);

        //  获取类中所有方法
        Method methodDisplay = clazz.getDeclaredMethod("display", String.class);
        //  如果方法为private,则需要设置访问
        methodDisplay.setAccessible(true);
        methodDisplay.invoke(person1, "CHN");

    }

    private static void test1(Person person) throws IllegalAccessException, InstantiationException, NoSuchFieldException {
        Class clazz = person.getClass();
        //  用运行时类的类型实例化一个person1
        Person person1 = (Person) clazz.newInstance();
        //1, 获取指定的属性, 并调用这个属性
        Field fieldName = clazz.getDeclaredField("name");
        fieldName.set(person1, "旺财");
        Field fieldAge = clazz.getDeclaredField("age");
        //1.1, age属性自身是private, 因访问权限不够,故需要将其设置成可访问的
        fieldAge.setAccessible(true);
        fieldAge.set(person1, 7);
        //2,
        System.out.println(person1);
        System.out.println(person);
    }

    private static void test3(Person person) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class clazz = person.getClass();

        //  调用Person类中的构造方法:    Person(String name, int age)
        Constructor cons = clazz.getDeclaredConstructor(String.class, int.class);
        //  设置构造方法的访问
        cons.setAccessible(true);
        //  用构造方法创建一个实例对象
        Person xiaoqiang = (Person) cons.newInstance("小强", 100);

        System.out.println(xiaoqiang.toString());
    }


}

