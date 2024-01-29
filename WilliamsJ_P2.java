/* 
Coding Homework Two: Number Game
Name: James Williams
*/
import java.util.Scanner;
import java.util.Random;
public class WilliamsJ_P2 {
   
   public static void main(String[] args) { 
      
      Scanner keyboard = new Scanner(System.in);
      Random r = new Random();
      
      //Section 1 game prompt
      
      System.out.println("Let's play a number guessing game!");
      
      //Section 2 range input
      
      System.out.println("Enter an integer");
      int num1 = keyboard.nextInt();
      System.out.println("Enter a different integer");
      int num2 = keyboard.nextInt();
      while(num1 == num2)
      {
         System.out.println("This number must be different from the first, please reenter");   
         num2 = keyboard.nextInt();
      }
      
      int smallest = num1 < num2 ? num1 : num2; 
      int largest = num1 < num2 ? num2 : num1;    
      int range = -1;
      
      if(smallest < 0 && largest < 0) 
      {
         range = Math.abs(smallest) - Math.abs(largest);     
            
      }     
      else if(smallest > 0 && largest > 0)
      {
         range = largest - smallest + 1;  
      }
      else if(smallest < 0 && largest > 0)
      {
         range = (Math.abs(smallest) + largest) +1;  
      }
      //Section 3 choosing a random number 
      
      int target = r.nextInt(range + 1) + smallest; 
      System.out.println("I've choosen a random number in the range you've specified");
      System.out.printf("\nThere are %d numbers to choose from, between and including %d and %d",range,smallest,largest);
      
      //Section 4 the first guess and it uses a nested if.
      
      System.out.printf("\nGuess a whole number between and including %d and %d: ",smallest,largest);
      int guess = keyboard.nextInt();
      if(guess == target)
      {
         System.out.printf("\n%d is correct",guess);
      }   
      /*
      if(){
          if{   
          }
          }      nested. 
     
      else if() { 
         } not nested
      
      else {
         if() { 
         }
         } nested? 
      */
      
      
      else 
         if(guess > target)
      {
         System.out.printf("\n%d is too large",guess);
         largest = guess - 1;
      }
      else
      {
         System.out.printf("\n%d is too small",guess);
         smallest = guess + 1;
      }
      
      //Section 5 Second guess without nested if
      System.out.printf("\nGuess a whole number between and including %d and %d: ",smallest,largest);
      guess = keyboard.nextInt();
      if(guess == target)
      {
         System.out.printf("\n%d is correct",guess);
      }
      else if(guess > target)
      {
         System.out.printf("\n%d is too large",guess);
         largest = guess - 1;
      }
      else
      {
         System.out.printf("\n%d is too small",guess);
         smallest = guess + 1;
      }
      
      //Section 6 third guess using conditonal operators
      System.out.printf("\nGuess a whole number between and including %d and %d: ",smallest,largest);
      guess = keyboard.nextInt();
      if(guess == target)
      {
         System.out.printf("\n%d is correct",guess);
         return;
      }
      String direction = guess > target ? "large" : "small";
      largest = guess > target ? guess - 1 : largest;
      smallest = guess < target ? guess + 1 : smallest; 
      System.out.printf("\n%d is too %s",guess, direction);
         
      //Section 7 fourth guess using a switch statement 
      System.out.printf("\nGuess a whole number between and including %d and %d: ",smallest,largest);
      guess = keyboard.nextInt();
      int offBy;
      if(guess < target)
      {
         offBy = -1;
      }
      else if(guess > target)
      {
         offBy = 1; 
      }
      else
      {
         offBy = 0;
      }
      switch(offBy) {
      
         case -1:
            System.out.println(guess + " is too small. the number was " + target);
            break;
         case 1:
            System.out.println(guess + " is too large. the number was " + target);
            break;
         case 0: 
            System.out.println(guess + " is correct!!");
      }
              
   }
            
}
            
      
      
      
