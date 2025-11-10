// 1. Student Management System

// Description:
// A console-based system to add, update, delete, and display student details (name, roll number, marks).
//Can also calculate grades and show top performers.
// Concepts Covered:
// Classes and Objects
// Encapsulation (private fields + getters/setters)
// Inheritance (e.g., Undergraduate, Postgraduate classes)
// Polymorphism (method overriding for grade calculation)
// Why Interview-Ready: Shows understanding of OOP principles and CRUD operations.


class Student{
  private String name;
  private String rollNumber;
  private int marks;
  
  public Student(String name,String rollNumber,int marks){
    this.name=name;
    this.rollNumber=rollNumber;
    if(marks>0&& marks<=100){
      this.marks=marks;
    }else{
      System.out.println("fail");
      this.marks=0;
    }
  }
  public String getName(){
    return name;
  }
  public String getRollNumber(){
    return rollNumber;
  }
  public int getMarks(){
    return marks;
  }
  public void setName(String name){
    this.name=name;
  }
  public void setRollNumber(String rollNumber){
    this .rollNumber=rollNumber;
  }
  public void setMarks(int marks){
    this .marks=marks;
  }
  public String gradeCalculation(){
   if(marks>=80) return "A";
   else if(marks>=60) return "B";
   else if(marks>=40) return "C";
   else if (marks>=30) return "D";
   else return "fail";
  }
  public void displayStudentDetails() {
        System.out.println("==============Student==============");
        System.out.println("Name: " + name);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Marks: " + marks);
        System.out.println("Grade: " + gradeCalculation());
    }
}


  class Undergraduate extends Student{
    public Undergraduate(String name,String rollNumber,int marks){
      super(name,rollNumber,marks);
    }
  }

  
  class Postgraduate extends Student{
    public Postgraduate(String name,String rollNumber,int marks){
      super(name,rollNumber,marks);
  }
}



class StudentGradeSystem{
  public static void main (String[] args) {
    Student s1=new Undergraduate("Sreenu","2211A",99);
    Student s2=new Postgraduate("Ibhram","2211AB",96);
    
    s1.displayStudentDetails();
    s2.displayStudentDetails();
    
    
    System.out.println("Name:"+s1.getName());
    System.out.println("Name:"+s2.getName());
  }
}