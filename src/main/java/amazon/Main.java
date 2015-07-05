package amazon;

/**
 * @author  tasyrkin
 * @since   2013/08/26
 */
public class Main {

    private static class Node {
        Node next;
        int val;

        public Node(final Node next, final int val) {
            this.next = next;
            this.val = val;
        }
    }

    public static void main(final String[] args) {

        int cnt = 6;
        Node h = new Node(null, cnt--);
        // h = new Node(h, cnt--);
        // h = new Node(h, cnt--);
        // h = new Node(h, cnt--);
        // h = new Node(h, cnt--);

        Node h2 = h;
        h = new Node(h, cnt--);

        print(h);

        reverse(h);

        print(h2);

    }

    static void print(Node head) {
        while (head != null) {
            System.out.print(" " + head.val);
            head = head.next;

        }

        System.out.println();
    }

    static int reverse(final Node head) {
        Node n1 = head;
        while (n1 != null && n1.next != null) {
            Node n2 = n1.next;
            Node n3 = n1.next.next;

            n1.next = n3;
            n2.next = n1;

            if (n3 != null && n3.next != null) {
                n1.next = n3.next;
            }

            n1 = n3;
        }

        return 0;
    }
}
