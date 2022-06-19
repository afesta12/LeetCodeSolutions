public class IsSubsequence {

    /**
     * Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
     *
     * A subsequence of a string is a new string that is formed from the original string by deleting some (can be none)
     * of the characters without disturbing the relative positions of the remaining characters.
     *
     * (i.e., "ace" is a subsequence of "abcde" while "aec" is not).
     *
     * Initial thought process is to iterate over t, increment a pointer each time the pointer == a letter in s. If
     * the pointer == s.length() return true.
     *
     * @param s the first string
     * @param t second string
     * @return true if s is a substring of t
     */
    public boolean isSubsequenceInitial(String s, String t) {

        int left = 0, right = 0, len = 0;

        while(left < s.length() && right < t.length()) {

            if(s.charAt(left) == t.charAt(right)) {

                len++;
                left++;

            }

            if(len == s.length()) return true;
        }

        // Check if s is an empty string
        return s.isBlank();
    }

    // Same thought process, but improved to 1ms - faster than 91.23%
    public boolean isSubsequence(String s, String t) {

        if(s.isEmpty()) return true;

        int left = 0, len = s.length(), tLen = t.length();

        for(int i = 0; i < tLen; i++) {

            if(t.charAt(i) == s.charAt(left)) left++;

            if(left == len) return true;

        }

        return false;
    }

}
