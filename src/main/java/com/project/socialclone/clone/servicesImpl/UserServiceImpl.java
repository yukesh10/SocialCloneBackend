package com.project.socialclone.clone.servicesImpl;

import com.project.socialclone.clone.exception.EmailAlreadyExistsException;
import com.project.socialclone.clone.exception.PasswordDoesNotMatchException;
import com.project.socialclone.clone.model.AppUserModel;
import com.project.socialclone.clone.entity.AppUser;
import com.project.socialclone.clone.model.ResponseModel;
import com.project.socialclone.clone.repo.AppUserRepo;
import com.project.socialclone.clone.services.UserService;
import org.apache.coyote.Response;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDate;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private AppUserRepo appUserRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public ResponseModel registerUser(AppUserModel bean) {

        ResponseModel res = new ResponseModel();

        if (!StringUtils.hasLength(bean.getPassword()) ||
                !StringUtils.hasLength(bean.getConfirmPassword()) ||
                !bean.getPassword().equals(bean.getConfirmPassword())){
            res.setMessage("The password and confirm password does not match");
            return res;
        }

        AppUser existingUser = appUserRepo.findByEmail(bean.getEmail());
        if (existingUser != null){
            res.setMessage("Provided email address already exists in the system");
            return res;
        }

        AppUser user = new AppUser();
        BeanUtils.copyProperties(bean, user);

        user.setPassword(passwordEncoder.encode(bean.getPassword()));

        user.setActiveFlg(true);
        user.setDateCreated(LocalDate.now());

        user = appUserRepo.save(user);

        res.setObject(user);
        res.setMessage("User created successfully!");
        res.setSuccessful(true);
        return res;
    }
}
