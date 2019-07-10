package proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * CGLIB代理模式：也是字节码重组
 * 带代理类
 * @author wangkun
 * @date 2019-07-06 18:32
 */
public class CGMonitor implements MethodInterceptor {

    private CGStudent target;


    // 根据传入的类的引用生成代理对象的"子类"
    public Object createTarget(Class clazz){
        //理解为cglib的工具类吧
        Enhancer enhancer = new Enhancer();
        //告诉CGlib生成的子类要继承哪个父类
        enhancer.setSuperclass(clazz);
        //方法回调会执行调用下面的intercept
        enhancer.setCallback(this);
        //分为几步enhancer.create() ;
        //1.生成源代码 2.编译生成class 3.加载到JVM中返回被代理对象
        return  enhancer.create() ;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        System.out.println("方法的调用前处理...");
        //使用反射执行父类的方法：传入的方法为CGLIB生成的被代理对象的子类和参数对象
        //在new 子类的时候，默认调用了父类的构造方法，也就是说new了子类，就new了父类,
        //相当于间接持有父类的引用  满足代理模式的必要条件
        methodProxy.invokeSuper(o,objects);
        System.out.println("方法执行后处理...");
        return null;
    }
}
