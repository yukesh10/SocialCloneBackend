package com.project.socialclone.clone.repo;

import com.project.socialclone.clone.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AppUserRepo extends JpaRepository<AppUser, Long> {
    AppUser findByEmail(String email);
}
