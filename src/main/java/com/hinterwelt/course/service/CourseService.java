package com.hinterwelt.course.service;

import com.hinterwelt.course.dao.CourseDao;
import com.hinterwelt.course.entity.Course;
import com.hinterwelt.course.entity.CreateCourseEntity;
import com.hinterwelt.course.entity.ErrorMessage;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 *
 * @author bilbo
 */
@Service
public class CourseService {

    @Qualifier("moodle")

    @Autowired
    private CourseDao courseDao;

    /**
     * Any course business logic would go here.
     *
     * @return
     */
    public List<Course> getAllCourses() {
        return this.courseDao.getAllCourses();
    }

    /**
     * Any business logic for the list of enrolled students and their courses
     * would go here.
     *
     * @param id
     * @return
     * @throws java.lang.Exception
     */
    public Course getCourseById(int id) throws Exception {
        Course course;
        course = this.courseDao.getCourseById(id);
        return course;
    }

    /**
     *
     * @param id
     * @return
     */
    public ErrorMessage removeCourse(int id) {
        return this.courseDao.removeCourseById(id);

    }

    /**
     *
     * @param course
     */
    public void updateCourse(Course course) {
        this.courseDao.updateCourseById(course);
    }

    /**
     *
     * @param course
     */
    public void insertCourse(CreateCourseEntity course) {
        this.courseDao.createCourse(course);
    }
}
