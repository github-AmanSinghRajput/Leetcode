package SlidingWindow.Medium;

import java.util.HashSet;
import java.util.Set;

public class LongestRepeatingCharacterReplacement {

    private int bruteLongestRepeatingCharacterReplacement(String s, int k) {

       int maxLength = 0;
       for(int i = 0; i < s.length(); i++){
            int[] freq = new int[26];
           int maxFreqInWindow = 0;
            for(int j = i; j < s.length(); j++){
                freq[s.charAt(j) - 'A']++;
                maxFreqInWindow = Math.max(maxFreqInWindow, freq[s.charAt(j) - 'A']);
                int windowSize = j-i+1;
                int numsToReplace = windowSize - maxFreqInWindow;
                if(numsToReplace <= k){
                    maxLength = Math.max(maxLength, windowSize);
                }
            }
       }
       return maxLength;
    }

    private int optimizedLongestRepeatingCharacterReplacement(String s, int k) {
        int[] freqArr = new int[26];
        int maxLength = 0;
        int left = 0;
        int maxFreq = 0;

       for(int right = 0; right < s.length(); right++){
           freqArr[s.charAt(right) - 'A']++;
           maxFreq = Math.max(maxFreq, freqArr[s.charAt(right) - 'A']);

           int windowSize = right - left + 1;
           if(windowSize - maxFreq > k){
               freqArr[s.charAt(left) - 'A']--;
               left++;
           }
           // window size remains same since we move left++;
           maxLength = Math.max(maxLength, right - left + 1);
       }

       return maxLength;

    }

    public static void main(String[] args) {
        LongestRepeatingCharacterReplacement solver = new LongestRepeatingCharacterReplacement();

        System.out.println("Brute Force:");
        System.out.println(solver.bruteLongestRepeatingCharacterReplacement("ABAB", 2)); // 4
        System.out.println(solver.bruteLongestRepeatingCharacterReplacement("AABABBA", 1)); // 4
        System.out.println(solver.bruteLongestRepeatingCharacterReplacement("ABCDE", 2)); // 3

        System.out.println("\nOptimized:");
        System.out.println(solver.optimizedLongestRepeatingCharacterReplacement("ABAB", 2)); // 4
        System.out.println(solver.optimizedLongestRepeatingCharacterReplacement("AABABBA", 1)); // 4
        System.out.println(solver.optimizedLongestRepeatingCharacterReplacement("ABCDE", 2)); // 3
    }
}
