package factory.func;

import factory.Benz;
import factory.Car;

/**
 * @author wangkun
 * @date 2019-07-12 00:24
 */
public class BenzCarFactory implements Factory{
    @Override
    public Car getCar() {
        return new Benz();
    }
}
