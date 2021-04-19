package baekjoon.dynamic_programming.funny_execute_function_9184;

import java.io.*;

public class Main2 {
    static final int LIMIT = 20;
    static int[][][] dp = new int[LIMIT + 1][LIMIT + 1][LIMIT + 1];

    public static void main(String[] args) throws IOException {

        //dp를 모두 초기화하고 값을 사용하는 방식
        initDp();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            String[] xyz = br.readLine().split(" ");
            int x = Integer.parseInt(xyz[0]);
            int y = Integer.parseInt(xyz[1]);
            int z = Integer.parseInt(xyz[2]);

            if (x == -1 && y == -1 && z == -1)
                break;

            int value = 0;
            if (x <= 0 || y <= 0 || z <= 0)
                value = 1;
            else if (x > LIMIT || y > LIMIT || z > LIMIT)
                value = dp[LIMIT][LIMIT][LIMIT];
            else
                value = dp[x][y][z];

            bw.write("w(" + x + ", " + y + ", " + z + ") = " + value + "\n");
        }
        bw.flush();
    }

    private static void initDp() {
        for (int i = 0; i < dp.length; i++)
        for (int j = 0; j < dp.length; j++)
                dp[0][i][j] = dp[i][0][j] = dp[i][j][0] = 1;

        for (int i = 1; i < dp.length; i++)
        for (int j = 1; j < dp.length; j++)
        for (int k = 1; k < dp.length; k++)
                    if (i < j && j < k)
                        dp[i][j][k] = dp[i][j][k - 1] + dp[i][j - 1][k - 1] - dp[i][j - 1][k];
                    else
                        dp[i][j][k] = dp[i - 1][j][k] + dp[i - 1][j - 1][k] + dp[i - 1][j][k - 1] - dp[i - 1][j - 1][k - 1];
    }
}
