
package employeemanagement;


public class ContractorEmployee extends Employee {

    public ContractorEmployee(double salary, String name, Gender gender, String socialSecurityN) {
        super(salary, name, gender, socialSecurityN);
    }

    @Override
    public String toString() {
        return super.toString()+ "\n   This employee is a temporary contractor and receives no benefits.";
    }

    @Override
    public double getTotalMonthlyIncome() {
        return getSalary();
    }

    @Override
    public double getUnUsedVacationDaysAllowance() {
        return getSalary()*0;
    }
    
    
    
    
}
