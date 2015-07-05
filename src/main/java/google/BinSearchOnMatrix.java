package google;

/**
 * @author  tasyrkin
 * @since   2013/08/24
 */
public class BinSearchOnMatrix {

    private static class Pair {
        int x;
        int y;

        public Pair(final int ix, final int iy) {
            x = ix;
            y = iy;
        }

        @Override
        public String toString() {
            return x + " " + y;
        }
    }

    static Pair find(final int[][] arr, final int key) {
        if (arr == null || arr.length == 0) {
            return null;
        }

        int st = 0;
        int end = arr.length - 1;
        while (st <= end) {
            int mid = (st + end) / 2;
            if (arr[mid][0] < key) {
                int foundIdx = binSearch(arr[mid], key);
                if (foundIdx >= 0) {
                    return new Pair(mid, foundIdx);
                }

                st = mid + 1;
            } else if (arr[mid][0] > key) {
                end = mid - 1;
            } else {
                return new Pair(mid, 0);
            }
        }

        return null;
    }

    private static int binSearch(final int[] arr, final int key) {

        if (arr == null || arr.length == 0) {
            return -1;
        }

        int st = 0;
        int end = arr.length - 1;

        while (st <= end) {
            int mid = (st + end) / 2;
            if (arr[mid] < key) {
                st = mid + 1;
            } else if (arr[mid] > key) {
                end = mid - 1;
            } else {
                return mid;
            }
        }

        return -1;
    }

    public static void main(final String[] args) {
        int[][] arr = new int[][] {
            {1, 2, 3},
            {2, 3, 4},
            {5, 6, 7}
        };
        System.out.println(find(arr, 3));
    }
}
