package ShangGuiGu.Reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理的使用
 */
interface Subject {
    void action();
}

//  被代理类
class RealSubject implements Subject {

    @Override
    public void action() {
        System.out.println("这是一个被代理类");
    }
}

//  invocation:调用   handler:处理程序
class MyInvocationHandler implements InvocationHandler {

    Object obj;//实现了接口的被代理类的对象的声明

    //  给被代理类的对象实例化
    //  返回一个代理类的对象
    public Object blind(Object obj) {
        this.obj = obj;
        //  返回 代理.新建代理实例对象(加载代理类,
        // 加载代理类实现的接口, 实现InvocationHandler的类对象,
        // 即:new MyInvocationHandler    (this)
        return Proxy.newProxyInstance(
                obj.getClass().getClassLoader(),//   动态接收被代理类的实例对象
                obj.getClass().getInterfaces(), //   动态接收被代理类实现的接口
                this);                       //   动态接收代理类对象
    }

    /**
     * 当通过代理类的对象发起对被重写的方法的调用时, 都会转换为对如下的invoke方法的调用
     * @param proxy 接收被代理类
     * @param method 接收被代理类实现的接口的方法
     * @param args 接收被代理类的动态参数
     * @return returnVal 即是: method.invoke(obj, args); 被代理类覆写的接口的方法的返回值
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //  method方法的返回值是returnVal
        Object returnVal = method.invoke(obj, args);
        return returnVal;
    }
}

public class L2_refliect {
    public static void main(String[] args) {
        //1, 建立被代理类的对象
        RealSubject realSubject = new RealSubject();
        //2, 建立实现了InvocationHandler接口的类的对象
        MyInvocationHandler handler = new MyInvocationHandler();
        //3, 调用blind()方法, 将此方法动态的返回一个同样实现了realSubject所在类实现的接口的代理类的对象
        Object obj = handler.blind(realSubject);
        Subject sub = (Subject) obj;
        sub.action();

        NikeClothFactory nike = new NikeClothFactory();
        ClothFactory proxyCloth = (ClothFactory) handler.blind(nike);// 返回代理类
        proxyCloth.productCloth();
    }
}
