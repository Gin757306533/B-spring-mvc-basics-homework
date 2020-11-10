package com.thoughtworks.capacity.gtb.mvc.controller;

import com.thoughtworks.capacity.gtb.mvc.dao.User;
import com.thoughtworks.capacity.gtb.mvc.service.UserService;
import org.hibernate.validator.constraints.Length;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@Validated
public class UserController {
    private UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void register(@Valid @RequestBody User user){
        userService.register(user);
    }

    @GetMapping("/login")
    @ResponseBody
    public User login(@Length(min = 3, max = 10, message = "用户名不合法")
                          @RequestParam(name = "username") String username,
                      @Length(min = 5, max = 12, message = "密码不合法")
                          @RequestParam(name="password") String password){
        return userService.login(username, password);
    }
}
