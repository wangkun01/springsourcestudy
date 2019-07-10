package proxy.custom;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * 小明版的classloader,把动态生成的class的内容加载到JVM中
 *
 * @author wangkun
 * @date 2019-07-07 17:27
 */
public class XMClassLoader extends ClassLoader {

    File baseDir;

    public XMClassLoader() {
        String baseDir = ClassLoader.getSystemResource("").getPath();
        this.baseDir = new File(baseDir);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {

        FileInputStream in = null;
        ByteArrayOutputStream out = null;
        File classFile;
        try {
            String className = XMClassLoader.class.getPackage().getName() + "." + name;
            if (baseDir != null) {
                classFile = new File(baseDir, className.replaceAll("\\.", "/") + ".class" );
                in = new FileInputStream(classFile);
                out = new ByteArrayOutputStream();
                byte[] buff = new byte[1024];
                int len;
                while ((len = in.read(buff)) != -1) {
                    out.write(buff, 0, len);
                }
                classFile.delete();
                return defineClass(className, out.toByteArray(), 0, out.size());
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != in) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != out) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null ;
    }
}
