package employeemanagement;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.function.Predicate;
import java.util.Comparator;
public class EmployeeManager {

    static Scanner sc = new Scanner(System.in);

    static ArrayList<Employee> employeeList = new ArrayList<>();

    public void printEmployee() {
        System.out.println("What is the name of the employee that you want information about?\n");
        String nameEmp = sc.nextLine();
        boolean foundName = false;
        for (Employee employee : employeeList) {
            if (nameEmp.equalsIgnoreCase(employee.getName())) {
                System.out.println(employee);
                System.out.println("");
                foundName = true;
            }
        }
        if (foundName == false) {
            System.out.println("Couldn't find employee with that name");
        }

    }

    public void loadList() {

        FullTimeEmployee emp = new FullTimeEmployee(3012, "Lukas Adamsson", Gender.MALE, "1995-10-10");
        FullTimeEmployee emp1 = new FullTimeEmployee(1200, "Kalle Blomqvist", Gender.MALE, "1984-04-09");
        ContractorEmployee emp2 = new ContractorEmployee(2500, "Sara Pettersson", Gender.FEMALE, "1982-12-24");
        ShareHolderEmployee emp3 = new ShareHolderEmployee(10500, "Harvey Specter", Gender.MALE, "1976-09-22");
        ShareHolderEmployee emp4 = new ShareHolderEmployee(7700, "Jessica Pearson", Gender.FEMALE, "1965-01-12");
        ContractorEmployee emp5 = new ContractorEmployee(5400, "Builder Bob", Gender.MALE, "1970-05-12");
        ShareHolderEmployee emp6 = new ShareHolderEmployee(15400, "Britt-Erik Svenssondotter", Gender.UNKNOWN, "1955-03-12");
        FullTimeEmployee emp7 = new FullTimeEmployee(5400, "Marat Matourin", Gender.MALE, "1994-12-04");
        ContractorEmployee emp8 = new ContractorEmployee(20120, "Caspar Sylwan", Gender.MALE, "1979-04-12");

        employeeList.add(emp);
        employeeList.add(emp1);
        employeeList.add(emp2);
        employeeList.add(emp3);
        employeeList.add(emp4);
        employeeList.add(emp5);
        employeeList.add(emp6);
        employeeList.add(emp7);
        employeeList.add(emp8);
        employeeList.add(new ShareHolderEmployee(17200, "Uffe B", Gender.MALE, "1955-04-08"));
        
       
        System.out.println("Loaded a list of " + employeeList.size() + " employees.\n");

    }

    public ArrayList<Employee> getEmployeeList() {
        return employeeList;
    }

    public void printList() {
        if (employeeList.size() != 0) {
            for (Employee employee : employeeList) {
                System.out.println(employee);
                System.out.println("");
            }
        } else {
            System.out.println("\nList is empty.");
        }
    }

    public void printListOfFemales() {
        if (employeeList.size() != 0) {
            for (Employee employee : employeeList) {
                if (employee.getGender() == Gender.FEMALE) {
                    System.out.println(employee);
                    System.out.println("");
                }

            }
        } else {
            System.out.println("\nList is empty.");
        }

    }

    public void printListOfShareHolders() {
        ArrayList<Employee> shareHolderList = new ArrayList<>();
        for (Employee employee : employeeList) {
            if (employee instanceof ShareHolderEmployee) {
                shareHolderList.add(employee);
            }
        }
        if (shareHolderList.size() != 0) {
            System.out.println("List of share holders:");
            for (Employee employee : shareHolderList) {
                System.out.println(employee);
            }
        } else {
            System.out.println("\nList is empty");
        }
    }

    public void printListOfFullTimeEmployees() {
        ArrayList<Employee> fullTimeList = new ArrayList<>();
        for (Employee employee : employeeList) {
            if (employee instanceof FullTimeEmployee) {
                fullTimeList.add(employee);
            }
        }
        if (fullTimeList.size() != 0) {
            System.out.println("Full time employees:");
            for (Employee employee : fullTimeList) {
                System.out.println(employee);
            }
        } else {
            System.out.println("\nList is empty");
        }
    }

    public void printListOfContractors() {
        ArrayList<Employee> contractorList = new ArrayList<>();
        for (Employee employee : employeeList) {
            if (employee instanceof ContractorEmployee) {
                contractorList.add(employee);
            }
        }
        if (contractorList.size() != 0) {
            System.out.println("Contractor employees:");
            for (Employee employee : contractorList) {
                System.out.println(employee);
            }
        } else {
            System.out.println("\nList is empty");
        }
    }

    public void printListOfMales() {
        if (employeeList.size() != 0) {
            for (Employee employee : employeeList) {
                if (employee.getGender() == Gender.MALE) {
                    System.out.println(employee);
                    System.out.println("");
                }

            }
        } else {
            System.out.println("\nList is empty");
        }
    }

    public void addEmployee() {

        System.out.println("\nWhat is the full name of the employee you want to add?");
        String name = sc.nextLine();
        System.out.println("\nWhat is the employees gender?\n1: Male\n2: Female\n3: Unknown");
        Gender gender;
        int choice2 = sc.nextInt();
        if (choice2 == 1) {
            gender = Gender.MALE;
        } else if (choice2 == 2) {
            gender = Gender.FEMALE;
        } else {
            gender = Gender.UNKNOWN;
        }

        System.out.println("\nWhat is the employees salary?");
        Double salary = sc.nextDouble();
        sc.nextLine(); // cache
        String socialSecurityN = "";
        do {
            System.out.println("\nEnter the employees social security number");
            System.out.println("Format: YYYYMMDDNNNN, Example: 199510104414.");
            socialSecurityN = sc.nextLine();
        } while (socialSecurityN.length() != 12);

        socialSecurityN = socialSecurityN.substring(0, 4) + "-" + socialSecurityN.substring(4, 6) + "-"
                + socialSecurityN.substring(6, 8);

        System.out.println("\nIn what capacity is the new employee being employed?");
        int capacity = 0;
        boolean loop = true;
        do {
            System.out.println("1: Shareholder and full time employee\n2: Full time Employee\n3: Contractor");
            int choice = sc.nextInt();
            if (choice == 1) {
                capacity = 1;
                loop = false;
            } else if (choice == 2) {
                capacity = 2;
                loop = false;
            } else if (choice == 3) {
                capacity = 3;
                loop = false;
            } else {
                System.out.println("Invalid option, enter again.\n");
            }

        } while (loop);

        if (capacity == 1) {
            employeeList.add(new ShareHolderEmployee(salary, name, gender, socialSecurityN));
            {
                System.out.println("Added shareholding full time employee: "
                        + "\n" + name + ", " + salary + ", " + socialSecurityN);
            }
        } else if (capacity == 2) {
            employeeList.add(new FullTimeEmployee(salary, name, gender, socialSecurityN));
            {
                System.out.println("Added full time employee: "
                        + "\n" + name + ", " + salary + ", " + socialSecurityN);
            }
        } else if (capacity == 3) {
            employeeList.add(new ContractorEmployee(salary, name, gender, socialSecurityN));
            {
                System.out.println("Added contractor employee: "
                        + "\n" + name + ", " + salary + ", " + socialSecurityN);
            }
        }
           Collections.sort(employeeList);

    }

    public void updateEmployee() {
        printList();
        System.out.println("What is the ID of the employee you want to update?");
        int empID = sc.nextInt();
        Employee updateEmp = null;
        for (Employee employee : employeeList) {
            if (employee.getEmployeeID() == empID) {
                updateEmp = employee;
            }
        }

        if (updateEmp != null) {
            System.out.println("What do you want to update?");
            System.out.println("1: Employee has left the company");
            System.out.println("2: Update the employees salary");
            System.out.println("3: Update the employees name");
            System.out.println("4: Update the employees gender");
            System.out.println("0: None of the above");

            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    updateEmp.setEndDate(LocalDate.now());
                    System.out.println("Employee updated. Employee has left the company in " + LocalDate.now());
                    break;
                case 2:
                    System.out.println("What is the employees new salary?");
                    double newSal = sc.nextDouble();
                    updateEmp.setSalary(newSal);
                    System.out.println("Salary updated to " + updateEmp.getSalary());
                    break;
                case 3:
                    System.out.println("What is the employees new name?");
                    sc.nextLine();//cache
                    String newName = sc.nextLine();
                    updateEmp.setName(newName);
                    System.out.println("Name updated to " + updateEmp.getName());
                    break;
                case 4:
                    System.out.println("What is the employees updated gender?");
                    System.out.println("1: Male\n2: Female\n3: Unknown");
                    int newGender = sc.nextInt();
                    switch (newGender) {
                        case 1:
                            updateEmp.setGender(Gender.MALE);
                            System.out.println("Gender updated to " + updateEmp.getGender());
                            break;
                        case 2:
                            updateEmp.setGender(Gender.FEMALE);
                            System.out.println("Gender updated to " + updateEmp.getGender());
                            break;
                        case 3:
                            updateEmp.setGender(Gender.UNKNOWN);
                            System.out.println("Gender updated to " + updateEmp.getGender());
                            break;
                        default:
                            System.out.println("No updates made");
                    }
                    break;
                default:
                    System.out.println("No updates were made");
            }
        }
        Collections.sort(employeeList);
    }

    public void removeEmployee() {

        printList();
        System.out.println("What is the Id of the employee you want to remove?");
        int ID = sc.nextInt();
        Employee empRemove = null;
        for (Employee emp : employeeList) {
            if (emp.getEmployeeID() == ID) {
                empRemove = emp;
            }
        }
        employeeList.remove(empRemove);
        Collections.sort(employeeList);
    }
}
