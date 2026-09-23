class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        int[] diff = new int[n + 1];

        for (int[] shift : shifts) {
            int start = shift[0];
            int end = shift[1];
            int direction = shift[2];

            int value = direction == 1 ? 1 : -1;

            diff[start] += value;
            diff[end + 1] -= value;
        }

        StringBuilder result = new StringBuilder();
        int currentShift = 0;

        for (int i = 0; i < n; i++) {
            currentShift += diff[i];

            int newPosition = (s.charAt(i) - 'a' + currentShift) % 26;

            if (newPosition < 0) {
                newPosition += 26;
            }

            result.append((char) ('a' + newPosition));
        }

        return result.toString();
    }
}