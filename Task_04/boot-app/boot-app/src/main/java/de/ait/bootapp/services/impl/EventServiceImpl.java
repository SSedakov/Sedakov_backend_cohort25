package de.ait.bootapp.services.impl;

import de.ait.bootapp.dto.EventDto;
import de.ait.bootapp.dto.NewEventDto;
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
    public NewEventDto addEvent(NewEventDto newEvent) {

        NewEventDto event = new NewEventDto(newEvent.getEventName(),newEvent.getTitle());

        eventRepository.save(event);

        return event;
    }

    @Override
    public List<EventDto> getAllEvent() {
        return eventRepository.findAll();
    }
}
