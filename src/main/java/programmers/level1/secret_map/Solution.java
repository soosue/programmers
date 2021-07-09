package programmers.level1.secret_map;

public class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for(int i=0; i<n; i++) {
            StringBuffer sb = new StringBuffer();
            String b = Integer.toBinaryString(arr1[i] | arr2[i]);
            for (int j = 0; j < b.length(); j++) {
                if (b.charAt(j) == '1') sb.append('#');
                else sb.append(' ');
            }
            answer[i]=String.format("%"+n+"s", sb.toString());
        }
        return answer;
    }
}