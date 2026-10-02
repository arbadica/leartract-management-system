package entity;

public class Trainer extends Person {
    private String specialization;

    public Trainer(int id, String firstName, String lastName, String email, String specialization) {
        super(id, firstName, lastName, email);
        this.specialization = specialization;
    }

    public String getSpecialization() { return specialization; }

    @Override
    public String getDisplayName() {
        return "[Trainer ID: " + id + "] " + firstName + " " + lastName + " | Field: " + specialization;
    }
}