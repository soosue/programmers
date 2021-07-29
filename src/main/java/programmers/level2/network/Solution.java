package programmers.level2.network;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    /*
        풀이
        컴퓨터들을 하나씩 확인하면서 네트워크 개수를 세는데 이미 사용되었는지 확인을 해본다.

        예)
        0번 컴퓨터를 기준으로 네트워크 연결된 컴퓨터들을 확인한다.
        확인하면서 연결된 컴퓨터는 체크했다고 표시를 해놓는다.
        0번과 연결된 컴퓨터를 모두 확인했으면 네트워크 개수를 하나 증가시킨다.

        다음 컴퓨터가 체크되었는지 확인한다.
        체크되었다면 해당 컴퓨터가 속한 네트워크는 이미 카운팅 되어 있는 네트워크이므로 다음 컴퓨터로 넘어간다.
        체크되지 않았다면 해당 컴퓨터가 속한 네트워크는 카운팅 하지 않은 네트워크이므로, 연결된 컴퓨터 탐색을 시작한다.

        연결된 컴퓨터를 체크하는 것이므로 bfs, dfs 모두 가능하다.
     */
//    int cnt = 0;

    //bfs(while)
    public int solution(int n, int[][] computers) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n];
        int network = 0;
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                q.add(i);
                visited[i] = true;

                while (!q.isEmpty()) {
                    int com = q.poll();

                    for (int j = 0; j < n; j++) {
//                        System.out.println("bfs : " + ++cnt);
                        if (computers[com][j] == 1 && !visited[j]) {
                            q.add(j);
                            visited[j] = true;
                        }
                    }
                }
                network++;
            }
        }
        return network;
    }

    //dfs(recursive)
    public int solution2(int n, int[][] computers) {
        boolean[] visited = new boolean[n];
        int network = 0;
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(computers, visited, i);
                network++;
            }
        }
        return network;
    }

    private void dfs(int[][] computers, boolean[] visited, int com) {
        for (int i = 0; i <computers.length; i++) {
//            System.out.println("dfs : " + ++cnt);
            if (computers[com][i] == 1 && !visited[i]) {
                visited[i] = true;
                dfs(computers, visited, i);
            }
        }
    }
}
