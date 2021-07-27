package baekjoon.dfs_bfs.dfs_and_bfs_1260;

import java.io.*;
import java.util.*;

public class Main {
    /*
        풀이
        map[from][to] = map[to][from] = 1의 이유는
        1과 2와 연결되었다는 사실을
        1 2로 줄 수도 있지만, 2 1로 줄 수도 있기 때문이다.

        그래프를 표현하는 방법에 2차배열 말고
        https://www.acmicpc.net/source/31480761처럼 할 수도 있다.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        String[] first = br.readLine().split(" ");
        int n = Integer.parseInt(first[0]);
        int m = Integer.parseInt(first[1]);
        int start = Integer.parseInt(first[2]);

        int[][] map = new int[n + 1][n + 1];

        //init
        for (int i = 0; i < m; i++) {
            String[] row = br.readLine().split(" ");
            int from = Integer.parseInt(row[0]);
            int to = Integer.parseInt(row[1]);
            map[from][to] = map[to][from] = 1;
        }

        //dfs
        Stack<Integer> st = new Stack<>();
        boolean[] visitedDfs = new boolean[n + 1];

        st.push(start);
        visitedDfs[start] = true;
        sb.append(start);

        while (!st.isEmpty()) {
            int s = st.peek();

            boolean isSearching = false;
            for (int i = 1; i < map.length; i++) {
                if (map[s][i] == 1 && !visitedDfs[i]) {
                    isSearching = true;
                    st.push(i);
                    visitedDfs[i] = true;
                    sb.append(' ').append(i);
                    break;
                }
            }
            if (isSearching) {
                continue;
            }else {
                st.pop();
            }
        }
        sb.append('\n');

        //bfs
        Queue<Integer> q = new LinkedList<>();
        boolean[] visitedBfs = new boolean[n + 1];

        q.add(start);
        visitedBfs[start] = true;
        sb.append(start);

        while (!q.isEmpty()) {
            int s = q.poll();

            for (int i = 1; i < map.length; i++) {
                if (map[s][i] == 1 && !visitedBfs[i]) {
                    q.add(i);
                    visitedBfs[i] = true;
                    sb.append(' ').append(i);
                }
            }
        }
        System.out.print(sb.toString());
    }
}
