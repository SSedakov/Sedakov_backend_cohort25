package de.ait.bootapp.models;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class Event {
    private Long id;
    private String eventName;
    private String title;

}
