package com.example.kourse.service;

import com.example.kourse.entity.Users;
import com.example.kourse.repository.UsersRep;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsersService {
    private final UsersRep usersRep;
    private final PasswordEncoder passwordEncoder;
    @Transactional
    public void createUsers (Users user){
        System.out.println(user.getEmail());
        if(usersRep.findByEmail(user.getUsername())==null){
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            usersRep.save(user);
        }
        else{
            System.out.println("Пользователь уже есть");
        }

    }
}
