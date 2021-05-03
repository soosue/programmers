package programmers.level3.whole_number_triangle;

public class Solution {
    public int solution(int[][] triangle) {

        /*
        * a : 해당 위치에서의 합
        * b : 합들 중 선택할 수 있는 값
        * c : 해당 위치에서의 값
        *
        * a(n) = Max(b(n-1)) + c(n)
        *
        * */

        int l = triangle.length;
        int[][] memo = new int[l+1][l+1];

        for (int i = 0; i < triangle.length; i++)
            for (int j = 0; j < triangle[i].length; j++)
                memo[i+1][j+1] = Math.max(memo[i][j], memo[i][j+1]) + triangle[i][j];


        int answer = 0;
        for (int i = 0; i < triangle[l-1].length; i++)
            answer = Math.max(answer, memo[l][i+1]);

        return answer;
    }
}
