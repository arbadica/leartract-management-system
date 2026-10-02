package service;

import entity.Course;
import exception.EntityNotFoundException;
import java.util.ArrayList;

public class CourseService {
    private final ArrayList<Course> courses = new ArrayList<>();

    public void addCourse(Course course) {
        courses.add(course);
    }

    public Course getCourseById(int id) throws EntityNotFoundException {
        for (Course c : courses) {
            if (c.getId() == id) {
                return c;
            }
        }
        throw new EntityNotFoundException("Course with ID " + id + " not found.");
    }

    public ArrayList<Course> getAllCourses() {
        return courses;
    }

    public void setCourseStatus(int id, boolean active) throws EntityNotFoundException {
        Course course = getCourseById(id);
        course.setActive(active);
    }
}