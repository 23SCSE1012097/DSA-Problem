class Solution {
    public int maxProduct(int[] nums) {

        int largestproduct = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {

            int currproduct = 1;

            for (int j = i; j < nums.length; j++) {

                currproduct *= nums[j];

                largestproduct = Math.max(largestproduct, currproduct);
            }
        }

        return largestproduct;
    }
}