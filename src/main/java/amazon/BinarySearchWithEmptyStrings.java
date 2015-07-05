package amazon;

/**
 * @author  tasyrkin
 * @since   2013/08/24
 */
public class BinarySearchWithEmptyStrings {

    public static int binarySearch(final String[] str, final String key) {
        if (str == null || str.length == 0 || key == null) {
            return -1;
        }

        int st = 0;
        int end = str.length - 1;
        while (st <= end) {
            int mid = (st + end) >>> 1;

            if (str[mid].length() == 0) {
                int left = mid;
                int right = mid;
                while (left > st || right < end) {
                    if (str[left].length() != 0) {
                        break;
                    }

                    if (str[right].length() != 0) {
                        break;
                    }

                    if (left > st) {
                        left--;
                    }

                    if (right < end) {
                        right++;
                    }
                }

                if (str[left].length() == 0 && str[right].length() == 0) {
                    return -(st + 1);
                }

                if (str[left].length() > 0) {
                    mid = left;
                }

                if (str[right].length() > 0) {
                    mid = right;
                }
            }

            if (str[mid].compareTo(key) < 0) {
                st = mid + 1;
            } else if (str[mid].compareTo(key) > 0) {
                end = mid - 1;
            } else {
                return mid;
            }

        }

        return -(st + 1);

    }

    public static void main(final String[] args) {
        String[] str = new String[] {"at", "", "", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""};

        System.out.println(binarySearch(str, "ball"));
        System.out.println(binarySearch(str, "ama"));

        String[] str1 = new String[] {"", "", "", "", "", "", "", "", "", "", "", "", "", "", ""};
        System.out.println(binarySearch(str1, ""));
    }

}
