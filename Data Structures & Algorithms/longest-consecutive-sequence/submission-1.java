class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        // convert array into set to lookup
        Set<Integer> seen = new HashSet<>();

        for (int num : nums) {
            seen.add(num);
        }

        // Set to hold nums that are possible starts
        Set<Integer> possibleStarts = 
            seen.stream()
                .filter(n -> !seen.contains(n-1))
                .collect(Collectors.toSet());

        int longest = 1;

        for (int num : possibleStarts) {
            int currLength = 1;
            int current = num;
            while (seen.contains(current+1)) {
                currLength += 1;
                current += 1;
            }
            if (currLength > longest) {
                longest = currLength;
            }
        }

        return longest;
    }
}
