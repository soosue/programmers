package programmers.level2.the_shortest_distance_of_the_game_map;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {
    @Test
    void ex1() {
        assertThat(new Solution()
                .solution2(new int[][]{
                        {1, 0, 1, 1, 1},
                        {1, 0, 1, 0, 1},
                        {1, 0, 1, 1, 1},
                        {1, 1, 1, 0, 1},
                        {0, 0, 0, 0, 1}
                }))
        .isEqualTo(11);
    }

    @Test
    void ex2() {
        assertThat(new Solution()
                .solution(new int[][]{
                        {1, 0, 1, 1, 1},
                        {1, 0, 1, 0, 1},
                        {1, 0, 1, 1, 1},
                        {1, 1, 1, 0, 0},
                        {0, 0, 0, 0, 1}
                }))
                .isEqualTo(-1);
    }

    @Test
    void ex3() {
        assertThat(new Solution()
                .solution2(new int[][]{
                        {1, 1, 1, 1, 1},
                        {1, 1, 1, 0, 1},
                        {1, 1, 1, 1, 1},
                        {1, 1, 1, 0, 1},
                        {0, 0, 0, 0, 1}
                }))
                .isEqualTo(-1);
    }
}