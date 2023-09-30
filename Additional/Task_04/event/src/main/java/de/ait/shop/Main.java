package de.ait.shop;


import de.ait.shop.config.ApplicationConfig;
import de.ait.shop.models.Event;
import de.ait.shop.repositories.CrudRepository;
import de.ait.shop.repositories.impl.EventRepositoryJdbcTemplate;
import de.ait.shop.services.EventService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);

        EventService eventService = context.getBean(EventService.class);


        Event event= Event.builder().eventName("HappyBirthday").eventTitle("Comming Soon").dateOfEvent("2024-03-08").build();



        eventService.save(event);



    }
}
