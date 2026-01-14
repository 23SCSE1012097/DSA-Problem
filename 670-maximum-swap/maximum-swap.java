class Solution {
    public int maximumSwap(int num) {
        char[] digits = Integer.toString(num).toCharArray();
        
       
        int[] last = new int[10];
        for (int i = 0; i < digits.length; i++) {
            last[digits[i] - '0'] = i;
        }
        
      
        for (int i = 0; i < digits.length; i++) {
            int currentDigit = digits[i] - '0';
            
            
            for (int d = 9; d > currentDigit; d--) {
                if (last[d] > i) {
                   
                    char temp = digits[i];
                    digits[i] = digits[last[d]];
                    digits[last[d]] = temp;
                    
                    return Integer.parseInt(new String(digits));
                }
            }
        }
        
       
        return num;
    }
}
