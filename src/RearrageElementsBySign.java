public class RearrageElementsBySign {

    /**
     * You are given a 0-indexed integer array nums of even length
     * consisting of an equal number of positive and negative integers.
     *
     * You should rearrange the elements of nums such that the modified array follows the given conditions:
     *
     * Every consecutive pair of integers have opposite signs.
     *
     * For all integers with the same sign, the order in which they were present in nums is preserved.
     *
     * The rearranged array begins with a positive integer.
     *
     * Return the modified array after rearranging the elements to satisfy the aforementioned conditions.
     *
     * Use two pointers, left = 0 and right = 1. Use the pointers to write to the array. If the number is > 0,
     * write at index left and increment by 2, if it is negative, write at index right and increment right by 2.
     * Since the array length is even and the problem states that the array will always start with a positive integer,
     * it will also always end with a negative integer.
     *
     * @param nums the array
     * @return the modified array
     */
    public int[] rearrangeArray(int[] nums) {

        int len = nums.length;
        int[] result = new int[len];

        int left = 0, right = 1;

        for (int num : nums) {

            if (num > 0) {

                result[left] = num;
                left += 2;

            } else {

                result[right] = num;
                right += 2;
            }

        }

        return result;
    }

}
