package com.smarthome.artech.controller;

import com.smarthome.artech.model.User;
import com.smarthome.artech.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/")
    public ResponseEntity<List<User>> index(@RequestParam(value = "limit", required = false) Integer limit) {
        return ResponseEntity.status(OK)
                .body(userService.getAllUsers());
    }

}