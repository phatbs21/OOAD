import java.util.ArrayList;
import java.util.List;

public class VNUHCMC {

    class UI {
        Controller controller = new Controller();

        public void saveStudentGraduation() {
            try {
                controller.displayListGraduation();
            } catch (Exception e) {
                displayError();
            }
        }

        public void displayError() {
            System.out.println("An error occurred.");
        }

        public void showFilePDF() {
            System.out.println("Displaying PDF file.");
        }
    }


    class Controller {
        StudentGraduation studentGraduation = new StudentGraduation();
        VNURecord vnuRecord = new VNURecord();

        public void displayListGraduation() {
            try {
                studentGraduation.createObj();
                studentGraduation.queryStudent();
                studentGraduation.returnData();

                vnuRecord.createObj();

                for (Student student : studentGraduation.getStudentList()) {
                    vnuRecord.pushInfoStudentWithSchool(student);
                }

                makeBackupDatabase();
                makeFilePDF();
            } catch (Exception e) {
                throw new RuntimeException("Error in displayListGraduation");
            }
        }

        private void makeBackupDatabase() {
            System.out.println("Making backup of the database.");
        }

        private void makeFilePDF() {
            System.out.println("Making PDF file.");
        }
    }


    class StudentGraduation {
        Data data = new Data();
        List<Student> studentList;

        public void createObj() {

        }

        public void queryStudent() {
            studentList = data.queryData();
        }

        public void returnData() {

        }

        public List<Student> getStudentList() {
            return studentList;
        }
    }


    class VNURecord {
        public void createObj() {

        }

        public void pushInfoStudentWithSchool(Student student) {
            System.out.println("Pushing data for student: " + student.getName());

        }
    }


    class Data {
        public List<Student> queryData() {

            List<Student> students = new ArrayList<>();
            students.add(new Student("John Doe"));
            students.add(new Student("Jane Smith"));
            return students;
        }
    }


    class Student {
        private String name;

        public Student(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

}
