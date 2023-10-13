package de.ait.bootapp.services;

import de.ait.bootapp.dto.EventDto;
import de.ait.bootapp.dto.NewEventDto;
import de.ait.bootapp.dto.ParticipantDto;
import de.ait.bootapp.dto.UpdateEventDto;

import java.util.List;

public interface EventService {


    List<EventDto> getAllEvent();

    EventDto addEvent(NewEventDto newEvent);

    EventDto getEventById(Long courseId);

    ParticipantDto addParticipantToEvent(Long eventId, ParticipantDto participant);

    List<ParticipantDto> getParticipantOfEvent(Long eventId);

    EventDto updateEvent(Long eventId,  UpdateEventDto updateEvent);

    EventDto deleteEvent(Long eventId);
}
