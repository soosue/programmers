package programmers.level2.menu_renewal;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    @Test
    void ex1() {
        String[] ans = new Solution().solution(new String[]{"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"}, new int[]{2, 3, 4});
        assertThat(ans).containsExactly(new String[]{"AC", "ACDE", "BCFG", "CDE"});
    }

    @Test
    void ex2() {
        String[] ans = new Solution().solution(new String[]{"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"}, new int[]{2, 3, 5});
        assertThat(ans).containsExactly(new String[]{"ACD", "AD", "ADE", "CD", "XYZ"});
    }

    @Test
    void ex3() {
        String[] ans = new Solution().solution(new String[]{"XYZ", "XWY", "WXA"}, new int[]{2, 3, 4});
        assertThat(ans).containsExactly(new String[]{"WX", "XY"});
    }
}