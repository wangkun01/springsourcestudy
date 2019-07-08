package proxy.custom;

import org.junit.Test;
import proxy.jdk.Monitor;
import proxy.jdk.Person;
import proxy.jdk.Student;
import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * JDK版的动态代理实现测试
 * @author wangkun
 * @date 2019-07-06 18:44
 */
public class TestProxy {

    @Test
    public void testProxy(){
        XMStudent student = new XMStudent();
        new XMMonitor().createTarget(student);
    }
}
