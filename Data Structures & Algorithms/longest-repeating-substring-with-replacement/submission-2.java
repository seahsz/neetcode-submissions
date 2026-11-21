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

        // Key takeaways: try to use While for a more elegant solution
        // Also it is the broader and more inclusive pattern when
        // Dealing with Sliding Window
        // Compared to using "if (right - left + 1) - highestFrequency > k"
        // Which works for this problem since we are always only incrementing 
        // right by 1 and the condition fails when k is exceeded by 1
        // So using "if" works since we will only need to reduce left by 1
        // each time the condition fails
    }
}
