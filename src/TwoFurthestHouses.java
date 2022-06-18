public class TwoFurthestHouses {

    /**
     * There are n houses evenly lined up on the street, and each house is beautifully painted.
     * You are given a 0-indexed integer array colors of length n, where colors[i] represents the color of the ith house.
     *
     * Return the maximum distance between two houses with different colors.
     *
     * The distance between the ith and jth houses is abs(i - j), where abs(x) is the absolute value of x.
     *
     * Either the first house or the last house will always have the max distance, iterate from the left and right,
     * once a different color house is found return.
     *
     * @param colors the array of house colors
     * @return the max distance between two houses of different colors
     */
    public int maxDistance(int[] colors) {

        int left = 0, right = colors.length - 1, len = colors.length;

        while(left < len) {

            if(colors[0] == colors[right]) right--;
            else return right;

            if(colors[len - 1] == colors[left]) left++;
            else return len - 1 - left;

        }

        return 0;
    }

    /*
    Iterate and check every pair of houses. Since the input is small this solution will not time out.
     */
    public int maxDistanceSimple(int[] colors) {

        int maxDistance = Integer.MIN_VALUE;

        int len = colors.length;

        for(int left = 0; left < len; left++) {

            for(int right = left + 1; right < len; right++) {

                if(colors[left] != colors[right]) {

                    maxDistance = Math.max(maxDistance, right - left);

                }

            }

        }

        return maxDistance;
    }

}
