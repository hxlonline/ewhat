package hxl.cn.com.ewhat.model;

import com.google.firebase.database.IgnoreExtraProperties;

/**
 * Created by hexinglin on 2017/08/25.
 */
@IgnoreExtraProperties
public class User {
    public String username;
    public String email;

    public User() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public User(String username, String email) {
        this.username = username;
        this.email = email;
    }

}
