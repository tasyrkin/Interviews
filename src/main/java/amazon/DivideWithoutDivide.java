package amazon;

/**
 * @author  tasyrkin
 * @since   2014/01/27
 */
public class DivideWithoutDivide {

    public int divide(int nom, final int den) {
        if (den == 0) {
            throw new IllegalStateException("Divide by 0");
        }

        nom -= nom % den;
        if (nom < den) {
            return 0;
        }

        int l = 1;
        int r = nom;
        int mid = (l + r) >>> 1;
        long curr = (long) mid * (long) den;
        while (curr != nom) {
            if (curr > nom) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }

            mid = (l + r) >>> 1;
            curr = (long) mid * (long) den;
        }

        return mid;
    }

    public static void main(final String[] args) {
        DivideWithoutDivide d = new DivideWithoutDivide();
        System.out.println(d.divide(7, 3));
        System.out.println(d.divide(1, 3));
        System.out.println(d.divide(Integer.MAX_VALUE, 1));
    }
}
