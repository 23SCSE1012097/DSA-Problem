class Solution {
    public List<Long> maximumEvenSplit(long finalSum) {
        List<Long> ans = new ArrayList<>();

        if ((finalSum & 1) == 1) {
            return ans;
        }

        long curr = 2;

        while (finalSum >= curr) {
            ans.add(curr);
            finalSum -= curr;
            curr += 2;
        }

        if (finalSum > 0) {
            int last = ans.size() - 1;
            ans.set(last, ans.get(last) + finalSum);
        }

        return ans;
    }
}