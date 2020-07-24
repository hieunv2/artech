package com.smarthome.artech;

import com.smarthome.artech.model.User;
import com.smarthome.artech.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class ArtechApplication{

    public static void main(String[] args) {
        SpringApplication.run(ArtechApplication.class, args);
    }
//    @Autowired
//    UserRepository userRepository;
//    @Autowired
//    PasswordEncoder passwordEncoder;
//
//    @Override
//    public void run(String... args) throws Exception {
//        // Khi chương trình chạy
//        // Insert vào csdl một user.
//        User user = new User();
//        user.setUsername("hieunv");
//        user.setPassword(passwordEncoder.encode("123456"));
//        userRepository.save(user);
//        System.out.println(user);
//    }
}
