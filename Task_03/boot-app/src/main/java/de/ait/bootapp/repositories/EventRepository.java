package de.ait.bootapp.repositories;

import de.ait.bootapp.models.Event;

import java.util.List;

public interface EventRepository {
    public List<Event> findAll();
    public void save(Event event);
}
