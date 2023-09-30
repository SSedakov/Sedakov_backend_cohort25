package de.ait.shop.services.impl;

import de.ait.shop.models.Event;
import de.ait.shop.repositories.impl.EventRepositoryJdbcTemplate;
import de.ait.shop.services.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class EventServiceImpl implements EventService {


    EventRepositoryJdbcTemplate eventRepository;
    @Override
    public void save(Event event) {
        Event existedEvent = eventRepository.findByData(event.getDateOfEvent()); // находим пользователя по email

        if (existedEvent!= null) {
            throw new IllegalArgumentException("Событие у этой датой уже существует");
        }

      eventRepository.save(event);
    }

    @Override
    public List<Event> findAll() {
      return   eventRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        List<Event> events = eventRepository.findAll();
        Event eventforUpdate = null;

        for(Event eventOld:events){
            if(eventOld.getId().equals(id)){
                eventforUpdate = eventOld;
                break;
            }
        }
        if (eventforUpdate == null){
            throw new IllegalArgumentException("Event with id <" + id + "> not found");
        }
        eventRepository.deleteById(eventforUpdate.getId());
    }

    @Override
    public  void update(Long id, String nameEvent, String titleEvent, String dateOfEvent) {
        List<Event> events = eventRepository.findAll();
        Event eventforUpdate = null;

        for(Event eventOld:events){
            if(eventOld.getId().equals(id)){
                eventforUpdate = eventOld;
                break;
            }
        }
          if (eventforUpdate == null){
              throw new IllegalArgumentException("Event with id <" + id + "> not found");
          }
             eventRepository.update(eventforUpdate);

    }
}
