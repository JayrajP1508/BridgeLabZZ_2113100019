package AssignmentCollectionFramework;

import java.util.PriorityQueue;

class Patient implements Comparable<Patient> {
    String name;
    int severity;

    public Patient(String name, int severity) {
        this.name = name;
        this.severity = severity;
    }

    @Override
    public int compareTo(Patient other) {
        return Integer.compare(other.severity, this.severity);
    }
}

public class HospitalSystem {
    public static void main(String[] args) {
        PriorityQueue<Patient> patientQueue = new PriorityQueue<>();

        patientQueue.offer(new Patient("John", 3));
        patientQueue.offer(new Patient("Alice", 5));
        patientQueue.offer(new Patient("Bob", 2));

        System.out.println("Order of treatment:");
        while (!patientQueue.isEmpty()) {
            Patient nextPatient = patientQueue.poll();
            System.out.println(nextPatient.name + " (Severity: " + nextPatient.severity + ")");
        }
    }
}
