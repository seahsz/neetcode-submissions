class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> seen = new HashMap<>();
        int left = 0, right = 0;
        int longest = 0;
        while (right < s.length()) {
            char current = s.charAt(right);
            if (seen.containsKey(current) && seen.get(current) >= left) {
                left = seen.get(current) + 1;
            } else {
                int currLength = right - left + 1;
                longest = Math.max(longest, currLength);
            }

            seen.put(current, right);                 
            right++;
        }

        return longest;

        // learning
        // 1. need to prevent left from going backwards
    }
}
