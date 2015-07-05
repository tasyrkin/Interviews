package amazon;

/**
 * Stack as a linked list.
 */
class Stack3 {
    Node top;

    Object pop() {
        if (top != null) {
            Object item = top.data;
            top = top.next;
            return item;
        }

        return null;
    }

    void push(final Object item) {
        Node t = new Node(item);
        t.next = top;
        top = t;
    }

    private class Node {

        Object data;
        Node next;

        Node(final Object item) {
            data = item;
        }
    }

    public static void main(final String[] args) {
        Stack3 stack = new Stack3();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
