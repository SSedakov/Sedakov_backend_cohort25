package de.ait.events.services.impl;

import de.ait.events.models.Event;
import de.ait.events.repositories.EventRepository;
import de.ait.events.services.EventService;

import java.time.LocalDate;
import java.util.List;

public class EventsServiceImpl implements EventService {

    private final EventRepository eventRepository;

    public EventsServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public Event addEvent( String title, LocalDate start, LocalDate finish) {
        if(title == null || title.equals("") || title.equals(" ")) {
            throw new IllegalArgumentException("Событие не может быть пусты");
        }
        if (start.compareTo(finish) >0){
            throw new IllegalArgumentException("Дата окончания не может быть раньше даты начала");
        }
        Event event = new Event( title, start, finish);
        eventRepository.save(event);
        return event;
    }

    @Override
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }
}
