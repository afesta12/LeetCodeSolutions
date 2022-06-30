public class ContainerWithMostWater {

    // Realized I was checking too many conditions / had too many variables, and the code could be simplified. This improved the speed by 2ms.
    public int maxAreaOptimized(int[] height) {

        int max = Integer.MIN_VALUE, left = 0, right = height.length - 1;

        while(left < right) {

            if(height[left] > height[right]) {

                max = Math.max(max, height[right] * (right - left));
                right--;

            } else {

                max = Math.max(max, height[left] * (right - left));
                left++;

            }

        }

        return max;
    }

    // Initial thought process. Watch index numbers for length. 2 pointers, get the shorted of the two heights,
    // then use the length of the rectangle for the other side. This gets the area when multiplied. If the sides are
    // equal, get area and move both pointers.
    public int maxArea(int[] height) {

        int maxArea = 0, left = 0, right = height.length - 1;

        while(left < right) {

            int leftHeight = height[left], rightHeight = height[right], area = 0;

            if(leftHeight > rightHeight) {

                area = rightHeight * (right - left);
                right--;

            } else if(leftHeight < rightHeight) {

                area = leftHeight * (right - left);
                left++;

            } else {

                area = leftHeight * (right - left);
                left++;
                right--;

            }

            maxArea = Math.max(maxArea, area);

        }

        return maxArea;
    }
}
