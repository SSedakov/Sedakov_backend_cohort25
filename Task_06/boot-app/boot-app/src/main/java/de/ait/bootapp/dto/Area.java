package de.ait.bootapp.dto;

import javax.persistence.OneToMany;
import java.util.Set;

public class Area {
    private String nameOfArea;
    private String title;

    @OneToMany(mappedBy = "area")
    private Set<NewEventDto> events;
}
