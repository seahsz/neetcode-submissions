class Solution {
    public int[] productExceptSelf(int[] nums) {

        // Vers 1. Division
        // Vers 2. Prefix and suffix (extra array or within array)

        int[] result = new int[nums.length];
        int prefix = 1;

        for (int i = 0; i < nums.length; i++) {
            // insert prefix first
            result[i]  = prefix;
            prefix *= nums[i];
        } 

        int suffix = 1;
        for (int i = nums.length - 1; i > -1; i--) {
            // insert suffix first before multiplying
            result[i] *= suffix;
            suffix *= nums[i];
        }

        return result;
    }
}  
