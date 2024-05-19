import java.util.ArrayList;
import java.util.List;

public class GraduationProcessingCommittee {

    public class UI {
        private Controller controller;

        public UI() {
            controller = new Controller();
        }

        public void makeListGraduation() {
            try {
                controller.makeListGraduation();
                System.out.println("Graduation list created successfully.");
            } catch (Exception e) {
                displayError(e.getMessage());
            }
        }

        public void checkStudyProcess() {
            try {
                controller.listAllStudentInfo();
                System.out.println("Study process checked successfully.");
            } catch (Exception e) {
                displayError(e.getMessage());
            }
        }

        private void displayError(String message) {
            System.err.println("Error: " + message);
        }

        public void displayAllInfo() {

            System.out.println("All student info displayed.");
        }

        public void displaySuccessful() {

            System.out.println("Operation successful.");
        }

        public void showFilePDF() {

            System.out.println("PDF file displayed.");
        }
    }


    public class Controller {
        private Data data;
        private List<StudentDocument> studentDocuments;

        public Controller() {
            data = new Data();
            studentDocuments = new ArrayList<>();
        }

        public void makeListGraduation() throws Exception {
            List<StudentDocument> studentDocs = data.queryStudentWithAllCheck();
            if (studentDocs == null || studentDocs.isEmpty()) {
                throw new Exception("No student data found.");
            }

            for (StudentDocument studentDoc : studentDocs) {
                StudentGraduation studentGraduation = new StudentGraduation();
                boolean success = data.pushInfoStudentWithAllCheck(studentDoc, studentGraduation);
                if (!success) {
                    throw new Exception("Failed to push student info.");
                }
                studentDocuments.add(studentDoc);
            }


            makeBackupDatabase();
            makeFilePDF();
        }

        public void listAllStudentInfo() throws Exception {
            List<StudentDocument> studentDocs = data.queryAllData();
            if (studentDocs == null || studentDocs.isEmpty()) {
                throw new Exception("No student data found.");
            }

            for (StudentDocument studentDoc : studentDocs) {
                String studentID = studentDoc.getStudentID();
                StudentEvaluation studentEvaluation = data.findInfoWithID(studentID);
                if (studentEvaluation == null) {
                    throw new Exception("Failed to find student info for ID: " + studentID);
                }

                displayAllInfo(studentEvaluation);


                boolean success = data.updateGraduationStatus(studentID, studentEvaluation);
                if (!success) {
                    throw new Exception("Failed to update graduation status for ID: " + studentID);
                }
            }

            displaySuccessful();
        }

        private void displayAllInfo(StudentEvaluation studentEvaluation) {

            System.out.println("Displaying info for student: " + studentEvaluation.getStudentID());
        }

        private void displaySuccessful() {

            System.out.println("All students processed successfully.");
        }

        private void makeBackupDatabase() {

            System.out.println("Database backup made.");
        }

        private void makeFilePDF() {

            System.out.println("PDF file created.");
        }
    }


    public class Data {
        public List<StudentDocument> queryStudentWithAllCheck() {

            return new ArrayList<>();
        }

        public boolean pushInfoStudentWithAllCheck(StudentDocument studentDoc, StudentGraduation studentGraduation) {

            return true;
        }

        public List<StudentDocument> queryAllData() {

            return new ArrayList<>();
        }

        public StudentEvaluation findInfoWithID(String studentID) {

            return new StudentEvaluation(studentID);
        }

        public boolean updateGraduationStatus(String studentID, StudentEvaluation studentEvaluation) {

            return true;
        }
    }


    public class StudentDocument {
        private String studentID;

        public StudentDocument() {

        }

        public String getStudentID() {
            return studentID;
        }

        public void setStudentID(String studentID) {
            this.studentID = studentID;
        }
    }


    public class StudentGraduation {
        private String studentID;
        private boolean graduationStatus;

        public StudentGraduation() {

        }

        public String getStudentID() {
            return studentID;
        }

        public void setStudentID(String studentID) {
            this.studentID = studentID;
        }

        public boolean isGraduationStatus() {
            return graduationStatus;
        }

        public void setGraduationStatus(boolean graduationStatus) {
            this.graduationStatus = graduationStatus;
        }
    }


    public class StudentEvaluation {
        private String studentID;
        private boolean creditsComplete;
        private boolean gradesSatisfactory;
        private boolean englishCertification;

        public StudentEvaluation(String studentID) {
            this.studentID = studentID;

            this.creditsComplete = true;
            this.gradesSatisfactory = true;
            this.englishCertification = true;
        }

        public String getStudentID() {
            return studentID;
        }

        public void setStudentID(String studentID) {
            this.studentID = studentID;
        }

        public boolean isCreditsComplete() {
            return creditsComplete;
        }

        public void setCreditsComplete(boolean creditsComplete) {
            this.creditsComplete = creditsComplete;
        }

        public boolean isGradesSatisfactory() {
            return gradesSatisfactory;
        }

        public void setGradesSatisfactory(boolean gradesSatisfactory) {
            this.gradesSatisfactory = gradesSatisfactory;
        }

        public boolean isEnglishCertification() {
            return englishCertification;
        }

        public void setEnglishCertification(boolean englishCertification) {
            this.englishCertification = englishCertification;
        }
    }


}
