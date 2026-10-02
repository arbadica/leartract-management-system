package util;

public class IdGenerator {
    private static int studentIdCounter = 1000;
    private static int courseIdCounter = 5000;
    private static int enrollmentIdCounter = 9000;

    public static synchronized int getNextStudentId() {
        return ++studentIdCounter;
    }

    public static synchronized int getNextCourseId() {
        return ++courseIdCounter;
    }

    public static synchronized int getNextEnrollmentId() {
        return ++enrollmentIdCounter;
    }
}