package baekjoon.dynamic_programming.the_longest_increasing_subsequence_11053;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    /*
     풀이 bottom up
     각 인덱스에서 가장 긴 증가하는 부분 수열을 저장해놓는다.
     인덱스가 0일 때, 1이다.
     인덱스가 1일 때, 이전 인덱스들 중에서 자기 자신 보다 작은 수들을 확인하고 있으면, 길이들 중 최대 값에 +1을 하여 값을 저장한다.
     인덱스가 2일 때, 위 로직을 반복한다.
     인덱스가 3일 때, 위 로직을 반복한다.
     O(n^2)
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] num = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] len = new int[n];

        for (int i = 0; i < n; i++) {
            len[i] = 1;
            for (int j = 0; j < i; j++)
                if (num[j] < num[i] && len[i] < len[j] + 1)
                    len[i] = len[j] + 1;
        }

        int max = Arrays.stream(len).max().getAsInt();

        System.out.print(max);
    }
}