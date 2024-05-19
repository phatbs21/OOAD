public class Student {
    // UI Class
    public class UI {
        private Controller controller;

        public UI(Controller controller) {
            this.controller = controller;
        }

        public void uploadFile() {
            boolean success = controller.uploadFile();
            if (success) {
                displaySuccessful();
            } else {
                displayErrorCode();
            }
        }

        private void displaySuccessful() {
            System.out.println("Upload Successful!");
        }

        private void displayErrorCode() {
            System.out.println("Error: Upload Failed!");
        }
    }

    // Controller Class
    public class Controller {
        private DatabaseConnection dbConnection;

        public Controller(DatabaseConnection dbConnection) {
            this.dbConnection = dbConnection;
        }

        public boolean uploadFile() {
            // Create StudentDocument object
            StudentDocument document = createStudentDocument();

            // Push object information to database
            boolean success = dbConnection.pushData(document);

            return success;
        }

        private StudentDocument createStudentDocument() {
            // Assuming ID_Stu and ID_Docu are provided here
            int studentId = 123; // Example student ID
            int documentId = 456; // Example document ID

            return new StudentDocument(studentId, documentId);
        }
    }

    // StudentDocument Class
    public class StudentDocument {
        private int studentId;
        private int documentId;

        public StudentDocument(int studentId, int documentId) {
            this.studentId = studentId;
            this.documentId = documentId;
        }

        // Getters and Setters
        public int getStudentId() {
            return studentId;
        }

        public void setStudentId(int studentId) {
            this.studentId = studentId;
        }

        public int getDocumentId() {
            return documentId;
        }

        public void setDocumentId(int documentId) {
            this.documentId = documentId;
        }
    }

    // DatabaseConnection Class
    public class DatabaseConnection {
        public boolean pushData(StudentDocument document) {
            // Simulate database interaction
            // Return true if push is successful, otherwise false

            // Example of a successful database push
            boolean isSuccessful = true;

            // Here would be the code to actually push data to the database
            // For example:
            // String query = "INSERT INTO documents (studentId, documentId) VALUES (?, ?)";
            // Use prepared statements and connection objects to execute the query

            return isSuccessful;
        }
    }

    // Main Class to run the application

}
