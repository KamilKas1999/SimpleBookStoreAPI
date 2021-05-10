package Kamil.Bookstore.Authority.request;

import com.sun.istack.NotNull;

public class SignUp {
    @NotNull
    private String email;
    @NotNull
    private String password;

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
