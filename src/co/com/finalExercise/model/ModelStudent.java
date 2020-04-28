package co.com.finalExercise.model;

import co.com.finalExercise.dto.StudentDTO;
import co.com.finalExercise.dto.SubjectDTO;
import co.com.finalExercise.util.Settings;

import javax.security.auth.Subject;
import java.util.ArrayList;
import java.util.List;

public class ModelStudent {

    private List<StudentDTO> listStudent;
    private int id = 0;

    public ModelStudent() {

        listStudent = new ArrayList<StudentDTO>();

        StudentDTO studentDTO1 = new StudentDTO(id++, "Juanita", 20);
        StudentDTO studentDTO2 = new StudentDTO(id++, "Gabriela", 19);
        StudentDTO studentDTO3 = new StudentDTO(id++, "Marcel", 25);
        StudentDTO studentDTO4 = new StudentDTO(id++, "Jaime", 18);
        StudentDTO studentDTO5 = new StudentDTO(id++, "Mateo", 22);
        StudentDTO studentDTO6 = new StudentDTO(id++, "Mariane", 24);

        listStudent.add(studentDTO1);
        listStudent.add(studentDTO2);
        listStudent.add(studentDTO3);
        listStudent.add(studentDTO4);
        listStudent.add(studentDTO5);
        listStudent.add(studentDTO6);

    }

    public List<StudentDTO> getListStudent() {
        return listStudent;
    }

    public void printListStudent() {
        for (StudentDTO data : this.listStudent) {
            System.out.println(data.toString());
        }
    }

    public StudentDTO addStudent() {

        String nameStudent = (String) Settings.getData("Please, insert the name for the new student ", "STRING");
        int ageStudent = (int) Settings.getData("Please, insert the age of the new student ", "INT");

        StudentDTO studentDTO = new StudentDTO(id++, nameStudent, ageStudent);

        listStudent.add(studentDTO);
        return studentDTO;
    }

    public List<StudentDTO> getStudentList() {
        List<StudentDTO> studentList = new ArrayList<StudentDTO>();
        StudentDTO studentToList;
        int next = 1;

        do {
            studentToList = this.getStudentById();
            studentList.add(studentToList);

            next = (int) Settings.getData("Please, digit 1 if do you want to add another existent student to the subject or another number if not", "INT");

        } while (next == 1);

        return studentList;

    }

    public StudentDTO getStudentById(){
        StudentDTO studentDTO = new StudentDTO();
        boolean flag = true;

        System.out.println("LIST OF STUDENTS");
        this.printListStudent();

        int idStudent = (int) Settings.getData("Please, insert the ID of the student.", "INT");


        for (StudentDTO data: listStudent) {
            if(data.getId() == idStudent){
                studentDTO = data;
                flag = false;
            }
        }

        if(flag){
            System.out.println("Student does not exist, please insert a valid ID");
            this.getStudentById();
        }

        return studentDTO;
    }


    public void getListSubjects(List<SubjectDTO> listSubject) {
        StudentDTO studentDTO = new StudentDTO();
        String subjectList = "";

        studentDTO = this.getStudentById();

        for (SubjectDTO data: listSubject) {
            if(data.getListStudentDTO().contains(studentDTO)){
               subjectList += "\n" + data.getName();
            }
        }
        System.out.println("The student with ID "+ studentDTO.getId() + " is on these subjects: " + subjectList );
    }
}
