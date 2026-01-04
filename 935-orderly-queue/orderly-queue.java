import java.util.Arrays;

class Solution {
    public String orderlyQueue(String s, int k) {

       
        if (k == 1) {
            String result = s;
            int n = s.length();

            for (int i = 1; i < n; i++) {
                String rotated = s.substring(i) + s.substring(0, i);
                if (rotated.compareTo(result) < 0) {
                    result = rotated;
                }
            }
            return result;
        }

       
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
