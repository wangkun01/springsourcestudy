package prototype.simple;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author wangkun
 * @date 2019-07-17 23:42
 */
public class ConCreateProType  extends ProtoType{

    private int age ;
    private Date BirthDay ;
    public ArrayList list ;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBirthDay() {
        return BirthDay;
    }

    public void setBirthDay(Date birthDay) {
        BirthDay = birthDay;
    }

    @Override
    public String toString() {
        return "ConCreateProType{" +
                "age=" + age +
                ", BirthDay=" + BirthDay +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        ConCreateProType conCreateProType = (ConCreateProType) super.clone();
        conCreateProType.list = (ArrayList) list.clone();
        return conCreateProType;
    }
}
