package co.com.finalExercise.dto;

public class StudentDTO extends PersonDTO {
    private int age;

    public StudentDTO() {
     }

    public StudentDTO(int id, String name, int age) {
        super(id, name);
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return
                "ID= " + id +
                ", NAME= '" + name +
                ", AGE= " + age ;
    }
}
