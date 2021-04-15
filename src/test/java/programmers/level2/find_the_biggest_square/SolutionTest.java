package programmers.level2.find_the_biggest_square;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    private final Solution sol = new Solution();

    @Test
    public void ex1() {
        int answer = sol.solution(new int[][]{
                {0, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {0, 0, 1, 0}
        });
        assertThat(answer).isEqualTo(9);
    }

    @Test
    public void ex2() {
        int answer = sol.solution(new int[][]{
                {0, 0, 1, 1},
                {1, 1, 1, 1}
        });
        assertThat(answer).isEqualTo(4);
    }
}