package de.ait.bootapp.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Data
@Schema(name = "Поля для обновления участника")
public class UpdateEventDto {

    @NotEmpty
    @NotBlank
    private String eventName;

    @NotEmpty
    @NotBlank
    private String title;
}
