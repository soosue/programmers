package programmers.level2.hopscotch;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    Solution sol = new Solution();

    @Test
    public void ex1() {
        int answer = sol.solution(new int[][]{
                {1, 2, 3, 5},
                {5, 6, 7, 8},
                {4, 3, 2, 1}
        });

        Assertions.assertThat(answer).isEqualTo(16);
    }
}