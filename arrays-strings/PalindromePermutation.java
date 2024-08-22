/*
*       Given a string, write a function to check if it is a permutation of palindrome.
*       A palindrome is a word or phrase that is a same forwards and backwards.
*       A permutation is a rearrangement of letters.
* */

import java.util.Scanner;

public class PalindromePermutation{

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        String string = s.nextLine();
        boolean result = isPermutationIsPalindrome(string);
        if(result){
            System.out.println("Permutation of " + string + " is a palindrome");
        }
        else{
            System.out.println("Permutation of " + string + " is NOT a palindrome");
        }

    }

//  APPROACH #1
//  TIME COMPLEXITY ----> O(N)
//  SPACE COMPLEXITY----> O(1)

    public static boolean isPermutationIsPalindrome(String s){
        if(s.length() == 1){    // string of length 1 is always palindrome
            return true;
        }
        int[] count = new int[26];  // int array to count occurrences of each character from 'a' to 'z'

        for(int i = 0; i < s.length(); i++){
            int key = s.charAt(i) - 'a';
            count[key]++;
        }

        int countOdd = 0;

        // count the number of oddNumber of occurrences of characters
        for(int i = 0; i < 26; i++){
            if((count[i] % 2) == 1){
                countOdd++;
            }
        }
        // if count oddNumber of occurences of character is more than 1 then it's not a palindrome.
        if(countOdd > 1) return false;
        return true;
    }

}