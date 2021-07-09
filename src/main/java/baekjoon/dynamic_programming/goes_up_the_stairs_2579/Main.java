package baekjoon.dynamic_programming.goes_up_the_stairs_2579;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    /*
        계단 맨 위에서부터 각 계단에서 얻을 수 있는 최고 점수를 계산하면서 내려온다.
        마지막 인덱스 n에서는 마지막 점수.
        max[n] = s[n] + s[n-1] + max[n-3]   -> 1
        max[n] = s[n] + max[n-2]            -> 2

        max[n] = 1, 2중 최대값
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] scores = new int[n + 1];
        int[] max = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            scores[i] = Integer.parseInt(br.readLine());
        }
        max[1] = scores[1];
        if (n > 1)
            max[2] = scores[1] + scores[2];


        for (int i = 3; i <= n; i++) {
            max[i] = Math.max(max[i - 3] + scores[i - 1], max[i - 2]) + scores[i];
        }

        System.out.print(max[n]);
    }
}
