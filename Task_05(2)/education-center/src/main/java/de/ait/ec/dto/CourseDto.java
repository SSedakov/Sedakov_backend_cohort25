package de.ait.ec.dto;

import de.ait.ec.models.Course;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(name = "NewUser", description = "Информация о курсе")
public class CourseDto {

    @Schema(description = "идентификатор курса", example = "1")
    private Long id;
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
    private String state;

    public static CourseDto from(Course course) {
        return CourseDto.builder()
                .id(course.getId())
                .description(course.getDescription())
                .title(course.getTitle())
                .beginDate(course.getBeginDate().toString())
                .endDate(course.getEndDate().toString())
                .price(course.getPrice())
                .state(course.getState().toString())
                .build();
    }

    public static List<CourseDto> from(List<Course> courses) {
        return courses
                .stream()
                .map(CourseDto::from)
                .collect(Collectors.toList());
    }
}
