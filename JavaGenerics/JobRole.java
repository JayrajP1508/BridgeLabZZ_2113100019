import java.util.ArrayList;
import java.util.List;

abstract class JobRole {
    private String roleName;

    public JobRole(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleName() {
        return roleName;
    }

    public abstract void displayRequirements();
}

class SoftwareEngineer extends JobRole {
    public SoftwareEngineer() {
        super("Software Engineer");
    }

    @Override
    public void displayRequirements() {
        System.out.println("Required Skills: Java, Python, C++, Algorithms");
    }
}

class DataScientist extends JobRole {
    public DataScientist() {
        super("Data Scientist");
    }

    @Override
    public void displayRequirements() {
        System.out.println("Required Skills: Python, Machine Learning, Data Analysis, Statistics");
    }
}

class ProductManager extends JobRole {
    public ProductManager() {
        super("Product Manager");
    }

    @Override
    public void displayRequirements() {
        System.out.println("Required Skills: Product Strategy, Market Research, Leadership, Communication");
    }
}

class Resume<T extends JobRole> {
    private String name;
    private T jobRole;

    public Resume(String name, T jobRole) {
        this.name = name;
        this.jobRole = jobRole;
    }

    public String getName() {
        return name;
    }

    public T getJobRole() {
        return jobRole;
    }

    public void displayResume() {
        System.out.println("Candidate: " + name + " - " + jobRole.getRoleName());
        jobRole.displayRequirements();
    }
}

class ResumeScreeningSystem {
    public static void processResumes(List<? extends JobRole> jobRoles) {
        for (JobRole jobRole : jobRoles) {
            jobRole.displayRequirements();
        }
    }
}

public class ResumeScreening {
    public static void main(String[] args) {
        Resume<SoftwareEngineer> resume1 = new Resume<>("Alice", new SoftwareEngineer());
        Resume<DataScientist> resume2 = new Resume<>("Bob", new DataScientist());
        Resume<ProductManager> resume3 = new Resume<>("Charlie", new ProductManager());

        List<Resume<? extends JobRole>> resumes = new ArrayList<>();
        resumes.add(resume1);
        resumes.add(resume2);
        resumes.add(resume3);

        System.out.println("Processing Resumes:");
        for (Resume<? extends JobRole> resume : resumes) {
            resume.displayResume();
        }

        System.out.println("\nJob Role Requirements:");
        ResumeScreeningSystem.processResumes(List.of(new SoftwareEngineer(), new DataScientist(), new ProductManager()));
    }
}
