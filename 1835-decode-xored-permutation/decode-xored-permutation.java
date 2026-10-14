class Solution {
    public int[] decode(int[] encoded) {
        int n = encoded.length + 1;
        int totalXor = 0;
        
        // Step 1: Calculate XOR of all numbers from 1 to n
        for (int i = 1; i <= n; i++) {
            totalXor ^= i;
        }
        
        // Step 2: Calculate XOR of encoded elements at odd indices
        int oddXor = 0;
        for (int i = 1; i < encoded.length; i += 2) {
            oddXor ^= encoded[i];
        }
        
        // Step 3: Find perm[0]
        int[] perm = new int[n];
        perm[0] = totalXor ^ oddXor;
        
        // Step 4: Reconstruct the rest of the perm array
        for (int i = 1; i < n; i++) {
            perm[i] = perm[i - 1] ^ encoded[i - 1];
        }
        
        return perm;
    }
}