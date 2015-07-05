package amazon;

import static org.hamcrest.MatcherAssert.assertThat;

import static org.hamcrest.Matchers.is;

/*
 * Given 2 arrays.Imagine you are making bst from each array.u need to tell whether 2 bsts will be identical or not
 * without actually constructing the tree.
 * Ex:
 * 2 3 1
 * 2 1 3
 * will construct the same tree
 * A1[]={2,1,3}
 * 2
 * 1 3
 *
 * A2[]={2,3,1}
 * 2
 * 1 3
 */
public class CompareArraysAsBST {

    public static boolean areBSTEqual(final int[] a, final int[] b) {

        if (a == null || b == null) {
            return false;
        }

        return areBSTEqual(a, 0, a.length - 1, b, 0, b.length - 1);
    }

    /**
     * Returns true if 2 arrays are BST equal from index start to index end inclusive.
     */
    private static boolean areBSTEqual(final int[] firstArr, final int firstStart, final int firstEnd,
            final int[] secondArr, final int secondStart, final int secondEnd) {

        // indexes have to be always the same for both arrays
        if (firstStart != secondStart || firstEnd != secondEnd) {
            return false;
        }

        // if we are outside of the array then ok
        if (firstStart >= firstArr.length && secondStart >= secondArr.length) {
            return true;
        }

        if (firstStart > firstEnd || secondStart > secondEnd) {
            return true;
        }

        // if first elements of the array are not the same then arrays are not BST same
        if (firstArr[firstStart] != secondArr[secondStart]) {
            return false;
        }

        int firstBorder = partition(firstArr, firstStart, firstEnd);
        int secondBorder = partition(secondArr, secondStart, secondEnd);

        // recursive invocation on 2 pieces of an array exclusive the first one (we checked it already)
        boolean areEqualLeft = areBSTEqual(firstArr, firstStart + 1, firstBorder - 1, secondArr, secondStart + 1,
                secondBorder - 1);
        boolean areEqualRight = areBSTEqual(firstArr, firstBorder, firstEnd, secondArr, secondBorder, secondEnd);

        return areEqualLeft && areEqualRight;
    }

    /**
     * Sorts an array in qsort way but elements' order is presumed. Returns an index of the first element that is *bigger
     * * than a[begin]
     */
    private static int partition(final int[] a, final int start, final int end) {

        // loop invariant: res is always pointing to the first element *bigger* than a[begin]
        int res = start + 1;
        for (int i = start + 1; i <= end; i++) {

            // if found an element that is less than a[begin] then circularly shift the sub array of elements
            // example: 4 1 3 5 8 2 7, res = 3 (a[res] = 5), i = 5 (a[i] = 2) -> shift the sub array {5 8 2} -> {2 5 8}
            // so that array becomes 4 1 3 2 5 8 7 and res = 6 (a[res] = 5)
            if (a[i] <= a[start]) {
                swapWithShift(a, res, i);
                ++res;
            }
        }

        return res;
    }

    private static void swapWithShift(final int[] a, final int start, final int end) {
        int tmp = a[end];
        for (int i = start; i <= end; i++) {
            int tmp2 = a[i];
            a[i] = tmp;
            tmp = tmp2;
        }
    }

    public static void main(final String[] args) {

        assertThat("", areBSTEqual(new int[] {2, 1, 3}, new int[] {2, 3, 1}), is(true));
        assertThat("", areBSTEqual(new int[] {5, 1, 3, 4, 8, 7, 6}, new int[] {5, 8, 1, 3, 7, 6, 4}), is(true));
        assertThat("", areBSTEqual(new int[] {3, 2, 3}, new int[] {2, 3, 1}), is(false));
        assertThat("", areBSTEqual(new int[] {2, 1, 3, 5}, new int[] {2, 3, 1}), is(false));
        assertThat("", areBSTEqual(new int[] {4, 2, 3, 1, 7}, new int[] {4, 2, 1, 3, 7}), is(true));
        assertThat("", areBSTEqual(new int[] {}, new int[] {}), is(true));
        assertThat("",
            areBSTEqual(new int[] {8, 2, 0, 4, 1, 3, 6, 5, 7, 14, 11, 9, 13, 20, 16, 22},
                new int[] {8, 14, 20, 22, 16, 11, 13, 9, 2, 4, 6, 7, 5, 3, 0, 1}), is(true));
        assertThat("", areBSTEqual(null, null), is(false));
    }
}
