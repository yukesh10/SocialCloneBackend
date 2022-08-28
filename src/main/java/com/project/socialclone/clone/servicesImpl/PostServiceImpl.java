package com.project.socialclone.clone.servicesImpl;

import com.project.socialclone.clone.entity.Post;
import com.project.socialclone.clone.model.PostModel;
import com.project.socialclone.clone.model.ResponseModel;
import com.project.socialclone.clone.repo.PostRepo;
import com.project.socialclone.clone.services.PostService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepo postRepo;

    @Override
    public ResponseModel createPost(PostModel bean) {

        ResponseModel res = new ResponseModel();
        Post post = new Post();
        BeanUtils.copyProperties(bean, post);

        postRepo.save(post);

        res.setObject(post);
        res.setMessage("Post created successfully!");
        res.setSuccessful(true);
        return res;
    }

    @Override
    public ResponseModel getUserPosts(Long userId) {
        return null;
    }

    @Override
    public ResponseModel getAllVisiblePost(Long userId) {
        return null;
    }
}
