package com.example.kourse.controllers;

import com.example.kourse.entity.Product;
import com.example.kourse.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class MainController {
    private final ProductService productService;
    @GetMapping("/home")
    public String home(){
        return "index";
    }
    @GetMapping("/katalog")
    public String katalog(Model model){

        model.addAttribute("products",productService.getAll());

        return "Katalog";
    }
    @GetMapping("/accaunt")
    public String accaunt(){
        return "Accaunt";
    }

    @GetMapping("/izbrannoe")
    public String izbranoe(){
        return "Izbrannoe";
    }
    @GetMapping("/admin")
    public String admin(){
        return "admin";
    }
//    @PostMapping ("/admin/add")
//    public String add(@RequestParam("product") Product product ,@RequestParam("image") MultipartFile file) throws IOException {
//        productService.add(product,file);
//        System.out.println(product.toString());
//
//        return "redirect:/admin";
//    }
    @PostMapping ("/admin/add")
    public String add(@RequestParam("title") String title,
                      @RequestParam("author") String author,
                      @RequestParam("price") int price,  @RequestParam("image") MultipartFile file)  throws IOException {
        Product product = new Product(title, author, price);
        productService.add(product,file);
        System.out.println(product.toString());

        return "redirect:/admin";
    }
    @PostMapping ("/qwe")
    public String qwe(String id)  throws IOException {
        System.out.println(id);
        return "redirect:/korsina";

    }
    @GetMapping("/hello")
    public String hello(Principal principal) {
        System.out.println(principal.getName());
        return "redirect:/home";
    }
}
