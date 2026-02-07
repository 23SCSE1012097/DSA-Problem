import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> map = new HashMap<>();

        // Step 2: Array ko traverse karte hain
        for (int i = 0; i < nums.length; i++) {

            // Step 3: Complement calculate karte hain
            int complement = target - nums[i];

            // Step 4: Check karte hain ki complement pehle se map me hai ya nahi
            if (map.containsKey(complement)) {

                // Step 5: Agar mil gaya, to indices return kar do
                return new int[] { map.get(complement), i };
            }

            // Step 6: Agar nahi mila, to current value ko map me store kar do
            map.put(nums[i], i);
        }

        // Step 7: (Problem ke according yeh kabhi execute nahi hoga)
        return new int[0];
    }
}
