package com.project.socialclone.clone.services;

import com.project.socialclone.clone.model.AppUserModel;
import com.project.socialclone.clone.model.ResponseModel;

public interface UserService {
    ResponseModel registerUser(AppUserModel user);
}
