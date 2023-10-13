package de.ait.bootapp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParticipantDto {

    private Long existsLessonId;
    @NotNull
    private String familyName;
    @NotNull
    private String name;

    @OneToMany(mappedBy = "area")
    private Set<NewEventDto> events;
}
