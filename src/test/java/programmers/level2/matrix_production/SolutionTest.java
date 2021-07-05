package programmers.level2.matrix_production;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void ex1() {
        Assertions.assertThat(
                new Solution().solution(new int[][]{{1, 4}, {3, 2}, {4, 1}}, new int[][]{{15, 15}, {15, 15}, {15, 15}})
        );
    }
    @Test
    void ex2() {
        Assertions.assertThat(
                new Solution().solution(new int[][]{{2, 3, 2}, {4, 2, 4}, {3, 1, 4}}, new int[][]{{22, 22, 11}, {36, 28, 18}, {29, 20, 14}})
        );
    }
}