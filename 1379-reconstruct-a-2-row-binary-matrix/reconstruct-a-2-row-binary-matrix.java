
class Solution {
    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        List<List<Integer>> ans = new ArrayList<>();

        int n = colsum.length;
        int[] top = new int[n];
        int[] bottom = new int[n];

        for (int i = 0; i < n; i++) {
            if (colsum[i] == 2) {
                top[i] = 1;
                bottom[i] = 1;
                upper--;
                lower--;
            }
        }

        if (upper < 0 || lower < 0) {
            return ans;
        }

        for (int i = 0; i < n; i++) {
            if (colsum[i] == 1) {
                if (upper > 0) {
                    top[i] = 1;
                    upper--;
                } else if (lower > 0) {
                    bottom[i] = 1;
                    lower--;
                } else {
                    return ans;
                }
            }
        }

        if (upper != 0 || lower != 0) {
            return ans;
        }

        List<Integer> row1 = new ArrayList<>();
        List<Integer> row2 = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            row1.add(top[i]);
            row2.add(bottom[i]);
        }

        ans.add(row1);
        ans.add(row2);

        return ans;
    }
}