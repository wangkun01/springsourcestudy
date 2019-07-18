package factory.abstra;

import factory.Car;

/**
 * @author wangkun
 * @date 2019-07-12 00:44
 */
public abstract class AbstactCarFactory {

     protected   abstract Car getCar();

    public Car getCar(String name) {
        if ("BMW".equalsIgnoreCase(name)) {
            return new BMWCarFactory().getCar();
        } else if ("Audi".equalsIgnoreCase(name)) {
            return new AudiCarFactory().getCar();
        } else if ("Benz".equalsIgnoreCase(name)) {
            return new BenzCarFactory().getCar();
        } else {
            System.out.println("不能造出此种车型！");
            return null;
        }
    }
}
