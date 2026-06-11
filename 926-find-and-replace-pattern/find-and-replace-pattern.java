import java.util.*;

class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> result = new ArrayList<>();

        for (String word : words) {
            if (matches(word, pattern)) {
                result.add(word);
            }
        }

        return result;
    }

    private boolean matches(String word, String pattern) {
        Map<Character, Character> wToP = new HashMap<>();
        Map<Character, Character> pToW = new HashMap<>();

        for (int i = 0; i < word.length(); i++) {
            char w = word.charAt(i);
            char p = pattern.charAt(i);

            if (wToP.containsKey(w)) {
                if (wToP.get(w) != p) {
                    return false;
                }
            } else {
                wToP.put(w, p);
            }

            if (pToW.containsKey(p)) {
                if (pToW.get(p) != w) {
                    return false;
                }
            } else {
                pToW.put(p, w);
            }
        }

        return true;
    }
}