package de.ait.bootapp.repositories;

import de.ait.bootapp.dto.ParticipantDto;
import de.ait.bootapp.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface EventsRepository extends JpaRepository<Event, Long> {

    Set<ParticipantDto> findAllByEventsContainsOrderById(Long event);
}
