
class Solution {
    public int maxDiff(int num) {
        String s = String.valueOf(num);

        char[] maxArr = s.toCharArray();
        char[] minArr = s.toCharArray();

        char x = ' ';
        for (int i = 0; i < maxArr.length; i++) {
            if (maxArr[i] != '9') {
                x = maxArr[i];
                break;
            }
        }

        if (x != ' ') {
            for (int i = 0; i < maxArr.length; i++) {
                if (maxArr[i] == x) {
                    maxArr[i] = '9';
                }
            }
        }

        if (minArr[0] != '1') {
            x = minArr[0];
            for (int i = 0; i < minArr.length; i++) {
                if (minArr[i] == x) {
                    minArr[i] = '1';
                }
            }
        } else {
            for (int i = 1; i < minArr.length; i++) {
                if (minArr[i] != '0' && minArr[i] != '1') {
                    x = minArr[i];
                    for (int j = 1; j < minArr.length; j++) {
                        if (minArr[j] == x) {
                            minArr[j] = '0';
                        }
                    }
                    break;
                }
            }
        }

        int maxNum = Integer.parseInt(new String(maxArr));
        int minNum = Integer.parseInt(new String(minArr));

        return maxNum - minNum;
    }
}
