package de.ait.bootapp.controllers;

import de.ait.bootapp.models.Event;
import de.ait.bootapp.services.EventService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;



@Controller
public class EventsController {

    private final EventService eventService;

    public EventsController(EventService eventService) {
        this.eventService = eventService;
    }

    @PostMapping("/event")
    public String addEvent(@RequestParam("nameEvent") String event,
                          @RequestParam("title") String title) {
        eventService.addEvent(event,title);
        return "redirect:/success_add_event.html";
    }

    @GetMapping("/events")
    public String getEventsPage(Model model) {
        List<Event> events = eventService.getAllEvent();
        model.addAttribute("eventList", events);
        return "events_page";
    }
}
