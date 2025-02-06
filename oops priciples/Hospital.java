package Assignment11;

import java.util.ArrayList;

public class Hospital {

    private String hospitalName;
    private ArrayList<Doctor> doctors;
    private ArrayList<Patient> patients;

    public Hospital(String hospitalName) {
        this.hospitalName = hospitalName;
        this.doctors = new ArrayList<>();
        this.patients = new ArrayList<>();
    }

    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    public String getHospitalName() {
        return hospitalName;
    }
}

class Doctor {
    private String docName;
    private ArrayList<Patient> patients;

    public Doctor(String docName) {
        this.docName = docName;
        this.patients = new ArrayList<>();
    }

    public void addPatient(Patient patient) {
        if (!patients.contains(patient)) {
            patients.add(patient);
            patient.addDoctor(this);
        }
    }

    public void consult(Patient patient) {
        if (patients.contains(patient)) {
            System.out.println("Dr. " + docName + " is consulting " + patient.getPatientName());
        } else {
            System.out.println(patient.getPatientName() + " is not a registered patient of Dr. " + docName);
        }
    }

    public String getDocName() {
        return docName;
    }

    @Override
    public String toString() {
        return "Dr. " + docName;
    }
}

class Patient {
    private String patientName;
    private ArrayList<Doctor> doctors;

    public Patient(String patientName) {
        this.patientName = patientName;
        this.doctors = new ArrayList<>();
    }

    public void addDoctor(Doctor doctor) {
        if (!doctors.contains(doctor)) {
            doctors.add(doctor);
            doctor.addPatient(this);
        }
    }

    public String getPatientName() {
        return patientName;
    }

    @Override
    public String toString() {
        return "Patient: " + patientName;
    }
}

class Main4 {
    public static void main(String[] args) {
        Hospital hospital = new Hospital("City Hospital");

        Doctor doctor1 = new Doctor("Smith");
        Doctor doctor2 = new Doctor("Jones");

        Patient patient1 = new Patient("John Doe");
        Patient patient2 = new Patient("Jane Doe");

        hospital.addDoctor(doctor1);
        hospital.addDoctor(doctor2);
        hospital.addPatient(patient1);
        hospital.addPatient(patient2);

        doctor1.addPatient(patient1);
        doctor2.addPatient(patient1);
        doctor1.addPatient(patient2);

        doctor1.consult(patient1);
        doctor2.consult(patient1);
        doctor2.consult(patient2);
    }
}



