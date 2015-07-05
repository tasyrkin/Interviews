package amazon;

import static org.hamcrest.MatcherAssert.assertThat;

import static org.hamcrest.Matchers.arrayContainingInAnyOrder;

import static com.google.common.collect.Sets.newHashSet;

import java.util.Set;

public class PrintPowerSetOfAString {

    public static Set<String> superSet(final String s) {

        final Set<String> result = newHashSet("");

        if (s == null || s.length() == 0) {
            return result;
        }

        /*
         * Level is the number of characters + 1 that have to be taken from the string, for example,
         * string: "abc"
         * level 0: "a", "b", "c"
         * level 1: "ab", "ac", "bc"
         * level 2: "abc"
         */
        for (int lvl = 0; lvl < s.length(); lvl++) {
            result.addAll(get(s.toCharArray(), 0, lvl));
        }

        return result;
    }

    /**
     * Returns combination of strings for a substring starting with {@code start} with number of characters
     * {@code lvl + 1}.
     */
    public static Set<String> get(final char[] a, final int start, final int lvl) {

        final Set<String> result = newHashSet();

        if (start >= a.length) {
            return result;
        }

        if (lvl < 0) {
            return result;
        }

        for (int i = start; i < a.length; i++) {

            // get combinations of the substring starting from the next char with lvl number of chars
            Set<String> set = get(a, i + 1, lvl - 1);
            if (!set.isEmpty()) {
                for (String s : set) {
                    result.add(a[i] + s);
                }
            } else {
                if (lvl + 1 == 1) {
                    result.add(String.valueOf(a[i]));
                }
            }
        }

        return result;

    }

    public static void main(final String[] args) {

        assertThat("", superSet("a").toArray(new String[0]), arrayContainingInAnyOrder("", "a"));
        assertThat("", superSet("abc").toArray(new String[0]),
            arrayContainingInAnyOrder("", "a", "b", "c", "ab", "ac", "bc", "abc"));
        assertThat("", superSet("abcde").toArray(new String[0]),
            arrayContainingInAnyOrder("", "a", "b", "c", "d", "e", "ab", "ac", "ad", "ae", "bc", "bd", "be", "cd", "ce",
                "de", "abc", "abd", "abe", "acd", "ace", "ade", "bcd", "bce", "bde", "cde", "abcd", "abce", "abde",
                "acde", "bcde", "abcde"));

    }
}
