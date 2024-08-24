/*
*       Implement a method to perform basic string compression using the count of repeated characters.
*       Example: String "aabcccccaaa" would become "a2b1c5a3"
*       If the "compressed" string won't become smaller than original string, return the original string.
*       Assumption: String contains only lowercase and uppercase letters (a-z)
* */

import java.util.Scanner;
import java.lang.StringBuilder;
import java.lang.String;

public class StringCompression {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String string = s.nextLine();
        String compressedString = stringCompression(string);
        System.out.println(compressedString);
    }

//  APPROACH  #1
//  TIME COMPLEXITY     O(N)
//  SPACE COMPLEXITY    O(1)
    public static String stringCompression(String s){
        if(s.length() == 1){        // if length of string is 1 simply return the string itself
            return s;
        }
        // Using StringBuilder in place of String will help in decreasing the complexity
        // when we concatenate the string a new copy of string is created and copied over
        // but stringbuilder will create a resizable array of strings and they are copied back when necessary.
        StringBuilder sb = new StringBuilder();

        int count = 0;  // keeping the count of consecutive characters.

        for(int i = 0; i < s.length(); i++){
            count++;
            // when i points to the last index character then i+1 will point to the index out of bound and leads to
            //  runtime error so when i+1 equals to string length then the second condition charAt(i) != charAt(i+1)
            //  won't be executed and we can get the last character appended to stringbuilder with the count

//   if i+1 > s.length() will be there the charAt(i) compared with charAt(i+1) which gives IndexOutOfBound error.
            if((i+1 >= s.length()) || s.charAt(i) != s.charAt(i+1)){
                sb.append(s.charAt(i)).append(count);
                count = 0;
            }
        }
        // if computed string has length greater then original string then returning original string
        return (sb.toString().length() > s.length()) ? s : sb.toString();
    }

}