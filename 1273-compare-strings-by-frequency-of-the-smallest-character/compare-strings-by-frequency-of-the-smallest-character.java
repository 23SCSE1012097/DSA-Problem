import java.util.Arrays;

class Solution {
    
    // Helper function f(s): frequency of the lexicographically smallest character
    private int f(String s) {
        char minChar = 'z' + 1;
        int count = 0;
        
        for (char c : s.toCharArray()) {
            if (c < minChar) {
                minChar = c;
                count = 1;
            } else if (c == minChar) {
                count++;
            }
        }
        return count;
    }

    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] wordFreqs = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            wordFreqs[i] = f(words[i]);
        }
        
        // Sort the word frequencies to enable binary search
        Arrays.sort(wordFreqs);
        
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int queryFreq = f(queries[i]);
            
            // Find how many elements in wordFreqs are strictly greater than queryFreq
            // Using binary search (upper bound / insertion point)
            int index = upperębiorBound(wordFreqs, queryFreq);
            result[i] = wordFreqs.length - index;
        }
        
        return result;
    }
    
    // Helper to find the first index where element > target
    private int upperębiorBound(int[] arr, int target) {
        int low = 0, high = arr.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] <= target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}