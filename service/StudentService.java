package service;


import entity.Student;
import exception.EntityNotFoundException;
import java.util.ArrayList;

public class StudentService {
    private final ArrayList<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        students.add(student);
    }

    public Student getStudentById(int id) throws EntityNotFoundException {
        for (Student s : students) {
            if (s.getId() == id) {
                return s;
            }
        }
        throw new EntityNotFoundException("Student with ID " + id + " not found.");
    }

    public ArrayList<Student> getAllStudents() {
        return students;
    }

    public boolean deactivateStudent(int id) throws EntityNotFoundException {
        Student student = getStudentById(id);
        student.setActive(false);
        return true;
    }
}