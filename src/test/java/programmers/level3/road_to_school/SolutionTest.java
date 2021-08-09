package programmers.level3.road_to_school;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {
    Solution sol = new Solution();

    @Test
    void ex1() {
        //given
        int m = 4;
        int n = 3;
        int[][] puddles = new int[][]{{2, 2}};

        //when
        int ans = sol.solution(m, n, puddles);

        //then
        assertThat(ans).isEqualTo(4);
    }

    @Test
    @DisplayName("학교가 웅덩이로 막힌 경우")
    void ex2() {
        assertThat(
                sol.solution(4, 3, new int[][]{{3, 3}, {4, 2}}))
                .isEqualTo(0);
    }

    @Test
    @DisplayName("집이 웅덩이로 막힌 경우")
    void ex3() {
        assertThat(
                sol.solution(4, 3, new int[][]{{1, 2}, {2, 1}}))
                .isEqualTo(0);
    }

    @Test
    @DisplayName("가는 길이 웅덩이로 막힌 경우")
    void ex4() {
        assertThat(
                sol.solution(4, 3, new int[][]{{3, 1}, {2, 2}, {1, 3}}))
                .isEqualTo(0);
    }
}