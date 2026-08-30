class Solution {
    public boolean hasDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int value = nums[i];
            if (map.containsKey(value)) {
                return true;
            } else {
                map.put(value, 0);
            }
        }
        return false;
    }
}