package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Doctor extends User {

    //Atributos
    private String speciality;
    //Coleccion
    private ArrayList<AvailableAppointmen> availableAppointmens = new ArrayList<>();

    public Doctor(String name, String email, String speciality){
        super(name, email);
        this.speciality = speciality;
    }

    //Comportamientos
    public void showName(){
        System.out.println(super.getName());
    }


    public void addAvailableAppointment(String date, String time){

        availableAppointmens.add(new AvailableAppointmen(date,time));
    }

    public ArrayList<AvailableAppointmen> getAvailableAppointmen() {
        return availableAppointmens;
    }

    @Override
    public void showData() {
        System.out.println("Hospital: Cruz Roja");
        System.out.println("Departamento: Pediatria");
    }

    //Clase estatica anidada
    public static class AvailableAppointmen{
        public int getId_availableAppointment() {
            return id_availableAppointment;
        }

        public void setId_availableAppointment(int id_availableAppointment) {
            this.id_availableAppointment = id_availableAppointment;
        }

        public Date getDate(String DATE) {
            return date;
        }

        public String getDate()
        {
            return format.format(date);
        }

        public void setDate(Date date) {
            this.date = date;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        private int id_availableAppointment;
        private Date date;
        private String time;
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");

        public AvailableAppointmen(String date, String time){
            try {
                this.date = format.parse(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            this.time = time;
        }

    }

    //Getter & Setter
    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

}
