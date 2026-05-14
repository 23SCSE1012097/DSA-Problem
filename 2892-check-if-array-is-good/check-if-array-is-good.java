class Solution {
    public boolean isGood(int[] nums) {
        Arrays.sort(nums);
        if(nums.length<2) return false ; 
        int max = nums[nums.length-1];
        if (nums[nums.length-1] !=max || nums[nums.length-2]!=max) return false;
            for (int i =0; i<nums.length-1; i++){
                if (nums[i]!= i+1){
                    return false;

            }
        }
        return true;
        
    }
}