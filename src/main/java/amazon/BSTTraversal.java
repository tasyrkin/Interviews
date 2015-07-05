package amazon;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * @author  tasyrkin
 * @since   2014/01/27
 */
public class BSTTraversal {

    private static class Node {
        int data;
        Node left;
        Node right;

        public Node(final int data, final Node left, final Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static void traverse(final Node root) {
        if (root == null) {
            return;
        }

        Stack<Node> stack = new Stack<Node>();
        stack.push(root);

        Set<Node> visited = new HashSet<Node>();
        while (!stack.isEmpty()) {
            Node curr = stack.peek();
            if (curr.left != null) {
                if (!visited.contains(curr.left)) {
                    stack.push(curr.left);
                    continue;
                } else {
                    stack.pop();
                    System.out.print(curr.data + " ");
                    visited.add(curr);
                }
            } else {
                stack.pop();
                System.out.print(curr.data + " ");
                visited.add(curr);
            }

            if (curr.right != null) {
                if (!visited.contains(curr.right)) {
                    stack.push(curr.right);
                    continue;
                }
            }
        }
    }

    public static Node buildBSTTree(final int[] a) {
        Arrays.sort(a);

        int mid = (a.length - 1) >>> 1;
        Node root = new Node(a[mid], null, null);
        buildBSTTree(a, 0, mid - 1, root);
        buildBSTTree(a, mid + 1, a.length - 1, root);

        return root;
    }

    public static void buildBSTTree(final int[] a, final int l, final int r, final Node n) {
        if (l > r) {
            return;
        }

        int mid = (r + l) >>> 1;
        Node newNode = new Node(a[mid], null, null);
        if (a[mid] <= n.data) {
            n.left = newNode;
        } else {
            n.right = newNode;
        }

        buildBSTTree(a, l, mid - 1, newNode);
        buildBSTTree(a, mid + 1, r, newNode);
    }

    public static void main(final String[] args) {

        Node root = buildBSTTree(new int[] {1, 2, 34, 5, 6, 7, 8, 4});

        // traverse2(root);
        traverse(root);
    }

    public static void traverse2(final Node root) {
        if (root.left != null) {
            traverse2(root.left);
        }

        System.out.print(root.data + " ");
        if (root.right != null) {
            traverse2(root.right);
        }
    }
}
