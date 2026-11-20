class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> seen = new HashMap<>();
        int left = 0;
        int longest = 0;

        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            if (seen.containsKey(currentChar)) {
                left = Math.max(left, seen.get(currentChar) + 1);
            }

            seen.put(currentChar, right);
            longest = Math.max(right - left + 1, longest);
        }

        return longest;

        // Notes:
        // Pattern: Sliding Window + HashMap
        // HashMap: Stores the last seen index of each Character
        // Duplicate handling: only duplicates within the current window matters
        // Key logic: left = Math.max(left, seen.get(current) + 1)
    }
}
