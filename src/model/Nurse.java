package model;

public class Nurse extends User{

    private String speciality;

    public Nurse(String name, String email) {
        super(name, email);
    }

    @Override
    public void showData() {
        System.out.println("Hospital: Cruz Roja");
        System.out.println("Departamentos: Pediatria, Oncologia");
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }
}
