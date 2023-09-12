package de.ait.bootapp.controllers;

import de.ait.bootapp.dto.EventDto;
import de.ait.bootapp.dto.NewEventDto;
import de.ait.bootapp.services.EventService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Tags(value = @Tag(name = "Events"))
@RequiredArgsConstructor
@Controller
public class EventsController {

    private final EventService eventService;

    @Operation(summary = "Получение всех событий", description = "Доступно администратору")
    @GetMapping("/events")
    @ResponseBody
    public List<EventDto> getAllEvents() {
        return eventService.getAllEvent();
    }

    @Operation(summary = "Добавление нового события", description = "Доступно администратору")
    @PostMapping("/events")
    @ResponseBody
    public NewEventDto addEvent(@RequestBody NewEventDto newEvent) {
        return eventService.addEvent(newEvent);
    }
}
