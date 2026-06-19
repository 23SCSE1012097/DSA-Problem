import java.util.Arrays;

class Solution {
    public int[] transformArray(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        
        int idx = 0;
        
        for (int num : nums) {
            if (num % 2 == 0) {
                res[idx++] = 0;
            } else {
                res[idx++] = 1;
            }
        }
        
        Arrays.sort(res);
        return res;
    }
}