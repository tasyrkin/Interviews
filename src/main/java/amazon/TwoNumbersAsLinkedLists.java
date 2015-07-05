package amazon;

import static org.hamcrest.MatcherAssert.assertThat;

import static org.hamcrest.Matchers.is;

import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.collect.Lists.newArrayList;
import static com.google.common.collect.Lists.newLinkedList;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Two numbers are represented as linked lists. Both lists are of same length. Add them without manipulating the lists
 * and without a second traversal.
 */
public class TwoNumbersAsLinkedLists {

    public static int sum(final LinkedList<Integer> ll1, final LinkedList<Integer> ll2) {
        checkNotNull(ll1, "Linked list may not be null");
        checkNotNull(ll2, "Linked list may not be null");

        int result = 0;

        Iterator<Integer> it1 = ll1.descendingIterator();
        Iterator<Integer> it2 = ll2.descendingIterator();

        boolean carry = false;
        int tens = 1;
        while (it1.hasNext()) {
            int n1 = it1.next();
            int n2 = it2.next();

            int r = n1 + n2 + (carry ? 1 : 0);

            if (r > 9) {
                carry = true;
            } else {
                carry = false;
            }

            result += (r % 10) * tens;

            tens *= 10;
        }

        if (carry) {
            result += tens;
        }

        return result;
    }

    public static void main(final String[] args) {

        assertThat("", sum(newLinkedList(newArrayList(1, 2, 3)), newLinkedList(newArrayList(1, 2, 3))), is(246));
        assertThat("", sum(newLinkedList(newArrayList(9)), newLinkedList(newArrayList(9))), is(18));
        assertThat("",
            sum(newLinkedList(newArrayList(9, 8, 7, 6, 5, 4, 3, 2, 1)),
                newLinkedList(newArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9))), is(1111111110));

    }

}
