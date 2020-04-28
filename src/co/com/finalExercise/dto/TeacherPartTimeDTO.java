package co.com.finalExercise.dto;

import co.com.finalExercise.interfaces.InterfaceSalary;

public class TeacherPartTimeDTO extends TeacherDTO implements InterfaceSalary {

    private float activeHoursPerWeek;

    public TeacherPartTimeDTO() {
        super();
    }

    public TeacherPartTimeDTO(int id, String name, float salary, float activeHoursPerWeek) {
        super(id, name, salary);
        this.activeHoursPerWeek = activeHoursPerWeek;
        this.calculateSalary();
    }

    public float getActiveHoursPerWeek() {
        return activeHoursPerWeek;
    }

    public void setActiveHoursPerWeek(long activeHoursPerWeek) {
        this.activeHoursPerWeek = activeHoursPerWeek;
    }

    @Override
    public void calculateSalary() {
    this.salary = baseSalary *  activeHoursPerWeek;

    }
}
