package de.ait.shop.services;

import de.ait.shop.models.Event;

import java.util.List;

public interface EventService {
    void save(Event event);

    List<Event> findAll();

    void deleteById(Long id);

    void update(Long id, String nameEvent, String titleEvent, String dateOfEvent);


}
