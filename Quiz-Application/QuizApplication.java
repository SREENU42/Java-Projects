// 9. Quiz Application

// Description: Simple console quiz game with questions and score calculation.
// Concepts Covered: Classes, Objects, Encapsulation, Polymorphism (overloaded methods for scoring).
// Features:
// Store questions and answers.
// Take user input for answers.
// Calculate score and show results.
// Extend to multiple categories using inheritance.

import java.util.ArrayList;
import java.util.Scanner;


class Question {
  private String questionText;
  private String[] options;
  private int correctAnswers;
  
  Question(String questionText,String []options,int correctAnswers){
    this.questionText=questionText;
    this.options=options;
    this.correctAnswers=correctAnswers;
  }
  public int askQuestion(){
    System.out.println("\n"+ questionText);
    for(int i=0;i<options.length;i++){
      System.out.println((i+1)+"."+options[i]);
    }
    System.out.println("Your Answer: ");
    return correctAnswers;
  }
}
class Quiz{
  private int score=0;
  private ArrayList<Question> questions=new ArrayList<>();
  
  public void addQuestion(Question q){
    questions.add(q);
  }
  public void startQuiz(){
    Scanner sc=new Scanner(System.in);
    
    for(Question q:questions){
      int correctAnswer=q.askQuestion();
      int userAnswer=sc.nextInt();
      
      if(userAnswer==correctAnswer){
        increaseScore();
      }
    }
    System.out.println("\n Quiz completed..!");
    System.out.println("Your Final Score: "+score+"/"+questions);
  }
  
  public void increaseScore(){
    score+=1;
  }
  public void increaseScore(int bonusPoints){
    score +=bonusPoints;
  }
}
class CategoryQuiz extends Quiz{
  private String categoryName;
  
  CategoryQuiz(String categoryName){
    this.categoryName=categoryName;
    System.out.print("\n Category: "+categoryName);
  }
}

public class QuizApplication{
  public static void main (String[] args) {
    CategoryQuiz quiz=new CategoryQuiz("Java Basics");
    
    quiz.addQuestion(new Question("Which keyword is used to inherit a class in java?",
    new String[]{"super","this","extends","implements"},3));
    quiz.addQuestion(new Question ("Which of these is not Java Oops Concept?",
    new String[]{"inheritance","Abstraction","Compilation","Encapsulation"},3));
     quiz.addQuestion(new Question( "Which method runs when program starts?",
    new String[]{"print()", "main()", "start()", "execute()"},2));
    quiz.startQuiz();
  }
}