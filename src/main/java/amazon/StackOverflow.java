package amazon;

/**
 * @author  tasyrkin
 * @since   2014/01/30
 */
public class StackOverflow {
    public void f(final int level, final long val) {
        System.out.println(level + ":" + val);
        f(level + 1, val + 2 * val);
    }

    public static void main(final String[] args) {
        StackOverflow s = new StackOverflow();
        s.f(0, 1);
    }
}
