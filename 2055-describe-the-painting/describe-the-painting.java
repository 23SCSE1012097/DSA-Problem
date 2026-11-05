
import java.util.*;

class Solution {
    public List<List<Long>> splitPainting(int[][] segments) {
        TreeMap<Integer, Long> map = new TreeMap<>();

        for (int[] segment : segments) {
            int start = segment[0];
            int end = segment[1];
            long color = segment[2];

            map.put(start, map.getOrDefault(start, 0L) + color);
            map.put(end, map.getOrDefault(end, 0L) - color);
        }

        List<List<Long>> result = new ArrayList<>();

        long sum = 0;
        int prev = 0;

        for (int curr : map.keySet()) {
            if (sum > 0 && prev < curr) {
                result.add(Arrays.asList(
                    (long) prev,
                    (long) curr,
                    sum
                ));
            }

            sum += map.get(curr);
            prev = curr;
        }

        return result;
    }
}
