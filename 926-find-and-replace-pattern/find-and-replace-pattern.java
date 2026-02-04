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
        Map<Character, Character> pToW = new HashMap<>();
        Map<Character, Character> wToP = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            char p = pattern.charAt(i);
            char w = word.charAt(i);

            if (pToW.containsKey(p) && pToW.get(p) != w)
                return false;

            if (wToP.containsKey(w) && wToP.get(w) != p)
                return false;

            pToW.put(p, w);
            wToP.put(w, p);
        }
        return true;
    }
}
