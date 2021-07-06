package baekjoon.dynamic_programming.integer_triangle_1932;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] triangle = new int[n][n + 1];
        int max = 0;

        /*   삼각형 입력 받기
         *   0 7 0 0 0 0
         *   0 3 8 0 0 0
         *   0 8 1 0 0 0
         *   0 2 7 4 4 0
         *   0 4 5 2 6 5
         *   앞에 0을 한 줄 더 만들어서 배열의 경계값 해결.
         * */
        for (int i = 0; i < n; i++) {
            String[] row = br.readLine().split(" ");
            for (int j = 0; j < row.length; j++)
                triangle[i][j + 1] = Integer.parseInt(row[j]);
        }

        //각 줄에 최대 값 계산
        for (int i = 1; i < triangle.length; i++)
            for (int j = 1; j <= i + 1; j++)
                triangle[i][j] += Math.max(triangle[i - 1][j - 1], triangle[i - 1][j]);


        //마지막 row에서 max값 구하기
        for (int i = 1; i < triangle[0].length; i++)
            max = Math.max(max, triangle[triangle.length - 1][i]);

        System.out.print(max);
    }
}
