package de.ait.bootapp.repositories;

import de.ait.bootapp.dto.ParticipantDto;
import de.ait.bootapp.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface ParticipantRepository extends JpaRepository<ParticipantDto,Long> {
    Set<ParticipantDto> findAllByEventsContainsOrderById(Event event);
}
