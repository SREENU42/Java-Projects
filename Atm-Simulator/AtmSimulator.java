// 5. ATM Simulator

// Description: Simulate basic ATM operations like PIN verification, withdrawal, deposit, and balance check.
// Concepts Covered: Classes, Objects, Methods, Encapsulation, Inheritance.
// Features:
// Validate PIN before transactions.
// Show transaction history.
// Different ATM types using inheritance.
import java.util.ArrayList;
import java.util.List;

class Atm{
  protected double balance;
  private String pin;
  private List<String> transactions;
  
  public Atm(double balance,String pin){
    this.balance=balance;
    this.pin=pin;
    this.transactions=new ArrayList<>();
  }
  public boolean verifyPin(String inputPin){
    return this.pin.equals(inputPin);
  }
  void deposit(double amount){
    if(amount>0){
      balance+=amount;
      transactions.add("Deposited Amount:"+amount);
      System.out.println("Amount Deposited Succesfull..");
    }else{
      System.out.println("Invalid Amount..");
    }
  }
  
  void withdraw(double amount){
    if(amount>0&&amount<=balance){
      balance-=amount;
      transactions.add("Withdral Amount:"+amount);
      System.out.println("Withdral Succesfull...");
    }else{
      System.out.println("Insufficient Funds..");
    }
  }
  public void checkBalance(){
    System.out.println("Available Balance:"+balance);
  }
  public void showTransactionHistory(){
    System.out.println("\nTransaction History.....");
    for(String transaction:transactions){
      System.out.println(transactions);
    }
  }
}
class SBIAtm extends Atm{
  public SBIAtm(double balance,String pin){
    super(balance,pin);
  }
}
class HDFCAtm extends Atm{
  public HDFCAtm(double balance,String pin){
  super(balance,pin);
  }
}
class AtmSimulator{
  public static void main (String[] args) {
    SBIAtm sbiAtm=new SBIAtm(90000.0,"2211A");
    HDFCAtm hdfcAtm=new HDFCAtm(80000.0,"2211B");
    
    
    if(sbiAtm.verifyPin("2211A")){
      sbiAtm.deposit(10000.0);
      sbiAtm.withdraw(5000.0);
      sbiAtm.checkBalance();
      sbiAtm.showTransactionHistory();
    }else{
      System.out.println("Invalid Pin Entered...");
    }
}
}