package programmers.level2.rotate_brace;

import java.util.*;

public class Solution {
    public int solution(String s) {
        // 1. 주어진 문자열이 올바른 문자열인지 확인.
        // 2. 왼쪽으로 돌림
        // 3. 1, 2번 반복
        // O(n^2)
        StringBuffer sb = new StringBuffer(s);
        int answer = 0;
        for (int i = 0; i < s.length(); i++) {
            if (isRightBraces(sb.toString()))
                answer ++;
            sb.append(sb.charAt(0)).deleteCharAt(0);
        }

        return answer;
    }

    private boolean isRightBraces(String s) {
        if (s.length() % 2 != 0) return false;

        Stack<Character> stack = new Stack<>();
        boolean chk = true;

        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty()) {
                if (!checkFirstBrace(s.charAt(i))) {
                    chk = false;
                    break;
                } else {
                    stack.push(s.charAt(i));
                }
            }else {
                if (checkBrace(stack.peek(), s.charAt(i))) {
                    stack.pop();
                }else {
                    if (checkImpossibleBrace(stack.peek(), s.charAt(i))) {
                        chk = false;
                        break;
                    }else {
                        stack.push(s.charAt(i));
                    }
                }
            }
        }
        return chk;
    }

    private boolean checkFirstBrace(char a) {
        if (a == ')' || a == ']' || a == '}')
            return false;
        return true;
    }

    private boolean checkBrace(char a, char b) {
        if ((a == '(' && b == ')')
                || (a == '[' && b == ']')
                || (a == '{' && b == '}')) {
            return true;
        }
        return false;
    }

    private boolean checkImpossibleBrace(char a, char b) {
        if ((a == '(' && (b == ']' || b == '}'))
                || (a == '[' && (b == ')' || b == '}'))
                || (a == '{' && (b == ')' || b == ']'))) {
            return true;
        }
        return false;
    }
}