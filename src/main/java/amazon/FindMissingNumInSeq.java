package amazon;

/**
 * amazon-interview-questions Given a string of numbers in sequence order. find the missing number.Range is not given.
 * sample input:"9899100101103104105" Answer:102
 *
 * @author  tasyrkin
 * @since   2013/08/24
 */
public class FindMissingNumInSeq {

    static int findMissing(final char[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        int len = 0;
        mainLoop:
        while (len < arr.length) {
            ++len;

            int prevLen = len;
            int prevNum = -1;
            int missing = -1;
            int nextIdx = len;

            while (nextIdx < arr.length) {
                if (nextIdx + prevLen <= arr.length) {
                    int currNum = Integer.parseInt(new String(arr, nextIdx, prevLen));
                    if (prevNum == -1) {
                        prevNum = currNum;
                        nextIdx += prevLen;
                        continue;
                    }

                    if (currNum - prevNum == 1) {
                        prevNum = currNum;
                        nextIdx += prevLen;
                        continue;
                    } else if (currNum - prevNum == 2) {
                        if (missing != -1) {
                            continue mainLoop;
                        }

                        missing = prevNum + 1;
                        nextIdx += prevLen;
                        prevNum = currNum;
                        continue;
                    }
                }

                if (nextIdx + prevLen + 1 <= arr.length) {
                    int currNum = Integer.parseInt(new String(arr, nextIdx, prevLen + 1));
                    if (currNum - prevNum == 1) {
                        ++prevLen;
                        nextIdx += prevLen;
                        prevNum = currNum;
                        continue;
                    } else if (currNum - prevNum == 2) {
                        if (missing != -1) {
                            continue mainLoop;
                        }

                        missing = prevNum + 1;
                        ++prevLen;
                        nextIdx += prevLen;
                        prevNum = currNum;
                        continue;
                    }
                }

                continue mainLoop;
            }

            if (missing != -1) {
                return missing;
            }
        }

        return -1;
    }

    public static void main(final String[] args) {

        // System.out.println(findMissing("9899100101103104105".toCharArray()));
        System.out.println(findMissing("100110021003100410061".toCharArray()));
    }

}
