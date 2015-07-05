package amazon;

/**
 * @author  tasyrkin
 * @since   2013/07/01
 */
public class TreeUtil {

    public static class Node {
        int value;
        Node parent;
        Node left;
        Node right;

        public String toString() {
            StringBuilder sb = new StringBuilder();

            if (left != null) {
                sb.append("{");
                sb.append(left);
                sb.append("}");
            }

            sb.append(value);

            if (right != null) {
                sb.append("{");
                sb.append(right);
                sb.append("}");
            }

            return sb.toString();
        }

        public Node(final Node parent, final int value) {
            this.parent = parent;
            this.value = value;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(final Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(final Node right) {
            this.right = right;
        }
    }

    public static Node buildTree(final int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }

        int idx = (arr.length - 1) / 2;
        Node parent = new Node(null, arr[idx]);

        Node left = buildTree(parent, arr, 0, idx - 1);
        parent.setLeft(left);

        Node right = buildTree(parent, arr, idx + 1, arr.length - 1);
        parent.setRight(right);

        return parent;
    }

    private static Node buildTree(final Node parent, final int[] arr, final int start, final int end) {
        if (start > end) {
            return null;
        } else if (start == end) {
            return new Node(parent, arr[start]);
        }

        int idx = (end + start) / 2;

        Node localParent = new Node(parent, arr[idx]);

        Node left = buildTree(localParent, arr, start, idx - 1);
        localParent.setLeft(left);

        Node right = buildTree(localParent, arr, idx + 1, end);
        localParent.setRight(right);

        return localParent;
    }

    public static void main(final String[] args) {

        Node parent = buildTree(new int[] {1, 2, 3, 4});
        System.out.println(parent);
    }
}
