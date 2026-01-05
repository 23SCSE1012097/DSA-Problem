import java.util.*;

class Solution {
    public List<Integer> fallingSquares(int[][] positions) {
        List<Integer> heights = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();

        int maxOverall = 0;

        for (int i = 0; i < positions.length; i++) {
            int left = positions[i][0];
            int size = positions[i][1];
            int right = left + size;

            int baseHeight = 0;

            // Check overlap with previous squares
            for (int j = 0; j < i; j++) {
                int prevLeft = positions[j][0];
                int prevRight = prevLeft + positions[j][1];

                // overlap condition
                if (Math.max(left, prevLeft) < Math.min(right, prevRight)) {
                    baseHeight = Math.max(baseHeight, heights.get(j));
                }
            }

            int currentHeight = baseHeight + size;
            heights.add(currentHeight);

            maxOverall = Math.max(maxOverall, currentHeight);
            ans.add(maxOverall);
        }

        return ans;
    }
}
