package prototype.simple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * 原型设计模式：1.过程相同但是结果不一样 2.数据内容完全一样，但是实例不同
 *
 * 虽然产生了两个不同的对象,clone 直接copy字节码 生成新的对象.
 * 浅拷贝： 8大基础数据类型+String .
 * 通过演示发现 list是同一个对象,没有达到想要的结果，
 * 可以在具体的原型类中重写list的clone方法
 * 如：   ConCreateProType conCreateProType = (ConCreateProType) super.clone();
 *        conCreateProType.list = (ArrayList) list.clone();
 *        return conCreateProType;
 * @author wangkun
 * @date 2019-07-17 23:44
 */
public class CloneTest {
    public static void main(String[] args) {
        ConCreateProType conCreateProType = new ConCreateProType();
        conCreateProType.setAge(12);
        conCreateProType.setBirthDay(new Date());
        ArrayList list = new ArrayList(Arrays.asList(new int[]{1,2,3}));
        conCreateProType.list = list ;
        try {
            ConCreateProType copy = (ConCreateProType) conCreateProType.clone();
            System.out.println(copy);
            System.out.println(conCreateProType == copy);
            System.out.println(conCreateProType.list == copy.list);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}