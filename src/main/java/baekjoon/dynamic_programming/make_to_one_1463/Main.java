package baekjoon.dynamic_programming.make_to_one_1463;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int[] min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());
        min = new int[x + 1];

        for (int i = 2; i <= x; i++) {
            min[i] = min[i - 1];
            if (i % 3 == 0)
                min[i] = Math.min(min[i], min[i / 3]);
            if (i % 2 == 0)
                min[i] = Math.min(min[i], min[i / 2]);

            min[i]++;
        }

        System.out.print(min[x]);
    }
}

//
//10
//
//5                9
//4                3     8
//2  3             1 2   4   7
//1  1 2             1
//     1