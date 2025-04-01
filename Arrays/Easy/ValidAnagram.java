package Arrays.Easy;

import java.util.Arrays;
import java.util.HashMap;

public class ValidAnagram {
    public static boolean isAnagramBrute(String s, String t){
       if(s.length() != t.length()) return false;

       char[] a = s.toCharArray();
       char[] b = t.toCharArray();

       Arrays.sort(a);
       Arrays.sort(b);

       return Arrays.equals(a, b);
    }

    //Optimized solution using arrays
    // pros of this solution -> no memory wastage like hashmaps
    public static boolean isAnagramOptimized(String s, String t){
        if(s.length() != t.length()) return false;
       int[] freq = new int[26];

       for(int i=0; i < s.length(); i++){
           freq[s.charAt(i) - 'a']++;
           freq[t.charAt(i) - 'a']--;
       }

       for(int count: freq){
           if(count != 0) return false;
       }

       return true;

    }

    //Optimized solution using Hashmaps
    // Cons of this solution ->  memory wastage in form of buckets but dynamic memory allocation
    public static boolean isAnagramHashmap1(String s, String t){
        if(s.length() != t.length()) return false;

        HashMap<Character,Integer> freq = new HashMap<>();

        for(int letterIndex = 0; letterIndex < s.length(); letterIndex++){
            // creating the frequency map from string s
            freq.put(s.charAt(letterIndex), freq.getOrDefault(s.charAt(letterIndex),0) + 1);
            // now going to use string t to reduce the characters from freqMap
            freq.put(t.charAt(letterIndex), freq.getOrDefault(t.charAt(letterIndex), 0) -1 );
        }

        for(char key: freq.keySet()){
            if(freq.get(key) != 0) return false;
        }

        return true;
    }

    // another approach using hashmaps

    public static boolean isAnagramHashMap2(String s, String t) {
        if (s.length() != t.length()) return false;
        HashMap<Character,Integer>  map = new HashMap<>();

        // Count frequency from string s
        for(char c: s.toCharArray()){
            map.put(c, map.getOrDefault(c,0) + 1);
        }

        for(char c: t.toCharArray() ){
            if(!map.containsKey(c)) return false;

            map.put(c, map.get(c) - 1);
            if(map.get(c) < 0) return false;
        }

        return true;
    }


    public static void main(String[] args) {
        System.out.println("Brute: " + isAnagramBrute("anagram", "nagaram")); // true
        System.out.println("Brute: " + isAnagramBrute("rat", "car"));         // false

        System.out.println("Optimized: " + isAnagramOptimized("anagram", "nagaram")); // true
        System.out.println("Optimized: " + isAnagramOptimized("rat", "car"));         // false

        System.out.println("Optimized: " +  isAnagramHashMap2("aaaaanagram", "nagaram")); // false
        System.out.println("Optimized: " + isAnagramHashMap2("rat", "car"));         // false


    }
}
