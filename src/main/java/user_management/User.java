package user_management;

import user_management.security.Password;

public class User {
    private String email;
    private int id;
    private String name;
    private Password password;

    @Override
    public String toString() {
        return this.name + " - " + this.email;
    }

    public User(int id, String name, String email, Password password) {
        this.email = email;
        this.id = id;
        this.name = name;
        this.password = password;
    }

    @Override
    public boolean equals(Object obj) {
        User otherUser = (User) obj;
        return this.name.equals(otherUser.getName()) && this.id == otherUser.getId() && this.name.equals(otherUser.getName());
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Password getPassword() {
        return password;
    }

    public void setPassword(Password password) {
        this.password = password;
    }

    public void setPassword(String password) {
        this.password = new Password(password);
    }
}
