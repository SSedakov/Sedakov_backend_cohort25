package events.services;


import events.models.Event;

import java.time.LocalDate;
import java.util.List;

public interface EventService {
    Event addEvent(String title, LocalDate start, LocalDate finish);

    List<Event> getAllEvents();
}
