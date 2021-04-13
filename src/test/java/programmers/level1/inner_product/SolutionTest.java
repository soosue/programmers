package programmers.level1.inner_product;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    private final Solution sol = new Solution();

    @Test
    public void ex1() {
        int answer = sol.solution(new int[]{1, 2, 3, 4}, new int[]{-3, -1, 0, 2});
        assertThat(answer).isEqualTo(3);
    }
    @Test
    public void ex2() {
        int answer = sol.solution(new int[]{-1,0,1}, new int[]{1,0,-1});
        assertThat(answer).isEqualTo(-2);
    }
}