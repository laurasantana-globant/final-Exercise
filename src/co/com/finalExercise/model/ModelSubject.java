package co.com.finalExercise.model;

import co.com.finalExercise.dto.StudentDTO;
import co.com.finalExercise.dto.SubjectDTO;
import co.com.finalExercise.dto.TeacherDTO;
import co.com.finalExercise.util.Settings;

import java.util.ArrayList;
import java.util.List;

public class ModelSubject {

    private List<SubjectDTO> listSubject;

    public ModelSubject(List<TeacherDTO> listTeacher, List<StudentDTO> listStudent) {

        listSubject = new ArrayList<SubjectDTO>();

        List<StudentDTO> listStudentSubjectDTO1 = new ArrayList<StudentDTO>(){
            {
                add(listStudent.get(0));
                add(listStudent.get(1));
            }
        };

        SubjectDTO subjectDTO1 = new SubjectDTO("MATH", "203", listStudentSubjectDTO1, listTeacher.get(0));

        List<StudentDTO> listStudentSubjectDTO2 = new ArrayList<StudentDTO>(){
            {
                add(listStudent.get(2));
                add(listStudent.get(3));
            }
        };

        SubjectDTO subjectDTO2 = new SubjectDTO("BIOLOGY", "201", listStudentSubjectDTO2, listTeacher.get(1));

        List<StudentDTO> listStudentSubjectDTO3 = new ArrayList<StudentDTO>(){
            {
                add(listStudent.get(4));
                add(listStudent.get(5));
            }
        };

        SubjectDTO subjectDTO3 = new SubjectDTO("SCIENCE", "204", listStudentSubjectDTO3, listTeacher.get(2));

        List<StudentDTO> listStudentSubjectDTO4 = new ArrayList<StudentDTO>(){
            {
                add(listStudent.get(0));
                add(listStudent.get(5));
            }
        };

        SubjectDTO subjectDTO4 = new SubjectDTO("PHYSIC", "202", listStudentSubjectDTO4, listTeacher.get(3));


        listSubject.add(subjectDTO1);
        listSubject.add(subjectDTO2);
        listSubject.add(subjectDTO3);
        listSubject.add(subjectDTO4);
    }

    public List<SubjectDTO> getListSubject() {
        return listSubject;
    }

    public void printListSubject() {
        for (SubjectDTO data : this.listSubject) {
            System.out.println(data.getName());
        }
    }

    public void printSubjectDetails(String subjectName) throws Exception {
        boolean flag  = true;
        for (SubjectDTO data : this.listSubject) {
            if (subjectName.equals(data.getName())){
                flag = false;
                System.out.println(data.toString());
                break;
            }
        }
        if(flag){
            throw new Exception("The inserted name is not in the subject list");
        }
    }

    public void assignStudentToSubject(StudentDTO studentDTO) throws Exception {
        System.out.println("LIST OF SUBJECTS");
        this.printListSubject();
        String subjectName = (String) Settings.getData("Digit the subject name you want to inscribe the student", "STRING");
        boolean flag  = true;

        for (SubjectDTO data : this.listSubject) {
            if (subjectName.equals(data.getName())){
                flag = false;
                data.getListStudentDTO().add(studentDTO);
                System.out.println("The student "+ studentDTO.getName() + " was added successfully to the subject " + subjectName);
                break;
            }
        }
        if(flag){
            System.out.println("The inserted name is not in the subject list");
            this.assignStudentToSubject(studentDTO);
        }
    }

    public SubjectDTO addSubject() throws Exception {
        SubjectDTO subjectDTO = new SubjectDTO();
        List<StudentDTO> listStudentSubjectDTO = new ArrayList<StudentDTO>();
        TeacherDTO teacherDTO = new TeacherDTO();

        String subjectName = (String) Settings.getData("Please, insert the name for the new subject ", "STRING");

        for (SubjectDTO data: listSubject) {
            if(data.getName().equals(subjectName)){
                throw new Exception("The subject already exists");
            }
        }

        String classroomSubject = (String) Settings.getData("Please, insert the classroom for the subject ", "STRING");
        subjectDTO = new SubjectDTO(subjectName, classroomSubject, listStudentSubjectDTO, teacherDTO);
        listSubject.add(subjectDTO);
        return subjectDTO;
    }
}
