// 10. Employee Leave Management System

// Description: Manage leave requests and approvals.
// Concepts Covered: Classes, Objects, Encapsulation, Inheritance, Arrays.
// Features:
// Request and approve leaves.
// Track remaining leave balance.
// Different leave types (Sick, Casual, Paid) with inheritance.

import java.util.*;

class Leave {
    protected String leaveType;
    protected int leaveDays;

    public Leave(String leaveType, int leaveDays) {
        this.leaveType = leaveType;
        this.leaveDays = leaveDays;
    }

    public String getLeaveType() {
        return leaveType;
    }

    public int getLeaveDays() {
        return leaveDays;
    }
}


class SickLeave extends Leave {
    public SickLeave(int leaveDays) {
        super("Sick Leave", leaveDays);
    }
}

class CasualLeave extends Leave {
    public CasualLeave(int leaveDays) {
        super("Casual Leave", leaveDays);
    }
}

class PaidLeave extends Leave {
    public PaidLeave(int leaveDays) {
        super("Paid Leave", leaveDays);
    }
}


class Employee {
    private int empId;
    private String empName;
    private int leaveBalance;

    public Employee(int empId, String empName, int leaveBalance) {
        this.empId = empId;
        this.empName = empName;
        this.leaveBalance = leaveBalance;
    }

    public boolean requestLeave(Leave leave) {  
        if (leaveBalance >= leave.getLeaveDays()) {
            leaveBalance -= leave.getLeaveDays();
            return true;
        }
        return false;
    }

    public int getLeaveBalance() {
        return leaveBalance;
    }

    public int getEmpId() {
        return empId;
    }

    public String getEmpName() {
        return empName;
    }
}


class LeaveSystem {
    private Employee[] employees;
    private int employeeCount = 0;

    public LeaveSystem(int size) {
        employees = new Employee[size];
    }

    public void addEmployee(Employee emp) {
        if (employeeCount < employees.length) {
            employees[employeeCount++] = emp;
        }
    }

    public Employee findEmployee(int empId) {   
        for (Employee emp : employees) {
            if (emp != null && emp.getEmpId() == empId) {
                return emp;
            }
        }
        return null;
    }

    public void applyLeave(int empId, Leave leave) {
        Employee emp = findEmployee(empId);

        if (emp != null) {
            if (emp.requestLeave(leave)) {
                System.out.println("\nLeave Approved for " + emp.getEmpName());
                System.out.println("Remaining Leaves: " + emp.getLeaveBalance());
            } else {
                System.out.println("\nLeave Rejected — Insufficient Leave Balance!");
            }
        } else {
            System.out.println("\nEmployee Not Found!");
        }
    }
}

// ---- Main Application ----
public class EmployeeLeaveSystem {
    public static void main(String[] args) {

        LeaveSystem system = new LeaveSystem(5);
        system.addEmployee(new Employee(101, "John", 12));
        system.addEmployee(new Employee(102, "Sara", 10));

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n------ Employee Leave Management ------");
            System.out.println("1. Apply Leave");
            System.out.println("2. Check Leave Balance");
            System.out.println("3. Exit");
            System.out.print("Choose Option: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Employee ID: ");
                    int id = sc.nextInt();

                    System.out.print("Enter Leave Days: ");
                    int days = sc.nextInt();

                    System.out.print("Enter Type (1-Sick | 2-Casual | 3-Paid): ");
                    int type = sc.nextInt();

                    Leave leave;
                    if (type == 1)
                        leave = new SickLeave(days);
                    else if (type == 2)
                        leave = new CasualLeave(days);
                    else
                        leave = new PaidLeave(days);

                    system.applyLeave(id, leave);
                    break;

                case 2:
                    System.out.print("Enter Employee ID: ");
                    int empId = sc.nextInt();

                    Employee emp = system.findEmployee(empId);

                    if (emp != null)
                        System.out.println("Remaining Leave Balance: " + emp.getLeaveBalance());
                    else
                        System.out.println("Employee Not Found!");

                    break;

                case 3:
                    System.out.println("\nThank You! Exiting System...");
                    System.exit(0);

                default:
                    System.out.println("Enter Valid Option!");
            }
        }
    }
}
