package baekjoon.dfs_bfs.virus_2606;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    /*
        그래프 탐색을 통해 1번 노드가 몇 개의 노드와 연결되어 있는지 세는 문제.
        그래프 탐색에는 dfs, bfs를 이용할 수 있다.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int r = Integer.parseInt(br.readLine());

        int[][] map = new int[n + 1][n + 1];

        //init
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map[x][y] = map[y][x] = 1;
        }

//        System.out.print(dfs(map));
        System.out.print(bfs(map));
    }

    private static int dfs(int[][] map) {
        Stack<Integer> st = new Stack<>();
        boolean[] visited = new boolean[map.length];
        int cnt = 0;

        st.push(1);
        visited[1] = true;

        while (!st.isEmpty()) {
            int v = st.peek();

            boolean isSearching = false;
            for (int i = 1; i < map.length; i++) {
                if (map[v][i] == 1 && !visited[i]) {
                    st.push(i);
                    visited[i] = true;
                    isSearching = true;
                    cnt++;
                    break;
                }
            }

            if (isSearching) {
                continue;
            }else {
                st.pop();
            }
        }
        return cnt;
    }

    private static int bfs(int[][] map) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[map.length];
        int cnt = 0;

        q.add(1);
        visited[1] = true;

        while (!q.isEmpty()) {
            int v = q.poll();

            for (int i = 1; i < map.length; i++) {
                if (map[v][i] == 1 && !visited[i]) {
                    q.add(i);
                    visited[i] = true;
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
