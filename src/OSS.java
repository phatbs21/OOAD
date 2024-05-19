public class OSS {
    // UI Class
    public class UI {
        private Controller controller;

        public UI() {
            this.controller = new Controller();
        }

        public void requestCheckPoliticalStudies() {
            boolean success = controller.checkPolitical();
            if (success) {
                displaySuccessUI();
            } else {
                displayError();
            }
        }

        public void displayError() {
            System.out.println("Error occurred while checking political studies.");
        }

        public void displaySuccessUI() {
            System.out.println("Political studies checked successfully.");
        }
    }

    // Controller Class
    public class Controller {
        private StudentDocumentary studentDocumentary;

        public boolean checkPolitical() {
            studentDocumentary = new StudentDocumentary();
            boolean success = studentDocumentary.queryAllData();
            if (success) {
                listAllValid();
                listAllInvalid();
                return true;
            } else {
                return false;
            }
        }

        public void listAllValid() {
            System.out.println("Listing all valid entries...");
        }

        public void listAllInvalid() {
            System.out.println("Listing all invalid entries...");
        }
    }

    // StudentDocumentary Class
    public class StudentDocumentary {
        private DatabaseConnection database;

        public StudentDocumentary() {
            this.database = new DatabaseConnection();
        }

        public boolean queryAllData() {
            boolean success = database.queryJoinTables();
            return success;
        }
    }

    // DatabaseConnection Class
    public class DatabaseConnection {

        public boolean queryJoinTables() {
            // Simulate joining tables and returning data
            System.out.println("Querying and joining tables...");
            boolean success = linkID();
            if (success) {
                return true;
            } else {
                return false;
            }
        }

        public boolean linkID() {
            // Simulate linking ID
            System.out.println("Linking ID and returning joined table...");
            return true; // Assume success for this example
        }

        public void updateCheckPoliticalStudiesStatus() {
            System.out.println("Updating check political studies status...");
        }
    }
    
}
