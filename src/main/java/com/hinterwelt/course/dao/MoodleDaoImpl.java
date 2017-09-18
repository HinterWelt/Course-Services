package com.hinterwelt.course.dao;

import com.hinterwelt.course.entity.ErrorMessage;
import com.hinterwelt.course.entity.Course;
import com.hinterwelt.course.entity.CreateCourseEntity;
import java.util.List;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

/**
 * This is the Moodle implementation of the Course DAO. This allows for the connection
 * to Moodle. 
 * @author bilbo
 */
@Repository("moodle")
@ConfigurationProperties
@PropertySource("classpath:secure.properties")
public class MoodleDaoImpl extends Exception implements CourseDao{

    private final String restMoodleURI = "http://moodle.hinterwelt.org/webservice/rest/server.php?wstoken=";
    private String vletoken;
    private final String requestFormat = "&moodlewsrestformat=json";

    /**
     * Returns all courses in the Moodle instance.
     * @return
     */
    @Override
    public List<Course> getAllCourses() {
        String moodleFunction = "&wsfunction=core_course_get_courses";
        String reqURL = restMoodleURI + vletoken + moodleFunction + requestFormat;
        RestTemplate restTemplate = new RestTemplate();

        System.out.println("Before call");

        ResponseEntity<List<Course>> courseResponse
                = restTemplate.exchange(reqURL,
                        HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<List<Course>>() {
                });

        List<Course> courses = courseResponse.getBody();
        return courses;

    }

    /**
     * Returns all the courses that the user (id) is enrolled in. If the student is
     * not enrolled in anything, it throws a custom exception.
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public Course getCourseById(int id) throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        String moodleFunction = "&wsfunction=core_enrol_get_users_courses&userid=" + id;
        String reqURL = restMoodleURI + vletoken + moodleFunction + requestFormat;

        ResponseEntity<List<Course>> courseResponse
                = restTemplate.exchange(reqURL,
                        HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<List<Course>>() {
                });

        List<Course> courses = courseResponse.getBody();

        if (courses.size() > 0) {
            return courses.get(0);
        } else {
            throw new Exception("No courses for student ID = "+id);
        }
    }

    @Override
    public ErrorMessage removeCourseById(int id) {
        String moodleFunction = "&wsfunction=core_course_delete_courses&field=id&values[0]=" + id;
        String reqURL = restMoodleURI + vletoken + moodleFunction + requestFormat;
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(reqURL);

        ResponseEntity<ErrorMessage> deleteResponse
                = restTemplate.exchange(reqURL,
                        HttpMethod.GET, null, new ParameterizedTypeReference<ErrorMessage>() {
                });
        ErrorMessage eResponse = deleteResponse.getBody();
        return eResponse;

    }

    @Override
    public void updateCourseById(Course course) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void createCourse(CreateCourseEntity course) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
