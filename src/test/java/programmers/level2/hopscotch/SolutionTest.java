package programmers.level2.hopscotch;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    Solution sol = new Solution();

    @Test
    public void ex1() {
        assertThat(sol.solution(new int[][]{
                {1, 2, 3, 5},
                {5, 6, 7, 8},
                {4, 3, 2, 1}
        })).isEqualTo(16);
    }
}