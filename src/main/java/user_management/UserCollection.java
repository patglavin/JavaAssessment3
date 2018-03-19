package user_management;

import user_management.security.UserAuthenticationFailedException;
import user_management.validation.EmailNotAvailableException;
import user_management.validation.InvalidEmailException;
import user_management.validation.PasswordTooSimpleException;

import java.util.ArrayList;
import java.util.ListIterator;

public class UserCollection extends ArrayList<User> {

    public User findById(int id) {
        for(User user:this){
            if (user.getId() == id) return user;
        }
        return null;
    }

    public User findByEmail(String email) {
        for (User user:this) if (user.getEmail().equals(email)) return user;
        return null;
    }

    public User attemptLogin(String email, String password) throws UserAuthenticationFailedException {
        User tempUser = this.findByEmail(email);
        if (tempUser == null) throw new UserAuthenticationFailedException();
        if (tempUser.getPassword().matches(password)) {
            return tempUser;
        } else {
            throw new UserAuthenticationFailedException();
        }
    }

    public int createUser(String name, String email, String password) throws EmailNotAvailableException, InvalidEmailException, PasswordTooSimpleException {
        if (this.findByEmail(email) != null) throw new EmailNotAvailableException();
        int id = this.size() + 1;
        if (emailInvalid(email)) throw new InvalidEmailException();
        if (passwordTooSimple(password)) throw new PasswordTooSimpleException();
        this.add(new User(id, name, email, password));
        return id;
    }

    private boolean passwordTooSimple(String password){
//        if (password.length() < 8) return true;
//        if (!password.matches("[a-z]")) return true;
//        if (!password.matches("[A-Z]")) return true;
//        if (!password.matches("[!@#$%^&*()<>?]")) return true;
//        if (!password.matches("[\\d]")) return true;
        if (!password.matches("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$")) return true;
        return false;
    }

    private boolean emailInvalid(String email){
        if (!email.matches("(\\w)+@(\\w)+\\.(\\w{3}|(\\w{2}\\.\\w{2}))")) return true;
        return false;
    }
}
