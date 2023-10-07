package de.ait.bootapp.models;

import de.ait.bootapp.dto.Area;
import de.ait.bootapp.dto.Participant;
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
    private Set<Participant> participants;
    @ManyToOne
    @JoinColumn(name ="event_id",nullable = false)
    private Area area;

}
