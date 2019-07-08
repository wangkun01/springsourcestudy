package proxy.custom;

/**
 * @author wangkun
 * @date 2019-07-06 18:31
 */
public class XMStudent implements XMPerson {
    @Override
    public void giveMoney() {
        System.out.println("学生缴费");
    }

}
