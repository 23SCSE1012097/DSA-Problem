class Solution {
    public int matrixSum(int[][] nums) {
        int m = nums.length;
        int n = nums[0].length;

        for (int[] row : nums) {
            Arrays.sort(row);
        }

        int ans = 0;

        for (int col = 0; col < n; col++) {
            int mx = 0;

            for (int row = 0; row < m; row++) {
                mx = Math.max(mx, nums[row][col]);
            }

            ans += mx;
        }

        return ans;
    }
}