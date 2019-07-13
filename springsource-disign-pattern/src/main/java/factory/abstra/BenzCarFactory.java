package factory.abstra;

import factory.Benz;
import factory.Car;
import factory.func.Factory;

/**
 * @author wangkun
 * @date 2019-07-12 00:24
 */
public class BenzCarFactory extends AbstactCarFactory{
    @Override
    public Car getCar() {
        return new Benz();
    }
}
