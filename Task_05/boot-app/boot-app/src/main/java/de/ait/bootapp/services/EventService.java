package de.ait.bootapp.services;

import de.ait.bootapp.dto.EventDto;
import de.ait.bootapp.dto.NewEventDto;
import de.ait.bootapp.models.Event;

import java.util.List;

public interface EventService {


    List<EventDto> getAllEvent();

    EventDto addEvent(NewEventDto newEvent);

}
