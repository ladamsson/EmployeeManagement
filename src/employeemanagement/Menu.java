package employeemanagement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.concurrent.TimeUnit; //to add some delays in the progrmar for fun/some kinda user friendlyness

public class Menu {

    static Scanner sc = new Scanner(System.in);
    EmployeeStats empStats = new EmployeeStats();
    EmployeeManager empMan = new EmployeeManager();

    public void menu() throws InterruptedException { //exception because of TimeUnits...
         ArrayList<Employee> employeeList = empMan.getEmployeeList();
        boolean loopMenu = true; //To make sure list of employees is only loaded once
        boolean isListLoaded = false;

        do {
            System.out.println("\nEmployee Management System");
            System.out.println("------------------------------------");
            System.out.println("Choose your action:");
            System.out.println("1: Load list of employees");
            System.out.println("2: Print list of employees");
            System.out.println("3: Search for a specific employee");
            System.out.println("4: Check general statistics regarding employees");
            System.out.println("5: Manage employees in the system(ADD/REMOVE/UPDATE)");
            System.out.println("0: Exit program");
            int choice = sc.nextInt();
            switch (choice) {
                case 0:
                    loopMenu = false;
                    break;
                case 1:
                    if (isListLoaded == false) {
                        empMan.loadList();
                        isListLoaded = true;
                        Collections.sort(EmployeeManager.employeeList); //sorts by surname
                    } else {
                        System.out.println("\nSorry, list can only be loaded once.\n");
                    }
                    break;
                case 2:
                    if(employeeList.size()!=0){
                    TimeUnit.SECONDS.sleep(1);
                    loadListMenu();
                    }
                    else
                        System.out.println("List is empty, load list or add employees");
                    
                    break;
                case 3:
                   if(employeeList.size()!=0){
                    TimeUnit.SECONDS.sleep((long) 0.25);
                    empMan.printEmployee();
                   }
                   else
                        System.out.println("List is empty, load list or add employees");
                    break;
                case 4:
                    if(employeeList.size()!=0){
                    printStatsMenu();
                    }
                    else
                        System.out.println("List is empty, load list or add employees");
                    break;
                case 5:
                    manageEmployeesMenu();
                    break;

                default:
                    System.out.println("Invalid option");
            }
            TimeUnit.SECONDS.sleep((long) 1.5);
        } while (loopMenu);
        System.out.println("\nBeep, boop, beep...");
        System.out.println("I... was... just learning to love...");
        System.out.println("Goodbye humans <(x_x)>");
    }

    public void loadListMenu() throws InterruptedException {
        System.out.println("Do you want to:");
        System.out.println("1: Print list of all employees");
        System.out.println("2: Print list of all male employees");
        System.out.println("3: Print list of all female employees");
        System.out.println("4: Print list of all shareholders");
        System.out.println("5: Print list of all full time employees");
        System.out.println("6: Print list of all contractor employees");
        int choice = sc.nextInt();
        TimeUnit.SECONDS.sleep((long) 1.5);
        switch (choice) {
            case 1:
                
                empMan.printList();
                TimeUnit.SECONDS.sleep((long) 2.5);
                break;
            case 2:
                empMan.printListOfMales();
                TimeUnit.SECONDS.sleep((long) 1.5);
                break;
            case 3:
                empMan.printListOfFemales();
                TimeUnit.SECONDS.sleep((long) 1.5);
                break;
            case 4:
                empMan.printListOfShareHolders();
                TimeUnit.SECONDS.sleep((long) 1.5);
                break;
            case 5:
                empMan.printListOfFullTimeEmployees();
                TimeUnit.SECONDS.sleep((long) 1.5);
                break;
            case 6:
                empMan.printListOfContractors();
                TimeUnit.SECONDS.sleep((long) 1.5);
                break;
            default:
                System.out.println("Invalid option");
        }
    }

    public void printStatsMenu() throws InterruptedException {
       
        System.out.println("What statistic would you like to check?");
        System.out.println("1: Average age of the employees");
        System.out.println("2: Average salary of the employees");
        System.out.println("3: Average salary between professions");
        System.out.println("4: Average salary between genders");
        System.out.println("5: Highest and lowest salary");
        System.out.println("6: Male to female ratio");
        System.out.println("7: Male to female ratio within professions");
        int choice = sc.nextInt();
        TimeUnit.SECONDS.sleep((long) 0.5);
        switch (choice) {
            case 1:

                System.out.println("The average age of the employees is " + empStats.getAverageAgeOfEmployees());
                break; 
            case 2:

                System.out.println("The average salary of the employees is : " + empStats.getAverageSalary());
                break;
            case 5:
                empStats.printEmployeesWithHighestAndLowestSalary();
                break;
            case 6:
                empStats.printGenderRatio();
                break;
            case 7:
                empStats.printGenderRatioWithinProfessions();
                break;
            case 3:
                empStats.printAverageSalaryWithinProfessions();
                break;
            case 4:
                empStats.printAverageSalaryBetweenGenders();
                break;
            default:
                System.out.println("Invalid option.");
        }
    }

    public void manageEmployeesMenu() {
        empMan.printList();
        System.out.println("");
        System.out.println("Do you want to:");
        System.out.println("1: Add employee to the list");
        System.out.println("2: Remove an employee from the list:");
        System.out.println("3: Update information about an employee?");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                empMan.addEmployee(); //calls addEmployee from employeeManager
                break;
            case 2:
                empMan.removeEmployee(); //calls removeEmploeye from employeeManager
                break;
            case 3:
                empMan.updateEmployee(); //calls updateEmployee from employeeManager
                break;
            default:
                System.out.println("Invalid option.");
        }

    }
}
