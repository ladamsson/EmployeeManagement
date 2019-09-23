package employeemanagement;

import java.time.LocalDate;
import java.time.Year;
import static java.time.temporal.ChronoUnit.YEARS;

public abstract class Employee {

    private double salary;
    private String name;
    private String socialSecurityN;
    private LocalDate startDate;
    private LocalDate endDate =null;

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
    private Gender gender;
    private static int counter = 1;
    private int employeeID = counter;

    public Employee(double salary, String name, Gender gender, String socialSecurityN) {
        this.salary = salary;
        this.name = name;
        this.socialSecurityN = socialSecurityN;
        this.startDate = LocalDate.now();
        this.gender =  gender;
        this.employeeID = counter;
        counter++;
    }

    public double getSalary() {
        return salary;
    }
    

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public int getEmployeeID() {
        return employeeID;
    }
    

    public String getSocialSecurityN() {
        return socialSecurityN;
    }

    public LocalDate getStartDate() {
        return startDate;
    }
    
    public int getAge(){
        LocalDate birthDate = LocalDate.parse(socialSecurityN);
        long employeeAge = YEARS.between(birthDate, LocalDate.now());
        return(int)employeeAge; //castar long till int
    }
    
    public abstract double getTotalMonthlyIncome();
    
    public abstract double getUnUsedVacationDaysAllowance();

    @Override
    public String toString() {
         if(endDate == null){
             return "ID " + employeeID + "/" + name + "/" + gender + "/" + socialSecurityN + "/Salary $" + salary 
                + ". Joined company in " + startDate;
        }
         else{
             return "ID " + employeeID + "/" + name + "/" + gender + "/" + socialSecurityN + "/Salary $" + salary 
                + ". Joined company in " + startDate + ", left company in " + endDate;
         }
    }

}
