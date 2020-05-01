package storage;

import exception.ModelNotFoundException;
import model.User;

import java.util.HashMap;
import java.util.Map;

public class UserStorage {
    Map<String, User> users;

    public UserStorage() {
        users = new HashMap<>();
    }
    public void addUser(String key, User author){
        users.put(key, author);
    }
    public User getUserByPhoneNumber(String phoneNumber){
        User user = users.get(phoneNumber);
        return user;

    }
    public User getUserByPhoneNumberAndPassword(String phoneNumber, String password) throws ModelNotFoundException {
        User user=users.get(phoneNumber);
        if (user.getPassword().equals(password)){
            return user;
        }
        throw new ModelNotFoundException(String.format("User with %s phoneNumber does not exist",phoneNumber));

    }


}
