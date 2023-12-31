package de.ait.bootapp.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

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

    @NotNull
    @NotBlank
    @Schema(description = "Описание события",example = "День рождения у бабушки 30 сентября")
    private String title;
}
