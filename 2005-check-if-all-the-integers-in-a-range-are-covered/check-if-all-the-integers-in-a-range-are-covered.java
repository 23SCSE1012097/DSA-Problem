class Solution {
    public boolean isCovered(int[][] ranges, int left, int right) {
        for (int num = left; num <= right; num++) {
            boolean covered = false;

            for (int[] range : ranges) {
                if (range[0] <= num && num <= range[1]) {
                    covered = true;
                    break;
                }
            }

            if (!covered) {
                return false;
            }
        }

        return true;
    }
}