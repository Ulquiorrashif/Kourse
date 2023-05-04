package com.example.kourse.controllers;

import com.example.kourse.entity.Product;
import com.example.kourse.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.security.access.prepost.PreAuthorize;
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
    public String katalog(Model model,Authentication authentication){
        model.addAttribute("authentication", authentication);

        model.addAttribute("productstrue",productService.getAlltrue());
        model.addAttribute("productsfalse",productService.getAllfalse());

        return "Katalog";
    }


    @GetMapping("/izbrannoe")
    public String izbranoe(){
        return "Izbrannoe";
    }
    @PreAuthorize("hasRole('ADMIN')")
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
                      @RequestParam("price") int price,
                      @RequestParam(value = "buy", defaultValue = "false") boolean buy,
                      @RequestParam(value = "image") MultipartFile file)  throws IOException {
        System.out.println(buy);
        Product product = new Product(title,author, price,buy);
        productService.add(product,file);
        System.out.println(product.toString());

        return "redirect:/accaunt";
    }
    @PostMapping ("/product/remove")
    public String remove(@RequestParam(value = "id",required = false)Long id, @RequestParam(value = "title", required = false)String title)  throws IOException {
        productService.remove(id,title);
        return "redirect:/accaunt";

    }
    @GetMapping("/hello")
    public String hello(Principal principal) {
        System.out.println(principal.getName());
        return "redirect:/home";
    }
}
