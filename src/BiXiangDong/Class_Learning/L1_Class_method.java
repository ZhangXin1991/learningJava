package BiXiangDong.Class_Learning;

import ShangGuiGu.Reflect.Person;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;

/**
 * java.lang.Class: 是反射的源头
 *
 *  通过getClass()方法获取运行时的类
 *  有了获取的类就可以获取这个类的所有内部结构
 *  (属性, 方法, 构造器, 内部类, 父类, 所在的包, 接口, 异常, 注解....)
 *  调用对应的的运行时的类的指定的结构(属性, 方法, 构造器)
 *
 */
public class L1_Class_method {
    public static void main(String[] args) throws NoSuchFieldException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, ClassNotFoundException, InstantiationException {
        /**如何获取Class的实例
         * 三种方式获取
         *  1, 调用运行时类本身的.class属性
         *      如: Class clazz1 = Person.class;
         *  2, 通过运行时类的对象获取
         *      如: Class clazz2 = person.getClass();
         *  3, 通过Class的静态方法获取
         *      如: String className = "路径.包.Person;
         *          Class clazz3 = Class.forName(className);
         */
        Person person = new Person();
        person.setName("旺财");
        person.setAge(3);
        System.out.println("------------------");

        //  Class类中, 返回一个实例对象的Class类,类名,新实例化类对象,类加载器
        testClassMethod(person);

        //  Class类中, field下方法
//        testClassMethod_field(person);

        //  Class类中, method下方法
//        testClassMethod_method(person);

        //  Class类中, 获取所有构造方法
//        testClassMethod_constructor(person);

        // 获取运行时类的父类, 父类的泛型
//        testClassMethod_super(person);

        //  获取实现的接口
//        testClassMethod_interfaces(person);

    }


    private static void testClassMethod(Person person) throws NoSuchFieldException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, ClassNotFoundException, InstantiationException {
        //  返回person的类
        Class c = person.getClass();
        System.out.println(c);

        //  用获取的类 new 一个这个获取的类
        //  创建对应的运行时类的对象, 实际上此方法调用了该类的空参的构造方法
        //  注意: 该方法需要空参构造方法;空参构造方法权限要足够;
        Person p = (Person) c.newInstance();

        //  返回person类对象的类名
        String className = person.getClass().getName();//class ShangGuiGu.Reflect.Person
        System.out.println(className);//ShangGuiGu.Reflect.Person

        //  获取person对象的类加载器
        ClassLoader classLoader = person.getClass().getClassLoader();
        //  获取person对象的类名
        String className0 = person.getClass().getName();
        //  用person对象的类加载器的loadClass方法加载person对象的类名 返回一个Class实例
        Class<?> class3 = classLoader.loadClass(className0);

        //  获取类的注释
        Annotation[] anns = person.getClass().getAnnotations();
        for (Annotation ann : anns) {
            System.out.println(ann);
        }

    }

    private static void testClassMethod_constructor(Person person) {
        //  获取person类的public权限的构造方法列表
        Constructor[] constructors = person.getClass().getConstructors();
        //  获取person类的所有构造方法列表
        Constructor[] constructors1 = person.getClass().getDeclaredConstructors();
        for (Constructor c : constructors) {
            System.out.println("构造方法: "+c);
        }
    }

    private static void testClassMethod_field(Person person) throws NoSuchFieldException {
        //  返回person类及其父类中的属性 public age
        Field field = person.getClass().getField("name");
        System.out.println("属性: " + field);
        //  返回运行时类本身声明的所有属性,
        Field[] fields = person.getClass().getDeclaredFields();
        for (Field f : fields) {
            //  获取每个属性的权限修饰符
            int i = f.getModifiers();
            String mod = Modifier.toString(i);
            System.out.println("权限修饰符: "+mod);
            //  获取属性的变量类型
            Class type = f.getType();
            System.out.println("属性类型: " + type);
            //  获取属性名
            System.out.println("属性: " + f);
        }
    }

    private static void testClassMethod_method(Person person) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        //  返回person对象中方法 的"show"方法
        Method methodShow = person.getClass().getMethod("show");
        Method[] methods = person.getClass().getMethods();
        for (Method m : methods) {
            //  获取方法名
            System.out.println("方法名: "+m.getName());
            //  获取方法修饰符
            String mod_str = Modifier.toString(m.getModifiers());
            System.out.println("修饰符: "+mod_str);
            //  获取方法返回值类型
            Class returnType = m.getReturnType();
            System.out.println("返回值类型: "+returnType);
            //  获取形参列表
            Class[] paramters = m.getParameterTypes();
            for (int x = 0; x < paramters.length; x++) {
                if (x == 0) {
                    System.out.print("形参列表: [");
                }
                System.out.print(paramters[x]+" ");
                if (x == paramters.length-1) {
                    System.out.println("]");
                }
            }
            //  获取抛出的异常
            Class[] exps = m.getExceptionTypes();
            for (int x = 0; x < exps.length; x++) {
                if (x==0)
                    System.out.print("异常列表: [");
                System.out.print(exps[x] + " ");
                if (x == exps.length - 1) {
                    System.out.println("]");
                }
            }
            //  获取方法注解
            Annotation[] ann = m.getAnnotations();
            for (Annotation a : ann) {
                System.out.println(a);
            }
        }
        Method[] methods1 = person.getClass().getDeclaredMethods();

        //  接收person对象, 用person对象调用此方法
        methodShow.invoke(person);
    }

    private static void testClassMethod_super(Person person) {
        //  获取不带泛型的父类
        Class superClass = person.getClass().getSuperclass();
        System.out.println("父类: "+superClass);

        //  获取带泛型的父类
        Type type = person.getClass().getGenericSuperclass();
        System.out.println("父类及其泛型:"+type);

        //  获取父类的泛型
        //1, 获取带泛型的父类
        Type type1 = person.getClass().getGenericSuperclass();
        //2, 强转换成子接口   类的参数
        ParameterizedType param = (ParameterizedType) type1;
        //3, 获取实际的类型参数s
        Type[] ars = param.getActualTypeArguments();
        System.out.println("父类的泛型:"+ ((Class)ars[0]).getName());
    }

    private static void testClassMethod_interfaces(Person person) {
        Class[] interfaces = person.getClass().getInterfaces();
        for (Class infaces : interfaces) {
            System.out.println(infaces);
        }
    }
}

