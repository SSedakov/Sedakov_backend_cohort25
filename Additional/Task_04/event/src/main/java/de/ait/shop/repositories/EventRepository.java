package de.ait.shop.repositories;

import de.ait.shop.models.Event;

public interface EventRepository extends CrudRepository<Event>{
    Event findByData(String data);
}
