package de.ait.bootapp.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Schema(name = "NewEvent",description = "информация для обавления события")
public class NewEventDto {

    @Schema(description = "Название события",example = "День рождения")
    private String eventName;
    @Schema(description = "Описание события",example = "День рождения у бабушки 30 сентября")
    private String title;
}
