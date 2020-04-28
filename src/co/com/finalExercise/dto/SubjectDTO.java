package co.com.finalExercise.dto;

import java.util.ArrayList;
import java.util.List;

public class SubjectDTO {

    private String name;
    private String classroom;
    private List<StudentDTO> listStudentDTO = new ArrayList<StudentDTO>();
    private TeacherDTO teacherDTO;

    public SubjectDTO() {
    }

    public SubjectDTO(String name, String classroom, List<StudentDTO> listStudentDTO, TeacherDTO teacherDTO) {
        this.name = name;
        this.classroom = classroom;
        this.listStudentDTO = listStudentDTO;
        this.teacherDTO = teacherDTO;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public List<StudentDTO> getListStudentDTO() {
        return listStudentDTO;
    }

    public void setListStudentDTO(List<StudentDTO> listStudentDTO) {
        this.listStudentDTO = listStudentDTO;
    }

    public TeacherDTO getTeacherDTO() {
        return teacherDTO;
    }

    public void setTeacherDTO(TeacherDTO teacherDTO) {
        this.teacherDTO = teacherDTO;
    }

    @Override
    public String toString() {

        String strListStudentDTO ="";

        for (StudentDTO data: listStudentDTO) {
            strListStudentDTO += data.toString() + "\n";
        }

        return  "\nNAME= '" + name + '\'' +
                "\nCLASSROOM= '" + classroom + '\'' +
                "\nSTUDENTS LISTED: \n" + strListStudentDTO +
                "\nTEACHER: " + teacherDTO.toString() ;
    }

}
