package de.ait.ec.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(name = "NewUser", description = "Информация для добавления курса")
public class NewCourseDto {
    @Schema(description = "Для кого подходит курс",example = "для программистов которые с 0")
    private String title;
    @Schema(description = "Описание курса",example = "Курс по базам данных")
    private String description;
    @Schema(description = "Начало курса",example = "22-09-23")
    private String beginDate;
    @Schema(description = "Конец курса",example = "22-12-23")
    private String endDate;
    @Schema(description = "Цена",example = "100")
    private Double price;
}
