package de.ait.bootapp.services.impl;

import de.ait.bootapp.dto.EventDto;
import de.ait.bootapp.dto.NewEventDto;
import de.ait.bootapp.exceptions.RestException;
import de.ait.bootapp.models.Event;
import de.ait.bootapp.repositories.EventsRepository;
import de.ait.bootapp.services.EventService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

import static de.ait.bootapp.dto.EventDto.from;

@RequiredArgsConstructor
@Service
public class EventServiceImpl implements EventService {

    private final EventsRepository eventRepository;



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
    public EventDto getEventById(Long courseId) {
        Event event = eventRepository.findById(courseId)
                .orElseThrow(() -> new RestException(HttpStatus.NOT_FOUND, "Course with id <" + courseId + "> not found"));
      return from(event);
    }


    @Override
    public List<EventDto> getAllEvent() {
        return from( eventRepository.findAll());
    }
}
