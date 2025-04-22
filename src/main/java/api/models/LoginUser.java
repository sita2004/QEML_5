package api.models;


public class LoginUser {
    private String username;
    private String password;

    private LoginUser(LoginUserBuilder builder) {
        this.username = builder.username;
        this.password = builder.password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public static class LoginUserBuilder {
        private String username;
        private String password;

        public LoginUserBuilder setUsername(String username) {
            this.username = username;
            return this;
        }

        public LoginUserBuilder setPassword(String password) {
            this.password = password;
            return this;
        }

        public LoginUser build() {
            return new LoginUser(this);
        }
    }
}
