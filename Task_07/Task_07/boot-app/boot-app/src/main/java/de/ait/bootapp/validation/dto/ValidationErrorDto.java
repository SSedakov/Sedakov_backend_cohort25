package de.ait.bootapp.validation.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(name = "ValidationError", description = "Описание ошибки валидации")
public class ValidationErrorDto {

    @Schema(description = "название поля, в котором возникла ошибка", example = "price")
    private String field;
    @Schema(description = "значение, которое ввел пользовать и которое было отвергнуто сервером", example = "short message")
    private String rejectedValue;
    @Schema(description = "сообщение, которое мы должны показать пользователю", example = "Должно быть более 10 символов")
    private String message;
}
