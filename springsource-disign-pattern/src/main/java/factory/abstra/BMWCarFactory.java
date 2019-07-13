package factory.abstra;

import factory.BMW;
import factory.Car;
import factory.func.Factory;

/**
 * @author wangkun
 * @date 2019-07-12 00:24
 */
public class BMWCarFactory extends AbstactCarFactory{
    @Override
    public Car getCar() {
        return new BMW();
    }
}
