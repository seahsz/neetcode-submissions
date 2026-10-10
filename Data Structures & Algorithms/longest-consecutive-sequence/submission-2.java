class Solution {
    public int longestConsecutive(int[] nums) {

        int longest = 0;

        // convert array into set to lookup
        Set<Integer> seen = new HashSet<>();

        for (int num : nums) {
            seen.add(num);
        }

        for (int num : nums) {
            if (!seen.contains(num - 1)) {
                int currLength = 1;
                int current = num;
                while (seen.contains(current+1)) {
                    currLength += 1;
                    current += 1;
                }
                longest = Math.max(longest, currLength);
            }
        }

        return longest;
    }
}
