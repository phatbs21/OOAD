public class OUAA {

    class UI {
        private Controller controller = new Controller();

        public void removeUnvalidStudent() {
            boolean result = controller.removeUnvalid();
            if (result) {
                displaySuccessful();
            } else {
                displayError();
            }
        }

        public void createDataSave() {
            boolean result = controller.createDataSave();
            if (result) {
                displayFile();
            } else {
                displayError();
            }
        }

        public void checkDocument() {
            String data = controller.checkDocument();
            if (data.equals("valid")) {
                displayDataWithValidID();
            } else {
                displayDataWithInvalidID();
            }
        }

        public void updateValid(String id, String stats) {
            boolean result = controller.updateValid(id, stats);
            if (result) {
                displaySuccessful();
            } else {
                displayErrorCode();
            }
        }

        public void makeHardCopy() {
            boolean result = controller.hardCopy();
            if (result) {
                displayFile();
            } else {
                displayError();
            }
        }

        public void createEvent() {
            boolean result = controller.createEvent();
            if (result) {
                displayEventCreated();
            } else {
                displayError();
            }
        }

        public void requestDiploma(String studentID) {
            boolean result = controller.findDiploma(studentID);
            if (result) {
                displayDiploma();
            } else {
                displayError();
            }
        }

        public void displayError() {
            System.out.println("Error occurred.");
        }

        public void displayErrorCode() {
            System.out.println("Error code occurred.");
        }

        public void displaySuccessful() {
            System.out.println("Operation successful.");
        }

        public void displayFile() {
            System.out.println("Displaying file...");
        }

        public void displayDataWithValidID() {
            System.out.println("Displaying data with valid ID...");
        }

        public void displayDataWithInvalidID() {
            System.out.println("Displaying data with invalid ID...");
        }

        public void displayEventCreated() {
            System.out.println("Event created successfully.");
        }

        public void displayDiploma() {
            System.out.println("Diploma found and confirmed.");
        }
    }


    class Controller {
        private StudentDocument studentDocument = new StudentDocument();
        private Database database = new Database();
        private DatabaseConnection databaseConnection = new DatabaseConnection();
        private StudentGraduation studentGraduation = new StudentGraduation();
        private EventOrganizationService eventService = new EventOrganizationService();
        private OUAAService ouaaService = new OUAAService();

        public boolean removeUnvalid() {
            boolean isRemoved = studentDocument.removeUnvalidStudent();
            return isRemoved;
        }

        public boolean createDataSave() {
            String data = database.listAllInfo();
            if (data == null) {
                return false;
            } else {

                createFile(data);


                createHardCopy(data);

                return true;
            }
        }

        public String checkDocument() {
            String data = studentDocument.listAllDocuments();
            if (data != null && data.contains("valid")) {
                return "valid";
            } else {
                return "invalid";
            }
        }

        public boolean updateValid(String id, String stats) {
            boolean isUpdated = studentDocument.updateStatsValid(id, stats);
            return isUpdated;
        }

        public boolean hardCopy() {
            String studentData = studentGraduation.listAllStudents();
            if (studentData == null) {
                return false;
            } else {

                System.out.println("Making hard copy of student data: " + studentData);


                System.out.println("Sending data to edusoft: " + studentData);
                return true;
            }
        }

        public boolean createEvent() {

            String serviceTypes = eventService.listAllServiceTypes();
            if (serviceTypes == null) {
                return false;
            }


            String chosenService = "Catering";
            boolean paymentSuccessful = eventService.chooseServiceAndMakePayment(chosenService);
            if (!paymentSuccessful) {
                return false;
            }


            String invoice = eventService.returnInvoice();
            if (invoice == null) {
                return false;
            }


            boolean preparationSuccessful = eventService.prepareForEvent();
            return preparationSuccessful;
        }

        public boolean findDiploma(String studentID) {

            boolean diplomaFound = ouaaService.findAndTickOnPaper(studentID);
            return diplomaFound;
        }

        private void createFile(String data) {

            System.out.println("Creating file and saving data...");
        }

        private void createHardCopy(String data) {

            System.out.println("Creating hard copy of data...");
        }
    }


    class StudentDocument {
        public boolean removeUnvalidStudent() {

            System.out.println("Removing unvalid student.");
            return true;
        }

        public String listAllDocuments() {

            System.out.println("Listing all documents.");
            return "all documents data";
        }

        public boolean updateStatsValid(String id, String stats) {

            System.out.println("Updating student ID " + id + " to status: " + stats);
            return true;
        }
    }


    class StudentGraduation {
        private DatabaseConnection databaseConnection = new DatabaseConnection();

        public String listAllStudents() {

            String studentData = databaseConnection.queryAllStudents();
            return studentData;
        }
    }


    class DatabaseConnection {
        public String queryAllStudents() {

            System.out.println("Querying all students from the database.");
            return "All student data";
        }
    }


    class Database {
        public String listAllInfo() {

            System.out.println("Listing all information from the database.");
            return "All information";
        }
    }


    class EventOrganizationService {
        private PaymentService paymentService = new PaymentService();

        public String listAllServiceTypes() {

            System.out.println("Listing all service types.");
            return "Catering, Decoration, Music";
        }

        public boolean chooseServiceAndMakePayment(String service) {

            System.out.println("Choosing service: " + service + " and making payment...");
            boolean paymentSuccessful = paymentService.processPayment(service);
            return paymentSuccessful;
        }

        public String returnInvoice() {

            System.out.println("Returning invoice.");
            return "Invoice data";
        }

        public boolean prepareForEvent() {

            System.out.println("Preparing for event.");
            return true;
        }
    }


    class PaymentService {
        public boolean processPayment(String service) {

            System.out.println("Processing payment for service: " + service);
            return true;
        }
    }


    class OUAAService {
        public boolean findAndTickOnPaper(String studentID) {

            System.out.println("Finding diploma for student ID: " + studentID);
            System.out.println("Ticking diploma on paper...");
            return true;
        }
    }
}
