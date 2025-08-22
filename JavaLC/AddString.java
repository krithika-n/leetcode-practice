// Problem: Add Strings
// Link: https://leetcode.com/problems/add-strings/

package JavaLC;

import java.util.logging.*;

public class AddString {

    private static final Logger logger = Logger.getLogger(AddString.class.getName());

    public String addStrings(String num1, String num2) {
        StringBuilder sum = new StringBuilder();
        int p1 = num1.length() - 1;
        int p2= num2.length() - 1;
        int carry = 0;
        while(p1 >= 0 && p2 >= 0){
            int posSum = (num1.charAt(p1--) - '0') + (num2.charAt(p2--)- '0') + carry;
            sum.append(String.valueOf(posSum % 10));
            carry = posSum / 10;
        }
        while(p1 >= 0){
            int posSum = (num1.charAt(p1--) - '0') + carry;
            sum.append(String.valueOf(posSum % 10));
            carry = posSum / 10;
        }

        while(p2 >= 0){
            int posSum = (num2.charAt(p2--)- '0') + carry;
            sum.append(String.valueOf(posSum % 10));
            carry = posSum / 10;
        }
        if(carry != 0){
            sum.append(String.valueOf(carry));
        }
        return sum.reverse().toString();
    }

    public static void main(String[] args) {
        AddString sol = new AddString();
        String result = sol.addStrings("42", "43");
        logger.log(Level.INFO, result);
    }
}