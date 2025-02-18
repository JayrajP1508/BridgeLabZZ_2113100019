import java.util.ArrayList;
import java.util.List;

abstract class CourseType {
    private String courseName;
    private String instructor;

    public CourseType(String courseName, String instructor) {
        this.courseName = courseName;
        this.instructor = instructor;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getInstructor() {
        return instructor;
    }

    public abstract String getEvaluationMethod();
}

class ExamCourse extends CourseType {
    public ExamCourse(String courseName, String instructor) {
        super(courseName, instructor);
    }

    @Override
    public String getEvaluationMethod() {
        return "Exam-Based Evaluation";
    }
}

class AssignmentCourse extends CourseType {
    public AssignmentCourse(String courseName, String instructor) {
        super(courseName, instructor);
    }

    @Override
    public String getEvaluationMethod() {
        return "Assignment-Based Evaluation";
    }
}

class ResearchCourse extends CourseType {
    public ResearchCourse(String courseName, String instructor) {
        super(courseName, instructor);
    }

    @Override
    public String getEvaluationMethod() {
        return "Research-Based Evaluation";
    }
}

class Course<T extends CourseType> {
    private List<T> courseList = new ArrayList<>();

    public void addCourse(T course) {
        courseList.add(course);
    }

    public List<T> getAllCourses() {
        return courseList;
    }
}

class UniversityUtility {
    public static void displayCourses(List<? extends CourseType> courses) {
        for (CourseType course : courses) {
            System.out.println(course.getCourseName() + " - " + course.getInstructor() + " (" + course.getEvaluationMethod() + ")");
        }
    }
}

public class UniversityManagement {
    public static void main(String[] args) {
        Course<ExamCourse> examCourses = new Course<>();
        examCourses.addCourse(new ExamCourse("Mathematics", "Dr. Sharma"));
        examCourses.addCourse(new ExamCourse("Physics", "Prof. Rao"));

        Course<AssignmentCourse> assignmentCourses = new Course<>();
        assignmentCourses.addCourse(new AssignmentCourse("Creative Writing", "Ms. Patel"));
        assignmentCourses.addCourse(new AssignmentCourse("Graphic Design", "Mr. Singh"));

        Course<ResearchCourse> researchCourses = new Course<>();
        researchCourses.addCourse(new ResearchCourse("Quantum Computing", "Dr. Bose"));
        researchCourses.addCourse(new ResearchCourse("AI Ethics", "Prof. Nair"));

        System.out.println("University Courses:");
        UniversityUtility.displayCourses(examCourses.getAllCourses());
        UniversityUtility.displayCourses(assignmentCourses.getAllCourses());
        UniversityUtility.displayCourses(researchCourses.getAllCourses());
    }
}
