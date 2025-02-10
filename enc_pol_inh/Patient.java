import java.util.ArrayList;
import java.util.List;

abstract class Patient {
    private String patientId;
    private String name;
    private int age;

    public Patient(String patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
    }

    public String getPatientId() {
        return patientId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getPatientDetails() {
        return "Patient ID: " + patientId + ", Name: " + name + ", Age: " + age;
    }

    public abstract double calculateBill();
}

interface MedicalRecord {
    void addRecord(String record);
    List<String> viewRecords();
}

class InPatient extends Patient implements MedicalRecord {
    private double dailyRate;
    private int daysAdmitted;
    private List<String> medicalRecords;

    public InPatient(String patientId, String name, int age, double dailyRate, int daysAdmitted) {
        super(patientId, name, age);
        this.dailyRate = dailyRate;
        this.daysAdmitted = daysAdmitted;
        this.medicalRecords = new ArrayList<>();
    }

    public double calculateBill() {
        return dailyRate * daysAdmitted;
    }

    public void addRecord(String record) {
        medicalRecords.add(record);
    }

    public List<String> viewRecords() {
        return medicalRecords;
    }
}

class OutPatient extends Patient implements MedicalRecord {
    private double consultationFee;
    private List<String> medicalRecords;

    public OutPatient(String patientId, String name, int age, double consultationFee) {
        super(patientId, name, age);
        this.consultationFee = consultationFee;
        this.medicalRecords = new ArrayList<>();
    }

    public double calculateBill() {
        return consultationFee;
    }

    public void addRecord(String record) {
        medicalRecords.add(record);
    }

    public List<String> viewRecords() {
        return medicalRecords;
    }
}

class HospitalPatientManagement {
    public static void displayPatientBills(List<Patient> patients) {
        for (Patient patient : patients) {
            System.out.println(patient.getPatientDetails());
            System.out.println("Total Bill: " + patient.calculateBill());
            System.out.println();
        }
    }

    public static void main(String[] args) {
        List<Patient> patients = new ArrayList<>();
        InPatient inPatient = new InPatient("IP001", "Alice", 30, 500, 5);
        inPatient.addRecord("Admitted for surgery.");
        patients.add(inPatient);

        OutPatient outPatient = new OutPatient("OP001", "Bob", 25, 200);
        outPatient.addRecord("Consulted for fever.");
        patients.add(outPatient);

        displayPatientBills(patients);
    }
}
