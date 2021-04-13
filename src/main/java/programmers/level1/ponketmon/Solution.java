package programmers.level1.ponketmon;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int solution(int[] nums) {
        int pickCount = nums.length / 2;
        Set<Integer> set = new HashSet<>();
        //O(n)
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        int answer = pickCount < set.size() ? pickCount : set.size();
        return answer;
    }
}
