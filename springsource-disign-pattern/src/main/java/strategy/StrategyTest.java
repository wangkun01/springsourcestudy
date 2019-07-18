package strategy;

/**
 * 策略设计模式：最后的结果集相同,具体过程不同。
 * 1.定义抽象策略角色(为策略对象定义一个公共的接口)
 * 2.编写具体策略角色(实际上就是实现上面定义的公共接口)
 * 3.定义环境角色，内部持有一个策略类的引用
 * @author wangkun
 * @date 2019-07-17 23:10
 */
public class StrategyTest {
    public static void main(String[] args) {

        new Environment(new NumberComparator()).compare(1, 2);
    }
}
