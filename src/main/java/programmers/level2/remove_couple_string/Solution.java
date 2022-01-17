package programmers.level2.remove_couple_string;

import java.util.*;

class Solution {
    public int solution(String s) {
        if (s.length() % 2 == 1) {
            return 0;
        }

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty()) {
                stack.push(s.charAt(i));
                continue;
            }

            if (stack.peek() == s.charAt(i)) {
                stack.pop();
                continue;
            }

            stack.push(s.charAt(i));
        }

        return stack.isEmpty()? 1 : 0;
    }
}
