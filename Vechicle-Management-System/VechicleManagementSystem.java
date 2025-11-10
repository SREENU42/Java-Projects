// 6. Vehicle Management System

// Description: Manage different types of vehicles with their details.
// Concepts Covered: Classes, Objects, Encapsulation, Inheritance, Polymorphism.
// Features:
// Add different vehicle types (Car, Bike, Truck).
// Calculate fuel efficiency or rental cost.
// Use method overriding for specific vehicle behavior.

class Vechicle{
  private String brand;
  private String model;
  private double price;
  
  Vechicle(String brand,String model,double price){
    this.brand=brand;
    this.model=model;
    this.price=price;
  }
  
  public void displayDetails(){
    System.out.println("------------Vechicle Details-------");
    System.out.println("Vechicle Brand:"+brand);
    System.out.println("Vechicle Model:"+model);
    System.out.println("Vechicle Price:"+price);
  }
  
  public double calculateCost(){
    return price;
  }
}
class Car extends Vechicle{
  Car(String brand,String model,double price){
    super(brand,model,price);
  }
  @Override
  public double calculateCost(){
    return super.calculateCost()+2000;
  }
}
class Bike extends Vechicle{
   Bike(String brand,String model,double price){
    super(brand,model,price);
  }
  @Override
  public double calculateCost(){
    return super.calculateCost()+1000;
  }
}
class Truck extends Vechicle{
   Truck(String brand,String model,double price){
    super(brand,model,price);
  }
  @Override
  public double calculateCost(){
    return super.calculateCost()+5000;
  }
}
class VechicleManagementSystem{
  public static void main (String[] args) {
  Vechicle car=new Car("Ferrari","Ferrari F8",500000.0);
  Vechicle bike=new Bike("Yamaha","Yamaha r6",10000.0);
  Vechicle truck=new Truck("AshokLeyland","AshokLeyland Bada Dost i5",20000.0);
  
  car.displayDetails();
  System.out.println("Total Cost:" + car.calculateCost()+"\n");
  bike.displayDetails();
  System.out.println("Total Cost:" + bike.calculateCost()+"\n");
  truck.displayDetails();
  System.out.println("Total Cost:" + truck.calculateCost());
  }
}
