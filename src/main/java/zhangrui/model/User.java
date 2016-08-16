package zhangrui.model;

import org.springframework.data.annotation.Id;

/**
 *
 * Created by zhangrui on 2016/8/16.
 */
public class User {

    //private String id;
    @Id
    private String name;

    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
