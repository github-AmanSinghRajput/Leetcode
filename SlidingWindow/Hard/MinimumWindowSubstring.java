package SlidingWindow.Hard;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

    private String minWindowBrute(String s, String t){
        String minSubString = null;
        HashMap<Character,Integer> tFreq = new HashMap<>();
        for(char c: t.toCharArray()){
            tFreq.put(c, tFreq.getOrDefault(c,0)+1);
        }

        for(int start=0; start < s.length(); start++) {
            for(int end = start; end < s.length(); end++) {
                String sub = s.substring(start, end + 1);
                if(isValidSubString(sub, tFreq)) {
                    if(minSubString == null || sub.length() < minSubString.length()){
                        minSubString = sub;
                    }
                }
            }
        }
        return minSubString == null ? "" : minSubString;
    }

    private  boolean isValidSubString(String sub, HashMap<Character, Integer> tFreq){
        HashMap<Character, Integer> subFreqMap = new HashMap<>();
        for(char c: sub.toCharArray()){
            subFreqMap.put(c, subFreqMap.getOrDefault(c, 0) + 1);
        }
        for(char key: tFreq.keySet()) {
            if(subFreqMap.getOrDefault(key, 0) < tFreq.get(key)) {
                return false;
            }
        }
        return true;
    }

    //optimized
    private String minWindowOptimized(String s, String t){
        if(s.length() < t.length()) return "";

        Map<Character,Integer> tFreq = new HashMap<>();
        for(char c : t.toCharArray()){
            tFreq.put(c, tFreq.getOrDefault(c, 0) + 1);
        }
        int left = 0, right = 0;
        int formed = 0, required = tFreq.size();
        Map<Character,Integer> windowFreq = new HashMap<>();
        int minLen = Integer.MAX_VALUE;
        int minLeft = 0;
        while(right < s.length()){
            char c = s.charAt(right);
            windowFreq.put(c, windowFreq.getOrDefault(c,0)+1);
            if(tFreq.containsKey(c) && windowFreq.get(c).intValue() == tFreq.get(c).intValue()){
                formed++;
            }
            while(formed == required){
                if((right - left + 1) < minLen){
                    minLen = right - left + 1;
                    minLeft = left;
                }
                char leftChar = s.charAt(left);
                windowFreq.put(leftChar, windowFreq.get(leftChar) -1);
                if(tFreq.containsKey(leftChar) && windowFreq.get(leftChar).intValue() == tFreq.get(leftChar).intValue()){
                    formed--;
                }
                left++;
            }
            right++;
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minLeft, minLeft + minLen);

    }



    public static void main(String[] args) {
    MinimumWindowSubstring solver = new MinimumWindowSubstring();
        System.out.println(solver.minWindowOptimized("ADOBECODEBANC", "ABC")); // Expected: "BANC"
        System.out.println(solver.minWindowOptimized("a", "a"));                // Expected: "a"
        System.out.println(solver.minWindowOptimized("a", "aa"));               // Expected: ""
    }
}
