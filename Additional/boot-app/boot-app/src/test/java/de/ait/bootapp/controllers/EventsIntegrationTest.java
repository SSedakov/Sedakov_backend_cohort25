package de.ait.bootapp.controllers;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;

import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@DisplayName("Endpoint /event is works:")
@DisplayNameGeneration(value = DisplayNameGenerator.ReplaceUnderscores.class)
@ActiveProfiles("test")
class EventsIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Nested
    @DisplayName("GET /events:")
    public class GetCourses {

        @Test
        @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
        public void return_empty_list_of_events_for_empty_database() throws Exception {
            mockMvc.perform(get("/events"))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.size()", is(0)));
        }

        @Test
        @Sql(scripts = "/sql/data.sql")
        @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
        public void return_list_of_events_for_not_empty_database() throws Exception {
            mockMvc.perform(get("/events"))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.size()", is(2)))
                    .andExpect(jsonPath("$.[0].id", is(1)))
                    .andExpect(jsonPath("$.[1].id", is(2)))
                    .andExpect(jsonPath("$.[2].title", is("Описание события 1")));
        }
    }

    @Nested
    @DisplayName("POST /events:")
    public class PostCourse {

        @Test
        @Sql(scripts = "/sql/data.sql")
        @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
        public void return_created_event() throws Exception {
            mockMvc.perform(post("/events")
                    .contentType("application/json")
                    .content("{\n" +
                            "  \"title\": \"coming soon\",\n" +
                            "  \"eventName\": \"др\",\n" +
                            "  \"endDate\": \"2023-02-02\"\n" +
                            "}"))
                    .andExpect(status().isCreated())
                    .andExpect(jsonPath("$.id", is(1)));
        }

        @Test
        public void return_400_for_not_valid_event() throws Exception {
            mockMvc.perform(post("/events")
                            .contentType("application/json")
                            .content("{\n" +
                                    "  \"title\": \"coming soon\",\n" +
                                    "  \"eventName\": \"др\",\n" +
                                    "  \"endDate\": \"2023-02-02\"\n" +
                                    "}"))
                    .andExpect(status().isBadRequest())
                    .andExpect(jsonPath("$.errors.size()", is(2)));
        }
    }

    @Nested
    @DisplayName("GET /event/{course-id}:")
    public class GetCourse {

        @Test
        @Sql(scripts = "/sql/data.sql")
        @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
        public void return_existed_event() throws Exception {
            mockMvc.perform(get("/event/1"))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.id", is(1)))
                    .andExpect(jsonPath("$.title", is("Описание события 1")));
        }

        @Test
        @Sql(scripts = "/sql/data.sql")
        @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
        public void return_404_for_not_existed_event() throws Exception {
            mockMvc.perform(get("/event/5"))
                    .andExpect(status().isNotFound());
        }
    }
}