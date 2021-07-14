package programmers.level2.word_chain;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {
    @Test
    void ex1() {
        assertThat(new Solution()
                .solution(3, new String[]{"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"}))
                .containsExactly(new int[]{3, 3});
    }
    @Test
    void ex2() {
        assertThat(new Solution()
                .solution(5, new String[]{"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"}))
                .containsExactly(new int[]{0, 0});
    }
    @Test
    void ex3() {
        assertThat(new Solution()
                .solution(2, new String[]{"hello", "one", "even", "never", "now", "world", "draw"}))
                .containsExactly(new int[]{1, 3});
    }

}