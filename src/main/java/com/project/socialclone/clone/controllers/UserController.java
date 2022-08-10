package com.project.socialclone.clone.controllers;

import com.project.socialclone.clone.entity.AppUser;
import com.project.socialclone.clone.model.AppUserModel;
import com.project.socialclone.clone.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    private ResponseEntity<?> registerUser(@RequestBody AppUserModel user){

        try {
            AppUser newUser = userService.registerUser(user);
            return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
        } catch(Exception e){
            log.error(e.getMessage());
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
