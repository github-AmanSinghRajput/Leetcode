package Arrays.Medium;

import java.util.*;


public class Kfrequent {

    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> freqMap = new HashMap<>();

        for(int number: nums) {
            freqMap.put(number, freqMap.getOrDefault(number, 0) + 1);
        }
        // Min-Heap to keep top K elements based on frequency
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(
                (a, b) -> freqMap.get(a) - freqMap.get(b)  // lower freq = higher priority
        );

        for(int num: freqMap.keySet()){
            minHeap.add(num);
            if(k < minHeap.size()){
                minHeap.poll();
            }
        }



        int[] result = new int[minHeap.size()];
        int i = 0;
        for(int value: minHeap){
            result[i++] = value;
        }

        return result;

    }

    public int[] topFrequentBucketSort(int[] nums, int k){
        Map<Integer,Integer> freqMap = new HashMap<>();
        for(int num: nums){
            freqMap.put(num, freqMap.getOrDefault(num,0)+1);

        }

        // Step 2: Create the bucket (index = frequency)
        @SuppressWarnings("unchecked")
        List<Integer>[] bucket = new ArrayList[nums.length + 1];
        for(int i = 0; i<bucket.length; i++){
            bucket[i] = new ArrayList<>();

        }
        // Fill the bucket
        for (int num : freqMap.keySet()) {
            int freq = freqMap.get(num);
            bucket[freq].add(num);
        }

        // Step 3: Collect top K from the end
        List<Integer> result = new ArrayList<>();
        for(int i = bucket.length - 1; i >=0 && result.size() < k; i--){
                for(int num: bucket[i]){
                    result.add(num);
                    if(result.size() == k) break;
                }
        }
        // Convert to int[]
        int[] resArr = new int[k];
        for(int i=0;i<k; i++){
            resArr[i] = result.get(i);
        }
        return resArr;
    }

    public static void main(String[] args) {
        Kfrequent kf = new Kfrequent();

        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;

        System.out.println("Top K Frequent: " + Arrays.toString(kf.topKFrequent(nums, k)));
        System.out.println("Top K Frequent: " + Arrays.toString(kf.topFrequentBucketSort(nums, k)));
    }
}
