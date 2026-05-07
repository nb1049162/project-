import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;


public class compiler{

   public static void main(String args[]){
      Scanner Input = new Scanner(System.in);
   
      System.out.println("Enter a problem");
   
      String problem = Input.nextLine();
   
      ArrayList<Token> tokens = lexer.lex(problem);
     

      Parser p = new Parser(tokens);
      Node result = p.parse();
      System.out.println("Tokens:"+tokens );
      if (result != null) {
      result.printTree("");
      double re = result.evaluate();
      System.out.println("result: "+re);

      }


   }
   }
