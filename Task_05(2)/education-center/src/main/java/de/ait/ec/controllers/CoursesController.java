package de.ait.ec.controllers;

import de.ait.ec.dto.CourseDto;
import de.ait.ec.dto.NewCourseDto;
import de.ait.ec.services.CoursesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/courses")
public class CoursesController {

    private final CoursesService coursesService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CourseDto addCourse(@RequestBody NewCourseDto newCourse) {
        return coursesService.addCourse(newCourse);
    }

    @GetMapping
    public List<CourseDto> getCourses(){
        return coursesService.getCourses();
    }
}
