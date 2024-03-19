/**
 * The Main class that contains the main method to run the application.
 */
public class Main {
    /**
     * The main method that is the entry point of the application.
     * @param args The command-line arguments.
     */
    public static void main(String[] args) {
        // Create an instance of AppFunctions class
        AppFunctions appFunctions = new AppFunctions();

        // Print the initial data from the database
        System.out.println("Initial data from the database:");
        // Call the method to display all students
        appFunctions.getAllStudents();

        // Print the message about adding a new student
        System.out.println("\nAdding a new student:");
        // Call the method to add a new student
        appFunctions.addStudent("Snoop", "Dawg", "snoopy@kushmail.com", "1805-04-20");
        // Call the method to display all students after adding a new one
        appFunctions.getAllStudents();

        // Print the message about updating a student's email
        System.out.println("\nUpdating email for student_id = 4:");
        // Call the method to update the email of a student
        appFunctions.updateStudentEmail(4, "snoopy@example.com");
        // Call the method to display all students after updating the email
        appFunctions.getAllStudents();

        // Print the message about deleting a student
        System.out.println("\nDeleting student with student_id = 4:");
        // Call the method to delete a student
        appFunctions.deleteStudent(4);
        // Call the method to display all students after deleting one
        appFunctions.getAllStudents();
    }
}