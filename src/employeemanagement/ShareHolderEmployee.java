package employeemanagement;

public class ShareHolderEmployee extends Employee {

    EmployeeStats empStats = new EmployeeStats();
    double dividend = 0.0;

    double unUsedVacationDaysAllowance = 0;

    public ShareHolderEmployee(double salary, String name, Gender gender, String socialSecurityN) {
        super(salary, name, gender, socialSecurityN);
    }

    @Override
    public String toString() {
        return  super.toString() + "\n   This employee is a full time employee and a share holder in the company." + "\n   This employee has the right to $" + getUnUsedVacationDaysAllowance() + " per month for unused vacation days."
                + "\n   This employee gets a monthly dividend of $" + getShareHoldersDividend()+ " due to shareholding in company.";
    }
    
    public double getShareHoldersDividend(){
        return empStats.getTotalOfAllSalaries()*0.025;
    }

    @Override
    public double getTotalMonthlyIncome() {
        
       double totalIncome = 0;
       totalIncome+= getSalary() + getUnUsedVacationDaysAllowance() + getShareHoldersDividend();
       return totalIncome;
          }

    @Override
    public double getUnUsedVacationDaysAllowance() {
        return getSalary()*0.12;
    }
    
}
