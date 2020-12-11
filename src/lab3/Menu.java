package lab3;

import lab3.controller.StudentFileController;
import lab3.model.Student;
import lab3.model.Course;

import java.util.List;
import java.util.Scanner;

import lab3.repository.CourseFileRepository;
import lab3.repository.StudentFileRepository;
import lab3.repository.TeacherFileRepository;
import lab3.view.StudentView;

public class Menu {

    CourseFileRepository cr;
    StudentFileRepository sr;
    TeacherFileRepository tr;
    private static lab3.RegistrationSystem rs;


    public Menu(CourseFileRepository cr, StudentFileRepository sr, TeacherFileRepository tr) {
        this.cr = cr;
        this.sr = sr;
        this.tr = tr;
        rs=new lab3.RegistrationSystem(cr);
    }

    public void displayMainMenu(){
        System.out.println("University");
        System.out.println("1) Menu Teacher\n2) Menu Student \n0) Exit ");
        System.out.print ( "Selection: " );
    }
    public void displayMenuTeacher(){
        System.out.println("Teacher Menu");
        System.out.println("1) Delete one of your courses\n2) Change credits for one of your courses\n3) Show all students enrolled at one specific course\n4) Filter courses with at least 1 student\n0) Exit");
        System.out.print ( "Selection: " );
    }
    public void displayMenuStudent(){
        System.out.println("Student Menu");
        System.out.println("1) Register for a course\n2) Show courses with free places and how many are left\n3) Show all courses\n4) Sort courses by the highest number of credits\n0) Exit");
        System.out.print ( "Selection: " );
    }

    public void selectMenu(){

        Scanner in = new Scanner ( System.in );

        do {
            displayMainMenu();
            switch (in.nextInt()) {
                case 1 -> {
                    menuTeacher();
                }
                case 2 -> {
                    menuStudent();
                }
                case 0 -> System.exit(0);
            }
        } while (in.nextInt()!=0);
    }

    public void menuTeacher(){

        int choice=1;

        displayMenuTeacher();
        do {
            Scanner in = new Scanner(System.in);
            choice=in.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.println("Please enter your teacher id: ");
                    long teacherId = in.nextLong();

                    checkInput(teacherId);

                    if (tr.findOne(teacherId) == null)
                        System.out.println("Id is not valid!");
                    else {
                        System.out.println("Which course id would you like to delete?");
                        long cursId = in.nextLong();
                        if(rs.deleteCourse(cursId, tr.findOne(teacherId)))
                        {
                            rs.deleteCourse(cursId, tr.findOne(teacherId));
                            cr.delete(cursId);
                            System.out.println("The remain courses are: ");

                            for (Course course : cr.courseList)
                                System.out.println(course.getName());
                            System.out.println("Course deleted successfully!");
                        }
                        else
                            System.out.println("You cannot delete this course!");
                    }

                }
                case 2 -> {
                    System.out.println("Please enter your teacher id: ");
                    long teacherId = in.nextLong();

                    checkInput(teacherId);

                    if (tr.findOne(teacherId) == null)
                        System.out.println("Id is not valid!");
                    else {
                        System.out.println("Which course id would you like to change credits?");
                        long cursId2 = in.nextLong();
                        System.out.println("Please enter the new number of credits!");
                        int newCredit = in.nextInt();
                        if (rs.changeCredits(cursId2, tr.findOne(teacherId), newCredit) == null)
                            System.out.println("You cannot change credits for this course!");
                        else {
                            rs.changeCredits(cursId2, tr.findOne(teacherId), newCredit);
                            System.out.println("Number of credits changed successfully!");
                        }
                    }
                }
                case 3 -> {
                    System.out.println("Please select the id of which course you would like to see participants of ");
                    long cursId3 = in.nextLong();

                    checkInput(cursId3);

                    Course course = cr.findOne(cursId3);
                    showStudents(rs.retrieveStudentsEnrolledForACourse(course));
                }
                case 4 -> {
                    for(int i=0; i<rs.filterCourseByEnrolledStudents().size();i++){
                        System.out.println(rs.filterCourseByEnrolledStudents().get(i).getName()+" has "+rs.filterCourseByEnrolledStudents().get(i).getStudentsEnrolled().size()+" students enrolled ");
                    }
                }
                case 0 ->{
                    selectMenu();
                    return;
                }
            }
            displayMenuTeacher();
        } while(choice!=0);
    }


    public void menuStudent(){

        int choice=1;
        displayMenuStudent();

        do {
            Scanner in = new Scanner(System.in);
            choice=in.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.println("Please enter your student id: ");
                    long studentId = in.nextLong();

                    checkInput(studentId);


                    if (sr.findOne(studentId) == null)
                    {
                        System.out.println("Id is not valid. Please sign up!");
                        break;
                    }
                    System.out.println("Please enter the course id you'd like to register: ");
                    long courseId = in.nextLong();
                    if(rs.register(courseId,sr.findOne(studentId)))
                        System.out.println("You registered successfully! ");
                }
                case 2 -> {
                    System.out.println("These are the courses with free places");
                    rs.retrieveCoursesWithFreePlaces();
                }
                case 3 -> {
                    System.out.println("All available courses: ");
                    for(int i=0; i<cr.getCourseList().size();i++)
                        System.out.println(rs.getAllCourses().get(i).getName());
                }
                case 4 -> {
                    for(int i=0; i<cr.getCourseList().size();i++){
                        System.out.println(rs.sortCoursesByCredits().get(i).getName()+" has "+rs.sortCoursesByCredits().get(i).getCredits()+" credits ");
                    }
                }
                case 0 ->   {
                    selectMenu();
                    return;
                }
            }
            displayMenuStudent();
        }while(choice!=0);
    }

    public void showStudents(List<Student> students) {
        for (Student studC: students) {
            StudentView studentView = new StudentView();
            StudentFileController studentController = new StudentFileController(studC, studentView);
            studentController.updateView();
        }
    }

    /**
     * @param id input
     * condition for ArithmeticException
     */
    static void checkInput(long id) {
        if (id <= 0)
            throw new ArithmeticException("Access denied - You cannot enter a negative id.");
    }

}
