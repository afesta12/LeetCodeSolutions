public class RemovingMinAndMaxArray {

    // Initial thought process, kind of messy but 2ms & faster than 100% of online submissions. Get min and max
    // while keeping track of the index for each. Then get the minimum from comparing deleting numbers up to the larger
    // index from the left, the smaller index from the right, and deleting from both sides.
    public int minimumDeletions(int[] nums) {

        if(nums.length == 1) return 1;
        if(nums.length == 2) return 2;

        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        int maxIndex = 0, minIndex = 0;

        for(int i = 0; i < nums.length; i++) {

            int num = nums[i];

            if(num > max) {

                max = num;
                maxIndex = i;

            }

            if(num < min) {

                min = num;
                minIndex = i;

            }

        }

        int higherIndex = Math.max(minIndex, maxIndex);
        int lowerIndex = Math.min(minIndex, maxIndex);

        // Deleting elements from the left
        int case1 = higherIndex + 1;

        // Deleting elements from the right
        int case2 = Math.abs(lowerIndex - nums.length);

        // Deleting elements from the front, then from the end
        int case3 = (lowerIndex + 1) + (nums.length - higherIndex);

        return Math.min(case1, Math.min(case2, case3));
    }

}
