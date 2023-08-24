package de.ait.events.controllers;

import de.ait.events.models.Event;
import de.ait.events.services.EventService;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class EventsControllers {
    private final Scanner scanner;
    private EventService eventService;

    public EventsControllers(Scanner scanner, EventService eventService) {
        this.scanner = scanner;
        this.eventService = eventService;
    }
     public void addEvent() {
         System.out.println("Введите событие");
         String title = scanner.nextLine();
         System.out.println("Введите дату начала события в формате (yyyy-MM-dd)");
         String start = scanner.nextLine();
         LocalDate startLocalDate = LocalDate.parse(start);
         System.out.println("Введите дату окончания события в формате (yyyy-MM-dd)");
         String finish = scanner.nextLine();
         LocalDate finishLocalDate = LocalDate.parse(finish);

         eventService.addEvent(title,startLocalDate,finishLocalDate);
     }

    public void getAllEvents() {
        List<Event> allEvents = eventService.getAllEvents();
        System.out.println(allEvents);
    }
}
