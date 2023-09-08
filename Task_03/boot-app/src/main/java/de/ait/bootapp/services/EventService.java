package de.ait.bootapp.services;

import de.ait.bootapp.models.Event;

import java.util.List;

public interface EventService {
    Event addEvent(String eventName, String title);

    List<Event> getAllEvent();
}
