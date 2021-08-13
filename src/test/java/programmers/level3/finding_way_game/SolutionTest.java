package programmers.level3.finding_way_game;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {
    @Test
    void ex1() {
        assertThat(new Solution()
                .solution(new int[][]{{5,3},{11,5},{13,3},{3,5},{6,1},{1,3},{8,6},{7,2},{2,2}}))
                .isEqualTo(new int[][]{{7,4,6,9,1,8,5,2,3},{9,6,5,8,1,4,3,2,7}});
    }
}