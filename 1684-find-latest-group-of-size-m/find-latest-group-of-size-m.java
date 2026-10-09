
class Solution {
    public int findLatestStep(int[] arr, int m) {
        int n = arr.length;

        if (m == n) {
            return n;
        }

        int[] length = new int[n + 2];
        int count = 0;
        int answer = -1;

        for (int step = 0; step < n; step++) {
            int pos = arr[step];

            int left = length[pos - 1];
            int right = length[pos + 1];

            int newLength = left + right + 1;

            length[pos - left] = newLength;
            length[pos + right] = newLength;
            length[pos] = newLength;

            if (left == m) {
                count--;
            }
            if (right == m) {
                count--;
            }
            if (newLength == m) {
                count++;
            }

            if (count > 0) {
                answer = step + 1;
            }
        }

        return answer;
    }
}