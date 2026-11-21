class Solution {
    public int characterReplacement(String s, int k) {
        int result = 0;
        int left = 0;

        Map<Character, Integer> frequency = new HashMap<>();

        int highestFrequency = 0;

        for (int right = 0; right < s.length(); right++) {
            char currChar = s.charAt(right);
            frequency.put(currChar, frequency.getOrDefault(currChar, 0) + 1);
            highestFrequency = Math.max(highestFrequency, frequency.get(currChar));

            while ((right - left + 1) - highestFrequency > k) {
                frequency.put(s.charAt(left), frequency.get(s.charAt(left)) - 1);
                left++;
            }
            result = Math.max(result, right - left + 1);
        }

        return result;
    }
}
