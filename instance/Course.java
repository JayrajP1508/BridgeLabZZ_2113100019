package Assignment9.Level1;

import javax.swing.plaf.IconUIResource;

public class Course {

    String courseName;
    float duration;
    float fee;
    static String instituteName;

    Course(String courseName,float duration,float fee){
        this.courseName=courseName;
        this.duration=duration;
        this.fee=fee;
    }

    void displayCourseDetails(){
        System.out.println("Course Name: "+ courseName);
        System.out.println("Duration :"+ duration);
        System.out.println("Fee: "+ fee);
        System.out.println("Intitute Name: "+instituteName);
    }
    static void updateInstituteName(String instituteName){
        Course.instituteName=instituteName;
    }

    public static void main(String[] args) {
        Course c1 = new Course("Java Programming", 3.5f, 5000.0f);
        Course c2 = new Course("Web Development", 4.0f, 7000.0f);
        Course c3 = new Course("Data Science", 6.0f, 15000.0f);
        Course c4 = new Course("Cyber Security", 5.0f, 12000.0f);
        Course c5 = new Course("Machine Learning", 6.5f, 18000.0f);
        Course.instituteName="GLA";

        c1.displayCourseDetails();
        c2.displayCourseDetails();

        updateInstituteName("Physics Wallah");
        c3.displayCourseDetails();
    }
}
