package Task1;

import java.util.ArrayList;
class Employee {
    private String firstName;
    private String lastName;
    private int age;
    private ArrayList<WorkExperience> workExperiences;

    public Employee(String firstName, String lastName, int age, ArrayList<WorkExperience> workExperiences) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.workExperiences = workExperiences;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public int getAge() {
        return age;
    }

    public ArrayList<WorkExperience> getWorkExperiences() {
        return workExperiences;
    }
}
