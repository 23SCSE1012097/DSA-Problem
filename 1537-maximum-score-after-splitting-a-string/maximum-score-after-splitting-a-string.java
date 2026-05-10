class Solution {
    public int maxScore(String s) {

        int onesRight = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                onesRight++;
            }
        }

        int zerosLeft = 0;
        int maxScore = 0;

        // split before last character, because right part cannot be empty
        for (int i = 0; i < s.length() - 1; i++) {

            if (s.charAt(i) == '0') {
                zerosLeft++;
            } else {
                onesRight--;
            }

            maxScore = Math.max(maxScore, zerosLeft + onesRight);
        }

        return maxScore;
    }
}