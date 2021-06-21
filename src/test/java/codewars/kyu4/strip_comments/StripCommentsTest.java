package codewars.kyu4.strip_comments;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StripCommentsTest {
    @Test
    void ex1() {
        assertEquals(
                "apples, pears\ngrapes\nbananas",
                StripComments.stripComments( "apples, pears # and bananas\ngrapes\nbananas !apples", new String[] { "#", "!" } )
        );
    }

    @Test
    void ex2() {
        assertEquals(
                "a\nc\nd",
                StripComments.stripComments( "a #b\nc\nd $e f g", new String[] { "#", "$" } )
        );
    }
}