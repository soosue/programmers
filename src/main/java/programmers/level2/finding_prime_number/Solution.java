package programmers.level2.finding_prime_number;

import java.util.*;

public class Solution {
    private boolean[] visited;
    private Set<Integer> set = new HashSet<>();
    public int solution(String numbers) {
        int l = numbers.length();
        int[] nums = new int[l];
        visited = new boolean[l];

        //init
        for (int i = 0; i < numbers.length(); i++)
            nums[i] = numbers.charAt(i) - '0';

        per(nums, 0, new StringBuffer());

        return (int) set.stream().filter((item) -> isPrimeNumber(item)).count();
//        return set.size();
    }

    private void per(int[] nums, int depth, StringBuffer sb) {
        set.add(toInteger(sb.toString()));

        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                sb.append(nums[i]);
                per(nums, depth + 1, sb);
                visited[i] = false;
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    private void dfs(int[] nums, int depth, StringBuffer sb) {
        if (depth == nums.length) {
            int n = toInteger(sb.toString());
            if (isPrimeNumber(n))
                set.add(n);
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                sb.append(nums[i]);
                visited[i] = true;

                dfs(nums, depth + 1, sb);

                if (!"".equals(nums[i]))
                    sb.deleteCharAt(sb.length() - 1);
                visited[i] = false;

                visited[i] = true;
                dfs(nums, depth + 1, sb);
                visited[i] = false;
            }
        }
    }

    private int toInteger(String num) {
        if (num.isBlank() || num.isEmpty())
            return 0;
        return Integer.parseInt(num);
    }

    private boolean isPrimeNumber(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0)
                return false;
        }
        return n > 1;
    }
}