package proxy.cglib;

import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;

/**
 * @author wangkun
 * @date 2019-07-08 23:23
 */
public class TestCGlib {

    @Test
    public void test1(){

        /**
         *   和JDK动态代理的区别：JDK生成代理对象强转为接口,
         *   CGlib是生成代理对象的子类，并重写父类的方法,子类强转为父类
         */
        CGStudent cgStudent = (CGStudent) new CGMonitor().createTarget(CGStudent.class);
        cgStudent.giveMoney();
    }

}
