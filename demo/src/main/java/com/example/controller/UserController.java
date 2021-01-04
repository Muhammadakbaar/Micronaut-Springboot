package com.example.controller;


import com.example.model.User;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/user")
public class UserController{

    @Autowired
    public UserRepository userRepository;

    @GetMapping("/")
    public @ResponseBody Iterable<User> getAllUser(){
        return userRepository.findAll();
    }
    @PostMapping("/")
    public @ResponseBody User addNewUser (@RequestBody User user){
        return userRepository.save(user);
    }
    @GetMapping("/{id}")
    User userById(@PathVariable Integer id){
        return userRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Integer id){
        userRepository.deleteById(id);
    }

}