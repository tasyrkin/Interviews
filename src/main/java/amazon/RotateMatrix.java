package amazon;

/**
 * Created with IntelliJ IDEA. User: tasyrkin Date: 6/10/13 Time: 11:20 PM To change this template use File | Settings |
 * File Templates.
 */
public class RotateMatrix {

    private static void rotate(final int[][] m) {

        if (m == null || m.length == 0 || m.length != m[0].length) {
            return;
        }

        int n = m.length;

        for (int i = 0; i < n / 2; i++) {
            for (int j = i; j < n - 1 - i; j++) {
                int tmp = m[i][n - 1 - j];
                m[i][n - 1 - j] = m[i][j];

                int tmp2 = m[n - 1 - i][n - 1 - j];
                m[n - 1 - i][n - 1 - j] = tmp;

                int tmp3 = m[n - 1 - i][j];
                m[n - 1 - i][j] = tmp2;

                m[i][j] = tmp3;
            }
        }
    }

    private static void print(final int[][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m.length; j++) {
                if (j > 0) {
                    System.out.print(" ");
                }

                System.out.print(m[i][j]);
            }

            System.out.println();
        }
    }

    public static void main(final String[] args) {

        int[][] m = {
            {1, 0, 0},
            {1, 0, 0},
            {1, 0, 0}
        };

        rotate(m);

        print(m);

    }
}
