package factory.func;

import factory.Audi;
import factory.BMW;
import factory.Car;

/**
 * @author wangkun
 * @date 2019-07-12 00:24
 */
public class AudiCarFactory implements Factory {
    @Override
    public Car getCar() {
        return new Audi();
    }
}
