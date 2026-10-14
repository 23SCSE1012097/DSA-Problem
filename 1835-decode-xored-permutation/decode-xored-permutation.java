class Solution {
    public int[] decode(int[] encoded) {
        int n = encoded.length + 1;
        int totalXor = 0;
        
        for (int i = 1; i <= n; i++) {
            totalXor ^= i;
        }
        
        int oddXor = 0;
        for (int i = 1; i < encoded.length; i += 2) {
            oddXor ^= encoded[i];
        }
        
        int[] perm = new int[n];
        perm[0] = totalXor ^ oddXor;
        
        for (int i = 1; i < n; i++) {
            perm[i] = perm[i - 1] ^ encoded[i - 1];
        }
        
        return perm;
    }
}