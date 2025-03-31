package BasicJava;
import java.util.HashMap;

public class FrequencyCounter {
    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 3, 1, 4, 2};

        HashMap<Integer, Integer> freqMap = new HashMap<>();

        // 🔁 Count frequency
        for(int num: nums){
            freqMap.put(num, freqMap.getOrDefault(num,0)+1);

        }
        // print frequency of each element
        System.out.println("Frequency of elements:");
        for (int key : freqMap.keySet()) {
            System.out.println("Element: " + key + ", Count: " + freqMap.get(key));
        }

        for(int num : nums){
            if(freqMap.get(num) > 1){
                System.out.println("First duplicate element: " + num);
                break;
            }
        }
    }
}
