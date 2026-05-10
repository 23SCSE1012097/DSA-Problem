class Solution {
    public int sumOddLengthSubarrays(int[] arr) {

        int totalSum = 0;

        for (int i = 0; i < arr.length; i++) {

            int currSum = 0;

            for (int j = i; j < arr.length; j++) {

                currSum += arr[j];

                int length = j - i + 1;

                if (length % 2 == 1) {
                    totalSum += currSum;
                }
            }
        }

        return totalSum;
    }
}
