class Solution {

    public long kMirror(int k, int n) {
        long sum = 0;
        int count = 0;

        for (int len = 1; count < n; len++) {

         
            for (long i = (long) Math.pow(10, len - 1);
                 i < (long) Math.pow(10, len) && count < n; i++) {

                long pal = makepalindrome(i, true);

                if (ispalindromeBasel(pal, k)) {
                    sum += pal;
                    count++;
                }
            }

          
            for (long i = (long) Math.pow(10, len - 1);
                 i < (long) Math.pow(10, len) && count < n; i++) {

                long pal = makepalindrome(i, false);

                if (ispalindromeBasel(pal, k)) {
                    sum += pal;
                    count++;
                }
            }
        }
        return sum;
    }

    private long makepalindrome(long x, boolean odd) {
        long res = x;
        if (odd) x /= 10;

        while (x > 0) {
            res = res * 10 + (x % 10);
            x /= 10;
        }
        return res;
    }

    private boolean ispalindromeBasel(long num, int k) {
        StringBuilder sb = new StringBuilder();

        while (num > 0) {
            sb.append(num % k);
            num /= k;
        }

        return sb.toString().equals(sb.reverse().toString());
    }
}
