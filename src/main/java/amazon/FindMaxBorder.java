package amazon;

/**
 * @author  tasyrkin
 * @since   2014/01/26
 */
public class FindMaxBorder {

    private static class Point {
        int x, y;

        public Point(final int x, final int y) {
            this.x = x;
            this.y = y;
        }

        public String toString() {
            return "{" + x + "," + y + "}";
        }
    }

    public static class Pair<T> {
        T first, second;

        public Pair(final T f, final T s) {
            first = f;
            second = s;
        }
    }

    Pair<Point> getMaxBorder(final boolean[][] m) {

        int n = m.length;
        int res = 0;

        Pair<Point> resP = null;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int len = 1; len <= n; len++) {
                    if (i + len <= n && j + len <= n) {
                        boolean checkRow1 = checkRow(i, j, j + len, m);
                        boolean checkRow2 = checkRow(i + len - 1, j, j + len, m);
                        boolean checkCol1 = checkCol(i, i + len, j, m);
                        boolean checkCol2 = checkCol(i, i + len, j + len - 1, m);
                        if (checkCol1 && checkCol2 && checkRow1 && checkRow2) {
                            if (len > res) {
                                resP = new Pair<Point>(new Point(i, j), new Point(i + len - 1, j + len - 1));
                                res = len;
                            }
                        }
                    }
                }
            }
        }

        return resP;
    }

    private boolean checkRow(final int row, final int jst, final int jend, final boolean[][] m) {
        for (int j = jst; j < jend; j++) {
            if (!m[row][j]) {
                return false;
            }
        }

        return true;
    }

    private boolean checkCol(final int ist, final int iend, final int col, final boolean[][] m) {
        for (int i = ist; i < iend; i++) {
            if (!m[i][col]) {
                return false;
            }
        }

        return true;
    }

    public static void main(final String[] args) {
        FindMaxBorder f = new FindMaxBorder();

        boolean[][] m = {
            {true, true, true},
            {false, true, true},
            {true, true, true}
        };

        Pair<Point> r = f.getMaxBorder(m);
        System.out.println(r.first + " : " + r.second);
    }
}
