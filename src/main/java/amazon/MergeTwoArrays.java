package amazon;

import java.util.Arrays;

/**
 * @author  tasyrkin
 * @since   2013/08/24
 */
public class MergeTwoArrays {

    public static void merge(final int[] a, final int[] b) {

        if (a == null || b == null || a.length - b.length < 0) {
            return;
        }

        int lenA = a.length - b.length;

        int idxA = lenA - 1;
        int idxB = b.length - 1;
        int idxNew = a.length - 1;

        while (idxA >= 0 || idxB >= 0) {
            if (idxA >= 0 && idxB >= 0) {
                if (a[idxA] > b[idxB]) {
                    a[idxNew--] = a[idxA--];
                } else {
                    a[idxNew--] = b[idxB--];
                }
            } else if (idxA >= 0) {
                a[idxNew--] = a[idxA--];
            } else {
                a[idxNew--] = b[idxB--];
            }
        }

    }

    public static void main(final String[] args) {

        int[] a = new int[] {1, 2, 3, 4, -1, -1};
        int[] b = new int[] {100, 400};
        merge(a, b);

        System.out.println(Arrays.toString(a));

    }

}
