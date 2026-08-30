class Solution {
    public boolean isAnagram(String s, String t) {
        // Do a length check first
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> mapS = new HashMap<>();
        Map<Character, Integer> mapT = new HashMap<>();

        for (char character: s.toCharArray()) {
            if (mapS.containsKey(character)) {
                int currCount = mapS.get(character);
                mapS.put(character, currCount + 1);
            } else {
                mapS.put(character, 1);
            }
        }

        for (char character: t.toCharArray()) {
            if (mapT.containsKey(character)) {
                int currCount = mapT.get(character);
                mapT.put(character, currCount + 1);
            } else {
                mapT.put(character, 1);
            }
        }

        return mapS.equals(mapT);
    }
}
