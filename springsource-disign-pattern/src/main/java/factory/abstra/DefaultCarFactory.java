package factory.abstra;

import factory.Car;

/**
 * @author wangkun
 * @date 2019-07-12 00:51
 */
public class DefaultCarFactory extends  AbstactCarFactory{
    @Override
    public Car getCar() {
        return new AudiCarFactory().getCar();
    }
}
