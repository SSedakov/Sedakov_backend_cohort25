package de.ait.bootapp.dto;

import de.ait.bootapp.models.Event;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Schema(name = "Event",description = "Описание события")
public class EventDto {

    @Schema(description = "Идентификатор пользователя", example = "1")
    private Long id;

    @Schema(description = "Название события",example = "День рождения")
    private String eventName;

    @Schema(description = "Описание события",example = "День рождения у бабушки 30 сентября")
    private String title;


    public static EventDto from(Event event){
        return new EventDto(event.getId(),event.getTitle(), event.getEventName());
    }
    public static List<EventDto> from (List<Event> events){
        return events.stream()
                .map(EventDto::from)
                .collect(Collectors.toList());
    }
}
