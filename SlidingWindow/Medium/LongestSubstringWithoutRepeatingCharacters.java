package SlidingWindow.Medium;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    private int bruteForceLengthOfLongestSubstring(String s){
        int longestSubstringLength = 0;
        for(int i=0; i<s.length(); i++){
            Set<Character> seen = new HashSet<>();
            for(int j = i; j< s.length(); j++) {
                if(seen.contains(s.charAt(j))) break;
                seen.add(s.charAt(j));
                longestSubstringLength = Math.max(longestSubstringLength,j - i +1);
            }
        }
        return longestSubstringLength;

    }
    private int slidingWindowForceLengthOfLongestSubstring(String s){
        int longestSubstringLength = 0;
        int left = 0;
        int right = 0;
        Set<Character> seen = new HashSet<>();
        while(right < s.length()){
            if(!seen.contains(s.charAt(right))){
                seen.add(s.charAt(right));
                longestSubstringLength = Math.max(longestSubstringLength, right - left + 1);
                right++;
            }else{
                seen.remove(s.charAt(left));
                left++;
            }
        }
        return longestSubstringLength;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters obj = new LongestSubstringWithoutRepeatingCharacters();

        String[] tests = {
                "abcabcbb",  // Expected 3 ("abc")
                "bbbbb",     // Expected 1 ("b")
                "pwwkew",    // Expected 3 ("wke")
                "",          // Expected 0 (empty string)
                "a",         // Expected 1 (single char)
                "abcdefg",   // Expected 7 (all unique)
                "abba",      // Expected 2 ("ab" or "ba")
                "tmmzuxt",   // Expected 5 ("mzuxt")
                "dvdf",      // Expected 3 ("vdf")
                "anviaj",    // Expected 5 ("nviaj")
        };

        for (String test : tests) {
            int bruteResult = obj.bruteForceLengthOfLongestSubstring(test);
            int optResult = obj.slidingWindowForceLengthOfLongestSubstring(test);

            System.out.println("Input      : \"" + test + "\"");
            System.out.println("Brute      : " + bruteResult);
            System.out.println("Optimized  : " + optResult);
            System.out.println((bruteResult == optResult ? "✅ PASSED" : "❌ FAILED"));
            System.out.println("-----------------------------------");
        }
    }
}
