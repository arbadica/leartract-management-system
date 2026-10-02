package service;

import entity.Enrollment;
import exception.EntityNotFoundException;
import util.IdGenerator;
import java.util.ArrayList;

public class EnrollmentService {
    private final ArrayList<Enrollment> enrollments = new ArrayList<>();

    public Enrollment enrollStudent(int studentId, int courseId, String date) {
        int id = IdGenerator.getNextEnrollmentId();
        Enrollment enrollment = new Enrollment(id, studentId, courseId, date);
        enrollments.add(enrollment);
        return enrollment;
    }

    public ArrayList<Enrollment> getEnrollmentsByStudentId(int studentId) {
        ArrayList<Enrollment> result = new ArrayList<>();
        for (Enrollment e : enrollments) {
            if (e.getStudentId() == studentId) {
                result.add(e);
            }
        }
        return result;
    }

    public void updateStatus(int enrollmentId, String status) throws EntityNotFoundException {
        for (Enrollment e : enrollments) {
            if (e.getId() == enrollmentId) {
                e.setStatus(status);
                return;
            }
        }
        throw new EntityNotFoundException("Enrollment with ID " + enrollmentId + " not found.");
    }
}