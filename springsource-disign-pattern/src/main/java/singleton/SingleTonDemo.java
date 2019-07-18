package singleton;

/**
 * @author wangkun
 * @date 2019-07-13 23:37
 */
public class SingleTonDemo {

    //static 保证全局唯一
    //private static SingleTonDemo instance = null ;
    //改进为静态内部类,不用静态方法块的原因,保证在调用的时候再声明不出来，不浪费空间
    private static class LazyHoler{
        private  static final SingleTonDemo  instance = new SingleTonDemo();
    }

    //静态方法保证实例不被外部new出来
    private SingleTonDemo() {
    }

    //final 防止被覆盖
    public final  static SingleTonDemo getInstance() {
/*        if(instance == null ){
            instance = new SingleTonDemo();
        }*/
        return LazyHoler.instance ;
    }

    public static void main(String[] args) {

        SingleTonDemo s1 = SingleTonDemo.getInstance() ;
        SingleTonDemo s2 = SingleTonDemo.getInstance() ;
        System.out.println(s1.equals(s2));

    }
}
