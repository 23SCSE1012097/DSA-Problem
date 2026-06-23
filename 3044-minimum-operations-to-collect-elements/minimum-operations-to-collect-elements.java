class Solution {
    public int minOperations(List<Integer> nums, int k) {
        boolean[] found = new boolean[k + 1];
        int count = 0;
        int operations = 0;

        for (int i = nums.size() - 1; i >= 0; i--) {
            operations++;

            int num = nums.get(i);

            if (num <= k && !found[num]) {
                found[num] = true;
                count++;
            }

            if (count == k) {
                return operations;
            }
        }

        return operations;
    }
}