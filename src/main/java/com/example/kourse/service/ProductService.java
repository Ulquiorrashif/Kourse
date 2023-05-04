package com.example.kourse.service;

import com.example.kourse.entity.Image;
import com.example.kourse.entity.Product;
import com.example.kourse.repository.ImageRep;
import com.example.kourse.repository.ProductRep;
import jakarta.transaction.Transactional;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRep productRep;
    private final ImageRep imageRep;
    @Transactional

    public void add(Product product, MultipartFile file) throws IOException {
        Image image;
//        if(file.getSize()!=0) {
//            image = toImageEntity(file);
//        }
        image=toImageEntity(file);
        productRep.save(product);
        image.setProduct(product);
        imageRep.save(image);


    }
    private Image toImageEntity(MultipartFile file) throws IOException {
        Image image = new Image();
        image.setName(file.getName());
        image.setOriginaleFileName(file.getOriginalFilename());
        image.setContentType(file.getContentType());
        image.setSize(file.getSize());
        image.setBytes(file.getBytes());
        return image;
    }
    @Transactional
    public List<Product> getAlltrue(){
        List<Product> list = new ArrayList<>();
        productRep.findAll().forEach(item->{
            if (item.isBuy())
                list.add(item);
        });
        return list;
    }
    @Transactional
    public List<Product> getAllfalse(){
        List<Product> list = new ArrayList<>();
        productRep.findAll().forEach(item->{
            if (item.isBuy()==false)
                list.add(item);
        });
        return list;
    }
    @Transactional
    public void remove(Long id, String title){
        if (id != null && title!=null){
            productRep.removeProductById(id);
            System.out.println("Товара удален "+  title+" "+id.toString());
        } else if (id == null && title!=null) {
            productRep.removeProductByTitle(title);
            System.out.println("Товара удален "+title);
        } else if (id != null && title==null) {
            productRep.removeProductById(id);
            System.out.println("Товара удален "+id.toString());
        }else
            System.out.println("Товара нет");
    }
}
