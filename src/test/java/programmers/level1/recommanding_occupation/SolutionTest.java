package programmers.level1.recommanding_occupation;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {
    @Test
    public void ex1() {
        assertThat(new Solution()
                .solution(new String[]{"SI JAVA JAVASCRIPT SQL PYTHON C#", "CONTENTS JAVASCRIPT JAVA PYTHON SQL C++", "HARDWARE C C++ PYTHON JAVA JAVASCRIPT", "PORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP", "GAME C++ C# JAVASCRIPT C JAVA"},
                        new String[]{"PYTHON", "C++", "SQL"},
                        new int[]{7, 5, 5}))
                .isEqualTo("HARDWARE");
    }

    @Test
    public void ex2() {
        assertThat(new Solution()
                .solution(new String[]{"SI JAVA JAVASCRIPT SQL PYTHON C#", "CONTENTS JAVASCRIPT JAVA PYTHON SQL C++", "HARDWARE C C++ PYTHON JAVA JAVASCRIPT", "PORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP", "GAME C++ C# JAVASCRIPT C JAVA"},
                        new String[]{"JAVA", "JAVASCRIPT"},
                        new int[]{7, 5}))
                .isEqualTo("PORTAL");

    }
}