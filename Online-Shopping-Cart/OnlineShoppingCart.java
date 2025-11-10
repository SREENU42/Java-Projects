// 7. Online Shopping Cart

// Description: Simple e-commerce simulation with cart operations.
// Concepts Covered: Classes, Objects, Arrays/Lists, Encapsulation, Inheritance.
// Features:
// Add/remove products to cart.
// Calculate total bill.
// Different product types (Electronics, Clothing) using inheritance.

import java.util.ArrayList;

class Product{
  private String name;
  private double price;
  
  Product(String name,double price){
    this.name=name;
    this.price =price;
  }
  public String getName(){
    return name;
  }
  public double getPrice(){
    return price;
  }
     public void displayProduct() {
        System.out.println("Product: " + name + ", Price: ₹" + price);
    }
}
class Electronics extends Product{
  Electronics (String name,double price){
    super(name,price);
  }
}
class Clothing extends Product{
  Clothing(String name,double price){
    super(name,price);
  }
}
class Cart{
  private ArrayList<Product>items=new ArrayList<>();
  public void addProduct(Product p){
    items.add(p);
    System.out.println(p.getName()+"added to Cart");
  }
  public void removeProduct(String productName){
    for(Product p:items){
    if(p.getName().equalsIgnoreCase(productName)){
    items.remove(p);
    System.out.println(productName+"removed From Cart");
    return;
    }
  }
    System.out.println("Product not Found");
}
    public double calculateTotal() {
        double total = 0;
        for (Product p : items) {
            total += p.getPrice();
        }
        return total;
    }

    public void viewCart() {
        System.out.println("\n----- Items in Cart -----");
        for (Product p : items) {
            p.displayProduct();
        }
    }
}

public class OnlineShoppingCart {
    public static void main(String[] args) {

        Product laptop = new Electronics("MacBook Air M2", 120000.00);
        Product tshirt = new Clothing("Nike Sports T-Shirt", 2000.00);
        Product tv = new Electronics("Samsung Smart TV", 45000.00);

        Cart cart = new Cart();
        cart.addProduct(laptop);
        cart.addProduct(tshirt);
        cart.addProduct(tv);

        cart.viewCart();

        System.out.println("\nTotal Bill: ₹" + cart.calculateTotal());

        cart.removeProduct("Nike Sports T-Shirt");
        System.out.println("\nAfter Removing:");
        cart.viewCart();

        System.out.println("Updated Total Bill: ₹" + cart.calculateTotal());
    }
}