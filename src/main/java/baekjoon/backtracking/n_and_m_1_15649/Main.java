package baekjoon.backtracking.n_and_m_1_15649;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++)
            list.add(i);

        backTracking(list, new ArrayList<>(), m, sb);
        System.out.print(sb.toString());
    }

    public static void backTracking(List<Integer> list, List<Integer> tmpList, int m, StringBuffer sb) {
        if (m <= 0) {
            for (int i = 0; i < tmpList.size(); i++)
                sb.append(tmpList.get(i)).append(" ");
            sb.append("\n");
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            tmpList.add(list.remove(i));
            backTracking(list, tmpList, m - 1, sb);
            list.add(i, tmpList.remove(tmpList.size() - 1));
        }
    }
}