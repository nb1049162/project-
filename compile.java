import java.util.Scanner;

public class compile{
//private String[] tokens;


   public static void main(String args[]){
      Scanner Input = new Scanner(System.in);
   
      System.out.println("Enter a problem");
   
      String problem = Input.nextLine();
   
      parser(problem);
   
   }

   static boolean parser(String p){
      System.out.println("your input was:"+ p +" right?");
      return true;
   
   
   }




}