package proxy.jdk;

import org.junit.Test;
import proxy.jdk.Monitor;
import proxy.jdk.Person;
import proxy.jdk.Student;
import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.io.IOException;

/**必须
 *
 * 代理模式三个必要条件：1.执行者和被代理对象 2.事情必须做，但自己不专业 3.需要获取到被代理对象的资料（即对象的引用）
 * JDK版的动态代理实现测试
 * @author wangkun
 * @date 2019-07-06 18:44
 */
public class TestJDKProxy {

    @Test
    public void testProxy() throws IOException {
        Student student = new Student();
        student.setName("小明");
        student.setAge(20);
        Person person = (Person) new Monitor().createTarget(student);
        System.out.println("执行交钱的对象为" + person.getClass());
        person.giveMoney();

        //从内存中获取生成的动态代理类$Proxy2

        byte[] data = ProxyGenerator.generateProxyClass("$Proxy2", new Class[]{Person.class});
        FileOutputStream fos = new FileOutputStream("E:\\study\\projects\\springsourcestudy\\springsource-disign-pattern\\$Proxy2.class");
        fos.write(data);
        fos.close();

        /**
         * 反编译后可以发现$Proxy2 实现了Person
         * public final class $Proxy2 extends Proxy implements Person
         *
         * giveMoney()实际上执行的是InvocationHandler的invoke方法
         *
         *     public final void giveMoney() throws  {
         *         try {
         *             super.h.invoke(this, m3, (Object[])null);
         *         }
         */


    }
}
