package com.smarthome.artech.controller;

import com.smarthome.artech.model.User;
import com.smarthome.artech.request.UserRequest;
import com.smarthome.artech.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("")
    public ResponseEntity<List<User>> index(@RequestParam(value = "limit", required = false) Integer limit) {
        return ResponseEntity.status(OK)
                .body(userService.getAllUsers());
    }

    @PostMapping
    public ResponseEntity<String> store(@RequestBody @Valid User user) {
        userService.save(user);
        return ResponseEntity.ok("User data is valid");
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> update( @PathVariable("id") Long id,
                                        @RequestBody User user){
        Optional<User> curentUser = userService.findById(id);
        if (!curentUser.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        if(user.getUsername() != null){
            curentUser.get().setUsername(user.getUsername());
        }
        if(user.getEmail() != null){
            curentUser.get().setEmail(user.getEmail());
        }

        userService.save(curentUser.get());
        return new ResponseEntity<>(curentUser.get(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id){
        Optional<User> curentUser = userService.findById(id);
        if (!curentUser.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        userService.remove(curentUser.get());
        return new ResponseEntity<>( HttpStatus.OK);
    }

}