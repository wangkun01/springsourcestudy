package prototype.simple;

/**
 * 原型类
 * @author wangkun
 * @date 2019-07-17 23:35
 */
public class ProtoType implements Cloneable{
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
