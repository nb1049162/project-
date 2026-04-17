public class NumberNode implements Node {
    double value;

    NumberNode(double value) {
        this.value = value;
    }

    @Override
    public double evaluate() {   // ← MUST be public
        return value;
    }

    @Override
    public void printTree(String indent) {
        System.out.println(indent + "Number(" + value + ")");
    }
    
    public String toString() {
    return "Number(" + value + ")";
}

}