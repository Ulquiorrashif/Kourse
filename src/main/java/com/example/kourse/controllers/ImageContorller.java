package com.example.kourse.controllers;

import com.example.kourse.entity.Image;
import com.example.kourse.repository.ImageRep;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.InputStreamSource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

@RestController
@RequiredArgsConstructor
public class ImageContorller {
    private final ImageRep imageRep;
    @GetMapping("/images/{id}")
    private ResponseEntity<?> getImageById(@PathVariable Long id ){
        Image image = imageRep.findById(id).orElse(null);
        return  ResponseEntity.ok().header("fileName", image.getOriginaleFileName())
                .contentType(MediaType.valueOf(image.getContentType()))
                .contentLength(image.getSize())
                .body(new InputStreamResource(new ByteArrayInputStream(image.getBytes())));


    }
}
