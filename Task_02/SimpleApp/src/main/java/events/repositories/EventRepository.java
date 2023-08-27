package events.repositories;

import events.models.Event;

public interface EventRepository extends CrudRepository<Event>{
    Event findByTitle(String title);

}
