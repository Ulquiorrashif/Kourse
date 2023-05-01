package com.example.kourse.service;

import com.example.kourse.entity.Korsina;
import com.example.kourse.entity.Role;
import com.example.kourse.entity.Users;
import com.example.kourse.repository.KorsinaRep;
import com.example.kourse.repository.UsersRep;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsersService {
    private final UsersRep usersRep;
    private final KorsinaRep korsinaRep;
    private final PasswordEncoder passwordEncoder;
    @Transactional
    public void createUsers (Users user){
        System.out.println(user.getEmail());
        if(usersRep.findByEmail(user.getUsername())==null){
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.getRoles().add(Role.ROLE_USER);
            usersRep.save(user);
            Korsina korsina = new Korsina();
            korsina.setUser(user);
            korsinaRep.save(korsina);
        }
        else{
            System.out.println("Пользователь уже есть");
        }

    }
    @Transactional
    public  void createAdmin(Users user){
        if(usersRep.findByEmail(user.getUsername())==null){
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.getRoles().add(Role.ROLE_ADMIN);
            usersRep.save(user);
            Korsina korsina = new Korsina();
            korsina.setUser(user);
            korsinaRep.save(korsina);
        }
        else{
            System.out.println("Пользователь уже есть");
        }
    }
}
