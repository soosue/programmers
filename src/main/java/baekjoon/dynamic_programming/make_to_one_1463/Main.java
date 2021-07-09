package baekjoon.dynamic_programming.make_to_one_1463;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.TemporalUnit;

public class Main {
    private static int[] min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());
        min = new int[x + 1];

        //Top down vs Bottom up
        //Bottom up O(n)
        //Top down
        // 36으로 예를 들면,
        //
        // 36
        // 12                               18          35
        // 4        6       11              17          34
        // 2   3            10              16          33
        //                  5   9           15          32
        //                          8       14          31
        //                          7       13          30
        //                                              29
        //                                              28
        //                                              27
        //                                              26
        //                                              25
        //                                              24
        //                                              23
        //                                              22
        //                                              21
        //                                              20
        //                                              19
        // 결국 각 위치에서의 값은 다 구하면서, 함수 횟수시간만 더 증가하게 된다.

        LocalDateTime before = LocalDateTime.now();
        System.out.println(answerOfB(x));
        LocalDateTime after = LocalDateTime.now();
        System.out.println("duration : " + Duration.between(before, after).toNanos());
    }

    //Bottom up방식
    private static int answerOfB(int x) {
        for (int i = 2; i <= x; i++) {
            min[i] = min[i - 1];
            if (i % 3 == 0)
                min[i] = Math.min(min[i], min[i / 3]);
            if (i % 2 == 0)
                min[i] = Math.min(min[i], min[i / 2]);

            min[i]++;
        }
        return min[x];
    }

    //Top down방식
    private static int answerOfT(int x) {
        if (x == 1) return 0;
        else if (min[x] != 0) return min[x];
        int answer = Integer.MAX_VALUE;

        if (x % 3 == 0)
            answer = Math.min(answerOfT(x / 3), answer);
        if (x % 2 == 0)
            answer = Math.min(answerOfT(x / 2), answer);
        if (x >= 1)
            answer = Math.min(answerOfT(x - 1), answer);

        return answer + 1;
    }
}