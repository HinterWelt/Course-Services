package com.hinterwelt.course.dao;

import com.hinterwelt.course.entity.Course;
import com.hinterwelt.course.entity.CreateCourseEntity;
import com.hinterwelt.course.entity.ErrorMessage;
import java.util.List;

/**
 * Interface for Course into the VLE of choice. Implementations
 * will take care of specific VLE systems.
 * @author bilbo
 */
public interface CourseDao {
    List<Course> getAllCourses();

    Course getCourseById(int id) throws Exception;

    ErrorMessage removeCourseById(int id);

    void updateCourseById(Course course);

    void createCourse(CreateCourseEntity course);
}
