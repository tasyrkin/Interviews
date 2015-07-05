
package google;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class StringSplitter {
    private static Set<String> dict = new HashSet<String>();

    static {
        dict.add("cow");
        dict.add("cowboy");
        dict.add("milk");
        dict.add("gun");
        dict.add("field");
    }

    public static void main(final String[] args) {
        List<String> split = split("cowboygunfields");
        if (!split.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (String s : split) {
                if (sb.length() > 0) {
                    sb.append(" ");
                }

                sb.append(s);
            }

            System.out.println(sb.toString());
        } else {
            System.out.println("No valid split exists");
        }
    }

    public static List<String> split(final String s) {
        if (s == null || s.length() == 0) {
            return new LinkedList<String>();
        }

        char[] a = s.toCharArray();
        LinkedList<String> result = new LinkedList<String>();
        boolean splitExists = split(a, 0, result);

        if (!splitExists) {
            return new LinkedList();
        }

        return result;
    }

    private static boolean split(final char[] a, final int idx, final LinkedList<String> words) {
        if (idx >= a.length) {
            return true;
        }

        for (int i = idx; i < a.length; i++) {
            String s = new String(a, idx, i - idx + 1);
            if (dict.contains(s)) {
                boolean subStrFound = split(a, i + 1, words);
                if (subStrFound) {
                    words.addFirst(s);
                    return true;
                }
            }
        }

        return false;
    }
}
