package de.ait.bootapp.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(name = "Сообщение", description = "Ответ с сервера")
public class StandardResponseDto {
    @Schema(description = "Сообщение об ошибке и т.д.", example = "Событие не найдено")
    private String message;
}