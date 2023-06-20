package Task1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

public class CSVDataReader {
    public static void main(String[] args) {
        readAndPrintData("src/main/java/resources/data.csv");
    }

    public static void readAndPrintData(String fileName) {
        ArrayList<Employee> employees = new ArrayList<>();
        HashSet<String> uniqueCompanies = new HashSet<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));//cream obiect BufferReader ca sa citeasca din filename
            String line;
            boolean firstLine = true; //sarim peste prima linie din fisier care contine denumirile coloanelor
            while ((line = reader.readLine()) != null) {
                if (firstLine) {
                    firstLine = false;
                    continue; // daca firstLine este true,sarim prima linie cu ajutorul instructiunii continue
                }

                String[] values = line.split(",");
                if (values.length >= 6) {
                    String firstName = values[0];
                    String lastName = values[1];
                    int age = Integer.parseInt(values[2]);
                    ArrayList<WorkExperience> workExperiences = new ArrayList<>();

                    for (int i = 3; i < values.length; i += 3) {
                        String[] workData = values[i].split(";");
                        if (workData.length == 3) {
                            String companyName = workData[0];
                            String startDate = workData[1];
                            String endDate = workData[2];
                            workExperiences.add(new WorkExperience(companyName, startDate, endDate));
                            uniqueCompanies.add(companyName);
                        } else {
                            System.out.println("Error: Invalid work data format for line: " + line);
                        }
                    }

                    Employee employee = new Employee(firstName, lastName, age, workExperiences);
                    employees.add(employee);
                } else {
                    System.out.println("Error: Invalid data format for line: " + line);
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Date despre fiecare employee
        for (Employee employee : employees) {
            System.out.println("Numele: " + employee.getFullName());
            System.out.println("Varsta: " + employee.getAge());
            System.out.println("Locul de munca si stajul:");

            for (WorkExperience workExperience : employee.getWorkExperiences()) {
                System.out.println("  Compania: " + workExperience.getCompanyName());
                System.out.println("    Stajul: " + workExperience.getMonthsOfWork() + " luni");
            }

            System.out.println();
        }


        System.out.println("Lista tuturor locurilor de muncă unice în ordine alfabetică:");
        ArrayList<String> sortedCompanies = new ArrayList<>(uniqueCompanies);
        sortedCompanies.sort(String::compareToIgnoreCase);

        for (String company : sortedCompanies) {
            System.out.println("- " + company);
        }
    }
}