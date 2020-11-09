package com.thoughtworks.capacity.gtb.mvc.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private int id;

    @NotNull(message = "用户名不合法")
    @Length(min=3, max=10, message = "用户名不合法")
    @Pattern(regexp = "[a-zA-Z_]{3,10}", message = "用户名不合法")
    private String username;

    @Length(min = 5, max = 12, message = "密码不合法")
    @NotNull(message = "密码不合法")
    private String password;

    @Email(message = "邮箱地址不合法")
    private String email;
}
