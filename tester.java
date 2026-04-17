import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;


public class tester{

   public static void main(String args[]){
      Scanner Input = new Scanner(System.in);
   
      System.out.println("Enter a problem");
   
      String problem = Input.nextLine();
   
      ArrayList<Token> tokens = lexerHolder.lexer(problem);
     
     try {
            Parser p = new Parser(tokens);
            Node result = p.parse();
            System.out.println("Parse: success");
            System.out.println("Parse Tree:");
            result.printTree("");
            double value = result.evaluate();
            System.out.println("Evaluation Result: " + value);
        } catch (RuntimeException e) {
            System.out.println("Parse: failure - " + e.getMessage());
        }

   
   }

   }