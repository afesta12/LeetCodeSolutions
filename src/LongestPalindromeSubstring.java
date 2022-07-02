public class LongestPalindromeSubstring {

    public String longestPalindrome(String s) {

        int left = 0, right = 0;

        for(int i = 0; i < s.length(); i++) {

            int oddLen = expand(s, i, i);
            int evenLen = expand(s, i, i + 1);

            int len = Math.max(oddLen, evenLen);

            if(len > right - left) {

                left = i - (len - 1) / 2;
                right = i + len / 2;

            }
        }

        return s.substring(left, right + 1);
    }

    public int expand(String s, int left, int right) {

        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {

            left--;
            right++;

        }

        return right - left - 1;
    }



    // TLE
    public static String longestPalindromeTLE(String s) {

        String result = "";

        for(int i = 0; i < s.length(); i++) {

            for(int j = s.length() - 1; j >= i; j--) {

                boolean pal = isPalindrome(s.substring(i, j + 1));

                if(pal && s.substring(i, j + 1).length() > result.length()) result = s.substring(i , j + 1);

            }

        }

        return result;
    }

    public static boolean isPalindrome(String s) {

        StringBuilder build = new StringBuilder(s);

        return build.reverse().toString().equals(s);
    }

}
