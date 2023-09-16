package de.ait.bootapp.repositories.impl;


import de.ait.bootapp.dto.EventDto;
import de.ait.bootapp.dto.NewEventDto;
import de.ait.bootapp.models.Event;
import de.ait.bootapp.repositories.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Repository
public class EventRepositoryJdbcmpl implements EventRepository {

    private final DataSource dataSource;




    @Override
    public List<Event> findAll() {
     return null;
    }




    @Override
    public void save(Event event) {

        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(dataSource)
                .usingGeneratedKeyColumns("id");
        jdbcInsert.withTableName("account");

        Map<String,Object> parameters = new HashMap<>();

        parameters.put("eventName",event.getEventName());
        parameters.put("title",event.getTitle());

        long generatedId = jdbcInsert.executeAndReturnKey(parameters).longValue();

        event.setId(generatedId);
    }
}
