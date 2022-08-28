package com.project.socialclone.clone.repo;

import com.project.socialclone.clone.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepo extends JpaRepository<Post, Long> {
}
