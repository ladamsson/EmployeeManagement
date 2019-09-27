package employeemanagement;

import java.time.LocalDate;
import java.time.Year;
import static java.time.temporal.ChronoUnit.YEARS;

public abstract class Employee implements Comparable<Employee>{

    private double salary;
    private String name;
    private String socialSecurityN;
    private LocalDate startDate;
    private LocalDate endDate =null;
    private Gender gender;
    private static int counter = 1;
    private int employeeID = counter;


    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
 

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
    
    public String getFirstName(){
        String[] x = name.split(" "); //creates an array of 2 Strings (firstname and surname, split by " ") and returns firstname
        return x[0];
    }

    public String getSurname(){
        String[] x = name.split(" "); //creates an array of 2 Strings (firstname and surname, split by " ") and returns surname
        return x[1];
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
        LocalDate birthDate = LocalDate.parse(socialSecurityN); //parses socialsecurity String to a LocalDate
        long employeeAge = YEARS.between(birthDate, LocalDate.now()); //calculates employees age
        return(int)employeeAge; //casts long to int
    }
    
    public abstract double getTotalMonthlyIncome();//calculates total income(salary, benefits, vacation pay etc)
    
    public abstract double getUnUsedVacationDaysAllowance(); //abstract method only used for 2/3 subclasses
    
     @Override
    public int compareTo(Employee o) {
     
        return ((name.split(" "))[1]).compareTo(o.getSurname()); /*Splits name into a String array of a[0] first name
        and [1] surname, chooses surname and compares it to the second surname with getSurname(), aka
       gives the ability to sort a list by surnames...
        */
    }

    @Override
    public String toString() {
         if(endDate == null){ //if employee has not left company and endDate is not set this toString is used
             return "ID " + employeeID + "/" + getSurname() +", " + getFirstName()  + "/" + gender + "/" + socialSecurityN + "/Salary $" + salary 
                + ". Joined company in " + startDate;
        }
         else{ // If employee has left company and endDate is set this toString is used with endDate included.
             return "ID " + employeeID + "/" +getSurname() +", " + getFirstName()  + "/" + gender + "/" + socialSecurityN + "/Salary $" + salary 
                + ". Joined company in " + startDate + ", left company in " + endDate;
         }
    }

}
