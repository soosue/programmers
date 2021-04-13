package programmers.level1.inner_product;

public class Solution {
    public int solution(int[] a, int[] b) {
        //O(n)
        int answer = 0;
        for (int i = 0; i < a.length; i++) {
            answer += a[i]*b[i];
        }
        return answer;
    }
}
