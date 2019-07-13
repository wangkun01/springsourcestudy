package factory.abstra;

/**
 *
 * 抽象工厂模式：
 *  特点 1.隐藏复杂的逻辑处理过程，只关系执行结果
 * @author wangkun
 * @date 2019-07-12 00:54
 */
public class TestXXCarFactory {
    public static void main(String[] args) {
        DefaultCarFactory defaultCarFactory = new DefaultCarFactory();
        System.out.println(defaultCarFactory.getCar("BMW"));
        System.out.println(defaultCarFactory.getCar("Audi"));
        System.out.println(defaultCarFactory.getCar("Benz"));;
    }

}
