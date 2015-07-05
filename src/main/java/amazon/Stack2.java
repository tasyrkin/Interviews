package amazon;

public class Stack2 {
    int stackSize = 300;
    int indexUsed = 0;
    int[] stackPointer = {-1, -1, -1};
    StackNode[] buffer = new StackNode[stackSize * 3];

    void push(final int stackNum, final int value) {

        int lastIndex = stackPointer[stackNum];
        stackPointer[stackNum] = indexUsed;
        indexUsed++;
        buffer[stackPointer[stackNum]] = new StackNode(lastIndex, value);
    }

    int pop(final int stackNum) {
        int value = buffer[stackPointer[stackNum]].value;
        int lastIndex = stackPointer[stackNum];
        stackPointer[stackNum] = buffer[stackPointer[stackNum]].previous;
        buffer[lastIndex] = null;
        indexUsed--;
        return value;
    }

    int peek(final int stack) {
        return buffer[stackPointer[stack]].value;
    }

    boolean isEmpty(final int stackNum) {
        return stackPointer[stackNum] == -1;
    }

    class StackNode {
        public int previous;
        public int value;

        public StackNode(final int p, final int v) {
            value = v;
            previous = p;
        }
    }

    public static void main(final String[] args) {
        Stack2 stack2 = new Stack2();

        stack2.push(0, 1);
        stack2.push(1, 2);
        stack2.push(0, 3);

        System.out.println(stack2.pop(1));
        stack2.push(0, 4);
        System.out.println(stack2.pop(0));
        System.out.println(stack2.pop(0));
        System.out.println(stack2.pop(0));
    }
}
