class Solution {
    public int characterReplacement(String s, int k) {
        int result = 0;
        int left = 0;

        Map<Character, Integer> frequency = new HashMap<>();

        char mostFrequentChar = ' ';
        int highestFrequency = 0;

        for (int right = 0; right < s.length(); right++) {
            char currChar = s.charAt(right);
            frequency.put(currChar, frequency.getOrDefault(currChar, 0) + 1);
            if (frequency.get(currChar) > highestFrequency) {
                highestFrequency = frequency.get(currChar);
                mostFrequentChar = currChar;
            }
            int currLength = right - left + 1;
            int nonFrequentCount = currLength - frequency.get(mostFrequentChar);
            if (nonFrequentCount > k) {
                // Need to drop the count of the left by 1
                frequency.put(s.charAt(left), frequency.get(s.charAt(left)) - 1);
                left++;
            }
            result = Math.max(result, right - left + 1);
        }

        return result;

        // Need a way to keep track of which is the most frequent, which also
        // has to be updated with every move of right?
    }
}
