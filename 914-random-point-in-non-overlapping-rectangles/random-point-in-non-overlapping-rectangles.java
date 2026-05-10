import java.util.*;

class Solution {

    int[][] rects;
    int[] prefixSum;
    Random rand;

    public Solution(int[][] rects) {
        this.rects = rects;
        this.prefixSum = new int[rects.length];
        this.rand = new Random();

        int totalPoints = 0;

        for (int i = 0; i < rects.length; i++) {
            int x1 = rects[i][0];
            int y1 = rects[i][1];
            int x2 = rects[i][2];
            int y2 = rects[i][3];

            int points = (x2 - x1 + 1) * (y2 - y1 + 1);
            totalPoints += points;

            prefixSum[i] = totalPoints;
        }
    }

    public int[] pick() {
        int target = rand.nextInt(prefixSum[prefixSum.length - 1]) + 1;

        int index = Arrays.binarySearch(prefixSum, target);

        if (index < 0) {
            index = -index - 1;
        }

        int[] rect = rects[index];

        int x1 = rect[0];
        int y1 = rect[1];
        int x2 = rect[2];
        int y2 = rect[3];

        int x = x1 + rand.nextInt(x2 - x1 + 1);
        int y = y1 + rand.nextInt(y2 - y1 + 1);

        return new int[]{x, y};
    }
}