import java.util.*;

class Solution {
    public int maxTwoEvents(int[][] events) {
    
        Arrays.sort(events, (a, b) -> a[1] - b[1]);

        int n = events.length;
        int[] maxValueTill = new int[n];
        maxValueTill[0] = events[0][2];

        for (int i = 1; i < n; i++) {
            maxValueTill[i] = Math.max(maxValueTill[i - 1], events[i][2]);
        }

        int answer = 0;

        for (int i = 0; i < n; i++) {
            int start = events[i][0];
            int value = events[i][2];

            int left = 0, right = i - 1;
            int index = -1;

            while (left <= right) {
                int mid = (left + right) / 2;
                if (events[mid][1] < start) {
                    index = mid;
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            if (index != -1) {
                answer = Math.max(answer, value + maxValueTill[index]);
            } else {
                answer = Math.max(answer, value);
            }
        }

        return answer;
    }
}
