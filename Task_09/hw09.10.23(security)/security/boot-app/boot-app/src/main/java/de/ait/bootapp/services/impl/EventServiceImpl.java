package de.ait.bootapp.services.impl;

import de.ait.bootapp.dto.EventDto;
import de.ait.bootapp.dto.NewEventDto;
import de.ait.bootapp.dto.ParticipantDto;
import de.ait.bootapp.dto.UpdateEventDto;
import de.ait.bootapp.exceptions.RestException;
import de.ait.bootapp.models.Event;
import de.ait.bootapp.repositories.EventsRepository;
import de.ait.bootapp.repositories.ParticipantRepository;
import de.ait.bootapp.services.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

import static de.ait.bootapp.dto.EventDto.from;

@RequiredArgsConstructor
@Service
public class EventServiceImpl implements EventService {

    private final EventsRepository eventRepository;
    private final ParticipantRepository participantRepository;



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
    public ParticipantDto addParticipantToEvent(Long eventId, ParticipantDto newParticipant) {

        EventDto event = getEventById(eventId);

        ParticipantDto participant;

        if (newParticipant.getExistsLessonId() == null) {
            participant = ParticipantDto.builder()
                    .familyName(newParticipant.getFamilyName())
                    .name(newParticipant.getName())
                    .events((Set<NewEventDto>) event)
                    .build();
        }else {
            participant = participantRepository.findById(newParticipant.getExistsLessonId())
                    .orElseThrow(() -> new RestException(HttpStatus.NOT_FOUND,
                            "Participant with id" + newParticipant.getExistsLessonId() + " not found"));
               participant.setEvents((Set<NewEventDto>) event);
        }
        participantRepository.save(participant);
        return participant;
    }

    @Override
    public List<ParticipantDto> getParticipantOfEvent(Long eventId) {
        EventDto event = getEventById(eventId);

        Set<ParticipantDto> participant = eventRepository.findAllByEventsContainsOrderById(eventId);
        return (List<ParticipantDto>) participant;
    }

    @Override
    public EventDto updateEvent(Long eventId, UpdateEventDto updateEvent) {

        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new RestException(HttpStatus.NOT_FOUND,
                "event with id " + eventId + " not found"));

                event.setEventName(updateEvent.getEventName());

        if (updateEvent.getTitle() != null) {
            event.setTitle(updateEvent.getTitle());
        }else {
            event.setTitle(null);
        }

        eventRepository.save(event);
        return from(event);

    }

    @Override
    public EventDto deleteEvent(Long eventId) {
        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new RestException(HttpStatus.NOT_FOUND,
                        "Event with id" + eventId + " not found"));
        event.setTitle(null);
        event.setEventName(null);
        eventRepository.save(event);
        return from(event);
    }


    @Override
    public List<EventDto> getAllEvent() {
        return from( eventRepository.findAll());
    }
}
