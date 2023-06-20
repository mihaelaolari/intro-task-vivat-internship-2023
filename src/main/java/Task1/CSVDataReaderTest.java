package Task1;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import java.util.ArrayList;

public class CSVDataReaderTest {

    @Test
    public void testGetMonthsOfWork() {
        WorkExperience workExperience = new WorkExperience("Google", "01/01/2010", "10/10/2011");
        Assertions.assertEquals(21, workExperience.getMonthsOfWork());
    }
    @Test
    public void testGetCompanyName() {
        WorkExperience workExperience = new WorkExperience("Google", "01/01/2010", "10/10/2011");
        Assertions.assertEquals("Google", workExperience.getCompanyName());
    }

    @Test
    public void testGetStartDate() {
        WorkExperience workExperience = new WorkExperience("Google", "01/01/2010", "10/10/2011");
        Assertions.assertEquals("01/01/2010", workExperience.getStartDate());
    }
    @Test
    public void testGetFullName() {
        Employee employee = new Employee("John", "Smith", 30, new ArrayList<>());
        Assertions.assertEquals("John Smith", employee.getFullName());
    }

    @Test
    public void testGetAge() {
        Employee employee = new Employee("John", "Smith", 30, new ArrayList<>());
        Assertions.assertEquals(30, employee.getAge());
    }

    @Test
    public void testGetWorkExperiences() {
        ArrayList<WorkExperience> workExperiences = new ArrayList<>();
        workExperiences.add(new WorkExperience("Google", "01/01/2010", "10/10/2011"));
        workExperiences.add(new WorkExperience("Microsoft", "23/1/2012", "10/10/2012"));
        workExperiences.add(new WorkExperience("Apple", "01/01/2014", "10/10/2015"));
        Employee employee = new Employee("John", "Smith", 30, workExperiences);

        Assertions.assertEquals(workExperiences, employee.getWorkExperiences());
    }

}
