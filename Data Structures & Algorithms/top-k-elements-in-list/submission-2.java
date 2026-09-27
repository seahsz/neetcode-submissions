class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Use heap when we wwant to get largest or smallest --> but when
        // it is Top K Frequent --> can use bucket sort for O(n) instead

        // Heap approach
        Map<Integer, Integer> freq = new HashMap<>();

        // Populate map to contain number and its freq
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        // Use MIN heap to determine top K most frequent
        // Java has built-in min-heap in PriorityQueue
        // You can define the comparator --> we are using the HashMap freq
        PriorityQueue<Integer> heap = 
                new PriorityQueue<>((a, b) -> freq.get(a) - freq.get(b));

        // offer() = insert
        // poll() = remove smallest
        // peak() = look at smallest

        for (int num : freq.keySet()) {
            heap.offer(num);
            if (heap.size() > k) {
                heap.poll();
            }
        }

        int[] result = new int[k];

        for (int i = 0; i < k; i++) {
            result[i] = heap.poll();
        }

        return result;
    }
}
