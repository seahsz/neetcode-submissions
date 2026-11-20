class Solution {
    public int maxArea(int[] heights) {
        int left = 0, right = heights.length -1;
        int result = 0;
        while (left < right) {
            int leftHeight = heights[left];
            int rightHeight = heights[right];
            if (leftHeight > rightHeight) {
                result = Math.max(result, (right - left) * rightHeight);
                right--;
            } else {
                result = Math.max(result, (right - left) * leftHeight);
                left++;
            }
        }

        return result;
    }
}
