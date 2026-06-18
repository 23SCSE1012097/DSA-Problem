class Solution {
    public boolean judgePoint24(int[] cards) {
        List<Double> nums = new ArrayList<>();

        for (int card : cards) {
            nums.add((double) card);
        }

        return solve(nums);
    }

    private boolean solve(List<Double> nums) {
        if (nums.size() == 1) {
            return Math.abs(nums.get(0) - 24.0) < 1e-6;
        }

        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < nums.size(); j++) {
                if (i == j) {
                    continue;
                }

                List<Double> next = new ArrayList<>();

                for (int k = 0; k < nums.size(); k++) {
                    if (k != i && k != j) {
                        next.add(nums.get(k));
                    }
                }

                double a = nums.get(i);
                double b = nums.get(j);

                if (i < j) {
                    next.add(a + b);
                    if (solve(next)) return true;
                    next.remove(next.size() - 1);

                    next.add(a * b);
                    if (solve(next)) return true;
                    next.remove(next.size() - 1);
                }

                next.add(a - b);
                if (solve(next)) return true;
                next.remove(next.size() - 1);

                if (Math.abs(b) > 1e-6) {
                    next.add(a / b);
                    if (solve(next)) return true;
                    next.remove(next.size() - 1);
                }
            }
        }

        return false;
    }
}