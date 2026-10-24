class Solution {
    public String arrangeWords(String text) {
        String[] words = text.toLowerCase().split(" ");

        java.util.Arrays.sort(words, (a, b) -> a.length() - b.length());

        String result = String.join(" ", words);

        return Character.toUpperCase(result.charAt(0)) + result.substring(1);
    }
}