package co.com.finalExercise.model;

import co.com.finalExercise.dto.StudentDTO;
import co.com.finalExercise.dto.TeacherDTO;
import co.com.finalExercise.dto.TeacherFullTimeDTO;
import co.com.finalExercise.dto.TeacherPartTimeDTO;
import co.com.finalExercise.util.Settings;

import java.util.ArrayList;
import java.util.List;

public class ModelTeacher {

    private List<TeacherDTO> listTeacher;
    private int id = 0;

    public ModelTeacher() {

        listTeacher = new ArrayList<TeacherDTO>();


        TeacherDTO teacherFullTimeDTO1 = new TeacherFullTimeDTO(id++, "Manuel", 0, 1);
        TeacherDTO teacherFullTimeDTO2 = new TeacherFullTimeDTO(id++, "Alejandro", 0,(float) 1.5);

        TeacherDTO teacherPartTimeDTO1 = new TeacherPartTimeDTO(id++, "Maria", 0, 9L);
        TeacherDTO teacherPartTimeDTO2 = new TeacherPartTimeDTO(id++, "Sofia", 0, 5L);

        listTeacher.add(teacherFullTimeDTO1);
        listTeacher.add(teacherFullTimeDTO2);
        listTeacher.add(teacherPartTimeDTO1);
        listTeacher.add(teacherPartTimeDTO2);
    }

    public List<TeacherDTO> getListTeacher() {
        return listTeacher;
    }

    public void printListTeacher() {
        for (TeacherDTO data : this.listTeacher) {

            System.out.println(data.toString());

        }
    }

    public TeacherDTO getTeacher() {
        TeacherDTO teacherSelected = new TeacherDTO();
        boolean flag = true;

        System.out.println("LIST OF TEACHERS");
        this.printListTeacher();

        int idTeacher = (int) Settings.getData("Please, insert the ID of the teacher you want to select", "INT");

        for (TeacherDTO data: listTeacher) {
            if(data.getId() == idTeacher){
                teacherSelected = data;
                flag = false;
            }
        }

        if(flag){
            System.out.println("Teacher does not exist, please insert a valid ID");
            this.getTeacher();
        }
        return teacherSelected;
    }
}
