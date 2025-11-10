// 1. Bank Account Management System

// Description: Simulate a simple bank system where users can create accounts, deposit, withdraw, and check balance.
// Concepts Covered: Classes, Objects, Methods, Encapsulation, Inheritance (e.g., SavingsAccount & CurrentAccount).
// Features:
// Create multiple account types.
// Deposit and withdraw with validation.
// Display account details.
// Use inheritance for account types.

class Account{
  private double balance=0;
  public void createAccount(){
    System.out.println("Amount created Successfull..");
  }
  public void deposit(double amount){
    if(amount>0){
      balance+=amount;
    System.out.println("Amount Deposited Successfull:"+amount);
    }else if(amount<0){
      System.out.println("Amount Must be Positive");
    }else {
      System.out.println("Invalid Try");
    }
  }
  public void withdraw(double amount){
    if(amount>0){
      if(amount<=balance){
        balance-=amount;
         System.out.println("withdraw Successsfull:"+amount);
      }else{
         System.out.println("Insufficient Balance..");
      }
    }else{
       System.out.println("Amount must be positive...");
    }
  }
    
    public double getBalance(){
      return balance;
    }
    public void displayDetails(){
       System.out.println("Current balance:"+balance);
    }
}
class SavingsAccount extends Account{
  
}
class CurrentAccount extends Account{
  
}

class BankAccountSystem{
  public static void main(String []args){
    SavingsAccount sa=new SavingsAccount();
    sa.createAccount();
    sa.deposit(50000.0);
    sa.withdraw(2000.0);
    sa.displayDetails();
    System.out.println("------------------------------");
    
    CurrentAccount ca=new CurrentAccount();
    ca.createAccount();
    ca.deposit(50000.0);
    ca.withdraw(4000.0);
    ca.displayDetails();
    System.out.println("------------------------------");
  }
}