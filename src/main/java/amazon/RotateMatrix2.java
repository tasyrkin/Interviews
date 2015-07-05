package amazon;

/**
 * @author  tasyrkin
 * @since   2013/06/23
 */
public class RotateMatrix2 {

    public static void rotate(final int[][] M) {
        if (M == null || M.length != M[0].length) {
            return;
        }

        int N = M.length;

        for (int i = 0; i < N / 2; i++) {
            for (int j = i; j < N - i - 1; j++) {
                int tmp = M[j][N - i - 1];
                M[j][N - i - 1] = M[i][j];

                int tmp2 = M[N - i - 1][N - j - 1];
                M[N - i - 1][N - j - 1] = tmp;

                int tmp3 = M[N - j - 1][i];
                M[N - j - 1][i] = tmp2;

                M[i][j] = tmp3;
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
            {1, 2, 3, 4},
            {1, 2, 3, 4},
            {1, 2, 3, 4},
            {1, 2, 3, 4}
        };

        rotate(m);

        print(m);

    }
}
