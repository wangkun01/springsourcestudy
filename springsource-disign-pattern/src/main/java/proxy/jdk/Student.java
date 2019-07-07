package proxy.jdk;

/**
 * @author wangkun
 * @date 2019-07-06 18:31
 */
public class Student implements Person {

    private String name;
    private Integer age;

    @Override
    public void giveMoney() {
        System.out.println("学生缴费");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
