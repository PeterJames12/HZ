package miracleit.com.hz.model;

/**
 * @author Igor Hnes on 1/11/18.
 */

public class HZ {
    private String email;
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "HZ " +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +"";
    }
}
