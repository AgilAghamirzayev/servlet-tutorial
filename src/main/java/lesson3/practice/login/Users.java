package lesson3.practice.login;

import java.util.HashMap;

public class Users {
    HashMap<String, String> users = new HashMap<>();

    public String add(String username, String password){

        if (username == null || password == null) return "Please enter password and username";
        if (users.containsKey(username) && users.containsValue(password)) return "You already registered";
        if (users.containsKey(username) )
        users.put(username, password);
        return "Registered successfully";
    }
}
