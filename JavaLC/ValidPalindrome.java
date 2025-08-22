// Problem: Valid Palindrome
// Link: https://leetcode.com/problems/valid-palindrome/

package JavaLC;

import java.util.logging.*;

public class ValidPalindrome {

    private static final Logger logger = Logger.getLogger(ValidPalindrome.class.getName());

    public boolean isPalindrome(String s) {
        char[] array = s.toLowerCase().toCharArray();
        int low = 0;
        int high = s.length() - 1;
        while(low <= high){
            while(low < s.length() && !Character.isLetterOrDigit(array[low])){
                low++;
            }
            while(high >= 0 && !Character.isLetterOrDigit(array[high])){
                high--;
            }
            if(low < s.length() - 1 && high >= 0){
                Character front = array[low];
                Character back = array[high];
                if(front.equals(back)){
                    return false;
                }
            }
            low++;
            high--;
        }
        return true;
    }

    public static void main(String[] args) {
        ValidPalindrome sol = new ValidPalindrome();
        boolean result = sol.isPalindrome("church");
        logger.log(Level.INFO, String.valueOf(result));

    }
}