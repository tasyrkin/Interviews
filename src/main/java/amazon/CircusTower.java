package amazon;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author  tasyrkin
 * @since   2013/08/24
 */
public class CircusTower {

    private static class Pair {
        int height;
        int weight;

        public Pair(final int iheight, final int iweight) {
            height = iheight;
            weight = iweight;
        }

        @Override
        public String toString() {
            return height + " " + weight;
        }
    }

    private static class PairCmp implements Comparator<Pair> {

        @Override
        public int compare(final Pair p1, final Pair p2) {

            if (p1.height == p2.weight) {
                return p1.weight - p2.weight;
            }

            return p1.height - p2.height;
        }
    }

    public static int findMax(final Pair[] ps) {
        if (ps == null || ps.length == 0) {
            return 0;
        }

        Arrays.sort(ps, new PairCmp());

        System.out.println(Arrays.toString(ps));

        int[] A = new int[ps.length];

        for (int i = ps.length - 1; i >= 0; i--) {
            int max = 0;
            for (int j = i + 1; j < ps.length; j++) {
                if (ps[i].height < ps[j].height && ps[i].weight < ps[j].weight) {
                    if (max < A[j]) {
                        max = A[j];
                    }
                }
            }

            A[i] = max + 1;
        }

        int max = 0;
        for (int i = 0; i < ps.length; i++) {
            if (max < A[i]) {
                max = A[i];
            }
        }

        return max;
    }

    public static void main(final String[] args) {

        Pair[] ps = new Pair[6];
        int cnt = 0;
        ps[cnt++] = new Pair(1, 100);
        ps[cnt++] = new Pair(2, 150);
        ps[cnt++] = new Pair(3, 90);
        ps[cnt++] = new Pair(4, 190);
        ps[cnt++] = new Pair(5, 95);
        ps[cnt++] = new Pair(6, 110);

        System.out.println(findMax(ps));

    }

}
