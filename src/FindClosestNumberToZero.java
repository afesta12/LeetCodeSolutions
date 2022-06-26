public class FindClosestNumberToZero {

    /**
     * Given an integer array nums of size n, return the number with the value closest to 0 in nums.
     * If there are multiple answers, return the number with the largest value.
     * @param nums the array
     * @return the value closest to zero
     */
    public int findClosestNumber(int[] nums) {

        int closestToZero = Integer.MAX_VALUE;

        for(int n : nums) {

            int current = Math.abs(n);

            if(current < Math.abs(closestToZero)) {

                closestToZero = n;

            } else if(current == Math.abs(closestToZero)) {

                closestToZero = Math.max(closestToZero, n);

            }

        }

        return closestToZero;
    }

}
