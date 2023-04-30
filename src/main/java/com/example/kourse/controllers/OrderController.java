package com.example.kourse.controllers;

import com.example.kourse.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;
import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping ("/addOrder")
    public String addOrder(String id, Principal principal)  throws IOException {
        orderService.korsina(id,principal);
        return "redirect:/korsina";

    }
//    @GetMapping("/korsina")
//    public String korsina(Model model, Principal principal){
//        model.addAttribute("orders", orderService.getAll(principal));
//
//        return "Korsina";
//    }
}
