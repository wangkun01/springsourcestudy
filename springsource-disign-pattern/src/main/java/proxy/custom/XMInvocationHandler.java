package proxy.custom;

import java.lang.reflect.Method;

/**
 * 小明版的InvocationHandler
 * @author wangkun
 * @date 2019-07-07 17:23
 */
public interface XMInvocationHandler {

    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable;

}
