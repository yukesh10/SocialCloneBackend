package com.project.socialclone.clone.services;

import com.project.socialclone.clone.model.AppUserModel;
import com.project.socialclone.clone.entity.AppUser;

public interface UserService {
    AppUser registerUser(AppUserModel user);
}
