package leetcode.string.groupanagrams;

import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        List<List<String>> result = new GroupAnagrams().groupAnagrams(strs);
        System.out.println(result);
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<List<Character>, List<String>> charToStrMap = new HashMap<>();

        Arrays.stream(strs).forEach(str -> {
            char[] strChars = str.toCharArray();
            List<Character> charList = new ArrayList<>();
            for (char strChar : strChars) {
                charList.add(strChar);
            }
            Collections.sort(charList);
            List<String> anagrams = charToStrMap.get(charList);
            if (anagrams == null) {
                anagrams = new ArrayList<>();
                anagrams.add(str);
                charToStrMap.put(charList, anagrams);
            } else {
                anagrams.add(str);
            }
        });
        return new ArrayList<>(charToStrMap.values());
    }
}
