public class Token{
   protected Type type;
   protected String value;

   public Token(Type c, String v){
   
      type = c;
      value = v;
   
   }

   public String toString(){
   
      return String.format("(%s %s)", this.type.name(), this.value);
   
   }

   public Type getTokenCLass(){
      return this.type;
   }

   public void setTokenCLass(Type c){
      this.type = c;
   
   }
   public String getValue(){
      return this.value;
   }

   public void setValue(String value){
      this.value = value;
   }

   public static enum Clas{
    NUMBER("-?[0-9]+"),
    PLUS("\\+"),
    MINUS("-"),
    DIVIDE("/"),
    MULTIPLY("\\*"),
    LPAREN("\\("),
    RPAREN("\\)");

      
      public String pattern;
      
      private Clas(String pattern){
         this.pattern = pattern;
      }
      
   }
   
   enum Type{NUMBER, PLUS, MINUS, DIVIDE, LPAREN, RPAREN, MULTIPLY}
   
  



}