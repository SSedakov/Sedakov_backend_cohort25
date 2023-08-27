package events;

import events.controllers.EventsControllers;
import events.repositories.EventRepository;
import events.repositories.impl.EventsRepositoryFileImpl;
import events.repositories.impl.EventsRepositoryListImpl;
import events.services.EventService;
import events.services.impl.EventsServiceImpl;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        EventRepository eventRepositoryList = new EventsRepositoryListImpl();
        EventRepository eventRepositoryFile = new EventsRepositoryFileImpl("C:\\Education\\Backend\\Lesson2\\homeWork\\SimpleApp\\src\\main\\java\\events\\events.txt");
        EventService eventService = new EventsServiceImpl(eventRepositoryFile);
        EventsControllers eventsControllers = new EventsControllers(scanner, eventService);

        boolean isRun = true;

        while (isRun) {
            String command = scanner.nextLine();

            switch (command) {
                case "add" -> eventsControllers.addEvent();
                case "events" -> eventsControllers.getAllEvents();
                case "exit" -> isRun = false;
            }
        }
    }
}
