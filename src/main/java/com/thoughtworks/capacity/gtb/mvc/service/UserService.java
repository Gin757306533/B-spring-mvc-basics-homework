package com.thoughtworks.capacity.gtb.mvc.service;

import com.thoughtworks.capacity.gtb.mvc.dao.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class UserService {
    private Map<Integer, User> userMap = new HashMap<>();
    private int biggestId = 0;

    public UserService(){

    }

    public void register(User user){
        int userId = biggestId+1;
        user.setId(userId);
        userMap.put(userId, user);
        biggestId += 1;
    }

    public User login(String username, String password){
        List<User> userList = new ArrayList(userMap.values().stream()
                .filter(
                        user -> user.getUsername().equals(username))
                .filter(user -> user.getPassword().equals(password))
                .collect(Collectors.toList()));
        return userList.get(0);
    }
}
