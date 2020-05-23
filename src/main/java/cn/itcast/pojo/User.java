package cn.itcast.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * @author GuoQingchun
 * @date 2020/5/20  - 15:25
 */
public class User implements Serializable {
    private String uname;
    private String password;
    private Integer age;


    @Override
    public String toString() {
        return "User{" +
                "uname='" + uname + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                '}';
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
