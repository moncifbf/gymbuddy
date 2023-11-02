package com.backslash.gymbuddy.controller;

import com.backslash.gymbuddy.dto.request.LinkGymBuddyDTO;
import com.backslash.gymbuddy.dto.request.LinkGymDTO;
import com.backslash.gymbuddy.model.GymUser;
import com.backslash.gymbuddy.service.GymUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.Objects.isNull;

@RestController
@RequestMapping(path = "/user")
@RequiredArgsConstructor
public class UserController {

    private final GymUserService gymUserService;

    @GetMapping
    public ResponseEntity<List<GymUser>> fetchAll() {
        List<GymUser> appUsers = gymUserService.getAll();
        if (CollectionUtils.isEmpty(appUsers)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return ResponseEntity.ok(appUsers);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<GymUser> fetchOne(@PathVariable("id") Long id) {
        GymUser gymUser = gymUserService.getOne(id);
        if (isNull(gymUser)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return ResponseEntity.ok(gymUser);
    }

    @PutMapping(value = "/link-gym-buddy", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GymUser> linkGymBuddies(@RequestBody LinkGymBuddyDTO dto) {
        GymUser updatedGymUser = gymUserService.linkGymBuddies(dto);
        if (isNull(updatedGymUser)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return ResponseEntity.ok(updatedGymUser);
    }

    @PutMapping("/link-gym")
    public ResponseEntity<GymUser> linkGym(@RequestBody LinkGymDTO dto) {
        GymUser updatedGymUser = gymUserService.linkGym(dto);
        if (isNull(updatedGymUser)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return ResponseEntity.ok(updatedGymUser);
    }
}
