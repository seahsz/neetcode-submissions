class Solution {
    public int longestConsecutive(int[] nums) {

        int longest = 0;

        // convert array into set to lookup
        Set<Integer> seen = new HashSet<>();

        for (int num : nums) {
            seen.add(num);
        }

        for (int num : seen) {
            if (!seen.contains(num - 1)) {
                int currLength = 1;
                int current = num;
                while (seen.contains(current+1)) {
                    currLength++;
                    current++;
                }
                longest = Math.max(longest, currLength);
            }
        }

        return longest;
    }
}
