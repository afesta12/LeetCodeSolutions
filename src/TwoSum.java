import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();

        int len = nums.length;

        for(int i = 0; i < len; i++) {

            int difference = target - nums[i];

            if(map.containsKey(difference)) {

                return new int[]{map.get(difference), i};

            }

            map.put(nums[i], i);
        }

        return new int[]{-1, -1};
    }

}
