package stack;

import java.util.Stack;

/**
 * Created by sisyphuspan on 16/4/21.
 */
public class LongestValidParentheses_32 {

    public int longestValidParentheses(String s) {
        if(s == null || s.length() == 0)
            return 0;
        Stack<Character> stack = new Stack<Character>();
        boolean flag = false;
        int count = 0;
        int max = 0;
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == ')' && !stack.empty() && stack.peek()=='(') {
                stack.pop();
                if(flag) {
                    count += 2;
                }else {
                    count = 2;
                }

                flag = true;
                if(max < count)
                    max = count;
            }else {
                stack.push(s.charAt(i));
                flag = false;
            }

        }
        return max;
    }
}
