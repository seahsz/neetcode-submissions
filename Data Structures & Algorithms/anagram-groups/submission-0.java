class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Map<Character, Integer>, List<Integer>> hm = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Map<Character, Integer> charHm = new HashMap<>();
            for (char c : chars) {
                charHm.put(c, charHm.getOrDefault(c, 0) + 1);
            }
            
            // Put the entry into the HashMap
            if (!hm.containsKey(charHm)) {
                List<Integer> newList = new ArrayList<>();
                newList.add(i);
                hm.put(charHm, newList);
            } else {
                List<Integer> currList = hm.get(charHm);
                currList.add(i);
                hm.put(charHm, currList);
            }
        }

        // Create new List
        List<List<String>> result = new ArrayList<>();

        hm.forEach((key, value) -> {
            List<String> innerList = new ArrayList<>();
            for (Integer i : value) {
                innerList.add(strs[i]);
            }
            result.add(innerList);
        });

        return result;
    }
}
