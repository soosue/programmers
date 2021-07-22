package baekjoon.greedy.coin_0_11047;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = 0;

        String[] in = br.readLine().split(" ");
        int n = Integer.parseInt(in[0]);
        int k = Integer.parseInt(in[1]);
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++)
            st.push(Integer.parseInt(br.readLine()));

        while (!st.isEmpty()) {
            Integer coin = st.pop();
            if (k < coin) continue;

            cnt += k / coin;
            k %= coin;
        }
        System.out.print(cnt);
    }
}
