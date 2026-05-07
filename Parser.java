import java.util.ArrayList;

public class Parser {
    private ArrayList<Token> tokens;
    private int pos = 0;

    public Parser(ArrayList<Token> tokens) {
        this.tokens = tokens;
    }

    private Token peek() {
        return pos < tokens.size() ? tokens.get(pos) : null;
    }

    private Token consume(Token.Type type) {
        Token t = peek();
        if (t == null) {
            throw error("Unexpected end of input. Expected: " + type);
        }
        if (t.getTokenCLass() != type) {
            throw error("Expected " + type + " but got " + t.getTokenCLass());
        }
        pos++;
        return t;
    }

    private RuntimeException error(String message) {
        Token t = peek();
        String location = (t == null)
                ? "at end of input"
                : "at token '" + t.getValue() + "' (type " + t.getTokenCLass() + ")";

        return new RuntimeException("Parse error " + location + ": " + message);
    }
    
    // this is where all of the error handeling is 
    public Node parse() {
        try {
        Node result = parseExpr();

        // If there are leftover tokens, that's an error
        if (peek() != null) {
            throw new RuntimeException("Unexpected extra tokens after valid expression");
        }

        System.out.println("Parsing successful!");
        return result;

    } catch (RuntimeException e) {
        System.out.println("Parsing failed!");
        System.out.println("Reason: " + e.getMessage());
        return null;
    }    
    }

    // Expr → Term ((PLUS | MINUS) Term)*
    private Node parseExpr() {
        Node left = parseTerm();

        while (true) {
            Token t = peek();
            if (t == null) break;

            switch (t.getTokenCLass()) {
                case PLUS:
                    consume(Token.Type.PLUS);
                    left = new BinaryOpNode("+", left, parseTerm());
                    break;

                case MINUS:
                    consume(Token.Type.MINUS);
                    left = new BinaryOpNode("-", left, parseTerm());
                    break;

                default:
                    return left;
            }
        }

        return left;
    }

    // Term → Factor ((MULTIPLY | DIVIDE) Factor)*
    private Node parseTerm() {
        Node left = parseFactor();

        while (true) {
            Token t = peek();
            if (t == null) break;

            switch (t.getTokenCLass()) {
                case MULTIPLY:
                    consume(Token.Type.MULTIPLY);
                    left = new BinaryOpNode("*", left, parseFactor());
                    break;

                case DIVIDE:
                    consume(Token.Type.DIVIDE);
                    left = new BinaryOpNode("/", left, parseFactor());
                    break;

                default:
                    return left;
            }
        }

        return left;
    }

    // Factor → NUMBER | LPAREN Expr RPAREN
    private Node parseFactor() {
        Token t = peek();

        if (t == null) {
            throw error("Unexpected end of input while parsing a factor");
        }

        switch (t.getTokenCLass()) {
            case NUMBER:
                consume(Token.Type.NUMBER);
                return new NumberNode(Double.parseDouble(t.getValue()));

            case LPAREN:
                consume(Token.Type.LPAREN);
                Node expr = parseExpr();
                if (peek() == null || peek().getTokenCLass() != Token.Type.RPAREN) {
                    throw error("Missing closing parenthesis ')'");
                }
                consume(Token.Type.RPAREN);
                return expr;

            default:
                throw error("Unexpected token in factor: " + t.getTokenCLass());
        }
    }
}



