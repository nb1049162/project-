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
        if (t == null || t.getTokenCLass() != type) {
            throw new RuntimeException("Expected " + type + " but got " + t);
        }
        pos++;
        return t;
    }

    public Node parse() {
        return parseExpr();
    }

    // Expr → Term ((PLUS | MINUS) Term)*
    private Node parseExpr() {
        Node left = parseTerm();

        while (true) {
            Token t = peek();
            if (t == null) break;

            if (t.getTokenCLass() == Token.Type.PLUS) {
                consume(Token.Type.PLUS);
                Node right = parseTerm();
                left = new BinaryOpNode("+", left, right);
            }
            else if (t.getTokenCLass() == Token.Type.MINUS) {
                consume(Token.Type.MINUS);
                Node right = parseTerm();
                left = new BinaryOpNode("-", left, right);
            }
            else break;
        }

        return left;
    }

    // Term → Factor ((MULTIPLY | DIVIDE) Factor)*
    private Node parseTerm() {
        Node left = parseFactor();

        while (true) {
            Token t = peek();
            if (t == null) break;

            if (t.getTokenCLass() == Token.Type.MULTIPLY) {
                consume(Token.Type.MULTIPLY);
                Node right = parseFactor();
                left = new BinaryOpNode("*", left, right);
            }
            else if (t.getTokenCLass() == Token.Type.DIVIDE) {
                consume(Token.Type.DIVIDE);
                Node right = parseFactor();
                left = new BinaryOpNode("/", left, right);
            }
            else break;
        }

        return left;
    }

    // Factor → NUMBER | LPAREN Expr RPAREN
    private Node parseFactor() {
        Token t = peek();

        if (t.getTokenCLass() == Token.Type.NUMBER) {
            consume(Token.Type.NUMBER);
            return new NumberNode(Double.parseDouble(t.getValue()));
        }

        if (t.getTokenCLass() == Token.Type.LPAREN) {
            consume(Token.Type.LPAREN);
            Node expr = parseExpr();
            consume(Token.Type.RPAREN);
            return expr;
        }

        throw new RuntimeException("Unexpected token: " + t);
    }
}
