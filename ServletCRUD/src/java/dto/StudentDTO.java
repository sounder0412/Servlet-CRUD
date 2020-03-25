package dto;

public class StudentDTO 
{
    //private fields
    private int roll;
    private String name;
    //constructors
    public StudentDTO() {
    }
    public StudentDTO(int roll, String name) {
        this.roll = roll;
        this.name = name;
    }
    //getter & setter
    public int getRoll() {
        return roll;
    }
    public void setRoll(int roll) {
        this.roll = roll;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}