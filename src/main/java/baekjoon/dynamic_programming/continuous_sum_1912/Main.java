package baekjoon.dynamic_programming.continuous_sum_1912;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    /*
    풀이
    각 인덱스까지 최고의 연속합을 계산해본다.
    인덱스가 0일 때는 자기 자신
    1일 때는 그 앞까지의 연속합이
     양수면 이 전 인덱스 연속합 + 자기 자신,
     음수면 자기 자신.
    2일 때도 바로 위 로직을 반복한다.
    3일 때도 바로 위 로직을 반복한다.

    위 로직들을 수열의 크기만큼 진행하는 가운데 max값을 저장해놓는다.

    O(n)에 끝난다.
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] tmp = br.readLine().split(" ");

        int[] cSum = new int[n];
        cSum[0] = Integer.parseInt(tmp[0]);
        int max = cSum[0];

        for (int i = 1; i < tmp.length; i++) {
            if (cSum[i - 1] > 0) {
                cSum[i] = Integer.parseInt(tmp[i]) + cSum[i - 1];
            }else {
                cSum[i] = Integer.parseInt(tmp[i]);
            }
            max = Math.max(max, cSum[i]);
        }
        System.out.print(max);
    }
}
