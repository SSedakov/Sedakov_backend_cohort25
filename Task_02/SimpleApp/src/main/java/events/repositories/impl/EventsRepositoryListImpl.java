package events.repositories.impl;


import events.models.Event;
import events.repositories.EventRepository;

import java.util.ArrayList;
import java.util.List;

public class EventsRepositoryListImpl implements EventRepository {

    List<Event> events = new ArrayList<>();
    int generateId = 0;

    @Override
    public Event findById(int id) {
        return null;
    }

    @Override
    public List<Event> findAll() {
        return new ArrayList<>(events);
    }

    @Override
    public void save(Event model) {
      events.add(model);
      model.setId(generateId);
      generateId ++;
    }

    @Override
    public void update(Event model) {

    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public Event findByTitle(String title) {
       for(Event event:events){
           if (event.getTitle().equals(title)){
               return event;
           }
       }
        return null;
    }
}