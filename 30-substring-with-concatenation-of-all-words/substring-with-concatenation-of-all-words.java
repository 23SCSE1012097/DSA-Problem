class Solution {
    public List<Integer> findSubstring(String s, String[] words) {

        List<Integer> result = new ArrayList<>();
        if (s.length() == 0 || words.length == 0) return result;

        int wordLen = words[0].length();
        int wordCount = words.length;
        int windowSize = wordLen * wordCount;

      
        HashMap<String, Integer> map = new HashMap<>();
        for (String w : words) {
            map.put(w, map.getOrDefault(w, 0) + 1);
        }

      
        for (int i = 0; i < wordLen; i++) {

            int left = i, count = 0;
            HashMap<String, Integer> tempMap = new HashMap<>();

            for (int right = i; right + wordLen <= s.length(); right += wordLen) {

                String word = s.substring(right, right + wordLen);

                if (map.containsKey(word)) {
                    tempMap.put(word, tempMap.getOrDefault(word, 0) + 1);
                    count++;

                    
                    while (tempMap.get(word) > map.get(word)) {
                        String leftWord = s.substring(left, left + wordLen);
                        tempMap.put(leftWord, tempMap.get(leftWord) - 1);
                        left += wordLen;
                        count--;
                    }

                    
                    if (count == wordCount) {
                        result.add(left);
                    }

                } else {
                    
                    tempMap.clear();
                    count = 0;
                    left = right + wordLen;
                }
            }
        }
        return result;
    }
}
