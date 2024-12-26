package com.banew.aklb_university.DTO;


import org.springframework.security.crypto.password.PasswordEncoder;

import com.banew.aklb_university.entities.User;
import com.banew.aklb_university.other.Position;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserRegistration {
    @NotBlank(message = "Дане поле обов'язкове!")
    @Size(min = 3, message = "Вказаний логін занадто короткий!")
    private String username;
    @Size(min = 3, message = "Вказане ім'я занадто коротке!")
    private String name;
    @Size(min = 3, message = "Вказане прізвище занадто коротке!")
    private String surname;
    @NotBlank(message = "Дане поле обов'язкове!")
    @Size(min = 8, message = "Пароль має містити бодай 8 символів!")
    @Pattern(regexp = ".*[A-Z].*", message = "Пароль має містити бодай один символ у верхньому регістрі!")
    @Pattern(regexp = ".*[a-z].*", message = "Пароль має містити бодай один символ у нижньому регістрі!")
    private String password;
    @NotBlank(message = "Дане поле обов'язкове!")
    @Size(min = 8, message = "Пароль має містити бодай 8 символів!")
    @Pattern(regexp = ".*[A-Z].*", message = "Пароль має містити бодай один символ у верхньому регістрі!")
    @Pattern(regexp = ".*[a-z].*", message = "Пароль має містити бодай один символ у нижньому регістрі!")
    private String password2;
    @NotBlank(message = "Дане поле вказати обов'язково!")
    private String status;

    public User toUser(PasswordEncoder encoder) throws Exception {
        if (password.equals(password2) && password != null) {
            var user = new User();
            user.setName(name);
            user.setNickname(username);
            user.setSurname(surname);
            user.setPassword(encoder.encode(password));
            user.setPosition(Position.valueOf(status));

            return user;
        }
        throw new Exception("Негри!");
    }
}