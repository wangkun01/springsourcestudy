package factory.simple;

import factory.Car;

/**
 * @author wangkun
 * @date 2019-07-12 00:17
 */
public interface Factory {
     public Car getCar(String name);
}
