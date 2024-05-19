import java.util.ArrayList;
import java.util.List;

public class FinanceDepartment {

    public class UI {
        private Controller controller;

        public UI() {
            controller = new Controller();
        }

        public void removeInvalidStudent() {
            boolean success = controller.removeInvalid();
            if (success) {
                displaySuccessful();
            } else {
                displayError();
            }
        }

        public void makeFileToSend() {
            boolean success = controller.createDataSave();
            if (success) {
                displayFile();
            } else {
                displayError();
            }
        }

        private void displayError() {
            System.out.println("Error: Operation failed.");
        }

        private void displaySuccessful() {
            System.out.println("Success: Operation successful.");
        }

        private void displayFile() {
            System.out.println("File created and saved successfully.");
        }
    }


    public class Controller {
        private DatabaseConnection database;

        public Controller() {
            database = new DatabaseConnection();
        }

        public boolean removeInvalid() {
            StudentDocument studentDocument = new StudentDocument();
            boolean success = database.removeData(studentDocument);
            return success;
        }

        public boolean createDataSave() {
            List<Student> students = database.listAllStudents();
            if (students == null || students.isEmpty()) {
                return false;
            }


            return true;
        }
    }


    public class StudentDocument {

    }


    public class DatabaseConnection {
        public boolean removeData(StudentDocument studentDocument) {


            return true;
        }

        public List<Student> listAllStudents() {


            return new ArrayList<>();
        }
    }


    public class Student {

    }
}
