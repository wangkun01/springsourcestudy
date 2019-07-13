package factory.func;

import factory.Benz;

/**
 * 方法工厂：缺点客户需要关注用哪个工厂，对客户来说不合理
 * @author wangkun
 * @date 2019-07-12 00:36
 */
public class TestXXCarFactory {
    public static void main(String[] args) {
        System.out.println(new BMWCarFactory().getCar());
        System.out.println(new AudiCarFactory().getCar());
        System.out.println(new BenzCarFactory().getCar());
    }
}
