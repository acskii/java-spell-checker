public class Node {
    Node left;
    Node right;
    String val;
    int height;

    Node(String value) {
        this.left = this.right = null;
        this.height = 1;
        this.val = value;
    }

    public int getHeight() {
        return this.height;
    }

    @Override
    public String toString() {
        return String.format("Node(%s)", this.val);
    }
}
