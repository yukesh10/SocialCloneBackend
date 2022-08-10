package com.project.socialclone.clone.model;

import com.project.socialclone.clone.entity.AppUser;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppUserModel extends AppUser {
    private String confirmPassword;
}
