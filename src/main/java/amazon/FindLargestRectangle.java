package amazon;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.google.common.collect.Lists;

/**
 * @author  tasyrkin
 * @since   2014/01/25
 */
public class FindLargestRectangle {

    private static class Dictionary {

        private List<String> content = new ArrayList<String>();

        public Dictionary(final Collection<String> content) {
            this.content.addAll(content);
        }

        public boolean isPrefix(final String s) {
            for (String c : content) {
                if (c.contains(s)) {
                    return true;
                }
            }

            return false;
        }

        public boolean isWord(final String s) {
            for (String c : content) {
                if (c.equals(s)) {
                    return true;
                }
            }

            return false;
        }
    }

    char[][] res = null;

    public char[][] findLargest(final Dictionary dict) {
        char[][] m = new char[30][30];
        findLargest(m, 0, 0, -1, dict);
        return res;
    }

    private void findLargest(final char[][] m, final int i, final int j, final int maxx, final Dictionary dict) {
        if (i >= m.length || j >= m[0].length) {
            return;
        }

        for (char ch = 'a'; ch <= 'z'; ch++) {
            m[i][j] = ch;
            if (maxx == -1) {
                String rowPrefix = getRowPrefix(m, i, j);
                if (dict.isPrefix(rowPrefix)) {
                    if (dict.isWord(rowPrefix)) {
                        if (res == null) {
                            res = buildRes(m, i, j);
                        } else {
                            res = res != null && res.length * res[0].length < (i + 1) * (j + 1) ? buildRes(m, i, j)
                                                                                                : res;
                        }

                        // print(m, i + 1, j + 1);
                        findLargest(m, i + 1, 0, j, dict);
                    } else {
                        findLargest(m, i, j + 1, maxx, dict);
                    }
                }
            } else {
                String rowPrefix = getRowPrefix(m, i, j);
                String colPrefix = getColPrefix(m, i, j);

                if (dict.isPrefix(rowPrefix) && dict.isPrefix(colPrefix)) {
                    if (j == maxx) {
                        boolean isRowWord = dict.isWord(rowPrefix);
                        boolean isColWord = dict.isWord(colPrefix);
                        if (isRowWord && isColWord) {

                            // print(m, i + 1, j + 1);
                            if (res == null) {
                                res = buildRes(m, i, j);
                            } else {
                                res = res != null && res.length * res[0].length < (i + 1) * (j + 1) ? buildRes(m, i, j)
                                                                                                    : res;
                            }

                            findLargest(m, i + 1, 0, maxx, dict);
                        } else if (isRowWord) {
                            findLargest(m, i + 1, 0, maxx, dict);
                        }
                    } else if (j < maxx) {
                        findLargest(m, i, j + 1, maxx, dict);
                    }
                }
            }
        }
    }

    private char[][] buildRes(final char[][] m, final int i, final int j) {
        char[][] currRes = new char[i + 1][j + 1];
        for (int k = 0; k <= i; k++) {
            for (int l = 0; l <= j; l++) {
                currRes[k][l] = m[k][l];
            }
        }

        return currRes;
    }

    private String getColPrefix(final char[][] m, final int i, final int j) {
        StringBuffer res = new StringBuffer(j + 1);
        for (int k = 0; k <= i; k++) {
            res.append(m[k][j]);
        }

        return res.toString();
    }

    private String getRowPrefix(final char[][] m, final int i, final int j) {
        return new String(m[i], 0, j + 1);
    }

    public static void main(final String[] args) {
        FindLargestRectangle f = new FindLargestRectangle();
        Dictionary dict = new Dictionary(Lists.newArrayList("rat", "usa", "bsu", "yam", "ruby", "assa", "taum", "yal",
                    "taul"));
        char[][] res = f.findLargest(dict);

        if (res == null) {
            System.out.println("NOTHING!");
        } else {
            print(res, res.length, res[0].length);
        }
    }

    private static void print(final char[][] a, final int rows, final int cols) {
        for (int i = 0; i < rows; i++) {
            System.out.println(new String(a[i], 0, cols));
        }
    }

}
