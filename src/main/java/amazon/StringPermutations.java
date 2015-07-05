package amazon;

import static org.hamcrest.MatcherAssert.assertThat;

import static org.hamcrest.Matchers.arrayContainingInAnyOrder;

import java.util.List;

import com.google.common.collect.Lists;

public class StringPermutations {

    public static List<String> permute(final String s) {
        return permute(s.toCharArray(), 0, s.length() - 1);
    }

    public static List<String> permute2(final String s) {
        return permute2(s.toCharArray(), s.length() - 1);
    }

    private static List<String> permute2(final char[] chars, final int idx) {
        if (idx < 0) {
            return Lists.newArrayList();
        } else if (idx == 0) {
            return Lists.newArrayList(String.valueOf(chars[idx]));
        }

        List<String> permutations = permute2(chars, idx - 1);
        List<String> result = Lists.newArrayList();
        for (String permutation : permutations) {
            result.add(chars[idx] + permutation);
            result.add(permutation + chars[idx]);
            for (int currIdx = 1; currIdx < permutation.length(); ++currIdx) {
                result.add(permutation.substring(0, currIdx) + chars[idx]
                        + permutation.substring(currIdx, permutation.length()));
            }
        }

        return result;
    }

    private static List<String> permute(final char[] arr, final int start, final int end) {
        if (start == end) {
            return Lists.newArrayList(String.valueOf(arr[start]));
        }

        if (start > end) {
            return Lists.newArrayList();
        }

        final List<String> strs = permute(arr, start, end - 1);

        final List<String> res = Lists.newArrayList();
        char endChar = arr[end];
        for (String s : strs) {
            char[] chs = s.toCharArray();
            res.add(endChar + s);
            res.add(s + endChar);
            for (int i = 0; i < chs.length - 1; i++) {
                res.add(new String(chs, 0, i + 1) + endChar + new String(chs, i + 1, chs.length - 1 - i));
            }
        }

        return res;
    }

    public static void main(final String[] args) {
        assertThat("", permute("a").toArray(new String[0]), arrayContainingInAnyOrder("a"));
        assertThat("", permute("ab").toArray(new String[0]), arrayContainingInAnyOrder("ab", "ba"));
        assertThat("", permute("abc").toArray(new String[0]),
            arrayContainingInAnyOrder("abc", "acb", "cab", "cba", "bac", "bca"));
        assertThat("", permute2("a").toArray(new String[0]), arrayContainingInAnyOrder("a"));
        assertThat("", permute2("ab").toArray(new String[0]), arrayContainingInAnyOrder("ab", "ba"));
        assertThat("", permute2("abc").toArray(new String[0]),
            arrayContainingInAnyOrder("abc", "acb", "cab", "cba", "bac", "bca"));
    }
}
