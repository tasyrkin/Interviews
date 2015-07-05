package google;

import java.util.Arrays;

/**
 * @author  tasyrkin
 * @since   2013/09/01
 */
public class CountSort {
    public static void countSort(final int[] a) {
        if (a == null || a.length == 0) {
            return;
        }

        int max = Integer.MIN_VALUE;
        int[] b = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            if (max < a[i]) {
                max = a[i];
            }
        }

        int[] count = new int[max + 1];
        for (int i = 0; i < a.length; i++) {
            count[a[i]]++;
        }

        System.out.println("only counts = " + Arrays.toString(count));

        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        System.out.println("positions = " + Arrays.toString(count));

        for (int i = 0; i < b.length; i++) {
            b[--count[a[i]]] = a[i];
        }

        for (int i = 0; i < a.length; i++) {
            a[i] = b[i];
        }
    }

    public static void main(final String[] args) {
        int[] a = new int[] {5, 6, 4, 3, 2, 1, 10, 1, 1, 1, 1, 1, 1, 2, 3, 3, 3, 3, 3};
        countSort(a);
        System.out.println(Arrays.toString(a));
    }

}
