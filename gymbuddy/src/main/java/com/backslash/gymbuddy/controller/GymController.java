package com.backslash.gymbuddy.controller;

import com.backslash.gymbuddy.dto.request.GymAddDTO;
import com.backslash.gymbuddy.model.Gym;
import com.backslash.gymbuddy.service.GymService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static java.util.Objects.isNull;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/gym")
public class GymController {

    private final GymService gymService;

    @PostMapping
    public ResponseEntity<Gym> create(@RequestBody GymAddDTO dto) {
        Gym gym = Gym.builder().name(dto.name()).address(dto.address()).gymContactInfo(dto.gymContactInfo())
                .openingHours(dto.openingHours()).pricing(dto.pricing()).rating(dto.rating())
                .socialMediaLinks(dto.socialMediaLinks()).build();
        Gym savedGym = gymService.create(gym);
        if (isNull(savedGym)) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(savedGym, HttpStatus.CREATED);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Gym> getOne(@PathVariable("id") Long id) {
        Gym dbGym = gymService.getOne(id);
        if (isNull(dbGym)) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(dbGym, HttpStatus.OK);
    }
}
