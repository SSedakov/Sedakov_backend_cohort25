package de.ait.bootapp.controllers;

import de.ait.bootapp.dto.ParticipantDto;
import de.ait.bootapp.services.EventService;
import de.ait.bootapp.services.ParticipantService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@Tag(name = "Participant")
@RestController
@RequestMapping("/api/events")
public class ParticipantController {


    private final ParticipantService service;


    @PostMapping("/register")
    public ResponseEntity<ParticipantDto> register(@RequestBody @Valid ParticipantDto participant){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(service.register(participant));
    }
}
