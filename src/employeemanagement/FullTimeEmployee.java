package employeemanagement;

public class FullTimeEmployee extends Employee {


    private double unUsedVacationDaysAllowance = 0;

    public FullTimeEmployee(double salary, String name, Gender gender, String socialSecurityN) {
        super(salary, name, gender, socialSecurityN);
    }

    @Override
    public String toString() {
        return super.toString() + "\n   This employee is a full time employee and has a right to:"
                + "\n   $" + getUnUsedVacationDaysAllowance() + " per for month for unused vacation days.";
    }
    
     public double getTotalMonthlyIncome(){
        double totalIncome = getSalary()+getUnUsedVacationDaysAllowance();
        return totalIncome;
    }

    public double getUnUsedVacationDaysAllowance() {
        unUsedVacationDaysAllowance = getSalary()*0.12;
        return unUsedVacationDaysAllowance;
    }
    
    
     
}
