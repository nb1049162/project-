import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class lexerHolder {
    public static ArrayList<Token> lexer(String input) {
        ArrayList<Token> tokens = new ArrayList<Token>();
        StringBuffer tokenPatternsBuffer = new StringBuffer();
        //this just searches through all the classes and values
        for (Token.Clas tokenClas : Token.Clas.values()) {
            tokenPatternsBuffer.append(String.format("|(?<%s>%s)", tokenClas.name(), tokenClas.pattern));
        }
        
        Pattern tokenPatterns = Pattern.compile(tokenPatternsBuffer.substring(1));
        Matcher matcher = tokenPatterns.matcher(input);
        
        while (matcher.find()) {
            // group() calls litterally just the way to add the tokens to thier respective groups 
            // if we want to add more token types add it to both this and the tokens enum
            if (matcher.group(Token.Clas.NUMBER.name()) != null) {
                tokens.add(new Token(Token.Type.NUMBER, matcher.group(Token.Clas.NUMBER.name())));
            } 
            else if (matcher.group(Token.Clas.PLUS.name()) != null) {
                tokens.add(new Token(Token.Type.PLUS, matcher.group(Token.Clas.PLUS.name())));
            } 
            else if (matcher.group(Token.Clas.MINUS.name()) != null) {
                tokens.add(new Token(Token.Type.MINUS, matcher.group(Token.Clas.MINUS.name())));
            } 
            else if (matcher.group(Token.Clas.DIVIDE.name()) != null) {
                tokens.add(new Token(Token.Type.DIVIDE, matcher.group(Token.Clas.DIVIDE.name())));
            } 
            else if (matcher.group(Token.Clas.LPAREN.name()) != null) {
                tokens.add(new Token(Token.Type.LPAREN, matcher.group(Token.Clas.LPAREN.name())));
            } 
            else if (matcher.group(Token.Clas.RPAREN.name()) != null) {
                tokens.add(new Token(Token.Type.RPAREN, matcher.group(Token.Clas.RPAREN.name())));
            }
            else if (matcher.group(Token.Clas.MULTIPLY.name()) != null) {
                tokens.add(new Token(Token.Type.MULTIPLY, matcher.group(Token.Clas.MULTIPLY.name())));
            }
 
        }
        //print the tokens

        return tokens;
    }
}