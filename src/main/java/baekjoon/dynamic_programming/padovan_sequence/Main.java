package baekjoon.dynamic_programming.padovan_sequence;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static long[] dp = new long[101];
    public static void main(String[] args) throws IOException {

        dp[1] = dp[2] = dp[3] = 1;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int N = Integer.parseInt(br.readLine());
            //O(n)
            for (int j = 4; j <= N; j++)
                dp[j] = dp[j - 2] + dp[j - 3];

            sb.append(dp[N]).append("\n");
        }
        System.out.print(sb.toString());
    }
}
