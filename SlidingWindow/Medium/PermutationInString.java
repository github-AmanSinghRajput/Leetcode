package SlidingWindow.Medium;

import java.util.Arrays;

public class PermutationInString {
    private boolean bruteCheckInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;

        int[] s1Freq = new int[26];

        // Build freq map for s1
        for (char c : s1.toCharArray()) {
            s1Freq[c - 'a']++;
        }
        for(int i=0; i<= s2.length() - s1.length(); i++){
            int[] s2Freq = new int[26];
            for(int j = 0; j < s1.length(); j++){
                s2Freq[s2.charAt(i + j) - 'a']++;
            }
            if(matches(s1Freq,s2Freq)) return true;
        }
        return false;
    }

    //helper to match freq arrays
    private boolean matches(int[] a, int[] b){
        for(int i = 0; i<26; i++){
            if(a[i] != b[i]) return false;
        }
        return true;
    }

    private boolean optimizedCheckInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;
        int[] s1Freq = new int[26];
        for(char c : s1.toCharArray()){
            s1Freq[c - 'a']++;
        }

        int[] windowFreq = new int[26];
        for(int i = 0; i < s1.length(); i++){
            windowFreq[s2.charAt(i) - 'a']++;
        }
        if(Arrays.equals(s1Freq,windowFreq)){
            return true;
        }
        for(int i= s1.length(); i < s2.length(); i++){
            windowFreq[s2.charAt(i - s1.length()) - 'a']--;
            windowFreq[s2.charAt(i) - 'a']++;
            if(Arrays.equals(s1Freq,windowFreq)) return true;

        }
        return false;

    }
    public static void main(String[] args) {

    }
}
