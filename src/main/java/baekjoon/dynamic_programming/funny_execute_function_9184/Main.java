package baekjoon.dynamic_programming.funny_execute_function_9184;

import java.io.*;

class Main {
    static final int LIMIT = 20;
    static int[][][] dp = new int[21][21][21];

    public static void main(String[] args) throws IOException {

        //dp에 값이 없으면 w메소드로 구하고, 있으면 바로 반환하는 방식

        dp[0][0][0] = 1;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            String[] xyz = br.readLine().split(" ");
            int x = Integer.parseInt(xyz[0]);
            int y = Integer.parseInt(xyz[1]);
            int z = Integer.parseInt(xyz[2]);

            if (x==-1 && y==-1 && z==-1)
                break;

//            bw.write(String.format("w(%d, %d, %d) = %d\n", x, y, z, w(x, y, z)));//시간 엄청 걸림
            bw.write("w(" + x + ", " + y + ", " + z + ") = " + w(x, y, z) + "\n");
        }
        bw.flush();
    }

    static int w(int x, int y, int z) {
        if (x <= 0 || y <= 0 || z <= 0) {
            return dp[0][0][0];
        }else if (x > LIMIT || y > LIMIT || z > LIMIT){
            if (dp[LIMIT][LIMIT][LIMIT] != 0)
                return dp[LIMIT][LIMIT][LIMIT];
            else
                return dp[LIMIT][LIMIT][LIMIT] = w(LIMIT, LIMIT, LIMIT);
        }else if (dp[x][y][z] != 0) {
            return dp[x][y][z];
        }else {
            int value = 0;
            if (x<y && y<z)
                value = w(x, y, z - 1) + w(x, y - 1, z - 1) - w(x, y - 1, z);
            else
                value = w(x - 1, y, z) + w(x - 1, y - 1, z) + w(x - 1, y, z - 1) - w(x - 1, y - 1, z - 1);

            return dp[x][y][z] = value;
        }
    }
}