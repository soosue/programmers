package programmers.level2.max_min;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Solution {
    public String solution(String s) {
//        int[] nums = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
        String[] nums = s.split(" ");

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        //O(n)
        for (String num : nums) {
            max = Math.max(max, Integer.parseInt(num));
            min = Math.min(min, Integer.parseInt(num));
        }
        StringBuilder sb = new StringBuilder();
        sb.append(min).append(" ").append(max);

        return sb.toString();
    }
}
