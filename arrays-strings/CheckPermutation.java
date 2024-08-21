/*
*           We are given two strings , write a method to decide if one is
*           permutation of the other
* */

import java.lang.String;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

public class CheckPermutation {

    public static void main(String[] args) {
        String str1 = "sinrtg";
        String str2 = "string";

        boolean result = checkPermutationUsingMap(str1, str2);
        System.out.println(result);
    }

//          APPROACH #1
//          TIME COMPLEXITY  ----> O(NLOGN)
//          SPACE COMPLEXITY ----> O(N)

    public static boolean checkPermutation(String s1, String s2){
        // if their length are diffrent they can never be permutation of one other
        if(s1.length() != s2.length()){
            return false;
        }
    // We are converting the strings to char-array
        char[] temp1 = s1.toCharArray();
        char[] temp2 = s2.toCharArray();

    // sort the array and if they are permutation of one another they will be equal(at each index both have same char)
        Arrays.sort(temp1);
        Arrays.sort(temp2);

        s1 = String.valueOf(temp1);     //char-array to string
        s2 = String.valueOf(temp2);

        return s1.equals(s2);   // if they are equal return true
    }
//          APPROACH #2
//          TIME COMPLEXITY  ----> O(N)
//          SPACE COMPLEXITY ----> O(N)

    public static boolean checkPermutationUsingMap(String s1, String s2){
        if(s1.length() != s2.length()){
            return false;
        }

        Map<Character, Integer> map = new HashMap<>();

//  keeping track of all the character of string in map
        for(int i = 0; i < s1.length(); i++){
            map.put(s1.charAt(i), map.getOrDefault(s1.charAt(i),0)+1);
        }
// if characters of string 2 present in map we decrement the count and if they are permutation of one another
// we will get a empty map at the end.
        for(int i = 0;i < s2.length(); i++){
            char key = s2.charAt(i);
            // if character is not found in map and present in string 2 return false
            if(!map.containsKey(key)){
                return false;
            }
            map.put(key,map.get(key)-1);
            if(map.get(key) == 0){
                map.remove(key);
            }
        }
        return map.isEmpty();
    }

    public static boolean checkPermutationUsingArray(String s1, String s2){
        if(s1.length() != s2.length()){
            return false;
        }

        int[] letters = new int[128];   // Assuming String character set is ASCII based.

        for(int i = 0; i < s1.length(); i++){
            letters[s1.charAt(i)]++;
        }

        for(int i = 0; i < s2.length(); i++){
            int c = (int)s2.charAt(i);
            letters[c]--;
            if(letters[c] < 0){
                return false;
            }
        }
        return true;
    }

}