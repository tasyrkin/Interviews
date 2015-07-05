package google;

import java.util.Arrays;

/**
 * @author  tasyrkin
 * @since   2013/08/31
 */
public class InsertionSort {
    public static void insertionSort(final int[] a) {
        if (a == null) {
            return;
        }

        for (int i = 1; i < a.length; i++) {
            int j = i - 1;
            int tmp = a[i];
            while (j >= 0 && a[j] > tmp) {
                a[j + 1] = a[j];
                j--;
            }

            a[j + 1] = tmp;
        }
    }

    public static void main(final String[] args) {
        int[] a = new int[] {3, 11, 1, 2, 6, 78, 4, -1};
        insertionSort(a);
        System.out.println(Arrays.toString(a));
    }
}
