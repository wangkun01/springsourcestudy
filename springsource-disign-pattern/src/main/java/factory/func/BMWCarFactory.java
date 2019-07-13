package factory.func;

import factory.BMW;
import factory.Car;

/**
 * @author wangkun
 * @date 2019-07-12 00:24
 */
public class BMWCarFactory implements Factory{
    @Override
    public Car getCar() {
        return new BMW();
    }
}
