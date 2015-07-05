package amazon;

import java.util.List;
import java.util.Set;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

/**
 * @author  tasyrkin
 * @since   2013/06/29
 */
public class GenerateAllSubsets {
    public List<Set<Integer>> generate(final int[] set) {
        return generate(set, 0);
    }

    private List<Set<Integer>> generate(final int[] set, final int idx) {
        if (idx == set.length) {
            return Lists.<Set<Integer>>newArrayList(Sets.<Integer>newHashSet());
        }

        List<Set<Integer>> allSubsets = generate(set, idx + 1);
        int item = set[idx];
        List<Set<Integer>> newSubsets = Lists.newArrayList();
        for (Set<Integer> subSet : allSubsets) {
            Set<Integer> newSubset = Sets.newHashSet();
            newSubset.addAll(subSet);
            newSubset.add(item);
            newSubsets.add(newSubset);

        }

        allSubsets.addAll(newSubsets);

        return allSubsets;
    }

    public static void main(final String[] args) {
        GenerateAllSubsets generateAllSubsets = new GenerateAllSubsets();

        List<Set<Integer>> subSets = generateAllSubsets.generate(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
        for (Set<Integer> subSet : subSets) {
            System.out.println(Joiner.on(',').join(subSet));
        }
    }
}
