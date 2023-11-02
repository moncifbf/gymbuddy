package com.backslash.gymbuddy.controller;

import com.backslash.gymbuddy.dto.request.LoginRequestDTO;
import com.backslash.gymbuddy.dto.response.JwtResponseDTO;
import com.backslash.gymbuddy.model.GymUser;
import com.backslash.gymbuddy.security.SecurityUser;
import com.backslash.gymbuddy.security.jwt.JwtUtils;
import com.backslash.gymbuddy.service.GymUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@RestController
@RequestMapping(path = "/auth")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;
    private final GymUserService gymUserService;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtils jwtUtils;

    @PostMapping
    public ResponseEntity<JwtResponseDTO> authenticate(@RequestBody LoginRequestDTO loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.username(), loginRequest.password()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        SecurityUser userDetails = (SecurityUser) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        return new ResponseEntity<>(new JwtResponseDTO(jwt,
                "Bearer",
                userDetails.getUsername(),
                roles), HttpStatus.OK);
    }

    @PostMapping(path = "/register")
    public ResponseEntity<GymUser> register(@RequestBody GymUser gymUser) {
        gymUser.setPassword(passwordEncoder.encode(gymUser.getPassword()));
        GymUser savedGymUser = gymUserService.create(gymUser);
        if (isNull(savedGymUser)) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ResponseEntity.ok(savedGymUser);
    }
}
