class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> indices = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int currVal = nums[i];
            int diff = target - currVal;
            if (indices.containsKey(diff)) {
                return new int[]{indices.get(diff), i};
            } else {
                indices.put(currVal, i);
            }
        }

        return new int[0];
    } 
}
