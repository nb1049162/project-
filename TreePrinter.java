public class TreePrinter {
     public static void print(Node node) {
        print(node, 0);
    }

    private static void print(Node node, int indent) {
        String pad = " ".repeat(indent);

        if (node instanceof NumberNode n) {
            System.out.println(pad + "Number(" + n.value + ")");
        }
        else if (node instanceof BinaryOpNode b) {
            System.out.println(pad + "Op(" + b.op + ")");
            print(b.left, indent + 2);
            print(b.right, indent + 2);
        }
    }
}