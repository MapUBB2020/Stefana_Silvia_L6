package lab3.view;

public class StudentView {

    public StudentView (){};

    public void printStudentDetails(long studentId, String prenume, String nume, int totalCredits){
        System.out.println("\tStudent: ");
        System.out.println("Student Id: "+studentId);
        System.out.println("First name: "+prenume);
        System.out.println("Last name: "+nume);
        System.out.println("Total credits: "+totalCredits);
        System.out.println("\n");
    }
}
