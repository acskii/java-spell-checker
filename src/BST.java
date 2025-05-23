public interface BST {
    static Node insertToBST(Node root, String value) {
        if (root == null) {
            return new Node(value);
        }
        if (value.compareTo(root.val) < 0) {
            root.left = insertToBST(root.left, value);
        }
        if (value.compareTo(root.val) > 0) {
            root.right = insertToBST(root.right, value);
        }
        return root;
    }

    static int heightBST(Node root) {
        if (root == null) { return -1; }
        return 1 + Math.max(heightBST(root.left), heightBST(root.right));
    }

    static Node getMinimumNode(Node root) {
        if (root == null || root.left == null) { return root; }
        return getMinimumNode(root.left);
    }

    static Node getMaximumNode(Node root) {
        if (root == null || root.right == null) { return root; }
        return getMinimumNode(root.right);
    }

    static Node getSuccessor(Node root, Node current) {
        if (current == null) { return null; }
        if (current.right != null) {
            return getMinimumNode(current.right);
        } else {
            Node succ = null;
            Node curr = root;

            while (curr != null) {
                if (current.val.compareTo(curr.val) < 0) {
                    succ = curr;
                    curr = curr.left;
                } else {
                    curr = curr.right;
                }
            }

            return succ;
        }
    }

    static Node getPredecessor(Node root, Node current) {
        if (current == null) { return null; }
        if (current.left != null) {
            return getMaximumNode(current.left);
        } else {
            Node pred = null;
            Node curr = root;

            while (curr != null) {
                if (current.val.compareTo(curr.val) > 0) {
                    pred = curr;
                    curr = curr.right;
                } else {
                    curr = curr.left;
                }
            }

            return pred;
        }
    }

    static Node searchBST(Node root, Node previous, String value) {
        if (root == null) { return previous; }
        if (value.equalsIgnoreCase(root.val)) {
            return root;
        } else if (value.compareTo(root.val) < 0) {
            return searchBST(root.left, root, value);
        } else {
            return searchBST(root.right, root, value);
        }
    }
}
