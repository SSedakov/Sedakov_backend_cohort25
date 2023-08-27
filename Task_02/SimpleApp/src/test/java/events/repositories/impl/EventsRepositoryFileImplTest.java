package events.repositories.impl;

import events.models.Event;
import org.junit.jupiter.api.*;

import java.io.*;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("EventRepositoryFileImpl is works ...")
@DisplayNameGeneration(value = DisplayNameGenerator.ReplaceUnderscores.class)
class EventsRepositoryFileImplTest {
    
    private static final String TEMP_USERS_FILE_NAME = "events_test.txt";

    private EventsRepositoryFileImpl eventsRepositoryFile;
    private final LocalDate START = LocalDate.of(1998,03,8);
    private final LocalDate FINISH = LocalDate.of(1998,03,9);


    @BeforeEach
    public void setUp() throws Exception {

        createNewFileForTest(TEMP_USERS_FILE_NAME);

        eventsRepositoryFile = new EventsRepositoryFileImpl(TEMP_USERS_FILE_NAME);
    }


    @AfterEach
    public void tearDown() throws Exception {
        deleteFileAfterTest(TEMP_USERS_FILE_NAME);
    }

    @DisplayName("save():")
    @Nested
    class Save {

        @Test
        public void writes_correct_line_to_file() throws Exception {
            Event event = new Event("birthday",START,FINISH);

            eventsRepositoryFile.save(event);

            String expected = "0#birthday#1998-03-08#1998-03-09";

            BufferedReader reader = new BufferedReader(new FileReader(TEMP_USERS_FILE_NAME));

            String actual = reader.readLine();

            reader.close();

            assertEquals(expected, actual);
        }
    }

    @DisplayName("findAll():")
    @Nested
    class FindAll {

        @Test
        public void returns_correct_list_of_users() throws Exception {

            BufferedWriter writer = new BufferedWriter(new FileWriter(TEMP_USERS_FILE_NAME));


            writer.write("0#birthday#1998-03-08#1998-03-09");
            writer.newLine();
            writer.close();


            List<Event> expected = Arrays.asList(
                    new Event("birthday",START,FINISH)

            );

            List<Event> actual = eventsRepositoryFile.findAll();

            assertEquals(expected, actual);
        }
    }

    private static void createNewFileForTest(String fileName) throws IOException {

        File file = new File(fileName);

        deleteIfExists(file);


        boolean result = file.createNewFile();

        if (!result) {
            throw new IllegalStateException("Problems with file create");
        }
    }

    private static void deleteFileAfterTest(String fileName) {
        File file = new File(fileName);

        deleteIfExists(file);
    }

    private static void deleteIfExists(File file) {

        if (file.exists()) {

            boolean result = file.delete();

            if (!result) {
                throw new IllegalStateException("Problems with file delete");
            }
        }
    }
}