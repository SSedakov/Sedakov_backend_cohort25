package de.ait.shop.repositories.impl;

import de.ait.shop.models.Event;
import de.ait.shop.repositories.CrudRepository;
import de.ait.shop.repositories.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor

public class EventRepositoryJdbcTemplate implements EventRepository{


    private final JdbcTemplate jdbcTemplate;

    //language = SQL
    private static final String SQL_SELECT_ALL = "select * from event order by date_of_event";

    private static final String SQL_SELECT_ONE_BY_DATE = "select * from account where date_of_event = ? limit 1";

    //language = SQL
    private static final String SQL_DELETE_ONE_BY_ID = "delete from account where id = ? limit 1";

    //language = SQL
    private static final String SQL_UPDATE_ONE_BY_ID =  "update event set eventName = ? eventTitle = ?  dateOfEvent = ?  WHERE id = ? LIMIT 1";


    private static final RowMapper<Event> EVENT_ROW_MAPPER = (row, rowNum) -> Event.builder()
            .id(row.getLong("id"))
            .eventName(row.getString("eventName"))
            .eventTitle(row.getString("eventTitle"))
            .dateOfEvent(row.getString("dateOfEvent"))
            .build();




    @Override
    public Event findByData(String data) {
        try{
            return jdbcTemplate.queryForObject(SQL_SELECT_ONE_BY_DATE,EVENT_ROW_MAPPER,data);
        }catch (EmptyResultDataAccessException e){
            return null;
        }
    }



    @Override
    public List<Event> findAll() {
        return Collections.singletonList(jdbcTemplate.queryForObject(SQL_SELECT_ALL, EVENT_ROW_MAPPER));
    }

    @Override

    public void save(Event model) {
        SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbcTemplate)
                .withTableName("event")
                .usingGeneratedKeyColumns("id");

        Map<String,Object> row = new HashMap<>();
        row.put("eventName",model.getEventName());
        row.put("eventTitle",model.getEventTitle());
        row.put("dateOfEvent",model.getDateOfEvent());

        Long generatedId = insert.executeAndReturnKey(row).longValue();

        model.setId(generatedId);

    }

    @Override
    public void deleteById(Long id) {
         jdbcTemplate.update(SQL_DELETE_ONE_BY_ID,id);
    }

    @Override
    public void update(Event model) {
         jdbcTemplate.update(SQL_UPDATE_ONE_BY_ID,model.getEventName(),model.getEventTitle(),model.getDateOfEvent(),model.getId());

    }
}
