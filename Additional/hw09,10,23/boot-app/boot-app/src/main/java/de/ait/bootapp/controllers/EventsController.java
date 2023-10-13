package de.ait.bootapp.controllers;

import de.ait.bootapp.dto.*;
import de.ait.bootapp.services.EventService;
import de.ait.bootapp.validation.dto.ValidationErrorsDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@Tags(value = @Tag(name = "Events"))
@RequiredArgsConstructor
@RestController
@Controller
@RequestMapping("/api/events")
public class EventsController {

    private final EventService eventService;


    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",
                    description = "Событие было успешно создано",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = EventDto.class))),
            @ApiResponse(responseCode = "400",
                    description = "Ошибка валидации",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ValidationErrorsDto.class)))
    })

    @Operation(summary = "Получение всех событий", description = "Доступно администратору")
    @GetMapping("/events")
    @ResponseBody
    public ResponseEntity<List<EventDto>> getAllEvents() {
        return ResponseEntity
                .ok(eventService.getAllEvent());
    }


    @Operation(summary = "Добавление нового события", description = "Доступно администратору")
    @PostMapping("/events")
    @ResponseBody
    public ResponseEntity<EventDto> addEvent(@RequestBody @Valid NewEventDto newEvent) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(eventService.addEvent(newEvent));
    }


    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Запрос обработан успешно",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = EventDto.class))
            ),
            @ApiResponse(responseCode = "404",
                    description = "Событие не найдено",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = StandardResponseDto.class)))
    })

    @GetMapping("/event/{event-id}")
    public ResponseEntity<EventDto> getCourse(@Parameter(description = "идентификатор события", example = "1")
                                               @PathVariable("event-id") Long courseId) {
        return ResponseEntity
                .ok(eventService.getEventById(courseId));
    }

    @PostMapping("/{events-id}/participant")
    public ResponseEntity<ParticipantDto> addParticipantToEvent(@PathVariable("events-id") Long participantId,
                                                           @RequestBody @Valid ParticipantDto participant) {
      return  ResponseEntity
                .status(HttpStatus.CREATED)
                .body(eventService.addParticipantToEvent(participantId,participant));

    }

    @GetMapping("/{event-id}/participant")
    public ResponseEntity<List<ParticipantDto>> getParticipantFromEvent(@PathVariable("event-id") Long eventId){
        return ResponseEntity.ok(eventService.getParticipantOfEvent(eventId));
    }

    @PutMapping("/{event-id}")
    public ResponseEntity<EventDto> updateEvent(@PathVariable("event-id") Long eventId,
                                                                   @RequestBody UpdateEventDto updateEvent){
      return ResponseEntity.ok(eventService.updateEvent(eventId,updateEvent));
    }

    @DeleteMapping("/{event-id}")
    public ResponseEntity<EventDto> deleteEvent(@PathVariable("even-id") Long eventId){
        return ResponseEntity.ok(eventService.deleteEvent(eventId));
    }
}
