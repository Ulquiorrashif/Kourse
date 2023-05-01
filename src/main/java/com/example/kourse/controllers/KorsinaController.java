package com.example.kourse.controllers;

import com.example.kourse.entity.Datas;
import com.example.kourse.entity.Orders;
import com.example.kourse.entity.Product;
import com.example.kourse.repository.OrderRep;
import com.example.kourse.service.KorsinaService;
//import com.example.kourse.service.OrderService;
import com.example.kourse.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class KorsinaController {
    private final KorsinaService korsinaService;
    private final OrderService orderService;

    @PostMapping ("/addOrder")
    public String addOrder(String id, Principal principal)  throws IOException {
        korsinaService.korsina(id,principal);
        return "redirect:/korsina";

    }
    @GetMapping("/korsina")
    public String korsina(Model model, Principal principal){
        System.out.println(principal.getName());

        model.addAttribute("products", korsinaService.getAll(principal));
        return "Korsina";
    }
    @PostMapping("/qwe")
    public String test(@RequestParam(name = "buy", required = false) List<Long> selectedProducts, Datas datas,Principal principal){
        System.out.println(selectedProducts.toString());
        System.out.println(datas.toString());
        System.out.println("qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq");
        orderService.createOrder(selectedProducts,datas,principal);

//        model.addAttribute("products", korsinaService.getAll(principal));
        return "redirect:/korsina";
    }
    @GetMapping("/order")
    public  String order (Model model, Principal principal){

        model.addAttribute("orders",orderService.getAll(principal));
        return "Orders";
    }
    @GetMapping("/accaunt")
    public String accaunt(Model model, Principal principal){
        if (principal!=null)
            model.addAttribute("orders",orderService.getAll(principal));


//        System.out.println(principal.getName());
        return "Accaunt";
    }
//    @GetMapping("/accaunt")
//    public String accaunt(Model model, Principal principal){
//        model.addAttribute("orders",orderService.getAll(principal));
//
//
////        System.out.println(principal.getName());
//        return "Accaunt";
//    }
}
