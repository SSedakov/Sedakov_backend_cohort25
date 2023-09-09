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

    private List<Event> events = new ArrayList<>();

    @PostMapping("/events")
    public String addEvent(@RequestParam("nameEvent") String event,
                          @RequestParam("title") String title) {
        events.add(new Event(event,title));
        return "redirect:/success_add_event.html";
    }

    @GetMapping("/events")
    public String getEventsPage(Model model) {

        model.addAttribute("eventsList", events);
        return "events_page";
    }
}
