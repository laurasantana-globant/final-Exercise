package co.com.finalExercise.dto;

public class TeacherDTO extends PersonDTO {

    protected float salary;

    public TeacherDTO() {
     }

    public TeacherDTO(int id, String name, float salary) {
        super(id, name);
        this.salary = salary;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return  "ID= " + id +
                ", NAME='" + name +
                ", SALARY= " + salary;
    }
}
