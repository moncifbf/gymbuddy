package com.backslash.gymbuddy.security;

import com.backslash.gymbuddy.model.AppUser;
import com.backslash.gymbuddy.repository.AppUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private AppUserRepository appUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        Optional<AppUser> dbAppUser = appUserRepository.findByUsername(username);
        return dbAppUser.map(SecurityUser::new).orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
}
