package programmers.level2.repeating_binary_conversion;

public class Solution {
    public int[] solution(String s) {
        StringBuilder sb = new StringBuilder(s);
        int[] answer = new int[2];
        String tmp = null;

        while (sb.length() > 1) {
            answer[0]++;
            answer[1] += removeZero(sb);
            tmp = Integer.toBinaryString(sb.length());
            sb.setLength(0);
            sb.append(tmp);
        }

        return answer;
    }

    private int removeZero(StringBuilder sb) {
        int rmvCnt = 0;
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '0') {
                rmvCnt++;
                sb.deleteCharAt(i);
                i--;
            }
        }
        return rmvCnt;
    }
}