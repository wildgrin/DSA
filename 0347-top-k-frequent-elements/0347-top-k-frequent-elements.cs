public class Solution {
    public int[] TopKFrequent(int[] nums, int k) {
        Dictionary<int, int> freqMap = new Dictionary<int, int>();

        // Count frequencies
        foreach(int num in nums){
            if(freqMap.ContainsKey(num)){
                freqMap[num]++;
            }
            else freqMap[num] = 1;
        }

        // Create buckets to store elements with the same frequency
        List<int>[] bucket = new List<int>[nums.Length + 1];
        foreach(int val in freqMap.Keys){
            int freq = freqMap[val];
            if(bucket[freq] == null){
                bucket[freq] = new List<int>();
            }
            bucket[freq].Add(val);
        }

        // Collect top k frequent elements
        List<int> result = new List<int>();
        for(int i = bucket.Length - 1; i >= 0 && result.Count < k; i--){
            if(bucket[i] != null){
                result.AddRange(bucket[i]);
            }
        }
        return result.ToArray();
    }
}