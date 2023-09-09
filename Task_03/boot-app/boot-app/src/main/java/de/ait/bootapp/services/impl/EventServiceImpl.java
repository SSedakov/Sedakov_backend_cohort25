package de.ait.bootapp.services.impl;

import de.ait.bootapp.models.Event;
import de.ait.bootapp.repositories.EventRepository;
import de.ait.bootapp.services.EventService;
import org.springframework.stereotype.Service;

import javax.websocket.server.ServerEndpoint;
import java.util.List;
@Service
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;


    public EventServiceImpl(EventRepository eventRepository) {
        this.eventRepository= eventRepository;
    }

    @Override
    public Event addEvent(String eventName, String title) {

        Event event = new Event(eventName,title);

        eventRepository.save(event);

        return event;
    }

    @Override
    public List<Event> getAllEvent() {
        return eventRepository.findAll();
    }
}
