/*
    Implement an algorithm to determine if a string has all unique characters. 
            What if you cannot use additional data structures?
*/
package arraysAndStrings;

public class IsUnique{

    public static void main(String[] args){

        String str = "abcdea";
        System.out.println(isUnique(str));
        System.out.println(isUniqueOptimized(str)); // This is the optimized version
        
    }

        // This is the brute force method
        // Time complexity: O(n^2)
        // Space complexity: O(1)

    public static boolean isUnique(String str){

        for(int i = 0; i < str.length(); i++){
            for(int j = i + 1; j < str.length(); j++){
                if(str.charAt(i) == str.charAt(j)){
                    return false;
                }
            }
        }
        return true;
    }

        // This is the optimized version
        // Time complexity: O(n)
        // Space complexity: O(1)

    public static boolean isUniqueOptimized(String str){

        if(str.length() > 128){
            return false;
        }
        boolean[] char_set = new boolean[128];
        for(int i = 0; i < str.length(); i++){
            int val = str.charAt(i);
            if(char_set[val]){
                return false;
            }
            char_set[val] = true;
        }
        return true;
    }

}