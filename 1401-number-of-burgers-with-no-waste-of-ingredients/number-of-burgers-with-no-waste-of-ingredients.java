
import java.util.*;

class Solution {
    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        List<Integer> ans = new ArrayList<>();

        if (tomatoSlices % 2 != 0) {
            return ans;
        }

        int jumbo = tomatoSlices / 2 - cheeseSlices;
        int small = cheeseSlices - jumbo;

        if (jumbo < 0 || small < 0 || 4 * jumbo + 2 * small != tomatoSlices) {
            return ans;
        }

        ans.add(jumbo);
        ans.add(small);

        return ans;
    }
}
