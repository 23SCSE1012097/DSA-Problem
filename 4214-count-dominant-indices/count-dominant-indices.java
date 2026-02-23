class Solution {
    public int dominantIndices(int[] nums) {
        int n = nums.length;
        int totalSum = 0;
        for (int num : nums ){
           totalSum += num;
                
            }
        long rightSum = totalSum;
        int count = 0;
        for (int i=0; i< n-1; i++){
            rightSum -= nums[i];
            int rightCount= n - i - 1;
            if((long) nums [i] * rightCount > rightSum){
                count ++;
            }
            
        }
        return count;
        
    }
}