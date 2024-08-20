/*
        Implement an algorithm to determine if a string has all the
            unique characters.

        NOTE:   What if we can't use any additional data structure?

*/

import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class IsUnique{

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String string = s.nextLine();
        boolean result = hasUniqueCharacters(string);

        if(result){
            System.out.println("The string has all unique characters");
        }
        else{
            System.out.println("The string has duplicate characters");
        }

    }
//      APPROACH #1

//      TIME COMPLEXITY ----> O(N^2)
//      SPACE COMPLEXITY----> O(1)

    public static boolean hasUniqueCharacters(String s){
        // The string is ASCII string
        if(s.length() > 128)    return false;

        for(int i = 0; i < s.length()-1; i++){
            char key = s.charAt(i);
            for(int j = i+1; j < s.length(); j++){
                if(key == s.charAt(j)){
                    return false;
                }
            }
        }
        return true;
    }

//         APPROACH #2

//      What if we use additional data structure    "HashMap"

//      TIME COMPLEXITY ----> O(N)
//      SPACE COMPLEXITY----> O(N)

    public static boolean hasUniqueCharactersUsingExtraSpace(String s){
        if(s.length() > 128)    return false;
        if(s.length() == 0)     return true;    // if string is empty

        Map<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < s.length(); i++){
            char key = s.charAt(i);
            if(map.containsKey(key)){   // if map contains the character we return false
                return false;
            }
            map.put(key,map.getOrDefault(key,0)+1);     // adding characters to map with their frequency
        }
        return true;
    }

//          APPROACH #3

//     if string contains only lowerCase alphabets a-z

//      TIME COMPLEXITY ----> O(N)
//      SPACE COMPLEXITY----> O(1)

    public static boolean hasUniqueCharactersForLowerCaseAlphabets(String s){
        if(s.length() > 26) return false;   // lowerCase aphabets has only 26 characters

        int checker = 0;    // int is 32 bit so to keep a check on alphabets which has only 26 characters.
        for(int i = 0; i < s.length(); i++){
            int bitAtIndex = s.charAt(i) - 'a'; // bit index value of characters

            //if character present in string so checker will make the bit as 1 and
            // when a duplicate character encounters this returns false
            if((checker & (1 << bitAtIndex)) > 0){
                return false;
            }
            checker = (checker | (1 << bitAtIndex));    // characters are make as 1 in bit Index
        }
        return true;
    }



}