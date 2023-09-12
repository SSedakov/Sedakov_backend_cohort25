package de.ait.bootapp.repositories;

import de.ait.bootapp.dto.NewEventDto;
import de.ait.bootapp.models.Event;

import java.util.List;

public interface EventRepository <T> {
    List<T> findAll();
    void save (NewEventDto model);
}
