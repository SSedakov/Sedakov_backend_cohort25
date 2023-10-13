package de.ait.bootapp.dto;

import lombok.EqualsAndHashCode;

import javax.persistence.OneToMany;
import java.util.Set;

public class AreaDto {
    private String nameOfArea;
    private String title;

    @OneToMany(mappedBy = "area")
    @EqualsAndHashCode.Exclude
    private Set<NewEventDto> events;
}
