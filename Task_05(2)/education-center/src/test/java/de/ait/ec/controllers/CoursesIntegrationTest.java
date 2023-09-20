package de.ait.ec.controllers;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@AutoConfigureMockMvc
@DisplayName("Endpoint /courses is works:")
@DisplayNameGeneration(value = DisplayNameGenerator.ReplaceUnderscores.class)
@ActiveProfiles("test")
class CoursesIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Nested
    @DisplayName("GET /courses:")
    public class GetCourses {

        @Test
        @Sql(scripts = {"/sql/data.sql"})
        public void return_empty_list_of_courses()throws Exception{
            mockMvc.perform(get("/api/courses"))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.size()",is(7)))
                    .andExpect(jsonPath("$.[0].id",is(1)))
                    .andExpect(jsonPath("$.[0].title",is("Course1t")))
                    .andExpect(jsonPath("$.[2].id",is(3)))
                    .andExpect(jsonPath("$.[2].price",is(100.0)))
                    .andExpect(jsonPath("$.[1].endDate",is("2023-02-02")));
        }


    }

    @Nested
    @DisplayName("POST /courses:")

    public class PostCourse {

        @Test
        @Sql(scripts = {"/sql/data.sql"})
        public void return_created_course() throws Exception{
            mockMvc.perform(post("/api/courses")
                            .contentType("application/json")
                            .content("{\n" +
                                    "  \"title\": \"Новый курс\",\n" +
                                    "  \"beginDate\": \"2022-02-02\",\n" +
                                    "  \"endDate\": \"2023-02-02\",\n" +
                                    "  \"description\": \"Описание нового курса\",\n" +
                                    "  \"price\": 100.0\n" +
                                    "}"))
                    .andExpect(jsonPath("$.id", is(4)))
                    .andExpect(status().isCreated());
        }
    }
}