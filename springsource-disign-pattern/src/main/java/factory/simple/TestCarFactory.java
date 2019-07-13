package factory.simple;

/**
 * 简单工厂模式： 缺点一个工厂什么都可以做，现实中不存在此类工厂,对工厂来说不合理
 * @author wangkun
 * @date 2019-07-12 00:29
 */
public class TestCarFactory {
    public static void main(String[] args) {
        System.out.println( new CarFactory().getCar("BMW"));
        System.out.println( new CarFactory().getCar("Audi"));
        System.out.println( new CarFactory().getCar("Benz"));
    }
}
