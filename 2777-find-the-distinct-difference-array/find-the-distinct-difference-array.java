class Solution {
    public int[] distinctDifferenceArray(int[] nums) {
        int n = nums.length;
        int[] diff = new int[n];

        for (int i = 0; i < n; i++) {
            HashSet<Integer> prefix = new HashSet<>();
            HashSet<Integer> suffix = new HashSet<>();

            // Count distinct elements in prefix [0...i]
            for (int j = 0; j <= i; j++) {
                prefix.add(nums[j]);
            }

            // Count distinct elements in suffix [i+1...n-1]
            for (int j = i + 1; j < n; j++) {
                suffix.add(nums[j]);
            }

            diff[i] = prefix.size() - suffix.size();
        }

        return diff;
    }
}