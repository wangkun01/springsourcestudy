package strategy;

/**
 * 定义环境角色，内部持有一个策略类的引用
 * @author wangkun
 * @date 2019-07-17 23:28
 */
public class Environment {

    private Comparator comparator = null ;

    public  Environment(Comparator comparator){
        this.comparator = comparator ;
    }

    public int compare(Object a , Object b){
        return comparator.compare(a,b) ;
    }

}
