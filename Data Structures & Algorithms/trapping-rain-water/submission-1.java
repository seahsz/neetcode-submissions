class Solution {
    public int trap(int[] height) {
        int result = 0;
        int[] prefixMax = new int[height.length];
        int[] suffixMax = new int[height.length];

        int lMax = 0, rMax = 0;
        for (int i = 0; i < height.length; i++) {
            prefixMax[i] = lMax;
            lMax = Math.max(lMax, height[i]);
        }

        for (int i = height.length - 1; i > -1; i--) {
            suffixMax[i] = rMax;
            rMax = Math.max(rMax, height[i]);
        }

        for (int i = 0; i < height.length; i++) {
            int currArea = Math.min(prefixMax[i], suffixMax[i]) - height[i];
            if (currArea > 0) {
                result += currArea;
            } 
        }

        return result;

        // Lesson 1: can't just check if curr height is shorter than L height
        // Because there may be smaller containers that exist without
        // Being taller than L height
    }
}
