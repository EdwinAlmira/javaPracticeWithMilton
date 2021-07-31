package model;

import javax.lang.model.type.ArrayType;
import java.util.ArrayList;
import java.util.Date;

public class Patient extends User {

    //Atributos
    private String birthday;
    private String blood;
    private double weight;
    private double height;

    private ArrayList<AppointementDoctor> appointementDoctors = new ArrayList<>();
    private ArrayList<AppointementNurse> appointementNurses = new ArrayList<>();

    public Patient(String name, String email){
        super(name, email);
    }

    @Override
    public void showData() {
        System.out.println("Paciente");
        System.out.println("Historial completo desde registro");
    }

    //Sobreescribir metodo padre <Polimorfismo>
    @Override
    public String toString() {
        return super.toString() + "\nAge: " + birthday + "\nWeight: "+ getWeight() + "\nHeihg: " + getHeight() + "\nBlood:"+blood;
    }

    //Getter & Setter
    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getBlood() {
        return blood;
    }

    public void setBlood(String blood) {
        this.blood = blood;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public ArrayList<AppointementDoctor> getAppointementDoctors() {
        return appointementDoctors;
    }

    public void addAppointementDoctors(Doctor doctor, Date date, String time) {
        AppointementDoctor appointmentDoctor = new AppointementDoctor(this, doctor);
        appointmentDoctor.schedule(date,time);
        appointementDoctors.add(appointmentDoctor);
    }

    public ArrayList<AppointementNurse> getAppointementNurses() {
        return appointementNurses;
    }

    public void addAppointementNurses(ArrayList<AppointementNurse> appointementNurses) {
        this.appointementNurses = appointementNurses;
    }
}
