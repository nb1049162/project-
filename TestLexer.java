import java.util.ArrayList;

public class TestLexer {
    public static void main(String[] args) {
        String input = "5 + 10 * - (3 / 2)";
        ArrayList<Token> tokens = lexerHolder.lexer(input);

        for (Token t : tokens) {
            System.out.println(t);
        }
    }
}

