public class SecondLargestDigitInString {

    /**
     * Given an alphanumeric string s, return the second largest numerical digit that appears in s, or -1 if it does not exist.
     *
     * An alphanumeric string is a string consisting of lowercase English letters and digits.
     * @param s the string
     * @return the second largest number in the string or -1
     */
    public int secondHighest(String s) {

        int max = Integer.MIN_VALUE, secondMax = Integer.MIN_VALUE, digitCount = 0;

        for(char ch : s.toCharArray()) {

            if(Character.isDigit(ch)) {

                digitCount++;

                int n = Character.getNumericValue(ch);

                if(n > max) {

                    secondMax = max;
                    max = n;

                } else if(n > secondMax && n < max) {

                    secondMax = n;

                }

            }

        }

        return digitCount == 0 ? - 1 : secondMax == Integer.MIN_VALUE ? - 1 : secondMax;
    }
}
