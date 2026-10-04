class Solution {
    public int[] productExceptSelf(int[] nums) {
        int numZeroes = 0;
        int totalProduct = 1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                numZeroes += 1;
                if (numZeroes == 1) {
                    continue;
                }
            }
            totalProduct *= nums[i];
        }

        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (numZeroes >= 1) {
                    result[i] = 0;
                } else {
                    result[i] = totalProduct / nums[i];
                }
            } else {
                if (numZeroes > 1) {
                    result[i] = 0;
                } else {
                    result[i] = totalProduct;
                }
            }
        }

        return result;

        // if numZeroes == 1 --> then we need 

        // Other notes
        // 1. Brute Force --> for loop with inner for loop, then just exclude if idx i = j
    }
}  
