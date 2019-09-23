package employeemanagement;

import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeStats {

    static Scanner sc = new Scanner(System.in);

    EmployeeManager empMan = new EmployeeManager();
    ArrayList<Employee> shareHolderList;
    ArrayList<Employee> fullTimeList;
    ArrayList<Employee> contractorList;

    ArrayList<Employee> employeeList = empMan.getEmployeeList();

    public double getTotalOfAllSalaries() {
        double totSal = 0;
        for (Employee employee : employeeList) {
            totSal += employee.getSalary();
        }

        return totSal;
    }

    public double getAverageSalary() {
        double totSal = 0;
        for (Employee employee : employeeList) {
            totSal += employee.getSalary();
        }
        return (Math.round(totSal / employeeList.size()));
    }
    
    

 
    public int getAverageAgeOfEmployees() {
        int totAge = 0;
        int averageAge = 0;
        for (Employee employee : employeeList) {
            totAge += employee.getAge();

        }
        return totAge / employeeList.size();
    }

    public void printGenderRatio() {

        double females = 0;
        double males = 0;
        double unknown = 0;
        double allEmployees = 0;

        if (employeeList.size() != 0) {
            for (Employee employee : employeeList) {
                if (employee.getGender() == Gender.FEMALE) {
                    females++;
                    allEmployees++;
                } else if (employee.getGender() == Gender.MALE) {
                    males++;
                    allEmployees++;
                } else if (employee.getGender() == Gender.UNKNOWN) {
                    unknown++;
                    allEmployees++;
                }

            }
            System.out.println("Female: " + (Math.round((females / allEmployees) * 100)) + "%");
            System.out.println("Male: " + (Math.round((males / allEmployees) * 100)) + "%");
            System.out.println("Unknown: " + (Math.round((unknown / allEmployees) * 100)) + "%");

        } else {
            System.out.println("List is empty.");
        }

    }
    
    public void printEmployeesWithHighestAndLowestSalary(){
        
        double max = 0;
        Employee maxEmp = null;
        Employee minEmp = null;
        for (Employee employee : employeeList) {
            if(employee.getSalary()>max){
                max = employee.getSalary();
                maxEmp = employee;
            }
        }
        double min = max;
        for (Employee employee : employeeList) {
            if(employee.getSalary()<min){
                min = employee.getSalary();
                minEmp = employee;
            }
        }
            System.out.println("Employee with lowest salary is:");
            System.out.println(minEmp);
            System.out.println("Employee with highest salary is:");
            System.out.println(maxEmp);
        
    }

    public void printGenderRatioWithinProfessions() {
        ArrayList<Employee> shareHolderList = new ArrayList<>();
        ArrayList<Employee> fullTimeList = new ArrayList<>();
        ArrayList<Employee> contractorList = new ArrayList<>();
        double shareHolderMales = 0;
        double shareHoldersFemales = 0;
        double shareHoldersUnknowns = 0;
        double fullTimeMales = 0;
        double fullTimeFemales = 0;
        double fullTimeUnknowns = 0;
        double contractorsMales = 0;
        double contractorsFemales = 0;
        double contractorsUnknowns = 0;

        for (Employee employee : employeeList) {
            if (employee instanceof ShareHolderEmployee) {
                shareHolderList.add(employee);
                if (employee.getGender() == Gender.MALE) {
                    shareHolderMales++;
                } else if (employee.getGender() == Gender.FEMALE) {
                    shareHoldersFemales++;
                } else if (employee.getGender() == Gender.UNKNOWN) {
                    shareHoldersUnknowns++;
                }
            } else if (employee instanceof FullTimeEmployee) {
                fullTimeList.add(employee);
                if (employee.getGender() == Gender.MALE) {
                    fullTimeMales++;
                } else if (employee.getGender() == Gender.FEMALE) {
                    fullTimeFemales++;
                } else if (employee.getGender() == Gender.UNKNOWN) {
                    fullTimeUnknowns++;
                }
            } else if (employee instanceof ContractorEmployee) {
                contractorList.add(employee);
                if (employee.getGender() == Gender.MALE) {
                    contractorsMales++;
                } else if (employee.getGender() == Gender.FEMALE) {
                    contractorsFemales++;
                } else if (employee.getGender() == Gender.UNKNOWN) {
                    contractorsUnknowns++;
                }

            }
        }
        

        System.out.println("Shareholder gender ratio:");
        System.out.println("Males: " + (Math.round((shareHolderMales / shareHolderList.size()) * 100)) + "%");
        System.out.println("Females: " + (Math.round((shareHoldersFemales / shareHolderList.size()) * 100)) + "%");
        System.out.println("Unknown: " + (Math.round((shareHoldersUnknowns / shareHolderList.size()) * 100)) + "%");

        System.out.println("\nFull time employee gender ratio:");
        System.out.println("Males: " + (Math.round((fullTimeMales / fullTimeList.size()) * 100)) + "%");
        System.out.println("Females: " + (Math.round((fullTimeFemales / fullTimeList.size()) * 100)) + "%");
        System.out.println("Unknowns: " + (Math.round((fullTimeUnknowns / fullTimeList.size()) * 100)) + "%");

        System.out.println("\nContractor employee gender ratio:");
        System.out.println("Males: " + (Math.round((contractorsMales / contractorList.size()) * 100)) + "%");
        System.out.println("Females: " + (Math.round((contractorsFemales / contractorList.size()) * 100)) + "%");
        System.out.println("Unknowns: " + (Math.round((contractorsUnknowns / contractorList.size()) * 100)) + "%");
    }
}
