import de.ait.events.controllers.EventsControllers;
import de.ait.events.repositories.EventRepository;
import de.ait.events.repositories.impl.EventsRepositoryFileImpl;
import de.ait.events.repositories.impl.EventsRepositoryListImpl;
import de.ait.events.services.EventService;
import de.ait.events.services.impl.EventsServiceImpl;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        EventRepository eventRepositoryList = new EventsRepositoryListImpl();
        EventRepository eventRepositoryFile = new EventsRepositoryFileImpl("events.txt");
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
