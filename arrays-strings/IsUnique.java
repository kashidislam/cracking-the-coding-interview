/*
        Implement an algorithm to determine if a string has all the
            unique characters.

        NOTE:   What if we can't use any additional data structure?

*/

import java.util.Scanner;

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

}