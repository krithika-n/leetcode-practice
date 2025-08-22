// Problem: Backspace String Compare
// Link: https://leetcode.com/problems/backspace-string-compare/

package JavaLC;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.logging.*;

public class BackspaceStringCompare {

    private static final Logger logger = Logger.getLogger(BackspaceStringCompare.class.getName());

    public boolean backspaceCompare(String s, String t) {
        Deque<Character> sStack = getFinalStringStack(s);
        Deque<Character> tStack = getFinalStringStack(t);
        while(!sStack.isEmpty() && !tStack.isEmpty()){
            if(!sStack.pop().equals(tStack.pop())){
                return false;
            }
        }
        return sStack.isEmpty() && tStack.isEmpty();
    }

    private Deque<Character> getFinalStringStack(String s){
        Deque<Character> stack = new ArrayDeque();
        for(Character ch: s.toCharArray()){
            if(ch.equals('#')){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            } else {
                stack.push(ch);
            }
        }
        return stack;
    }

    public static void main(String[] args) {
        BackspaceStringCompare sol = new BackspaceStringCompare();
        boolean result = sol.backspaceCompare("adft###", "abc##");
        logger.log(Level.INFO, String.valueOf(result));
    }
}