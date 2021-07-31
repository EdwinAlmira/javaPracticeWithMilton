package ui;

import model.Doctor;
import model.Patient;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.Scanner;

public class UIMenu {

    public static final String[] MONTHS = {"January", "Febrary", "March", "April", "May",
                                    "June", "July","August","September","October","November","December"};
    public  static Doctor doctorLogged;
    public static Patient patientLogged;
    public static void showMenu(){
        System.out.println("Welcome to My Appointments");
        System.out.println("Selecciona la opción deseada");

        int response = 0;
        do {
            System.out.println("1. Doctor");
            System.out.println("2. Patient");
            System.out.println("0. Salir");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            switch (response){
                case 1:

                    response = 0;
                    authUser(1);
                    break;
                case 2:
                    System.out.println("Doctor");
                    response = 0;
                    authUser(2);
                    break;
                case 0:
                    System.out.println("Thank you for you visit");
                    response = 0;//lam
                    break;
                default:
                    System.out.println("Please select a correct answer");
            }
        }while (response != 0);
    }

    private static void authUser(int userType){

        ArrayList<Doctor> doctors = new ArrayList<>();
        doctors.add(new Doctor("Ale", "c@gmail.cpm","Pediatria"));
        doctors.add(new Doctor("Rodir", "a@gmail.cpm","Oncoloia"));
        doctors.add(new Doctor("Gerardo", "b@gmail.cpm","Geriatria"));

        ArrayList<Patient> patients = new ArrayList<>();
        patients.add(new Patient("Mike", "1@gmail.cpm"));
        patients.add(new Patient("Jack", "2@gmail.cpm"));
        patients.add(new Patient("Drew", "3@gmail.cpm"));

        boolean emailCorrect = false;
        do {
            System.out.println("Insert your gmail");
            Scanner sc = new Scanner(System.in);
            String email = sc.nextLine();
            if (userType == 1)
            {
                for (Doctor d: doctors){
                    if (d.getEmail().equals(email));
                    emailCorrect = true;
                    doctorLogged = d;
                    UIDoctorMenu.showDoctorMenu();
                }
            }
            if (userType == 2)
            {
                for (Patient p: patients){
                    if (p.getEmail().equals(email));
                    emailCorrect = true;
                    patientLogged = p;
                    UIPatientMenu.showPatientMenu();
                }
            }
            else{
                System.out.println("Error");
            }
        }while (!emailCorrect);

    }

}
