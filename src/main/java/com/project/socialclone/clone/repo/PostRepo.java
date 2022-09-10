package com.project.socialclone.clone.repo;

import com.project.socialclone.clone.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepo extends JpaRepository<Post, Long> {
    List<Post> findByUserId(Long userId);
}
