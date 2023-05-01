package com.example.kourse.controllers;

import com.example.kourse.entity.Users;
import com.example.kourse.repository.UsersRep;
import com.example.kourse.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class AdminController {
    private final UsersService usersService;
    @GetMapping("/adminpage")
    public String print(){
        return "AdminPage";
    }
    @PostMapping("/admin/reg")
    public String reg(Users user){
        usersService.createAdmin(user);
        return "redirect:/home";

    }

}
