class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;
        int[] s1_chars = new int[26];
        int[] s2_chars = new int[26];
        int n = s1.length();
        for (int i = 0; i < n; i++) { //create a window
            s1_chars[s1.charAt(i) - 'a']++;
            s2_chars[s2.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s2.length() - n; i++) { //slide the window
            if (matches(s1_chars, s2_chars))
                return true;
            s2_chars[s2.charAt(i + n) - 'a']++;
            s2_chars[s2.charAt(i) - 'a']--;
        }
        return matches(s1_chars, s2_chars);
    }
    public boolean matches(int[] s1map, int[] s2map) {
        for (int i = 0; i < 26; i++) {
            if (s1map[i] != s2map[i])
                return false;
        }
        return true;
    }
}