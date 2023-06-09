package com.example.kourse.service;

import com.example.kourse.entity.Korsina;
import com.example.kourse.entity.Orders;
import com.example.kourse.entity.Product;
import com.example.kourse.repository.KorsinaRep;
import com.example.kourse.repository.OrderRep;
import com.example.kourse.repository.ProductRep;
import com.example.kourse.repository.UsersRep;
import jakarta.persistence.criteria.Order;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class KorsinaService {
    private final KorsinaRep korsinaRepRep;
    private final UsersRep userRep;
    private final ProductRep productRep;
//    @Transactional
//    public void createOrder(String id, Principal principal){
//        List<String> list = List.of(id.split("_"));
//        Orders order = new Orders();
//
//        order.setUser(userRep.findByEmail(principal.getName()));
//        for (int i =1; i<list.size(); i++){
//            order.getProductList().add(productRep.getProductsById(Long.parseLong(list.get(i))));
//        }
//        orderRep.save(order);
//        System.out.println(list.toString());
//    }
    @Transactional
    public void korsina(String id, Principal principal){
//        Korsina korsina;
//        if (userRep.findByEmail(principal.getName()).getKorsina()==null)
//            korsina = new Korsina();
//        else {
//            korsina=userRep.findByEmail(principal.getName()).getKorsina();
//        }
////       korsina.setUser(userRep.findByEmail(principal.getName()));
//        korsinaRepRep.save(korsina);
//        List<String> list = List.of(id.split("_"));
//
//        for (int i = 1; i < list.size(); i++) {
//            Product product = productRep.getProductsById(Long.parseLong(list.get(i)));
//            product.getKorsina().add(korsina);
//        }
//        korsina.setUser(userRep.findByEmail(principal.getName()));
//
////        userRep.findByEmail(principal.getName()).setKorsina(korsina);
        Korsina korsina = userRep.findByEmail(principal.getName()).getKorsina();
        List<String> list = List.of(id.split("_"));

        for (int i = 1; i < list.size(); i++) {
            Product product = productRep.getProductsById(Long.parseLong(list.get(i)));
            product.getKorsina().add(korsina);
        }



    }
    @Transactional
    public List<Product> getAll(Principal principal){
//        return userRep.findByEmail(principal.getName()).getKorsina().getProductList();
//        System.out.println(userRep.findByEmail(principal.getName()).getKorsina().getProductList());
        return productRep.getAllByKorsina(userRep.findByEmail(principal.getName()).getKorsina());

    }
}
