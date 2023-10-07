package de.ait.bootapp.dto;

import javax.persistence.OneToMany;
import java.util.Set;

public class Participant {
    private String familyName;
    private String name;

    @OneToMany(mappedBy = "area")
    private Set<NewEventDto> events;
}
