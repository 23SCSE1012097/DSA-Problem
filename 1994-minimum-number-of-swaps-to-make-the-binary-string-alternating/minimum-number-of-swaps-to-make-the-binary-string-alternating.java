
class Solution {
    public int minSwaps(String s) {
        int zeros = 0;
        int ones = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                zeros++;
            } else {
                ones++;
            }
        }

        if (Math.abs(zeros - ones) > 1) {
            return -1;
        }

        if (zeros > ones) {
            return countSwaps(s, '0');
        }

        if (ones > zeros) {
            return countSwaps(s, '1');
        }

        return Math.min(countSwaps(s, '0'), countSwaps(s, '1'));
    }

    private int countSwaps(String s, char start) {
        int mismatches = 0;

        for (int i = 0; i < s.length(); i++) {
            char expected = (i % 2 == 0) ? start :
                            (start == '0' ? '1' : '0');

            if (s.charAt(i) != expected) {
                mismatches++;
            }
        }

        return mismatches / 2;
    }
}
