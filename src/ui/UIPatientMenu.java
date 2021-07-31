package ui;

import model.Doctor;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class UIPatientMenu {
    public static void showPatientMenu(){
        int response = 0;
        do {
            System.out.println("\n\n");
            System.out.println("Patient");
            System.out.println("Welcome: "+ UIMenu.patientLogged);
            System.out.println("1. Book an appointment");
            System.out.println("2. My Appointments");
            System.out.println("0. Logout");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            switch (response){
                case 1:
                    showBookAppointment();
                    break;
                case 2:
                    showPatientMyAppointments();
                    break;
                case 0:
                    UIMenu.showMenu();
                    break;
            }

        }while (response != 0);
    }

    private  static void showBookAppointment()
    {
        int response = 0;
        do {
            System.out.println("::Book an Appointment");
            System.out.println(":: Select date: ");
            //Mostrar fechas de doctores - Numeracion de la lista de fechas
            Map<Integer, Map<Integer, Doctor>> doctors = new TreeMap<>();
            int k =0;
            for (int i = 0; i < UIDoctorMenu.doctorsAvailableAppointments.size(); i++) {
                ArrayList<Doctor.AvailableAppointmen> availableAppointmens1
                        = UIDoctorMenu.doctorsAvailableAppointments.get(i).getAvailableAppointmen();
                Map<Integer, Doctor> doctorAppointments = new TreeMap<>();
                for (int j = 0; j < availableAppointmens1.size(); j++) {
                    k++;
                    System.out.println(k+ ". "+ availableAppointmens1.get(j).getDate());
                    doctorAppointments.put(Integer.valueOf(j), UIDoctorMenu.doctorsAvailableAppointments.get(i));

                    doctors.put(Integer.valueOf(k), doctorAppointments);
                }
            }
            Scanner sc = new Scanner(System.in);
            int responseDateSelected = Integer.valueOf(sc.nextLine());

            Map<Integer, Doctor> doctorAvailableSelected = doctors.get(responseDateSelected);
            int indexDate = 0;
            Doctor doctorSelected = new Doctor("","", "");

            for (Map.Entry<Integer, Doctor> doc:doctorAvailableSelected.entrySet()) {
                indexDate = doc.getKey();
                doctorSelected = doc.getValue();
            }

            System.out.println("You selected Dr." + doctorSelected.getName() +
                    ". Date: " + doctorSelected.getAvailableAppointmen().get(indexDate).getDate() +
                    ". Time: "+ doctorSelected.getAvailableAppointmen().get(indexDate).getTime());

            System.out.println("Confirm your appointment: \n1. Correct\n2. Change data" );
            response = Integer.valueOf(sc.nextLine());

            if (response == 1)
            {
                UIMenu.patientLogged.addAppointementDoctors(doctorSelected,
                        doctorSelected.getAvailableAppointmen().get(indexDate).getDate(null),
                        doctorSelected.getAvailableAppointmen().get(indexDate).getTime());
                showPatientMenu();
            }

        }while (response != 0);
    }

    private static void showPatientMyAppointments(){
        int response = 0;
        do {
            System.out.println(":: My Appointments");
            if (UIMenu.patientLogged.getAppointementDoctors().size() == 0){
                System.out.println("Dont hace appointments");
                break;
            }

            for (int i = 0; i < UIMenu.patientLogged.getAppointementDoctors().size(); i++) {
                int j = i + 1;
                System.out.println(j+ ". " +
                        "Date: " + UIMenu.patientLogged.getAppointementDoctors().get(i).getDate() +
                        " Time: " + UIMenu.patientLogged.getAppointementDoctors().get(i).getTime() +
                        " Doctor: " + UIMenu.patientLogged.getAppointementDoctors().get(i).getDoctor().getName());
            }
            System.out.println("0. Return");
        }while (response != 0);
    }

}
