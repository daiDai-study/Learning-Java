package org.fenixsoft.oom;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * JDK7及之前 VM Args: -XX:PermSize=10m -XX:MaxPermSize=10m
 * JDK8及之后 VM Args: -XX:MetaspaceSize=10m -XX:MaxMetaspaceSize=10m
 */
public class JavaMethodAreaOOM {

    static class OOMObject{

    }

    public static void main(final String[] args) {
        while(true){
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(OOMObject.class);
            enhancer.setUseCache(false);
            enhancer.setCallback(new MethodInterceptor() {
                public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                    return methodProxy.invokeSuper(o, args);
                }
            });
            enhancer.create();
        }
    }
}
