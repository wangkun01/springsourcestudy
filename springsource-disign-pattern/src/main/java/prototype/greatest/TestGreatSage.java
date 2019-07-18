package prototype.greatest;

/**
 *
 * //关键点:通过序列化和反序列化，拷贝出一个对象，实现深拷贝
 * bos = new ByteArrayOutputStream() ;
 * oos = new ObjectOutputStream(bos);
 * oos.writeObject(this);
 *
 * bis = new ByteArrayInputStream(bos.toByteArray());
 * ois = new ObjectInputStream(bis);
 * return (GreatSage) ois.readObject();
 *
 * 特别注意点：********对象需要序列化要实现Serializable***************
 * public class GreatSage extends MonKey  implements Cloneable ,Serializable
 * @author wangkun
 * @date 2019-07-19 00:41
 */
public class TestGreatSage {


    public static void main(String[] args) {
        GreatSage greatSage = new GreatSage();
        GreatSage copy = (GreatSage) greatSage.clone();
        System.out.println("大圣本尊的年龄" + greatSage.getBirthday());
        System.out.println("假大圣的年龄" + copy.getBirthday());

        System.out.println("真假大圣的金箍棒是否同一个" + (greatSage.getGoldenCudgel() == copy.getGoldenCudgel()));
        System.out.println("真假大圣是否是同一个对象" + (greatSage == copy));

    }
}
