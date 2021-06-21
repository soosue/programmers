package codewars.kyu4.strip_comments;
import java.util.*;

public class StripComments {

    private static Map<Character, Integer> symbols = new HashMap<>();

    public static String stripComments(String text, String[] commentSymbols) {
        // 문장을 훑으면서 onComments 상태면 append, 아니면 continue,
        // symbol일 경우 onComments 상태, onComments에서 \n을 만나면 상태해제.
        StringBuffer sb = new StringBuffer();
        boolean onComments = false;

        setCommentSymbols(commentSymbols);

        for (int i = 0; i < text.length(); i++) {
            if (isCommentSymbols(text.charAt(i))) {
                onComments = true;
                continue;
            }
            if (text.charAt(i) == '\n') {
                sbTrim(sb);
                onComments = false;
            }
            if (!onComments) sb.append(text.charAt(i));
        }
        return sbTrim(sb).toString();
    }

    private static StringBuffer sbTrim(StringBuffer sb) {
        while (sb.length() > 0 && ' ' == sb.charAt(sb.length() - 1))
            sb.deleteCharAt(sb.length() - 1);
        return sb;
    }

    private static void setCommentSymbols(String[] s) {
        for (int i = 0; i < s.length; i++)
            symbols.put(s[i].charAt(0), 1);
    }

    private static boolean isCommentSymbols(char c) {
        if (symbols.get(c) != null)
            return true;
        return false;
    }
}