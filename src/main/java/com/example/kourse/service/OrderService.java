package com.example.kourse.service;

import com.example.kourse.entity.*;
import com.example.kourse.repository.*;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRep orderRep;
    private final DatasRep datasRep;
    private final ProductRep productRep;
    private final UsersRep usersRep;
    private final KorsinaRep korsinaRepRep;


    @Transactional
    public void createOrder(List<Long> selectedProducts, Datas datas, Principal principal) {
        Users user = usersRep.findByEmail(principal.getName());
        System.out.println(datas.toString());
        Orders orders = new Orders();
        orders.setUser(usersRep.findByEmail(principal.getName()));
        orderRep.save(orders);
        datas.setOrders(orders);
        datasRep.save(datas);

        datasRep.save(datas);
        for (int i = 0; i<selectedProducts.size(); i++){
            Product prod1=productRep.getProductsById(selectedProducts.get(i));
            int price=orders.getPrice();
            price+=prod1.getPrice();
            orders.setPrice(price);


            prod1.getOrderList().add(orders);
            Korsina kors1=korsinaRepRep.findByUser(user);
            prod1.getKorsina().remove(kors1);
            kors1.getProductList().remove(prod1);

        }
    }
    @Transactional
    public List<Orders> getAll(Principal principal){

        return orderRep.getAllByUser(usersRep.findByEmail(principal.getName()));
    }
}
