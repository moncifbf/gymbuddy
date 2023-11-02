package com.backslash.gymbuddy.controller;

import com.backslash.gymbuddy.dto.request.CreateProfileRequestDTO;
import com.backslash.gymbuddy.dto.response.ProfileResponseDTO;
import com.backslash.gymbuddy.model.Profile;
import com.backslash.gymbuddy.service.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static java.util.Objects.isNull;

@RestController
@RequestMapping(path = "/profile")
@RequiredArgsConstructor
public class ProfileController {

    private final ProfileService profileService;

    @PostMapping
    public ResponseEntity<ProfileResponseDTO> create(@RequestBody CreateProfileRequestDTO dto) {
        ProfileResponseDTO dbProfile = profileService.linkProfile(dto);
        if (isNull(dbProfile)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(dbProfile, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfileResponseDTO> getOne(@PathVariable("id") Long id) {
        ProfileResponseDTO dbProfile = profileService.getProfileById(id);
        if (isNull(dbProfile)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(dbProfile, HttpStatus.OK);
    }
}
