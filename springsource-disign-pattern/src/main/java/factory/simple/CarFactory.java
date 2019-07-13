package factory.simple;

import factory.Audi;
import factory.BMW;
import factory.Benz;
import factory.Car;

/**
 * @author wangkun
 * @date 2019-07-12 00:24
 */
public class CarFactory  implements Factory{
    @Override
    public Car getCar(String name) {
        if("BMW".equalsIgnoreCase(name)){
            return new BMW();
        }else if("Audi".equalsIgnoreCase(name)){
            return new Audi();
        }else if("Benz".equalsIgnoreCase(name)){
            return new Benz();
        }else{
            System.out.println("不能造出此种车型！");
            return null;
        }
    }
}
