class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if (s2.length() < s1.length()) {
            return false;
        }

        Map<Character, Integer> m = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            char currChar = s1.charAt(i);
            m.put(currChar, m.getOrDefault(currChar, 0) + 1);
        }

        Map<Character, Integer> seen = new HashMap<>();
        int l = 0, r = l + s1.length() - 1;

        // Initialize seen Map;
        for (int i = 0; i < s1.length(); i++) {
            char currChar = s2.charAt(i);
            seen.put(currChar, seen.getOrDefault(currChar, 0) + 1);
        }

        if (m.equals(seen)) {
            return true;
        }

        while(r < s2.length() - 1) {
            int leftCount = seen.get(s2.charAt(l));
            if (leftCount - 1 == 0) {
                seen.remove(s2.charAt(l));
            } else {
                seen.put(s2.charAt(l), leftCount - 1);
            }
            l++;
            r++;
            seen.put(s2.charAt(r), seen.getOrDefault(s2.charAt(r), 0) + 1);
            if (m.equals(seen)) {
                return true;
            }
        }

        return false;
    }
}
