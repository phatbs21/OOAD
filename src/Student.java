public class Student {

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


    public class Controller {
        private DatabaseConnection dbConnection;

        public Controller(DatabaseConnection dbConnection) {
            this.dbConnection = dbConnection;
        }

        public boolean uploadFile() {

            StudentDocument document = createStudentDocument();


            boolean success = dbConnection.pushData(document);

            return success;
        }

        private StudentDocument createStudentDocument() {

            int studentId = 123;
            int documentId = 456;

            return new StudentDocument(studentId, documentId);
        }
    }


    public class StudentDocument {
        private int studentId;
        private int documentId;

        public StudentDocument(int studentId, int documentId) {
            this.studentId = studentId;
            this.documentId = documentId;
        }


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


    public class DatabaseConnection {
        public boolean pushData(StudentDocument document) {


            boolean isSuccessful = true;


            return isSuccessful;
        }
    }


}
