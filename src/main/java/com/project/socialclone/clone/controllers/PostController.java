package com.project.socialclone.clone.controllers;

import com.project.socialclone.clone.model.PostModel;
import com.project.socialclone.clone.model.ResponseModel;
import com.project.socialclone.clone.services.PostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("post")
@Slf4j
@CrossOrigin(origins = "http://localhost:3000")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("/create")
    private ResponseEntity<?> createPost(@RequestBody PostModel post){
        ResponseModel res = new ResponseModel();
        try {
            res = postService.createPost(post);
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
