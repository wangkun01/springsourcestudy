package prototype.greatest;

import lombok.Data;

import java.io.*;
import java.util.Date;

/**
 * 齐天大圣：有
 *
 * @author wangkun
 * @date 2019-07-19 00:18
 */
@Data
public class GreatSage extends MonKey  implements Cloneable ,Serializable{

    //有一个金箍棒的对象
    private GoldenCudgel goldenCudgel;

    public GreatSage() {
        goldenCudgel = new GoldenCudgel();
        this.setHight(150);
        this.setBirthday(new Date().getTime());
    }

    //齐天大圣有一个变化的方法clone,变化出幻象齐天大圣
    public Object clone() {
        ByteArrayOutputStream bos = null;
        ObjectOutputStream oos = null;
        ByteArrayInputStream bis = null;
        ObjectInputStream ois = null;
        try {
            //关键点:通过序列化和反序列化，拷贝出一个对象，实现深拷贝
            bos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(bos);
            oos.writeObject(this);

            bis = new ByteArrayInputStream(bos.toByteArray());
            ois = new ObjectInputStream(bis);
            GreatSage copy = (GreatSage) ois.readObject();
            copy.setBirthday(new Date().getTime());
            return copy;
        } catch (Exception e) {
            e.printStackTrace();
            return null ;
        } finally {
            try {
                if (bos != null) {
                    bos.close();
                }
                if (oos != null) {
                    oos.close();
                }

                if (bis != null) {
                    bis.close();
                }
                if (ois != null) {
                    ois.close();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
