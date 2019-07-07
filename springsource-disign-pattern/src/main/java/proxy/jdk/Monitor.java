package proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 带代理类
 * @author wangkun
 * @date 2019-07-06 18:32
 */
public class Monitor implements InvocationHandler {

    private Student target;


    //根据传入的类的引用生成代理对象
    public Object createTarget(Student target){
        this.target = target ;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("方法的调用前处理...");
        //使用反射执行方法
        method.invoke(target,args);
        System.out.println("方法执行后处理...");

        //根据被代理对象的方法是否有返回值决定返回什么
        return null;

    }
}
