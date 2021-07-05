package programmers.level2.matrix_production;

public class Solution {
    /**
     * 문제분석 - 행렬의 곱셈에는 규칙성이 존재한다. mxa axn처럼 a부분이 같아야만 곱셈을 할 수 있고, 그 결과 mxn이 나온다.
     * 규칙은
     * s[0][0] = m[0][0]*n[0][0] + m[0][1]*n[1][0]
     * s[0][1] = m[0][0]*n[0][1] + m[0][1]*n[1][1] 와 같다.
     *
     * 가운데 뭉쳐 있는 값이 a까지 0, 1..씩 증가하여
     * s[m][n] += m[m][a]*n[a][n] 와 같이 된다.
     */
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];

        for (int i = 0; i < answer.length; i++)
            for (int j = 0; j < answer[i].length; j++)
                for (int k = 0; k < arr1[i].length; k++)
                    answer[i][j] += arr1[i][k] * arr2[k][j];
        return answer;
    }
}