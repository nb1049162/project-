public class BinaryOpNode implements Node {
    String op;
    Node left, right;

    BinaryOpNode(String op, Node left, Node right) {
        this.op = op;
        this.left = left;
        this.right = right;
    }

    
    public double evaluate() {   // ← MUST be public
        double l = left.evaluate();
        double r = right.evaluate();

        return switch (op) {
            case "+" -> l + r;
            case "-" -> l - r;
            case "*" -> l * r;
            case "/" -> l / r;
            default -> throw new RuntimeException("Unknown operator: " + op);
        };
    }

    
    public void printTree(String indent) {
        System.out.println(indent + "Op(" + op + ")");
        left.printTree(indent + "  ");
        right.printTree(indent + "  ");
    }    public String toString() {
    return "BinaryOp(" + op + ", " + left + ", " + right + ")";
}

}