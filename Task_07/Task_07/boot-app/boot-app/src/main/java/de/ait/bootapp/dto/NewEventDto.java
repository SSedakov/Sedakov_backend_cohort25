package de.ait.bootapp.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Schema(name = "NewEvent",description = "информация для обавления события")
public class NewEventDto {

    @Schema(description = "Название события",example = "День рождения")
    @Size(min = 5, max = 1000)
    @NotBlank
    @NotNull
    private String eventName;


    @Schema(description = "Описание события",example = "День рождения у бабушки 30 сентября")
    private String title;


    @OneToMany(mappedBy = "participant")
    private Set<Participant> participants;
    @ManyToOne
    @JoinColumn(name ="event_id",nullable = false)
    private Area area;
}
