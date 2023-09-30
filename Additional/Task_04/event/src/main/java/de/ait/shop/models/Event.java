package de.ait.shop.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Event {

    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private String eventName;
    private String eventTitle;
    private String dateOfEvent;
}
