// 3. Employee Payroll System

// Description: Handle employee salary calculation including bonuses and deductions.
// Concepts Covered: Classes, Objects, Methods, Encapsulation, Inheritance, Polymorphism (method overloading).
// Features:
// Calculate net salary.
// Show detailed payslip.
// Inheritance for different types of employees (Permanent, Contractual).
// Overload methods for bonus calculation.

class Employee{
  protected double salary;
  protected double bonuses;
  protected double deductions;
  
  Employee (double salary){
    this.salary=salary;
    this.bonuses=0;
    this.deductions=0;
  }
  
  public void addBonus(double bonus){
    this.bonuses+=bonus;
  }
  public void addBonus(double bonus,double extraBonus){
    this.bonuses+=(bonus+extraBonus);
  }
  public void adddeductions(double deductions){
    this.deductions+=deductions;
  }
  
  public void salaryCaculation(){
    double totalSalary=salary+bonuses-deductions;
    System.out.println("---------------------------");
    System.out.println("Employee Salary:"+salary);
    System.out.println("Employee Bonuses:"+bonuses);
    System.out.println("Employee deductions:"+deductions);
    System.out.println("Employee Net Salary:"+totalSalary);
  }
}

class PermanentEmployee extends Employee{
  public PermanentEmployee(double salary){
    super(salary);
  }
}
class ContractualEmployee extends Employee{
  public ContractualEmployee(double salary){
    super(salary);
  }
}

class EmployeePayrollSystem{
  public static void main (String[] args) {
    PermanentEmployee pEmp=new PermanentEmployee(50000.0);
    
    pEmp.addBonus(5000);
    pEmp.adddeductions(2000);
    pEmp.salaryCaculation();
    
    System.out.println("----------------------------");
    
    ContractualEmployee cEmp=new ContractualEmployee(3000.0);
    
    cEmp.addBonus(1000.0);
    cEmp.adddeductions(500.0);
    cEmp.salaryCaculation();
    
    System.out.println("-----------------------------");
  }
}