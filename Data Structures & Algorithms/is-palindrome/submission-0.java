class Solution {
    public boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        s = s.toLowerCase();

        while (start < end) {
            char startChar = s.charAt(start);
            char endChar = s.charAt(end);
            if (!Character.isLetterOrDigit(startChar)) {
                start += 1;
                continue;
            } else if (!Character.isLetterOrDigit(endChar)) {
                end -= 1;
                continue;
            }

            if (startChar != endChar) {
                return false;
            }

            start += 1;
            end -= 1;
        }

        return true;
    }
}
