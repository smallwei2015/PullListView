package txvpn.txjsq.com.pulllistview;

/**
 * Created by anpy on 2016/3/17.
 */
public class UserData {
    String name;
    int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public UserData(int age, String name) {

        this.age = age;
        this.name = name;
    }
}
