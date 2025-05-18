package Arrays.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {

    public static List<List<String>> groupAnagramBruteForce(String[] words) {
      HashMap<String, List<String>> anagramListMap = new HashMap<>();

      for(String word: words){
          char[] charsArray = word.toCharArray();
          Arrays.sort(charsArray);
          String sortedWord = new String(charsArray);
          if(!anagramListMap.containsKey(sortedWord)){
              anagramListMap.put(sortedWord, new ArrayList<>());
          }

          anagramListMap.get(sortedWord).add(word);

      }
      return new ArrayList<>(anagramListMap.values());
    };
    public static void main(String[] args) {
            String[] stringsArr = {"eat", "tea", "tan", "ate", "nat", "bat"};
            System.out.println("Resulting grouped anagram : "+ groupAnagramBruteForce(stringsArr));
    }
}
