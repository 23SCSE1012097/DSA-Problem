import java.util.*;

class Solution {
    public int minimumGroups(String[] words) {
        Set<String> set = new HashSet<>();

        for (String s : words) {
            StringBuilder even = new StringBuilder();
            StringBuilder odd = new StringBuilder();

            for (int i = 0; i < s.length(); i++) {
                if ((i & 1) == 0) {
                    even.append(s.charAt(i));
                } else {
                    odd.append(s.charAt(i));
                }
            }

            set.add(minRotation(even.toString()) + "#" + minRotation(odd.toString()));
        }

        return set.size();
    }

    private String minRotation(String s) {
        int n = s.length();

        if (n <= 1) {
            return s;
        }

        int i = 0;
        int j = 1;
        int k = 0;

        while (i < n && j < n && k < n) {
            char a = s.charAt((i + k) % n);
            char b = s.charAt((j + k) % n);

            if (a == b) {
                k++;
            } else if (a > b) {
                i = i + k + 1;

                if (i <= j) {
                    i = j + 1;
                }

                k = 0;
            } else {
                j = j + k + 1;

                if (j <= i) {
                    j = i + 1;
                }

                k = 0;
            }
        }

        int start = Math.min(i, j);

        return s.substring(start) + s.substring(0, start);
    }
}