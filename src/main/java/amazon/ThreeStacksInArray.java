package amazon;

import com.google.common.base.Preconditions;

/**
 * Implement 3 stacks of 90 elements in total using array with 100 elements.
 */
public class ThreeStacksInArray {

    private static final int SHIFT = 93;
    private int[] st = new int[100];

    public ThreeStacksInArray() {
        setTop(1, 30);
        setBot(1, 30);
        setTop(2, 92);
        setBot(2, 92);
    }

    private int getTop(final int idx) {
        return SHIFT + idx * 2 + 1;
    }

    private void setTop(final int idx, final int value) {
        st[SHIFT + idx * 2 + 1] = value;
    }

    private int getBot(final int idx) {
        return SHIFT + idx * 2;
    }

    private void setBot(final int idx, final int value) {
        st[SHIFT + idx * 2] = value;
    }

    private void incTop(final int idx) {
        int topIdx = getTop(idx);
        if (idx == 0 || idx == 1) {
            setTop(idx, st[topIdx] + 1);
        } else {
            setTop(idx, st[topIdx] - 1);
        }
    }

    private void decTop(final int idx) {
        int topIdx = getTop(idx);
        if (idx == 0 || idx == 1) {
            setTop(idx, st[topIdx] - 1);
        } else {
            setTop(idx, st[topIdx] + 1);
        }
    }

    public void push(final int idx, final int value) {
        Preconditions.checkArgument(idx >= 0 && idx < 3, "Wrong idx");

        if (idx == 0) {
            int topLeft = getTop(0);
            int botMid = getBot(1);
            if (st[topLeft] + 1 >= st[botMid]) {
                shiftMiddleRightOrFail();
            }

            st[st[topLeft]] = value;
            incTop(idx);
        } else if (idx == 1) {
            int topMid = getTop(1);
            int topRight = getTop(2);
            if (st[topMid] + 1 >= st[topRight]) {
                shiftMiddleLeftOrFail();
                topMid = getTop(1);
            }

            st[st[topMid]] = value;
            incTop(idx);
        } else if (idx == 2) {
            int topRight = getTop(2);
            int topMid = getTop(1);
            if (st[topRight] - 1 <= st[topMid]) {
                shiftMiddleLeftOrFail();
            }

            st[st[topRight]] = value;
            incTop(idx);
        }
    }

    public int pop(final int idx) {
        Preconditions.checkArgument(idx >= 0 && idx < 3, "Wrong idx");

        int top = getTop(idx);
        int bot = getBot(idx);
        if (st[top] == st[bot]) {
            throw new IllegalStateException(String.format("Stack [%s] is empty", idx));
        }

        if (idx == 0 || idx == 1) {
            int val = st[st[top] - 1];
            decTop(idx);
            return val;
        }

        int val = st[st[top] + 1];
        decTop(idx);
        return val;
    }

    private void shiftMiddleLeftOrFail() {
        int topMid = getTop(1);
        int botMid = getBot(1);
        int topLeft = getTop(0);
        if (st[topLeft] >= st[botMid] - 1) {
            throw new IllegalStateException("Can't move middle to the left");
        }

        for (int i = st[botMid]; i < st[topMid]; i++) {
            st[i - 1] = st[i];
        }

        setTop(1, st[topMid] - 1);
        setBot(1, st[botMid] - 1);
    }

    private void shiftMiddleRightOrFail() {
        int topMid = getTop(1);
        int botMid = getBot(1);
        int topRight = getTop(2);
        if (st[topRight] <= st[topMid] + 1) {
            throw new IllegalStateException("Can't move middle to the right");
        }

        for (int i = st[topMid] - 1; i >= st[botMid]; i++) {
            st[i + 1] = st[i];
        }

        setTop(1, st[topMid] + 1);
        setBot(1, st[botMid] + 1);
    }

}
