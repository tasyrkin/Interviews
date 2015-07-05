package amazon;

/**
 * @author  tasyrkin
 * @since   2013/06/26
 */
public class QueueWithStacks<T> {
    private java.util.Stack<T> popStack = new java.util.Stack<T>();
    private java.util.Stack<T> pushStack = new java.util.Stack<T>();

    public void enqueue(final T data) {
        if (!popStack.isEmpty()) {
            while (!popStack.isEmpty()) {
                T cdata = popStack.pop();
                pushStack.push(cdata);
            }
        }

        pushStack.push(data);
    }

    public T dequeue() {
        if (!pushStack.isEmpty()) {
            while (!pushStack.isEmpty()) {
                T cdata = pushStack.pop();
                popStack.push(cdata);
            }
        }

        return popStack.pop();
    }

    public static void main(final String[] args) {
        QueueWithStacks<Integer> queueWithStacks = new QueueWithStacks<Integer>();

        queueWithStacks.enqueue(10);
        queueWithStacks.enqueue(20);
        queueWithStacks.enqueue(30);

        System.out.println(queueWithStacks.dequeue());
        System.out.println(queueWithStacks.dequeue());
        queueWithStacks.enqueue(1000);
        System.out.println(queueWithStacks.dequeue());
        System.out.println(queueWithStacks.dequeue());
    }
}
