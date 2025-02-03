class Patient {
    private static String hospitalName = "City Hospital";
    private static int totalPatients = 0;
    private final int patientID;
    private String name;
    private int age;
    private String ailment;
    private static int idCounter = 1;

    public Patient(String name, int age, String ailment) {
        this.patientID = idCounter++;
        this.name = name;
        this.age = age;
        this.ailment = ailment;
        totalPatients++;
    }

    public static int getTotalPatients() {
        return totalPatients;
    }

    public void displayPatientDetails() {
        if (this instanceof Patient) {
            System.out.println("Patient ID: " + patientID);
            System.out.println("Name: " + name);
            System.out.println("Age: " + age);
            System.out.println("Ailment: " + ailment);
            System.out.println("Hospital Name: " + hospitalName);
        }
    }

    public static void main(String[] args) {
        Patient p1 = new Patient("Alice", 30, "Flu");
        Patient p2 = new Patient("Bob", 45, "Fracture");

        p1.displayPatientDetails();
        System.out.println();
        p2.displayPatientDetails();
        System.out.println();
        System.out.println("Total Patients Admitted: " + Patient.getTotalPatients());
    }
}
