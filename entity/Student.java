package entity;

public class Student extends Person {
    private String batch;
    private boolean active;

    // Parameterized constructor with all fields
    public Student(int id, String firstName, String lastName, String email, String batch) {
        super(id, firstName, lastName, email);
        this.batch = batch;
        this.active = true;
    }

    // Constructor overloading example (without email)
    public Student(int id, String firstName, String lastName, String batch) {
        super(id, firstName, lastName, "N/A");
        this.batch = batch;
        this.active = true;
    }

    public String getBatch() { return batch; }
    public boolean isActive() { return active; }

    public void setBatch(String batch) { this.batch = batch; }
    public void setActive(boolean active) { this.active = active; }

    @Override
    public String getDisplayName() {
        return "[Student ID: " + id + "] " + firstName + " " + lastName + " | Batch: " + batch + " | Active: " + active;
    }
}