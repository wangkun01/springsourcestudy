package proxy.custom;

import com.sun.org.apache.bcel.internal.generic.LNEG;

import javax.management.relation.RelationNotFoundException;
import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * 小明版的动态生成代理对象的代码
 * 只是为了说明原理,只传入一个Class<?>
 * @author wangkun
 * @date 2019-07-07 17:23
 */
public class XMProxy {
    private static final  String rn = "\r\n";
    public static Object newProxyInstance(XMClassLoader xmClassLoader,
                                          Class<?> interfaces,
                                      XMInvocationHandler h){
        try {
        //1.生成源代码
        String src = generateSrc(interfaces);
        //2.输出到磁盘保存为.java
        String filePath = interfaces.getResource("").getPath() +"$Proxy2.java";
        File javaFile = new File(filePath);
        FileWriter fileWriter = null;

        fileWriter = new FileWriter(javaFile);
        fileWriter.write(src);
        fileWriter.flush();
        fileWriter.close();
        //3.编译源代码,生成.class
        JavaCompiler javaCompiler = ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager manager = javaCompiler.getStandardFileManager(null,null,null);
        Iterable iterable =   manager.getJavaFileObjects(javaFile);
        //上面三行代码只是找到java文件
        //建立编译任务
        JavaCompiler.CompilationTask compilationTask  = javaCompiler.getTask(null, manager, null, null, null, iterable);
        compilationTask.call();
        manager.close();
        //4.将class文件中的内容动态加载到JVM
        Class proxyClass = xmClassLoader.findClass("$Proxy2");
        //5.返回被代理后的对象,调用XMInvocationhandler 的 invoke方法

        Constructor constructor = proxyClass.getConstructor(XMInvocationHandler.class);
        return constructor.newInstance(h);

        }catch (Exception e) {
            e.printStackTrace();
        }
        return null ;
    }


    public static String generateSrc(Class<?> interfaces){
        StringBuffer s = new StringBuffer();
        s.append("package proxy.custom;" + rn);
        s.append("import java.lang.reflect.Method;" + rn);
        s.append("public class $Proxy2 implements XMPerson {" +rn);
        //成员变量
        s.append("XMInvocationHandler h;" + rn);
        //构造方法
        s.append("public $Proxy2(XMInvocationHandler h) {" + rn);
        s.append("this.h = h;" + rn);
        s.append("}" + rn);

        Method[] methods = interfaces.getMethods();
        for(Method method : methods){
            s.append("public " + method.getReturnType().getName() + " "+ method.getName() + "(){" + rn);
            /**
             * 调用InvocationHandler中的invoke方法
             */
             s.append("try{" + rn);
             s.append("Method m = " + interfaces.getName() + ".class.getMethod(\"" +method.getName() + "\",new Class[]{});"+rn);
             s.append("this.h.invoke(this,m,null);" + rn);
             s.append("}catch(Throwable e){e.printStackTrace();}" + rn);
             s.append("}");
        }
        s.append("}" + rn);
        return s.toString();

    }

}
