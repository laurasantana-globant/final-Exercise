package co.com.finalExercise.dto;

import co.com.finalExercise.interfaces.InterfaceSalary;

public class TeacherFullTimeDTO extends TeacherDTO implements InterfaceSalary {

    private float yearsOfExperience;

    public TeacherFullTimeDTO() {
        super();
    }

    public TeacherFullTimeDTO(int id, String name, float salary, float yearsOfExperience) {
        super(id, name, salary);
        this.yearsOfExperience = yearsOfExperience;
        this.calculateSalary();
    }

    public float getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(long yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    @Override
    public void calculateSalary() {

        this.salary = (float) (baseSalary * 1.1 * yearsOfExperience);
    }
}
