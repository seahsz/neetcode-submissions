class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length -2; i++) {
            if (i >= 1 && nums[i] == nums[i-1]) {
                continue;
            }
            int j = i + 1;
            int k = nums.length - 1;
            int target = -1 * nums[i];
            while (j < k) {
                int sum = nums[j] + nums[k];
                if (sum == target) {
                    // save the combi
                    List<Integer> combi = List.of(nums[i], nums[j], nums[k]);
                    result.add(combi);
                    // somehow prevent duplicate
                    j += 1;
                    k -= 1;
                    while (j < nums.length && nums[j] == nums[j-1]) {
                        j += 1;
                    }

                } else if (sum < target) {
                    j += 1;
                } else {
                    k -= 1;
                }
            }
        }

        return result;
    }
}
