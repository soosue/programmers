package programmers.level1.reverse_ternary;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int solution(int n) {
        //O(2n)? => O(n)
        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();

        while (n > 0) {
            queue.add(n%3);
            n/=3;
        }
        while (!queue.isEmpty()) {
            answer += queue.poll() * Math.pow(3, queue.size());
        }

        return answer;
    }
}
