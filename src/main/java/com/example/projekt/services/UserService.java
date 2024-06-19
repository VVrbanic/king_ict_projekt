package com.example.projekt.services;

import com.example.projekt.api.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private List<User> userList;

    public UserService(){
        userList = new ArrayList<>();

        User user1 = new User(1, "Ida", 21, "ida@gmail.com");
        User user2 = new User(2, "Ida2", 22, "ida2@gmail.com");
        User user3 = new User(3, "Ida3", 23, "ida3@gmail.com");
        User user4 = new User(4, "Ida4", 24, "ida4@gmail.com");
        User user5 = new User(5, "Ida5", 25, "ida5@gmail.com");

        userList.addAll(Arrays.asList(user1, user2, user3, user4, user5));
    }
    public Optional<User> getUser(int id) {
        Optional optional = Optional.empty();
        for (User user : userList) {
            if (id == user.getId()) {
                optional = Optional.of(user);
                return optional;
            }
        }
        return optional;
    }
}
