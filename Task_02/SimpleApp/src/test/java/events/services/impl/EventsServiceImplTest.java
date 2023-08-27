package events.services.impl;

import events.models.Event;
import events.repositories.EventRepository;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@DisplayName("UsersServiceImpl is works ...")
@DisplayNameGeneration(value = DisplayNameGenerator.ReplaceUnderscores.class)
class EventsServiceImplTest {

    private static final String EXIST_EVENT_TITLE = "birtday";
    private static final String NOT_EXIST_EVENT_TITLE = "christmas";
    private final LocalDate START = LocalDate.of(1998,03,8);
    private final LocalDate FINISH = LocalDate.of(1998,03,9);
    private final Event EXIST_EVENT = new Event(EXIST_EVENT_TITLE,START,FINISH);


    private EventsServiceImpl eventsService;

    private EventRepository eventRepository;



    @BeforeEach
    public void setUp() {

        eventRepository = Mockito.mock(EventRepository.class);

        when(eventRepository.findByTitle(EXIST_EVENT_TITLE)).thenReturn(EXIST_EVENT );

        when(eventRepository.findByTitle(NOT_EXIST_EVENT_TITLE)).thenReturn(null);
        this.eventsService = new EventsServiceImpl(eventRepository);
    }

    @Nested
    @DisplayName(("addUser():"))
    class AddUser {
        @Test
        public void on_incorrect_title_throws_exception() {

            assertThrows(IllegalArgumentException.class, () -> eventsService.addEvent(null,START,FINISH));
        }

        @Test
        public void on_incorrect_localDate_throws_exception() {

            assertThrows(IllegalArgumentException.class, () -> eventsService.addEvent(EXIST_EVENT_TITLE,FINISH,START));
        }

        @Test
        public void on_existed_event_throws_exception() {
            assertThrows(IllegalArgumentException.class, () -> eventsService.addEvent("", START,FINISH));
        }

        @Test
        public void returns_created_event() {
            Event actual = eventsService.addEvent(EXIST_EVENT_TITLE, START,FINISH);


            verify(eventRepository).save(actual);

            assertNotNull(actual);
        }
    }

}