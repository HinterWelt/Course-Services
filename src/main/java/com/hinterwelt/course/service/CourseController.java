package com.hinterwelt.course.service;

import com.hinterwelt.course.entity.Course;
import com.hinterwelt.course.entity.CreateCourseEntity;
import com.hinterwelt.course.entity.ErrorMessage;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author bilbo
 */
@RestController
@Configuration
@EnableAutoConfiguration
@EnableDiscoveryClient
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;
   /**
     * Returns a list of courses, all courses in the VLE. 
     * @return List\<Course\>
     */
    @RequestMapping(method = RequestMethod.GET)
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    /**
     * Returns a Response entity either with the payload or an 
     * error code and message.
     * @param id
     * @return ResponseEntity<>
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getCourseById(@PathVariable("id") int id) {
        Course course=null;
        try {
            course = courseService.getCourseById(id);
        } catch (Exception e) {
            ErrorMessage msj = new ErrorMessage(HttpStatus.EXPECTATION_FAILED,e.getMessage(),"Empty Set");
            return new ResponseEntity<>(msj,new HttpHeaders(),msj.getStatus());
        }
        return ResponseEntity.ok(course);

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ErrorMessage deleteCourseById(@PathVariable("id") int id) {
        return courseService.removeCourse(id);
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateCourse(@RequestBody Course student) {
        courseService.updateCourse(student);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void insertCourse(@RequestBody CreateCourseEntity course) {
        courseService.insertCourse(course);
    }
}
