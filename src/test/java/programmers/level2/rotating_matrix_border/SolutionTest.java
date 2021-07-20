package programmers.level2.rotating_matrix_border;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {
    @Test
    void ex1() {
        Assertions.assertThat(new Solution()
                .solution(6, 6, new int[][]{{2,2,5,4},{3,3,6,6},{5,1,6,3}}))
                .containsExactly(8, 10, 25);
    }
    @Test
    void ex2() {
        Assertions.assertThat(new Solution()
                .solution(3, 3, new int[][]{{1,1,2,2},{1,2,2,3},{2,1,3,2},{2,2,3,3}}))
                .containsExactly(1, 1, 5, 3);
    }
    @Test
    void ex3() {
        Assertions.assertThat(new Solution()
                .solution(100, 97, new int[][]{{1,1,100,97}}))
                .containsExactly(1);
    }
}