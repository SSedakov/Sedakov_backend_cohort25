package de.ait.bootapp.services.impl;

import de.ait.bootapp.dto.EventDto;
import de.ait.bootapp.dto.NewEventDto;
import de.ait.bootapp.models.Event;
import de.ait.bootapp.repositories.EventRepository;
import de.ait.bootapp.services.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static de.ait.bootapp.dto.EventDto.from;

@RequiredArgsConstructor
@Service
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;



    @Override
    public EventDto addEvent(NewEventDto newEvent) {
        Event event = Event.builder()
                .eventName(newEvent.getEventName())
                .title(newEvent.getTitle())
                .build();

        eventRepository.save(event);

        return from(event);
    }



    @Override
    public List<EventDto> getAllEvent() {
        return from( eventRepository.findAll());
    }
}
