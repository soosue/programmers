package programmers.level2.network;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {
    @Test
    void exBfs1() {
        assertThat(new Solution()
                .solution(3, new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 1, 1}}))
                .isEqualTo(2);
    }
    @Test
    void exBfs2() {
        assertThat(new Solution()
                .solution(3, new int[][]{{1, 1, 0}, {1, 1, 1}, {0, 1, 1}}))
                .isEqualTo(1);
    }
    @Test
    void exDfs1() {
        assertThat(new Solution()
                .solution2(3, new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 1, 1}}))
                .isEqualTo(2);
    }
    @Test
    void exDfs2() {
        assertThat(new Solution()
                .solution2(3, new int[][]{{1, 1, 0}, {1, 1, 1}, {0, 1, 1}}))
                .isEqualTo(1);
    }
}