package de.ait.bootapp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParticipantDto {

    public enum Role {
        ADMIN, MANAGER, USER
    }

    private Long existsLessonId;
    @NotNull
    private String familyName;
    @NotNull
    private String name;

    @Enumerated(value = EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "area")
    private Set<NewEventDto> events;
}
