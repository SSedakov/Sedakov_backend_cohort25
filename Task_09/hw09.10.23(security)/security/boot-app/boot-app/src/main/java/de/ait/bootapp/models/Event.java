package de.ait.bootapp.models;

import de.ait.bootapp.dto.AreaDto;
import de.ait.bootapp.dto.ParticipantDto;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String eventName;
    private String title;

    @OneToMany(mappedBy = "participant")
    @EqualsAndHashCode.Exclude
    private Set<ParticipantDto> participants;

    @ManyToOne
    @EqualsAndHashCode.Exclude
    @JoinColumn(name ="event_id",nullable = false)
    private AreaDto area;

}
