class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();

        for (int num : nums) {
            freq.put(num, (freq.getOrDefault(num, 0) + 1));
        }

        List<Integer>[] buckets = new List[nums.length + 1];

        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            int num = entry.getKey();
            int frequency = entry.getValue();

            if (buckets[frequency] == null) {
                buckets[frequency] = new ArrayList<>();
            }

            buckets[frequency].add(num);
        }

        int[] result = new int[k];
        int idx = 0;

        for (int frequency = buckets.length - 1; idx < k && frequency >= 0; frequency--) {
            if (buckets[frequency] != null) {

                for (int num : buckets[frequency]) {
                    result[idx++] = num;

                    if (idx == k) {
                        break;
                    }
                }
            }
        }

        return result;
    }
}
