package com.project.socialclone.clone.services;

import com.project.socialclone.clone.model.PostModel;
import com.project.socialclone.clone.model.ResponseModel;
import org.springframework.stereotype.Service;

@Service
public interface PostService {

    ResponseModel createPost(PostModel post);
    ResponseModel getUserPosts(Long userId);
    ResponseModel getAllVisiblePost(Long userId);
    ResponseModel getAllPosts();
}
