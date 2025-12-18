import java.util.*;

class Solution {
    public int[] recoverArray(int n, int[] sums) {
        Arrays.sort(sums);

        List<Integer> curr = new ArrayList<>();
        for (int s : sums) curr.add(s);

        int[] ans = new int[n];
        int idx = 0;

        for (int i = 0; i < n; i++) {
            int x = curr.get(1) - curr.get(0);

            Map<Integer, Integer> count = new HashMap<>();
            for (int s : curr) {
                count.put(s, count.getOrDefault(s, 0) + 1);
            }

            List<Integer> without = new ArrayList<>();
            List<Integer> withX = new ArrayList<>();

            for (int s : curr) {
                if (count.get(s) == 0) continue;

                count.put(s, count.get(s) - 1);
                count.put(s + x, count.get(s + x) - 1);

                without.add(s);
                withX.add(s + x);
            }

            if (without.contains(0)) {
                ans[idx++] = x;
                curr = without;
            } else {
                ans[idx++] = -x;
                curr = withX;
            }
        }

        return ans;
    }
}
