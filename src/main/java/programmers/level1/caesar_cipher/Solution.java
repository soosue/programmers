package programmers.level1.caesar_cipher;

public class Solution {
    public String solution(String s, int n) {
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                sb.append(" ");
            } else {
                char a = Character.isUpperCase(c) ? 'A' : 'a';
                sb.append((char) ((c + n - a) % 26 + a));
            }
        }

        return sb.toString();
    }
}
