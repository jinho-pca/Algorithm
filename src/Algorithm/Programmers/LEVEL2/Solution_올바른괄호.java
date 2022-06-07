package Algorithm.Programmers.LEVEL2;

import java.util.Stack;

public class Solution_올바른괄호 {
    public boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        int len = s.length();
        if(s.charAt(0) == ')') return false;
        if(s.charAt(len-1) == '(') return false;
        for(int i = 0; i < len; i++) {
            char current = s.charAt(i);
            if(current == '(') stack.push(current);
            else {
                if(stack.empty()) return false;
                if(stack.peek() == '(') stack.pop();
                else return false;
            }
        }
        return stack.empty();
    }
}
