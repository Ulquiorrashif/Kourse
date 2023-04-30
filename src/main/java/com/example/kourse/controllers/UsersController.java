package com.example.kourse.controllers;

import com.example.kourse.entity.Users;
import com.example.kourse.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class UsersController {
    private final UsersService usersService;
    @PostMapping("/reg")
    public String reg(Users user){
        usersService.createUsers(user);
        return "redirect:/accaunt";
    }

}
