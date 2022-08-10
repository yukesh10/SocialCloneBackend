package com.project.socialclone.clone.servicesImpl;

import com.project.socialclone.clone.entity.AppUser;
import com.project.socialclone.clone.model.JwtUserDetails;
import com.project.socialclone.clone.repo.AppUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class JwtUserDetailService implements UserDetailsService {

    @Autowired
    private AppUserRepo appUserRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        List<AppUser> users = appUserRepo.findAll();

        Optional<AppUser> findFirst = users.stream()
                .filter(user -> user.getEmail().equals(username)).findFirst();

        if (!findFirst.isPresent()) {
            throw new UsernameNotFoundException(String.format("USER_NOT_FOUND '%s'.", username));
        }

        AppUser user = findFirst.get();

        JwtUserDetails userDetails = new JwtUserDetails(user.getUserId(), user.getEmail(), user.getPassword(), null);

        return userDetails;
    }
}
