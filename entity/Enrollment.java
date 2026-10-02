package entity;
public class Enrollment {
    private int id;
    private int studentId;
    private int courseId;
    private String enrollmentDate;
    private String status; // "ACTIVE", "COMPLETED", "CANCELLED"

    public Enrollment(int id, int studentId, int courseId, String enrollmentDate) {
        this.id = id;
        this.studentId = studentId;
        this.courseId = courseId;
        this.enrollmentDate = enrollmentDate;
        this.status = "ACTIVE";
    }

    public int getId() { return id; }
    public int getStudentId() { return studentId; }
    public int getCourseId() { return courseId; }
    public String getEnrollmentDate() { return enrollmentDate; }
    public String getStatus() { return status; }

    public void setStatus(String status) { this.status = status; }

    @Override
    public String toString() {
        return "[Enrollment ID: " + id + "] Student ID: " + studentId + " -> Course ID: " + courseId + " | Status: " + status;
    }
}