package co.com.finalExercise.main;

import co.com.finalExercise.dto.StudentDTO;
import co.com.finalExercise.dto.SubjectDTO;
import co.com.finalExercise.dto.TeacherDTO;
import co.com.finalExercise.model.ModelStudent;
import co.com.finalExercise.model.ModelSubject;
import co.com.finalExercise.model.ModelTeacher;
import co.com.finalExercise.util.Settings;

import java.util.List;

public class Main {


    public static void main (String[] args){

        String option = null;
        String subjectName = null;
        ModelTeacher modelTeacher = new ModelTeacher();
        ModelStudent modelStudent = new ModelStudent();
        ModelSubject modelSubject = new ModelSubject(modelTeacher.getListTeacher(), modelStudent.getListStudent());

        do {
            try {
                System.out.println ("\n-----WELCOME TO OUR UNIVERSITY SYSTEM-----");
                Settings.getMenu(Settings.MAIN);
                option= (String) Settings.getData("Please, insert the number of the desired option", "STRING");

                Settings.validateOption(Settings.MAIN, option);

                if (option.equals("1")) {
                    System.out.println("LIST OF TEACHERS");
                    modelTeacher.printListTeacher();
                }else if (option.equals("2")){
                    System.out.println("LIST OF SUBJECTS");
                    modelSubject.printListSubject();

                    Settings.getMenu(Settings.SUBJECTS);
                    option= (String) Settings.getData("Please, insert the number of the desired option", "STRING");
                    Settings.validateOption(Settings.SUBJECTS, option);

                        if (option.equals("1")) {
                            subjectName = (String) Settings.getData("Digit the subject name", "STRING");
                            modelSubject.printSubjectDetails(subjectName);
                        }else if (option.equals("2")){
                            Settings.getMenu(Settings.MAIN);
                        }
                }else if (option.equals("3")) {
                    StudentDTO studentDTO = modelStudent.addStudent();
                    modelSubject.assignStudentToSubject(studentDTO);

                }else if (option.equals("4")) {
                    SubjectDTO subjectDTO = modelSubject.addSubject();
                    List<StudentDTO> studentList = modelStudent.getStudentList();
                    subjectDTO.getListStudentDTO().addAll(studentList);
                    TeacherDTO teacherDTO = modelTeacher.getTeacher();
                    subjectDTO.setTeacherDTO(teacherDTO);
                    System.out.println(subjectDTO.toString());
                }else if (option.equals("5")) {
                    modelStudent.getListSubjects(modelSubject.getListSubject());
                }
            }catch (Exception ex){
                System.out.println(ex.getMessage());
                ex.printStackTrace();
            }

        } while (!option.equals("0"));

    }


}
