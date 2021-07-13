package programmers.level2.making_jaden_case_string;

import java.util.StringTokenizer;

public class Solution {
    /*
        풀이
        모든 단어의 첫문자가 대문자, 그 나머지는 소문자인 문자열을 만들려면.
        최소 한 번의 순회를 해야하므로 최소 O(n)이다.

        StringTokenizer나 split을 이용하면 순회를 한 번 더 돌기는 한다.

        고려사항(문제 조건)
        s가 한 글자거나 여러 글자일 때 문제가 생기는가?
        첫글자가 ' '일 때 문제가 생기는가?

     */
    public String solution(String s) {
        StringBuffer sb = new StringBuffer();

        boolean isFirst = true;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                sb.append(' ');
                isFirst = true;
            }else if (isFirst) {
                sb.append(Character.toUpperCase(s.charAt(i)));
                isFirst = false;
            }else {
                sb.append(Character.toLowerCase(s.charAt(i)));
            }
        }
        return sb.toString();
    }
}
