package com.project.socialclone.clone.controllers;

import com.project.socialclone.clone.entity.AppUser;
import com.project.socialclone.clone.model.AppUserModel;
import com.project.socialclone.clone.model.ResponseModel;
import com.project.socialclone.clone.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("auth")
@Slf4j
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    private ResponseEntity<?> registerUser(@RequestBody AppUserModel user){

        ResponseModel res = new ResponseModel();
        try {
            res = userService.registerUser(user);
            if (res.isSuccessful()) {
                return ResponseEntity.status(HttpStatus.CREATED).body(res);
            } else {
                return ResponseEntity.badRequest().body(res);
            }
        } catch(Exception e){
            res.setMessage(e.getMessage());
            return ResponseEntity.badRequest().body(res);
        }
    }
}
