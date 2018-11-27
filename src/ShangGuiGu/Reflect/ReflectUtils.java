package ShangGuiGu.Reflect;

import java.lang.reflect.*;

/**
 * 反射的Utils 函数集合
 * 提供访问私有变量, 获取泛型类型 Class, 提取集合中元素属性等Utils函数
 *
 */
public class ReflectUtils {

    /**
     * 将反射时的"检查异常"转换为"运行时异常"
     * @return
     */
    public static IllegalArgumentException convertToUncheckedException(Exception ex) {
        //  如果接收的ex是IllegalArgumentException
        // 或IllegalAccessException
        // 或NoSuchMethodException 则抛出"反射异常",否则抛出异常
        if (ex instanceof IllegalArgumentException ||
                ex instanceof IllegalAccessException ||
                ex instanceof NoSuchMethodException) {
            throw new IllegalArgumentException("反射异常", ex);
        } else {
            throw new IllegalArgumentException(ex);
        }
    }

    /**
     * 通过反射, 获取定义Class时声明的父类的泛型参数的类型
     * 如: public EmployeeDao extends BaseDao<Employee, String>
     * @return 返回泛型父类数组中指定位置的类
     */
    @SuppressWarnings("unchecked")
    public static Class getSuperClassGenricType(Class clazz, int index) {
        //  获取clazz的泛型的父类
        Type genType = clazz.getGenericSuperclass();

        //  如果不是泛型类则返回Object类
        if (!(genType instanceof ParameterizedType)) {
            return Object.class;
        }

        //  如果是泛型类则转化成泛型类,然后获取这个泛型类的父类
        //  由于泛型类可能不止一个,所以用数组的形式接收它们
        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();

        //  如果接收的index 大于等于泛型父类数组的长度 或 接收的index小于0
        //  则返回Object类
        if (index >= params.length || index < 0) {
            return Object.class;
        }
        //  如果数组中的类不是一个类....则返回Object类
        if (!(params[index] instanceof Class)) {
            return Object.class;
        }

        //  返回泛型父类数组中指定位置的类
        return (Class) params[index];
    }

    /**
     * 通过反射,获得Class 定义中声明的父类的泛型参数类型
     * 如: public EmployDao extends BaseDao<Employee, String>
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> Class<T> getSuperGenrticType(Class clazz) {
        return getSuperClassGenricType(clazz, 0);
    }

    /**
     * 循环向上转型,获取对象的DeclaredMethod(声明方法)
     * 用已知的 方法名 和 方法接收的参数类型 来获取 object对象的方法或object的父类的方法
     * 直到返回匹配的方法 或 没有匹配的返回返回null 为止
     * @param object         接收一个对象
     * @param methodName     接收指定的方法名
     * @param parameterTypes 接收指定的参数类型
     * @return
     */
    public static Method getDeclaredMethod(Object object, String methodName, Class<?>[] parameterTypes) {
        //  循环 用superClass获取object的类型;
        //      如果superClass不等于Object类;
        //      用superClass获取superClass的父类;
        //  直到superClass的类型等于Object类为止
        //  在这个循环中, 不断的返回与指定的方法名和指定的参数类型匹配的方法,
        //  若获取的方法与指定的方法名或参数类型不匹配则出现异常,
        //  但该异常会被捕获,继续向上获取父类进行方法匹配
        //  直到返回匹配的方法 或 提升到Object类 返回null 为止

        for (Class<?> superClass = object.getClass();
             superClass != Object.class;
             superClass = superClass.getSuperclass()) {
            try {
                return superClass.getDeclaredMethod(methodName, parameterTypes);
            } catch (NoSuchMethodException e) {
                //  Method 不在当前类定义, 继续向上转型
            }
        }
        return null;
    }

    /**
     * 使filed变为可访问的     filed:属性值
     * 其实可以直接使用field.setAccessible(true);.....
     * @param field 接收Field类的field......
     */
    public static void makeAccessible(Field field) {
        if (!Modifier.isPublic(field.getModifiers())) {
            field.setAccessible(true);
        }
    }

    /**
     * 循环向上转型, 获取对象的DeclaredField
     * 用已知的属性名 匹配object对象的属性名或object的父类的属性名
     * 直到返回匹配的属性 或 没有匹配的属性返回null为止
     * @param object    接收一个对象
     * @param filedName 接收一个指定的属性名字
     * @return          返回匹配的属性
     */
    public static Field getDeclaredField(Object object, String filedName) {
        for (Class<?> superClass = object.getClass();
             superClass != Object.class;
             superClass = superClass.getSuperclass()) {
            try {
                return superClass.getDeclaredField(filedName);
            } catch (NoSuchFieldException e) {
                //  Field 不在当前类定义,继续向上转型
            }
        }
        return null;
    }

    /**
     * 直接调用对象方法, 而忽略访问修饰符(private, protected)
     * 由于循环向上抽取匹配的方法名和匹配的参数类型 所以接收 methodName,parameterType
     * 由于运行method.invoke(对象, 参数)所以接收object,parameters
     * @param methodName    接收指定方法名     用于抽取需要的方法
     * @param parameterType 接收指定的参数类型 用于抽取需要的方法
     * @param parameters    接收指定的参数     用于运行需要的方法
     * @param object        接收指定对象       用于运行需要的方法
     * @return  返回需要运行的方法的返回结果  或没有找到指定的方法返回null
     */
    public static Object invokeMethod(Object object, String methodName,
                                      Class<?>[] parameterType,Object [] parameters) {
        //  循环向上获取需要的方法...
        Method method = getDeclaredMethod(object, methodName, parameterType);
        //  如果没有获取到需要的方法,则抛出异常
        if (method == null) {
            throw new IllegalArgumentException(
                    "Could not find [" + methodName + "] on target [" + object + "]");
        }
        //  不管是不是public方法,直接获取权限....
        method.setAccessible(true);
        //
        try {
            return method.invoke(object, parameters);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) { }

        return null;
    }

    /**
     * 直接设置指定对象的属性值, 忽略该属性值的访问权限, 也不经过setter....
     * @param object    接收需要设定属性值的对象
     * @param fieldName 接收属性名称
     * @param value     接收要set的属性值
     */
    public static void setFieldValue(Object object, String fieldName, Object value) {
        //  直接对指定对象抽取匹配的属性名
        Field field = getDeclaredField(object, fieldName);
        if (field == null) {
            throw new IllegalArgumentException(
                    "Could not find field [" + fieldName + "] on target [" + object + "]");
        }
        //  不管该属性是否是public,直接设定为可访问的....
        makeAccessible(field);

        //  直接设置指定对象的属性值
        try {
            field.set(object,value);
        } catch (IllegalAccessException e) { }
    }

    /**
     * 直接获取指定对象的属性值, 忽略该属性值得访问权限, 也不经过getter....
     * @param object
     * @param fieldName
     * @return
     */
    public static Object getFieldValue(Object object, String fieldName) {
        //  直接获取指定的属性名的属性
        Field field = getDeclaredField(object, fieldName);

        //  如果属性为空,则抛出异常
        if (field == null) {
            throw new IllegalArgumentException(
                    "Could not find field [" + fieldName + "] on target [" + object + "]");
        }
        //  不管属性是否可以被访问,直接设定为可访问
        makeAccessible(field);
        //  创建返回结果;
        Object result = null;
        //  用result接收属性值
        try {
            result = field.get(object);
        } catch (IllegalAccessException e) { }

        //  返回接收了属性值的result;
        return result;
    }




}

