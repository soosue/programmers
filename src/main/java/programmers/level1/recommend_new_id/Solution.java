package programmers.level1.recommend_new_id;

public class Solution {

    public static void main(String[] args) {
        new Solution().solution("=.=");
    }

    public String solution(String new_id) {

        // 1. 모든 대문자를 대응되는 소문자로 치환
        new_id = toLowerCase(new_id);

        // 2. 알파벳 소문자, 숫자, -, _, .만 남기기
        new_id = fastFilter(new_id);
//        String regex = "[^a-z\\d-_.]";
//        String replacement = "";
//        new_id = applyRegexTo(new_id, regex, replacement);

        // 3. .가 2번 이상 연속된 부분을 하나의 .로 치환하기
        String regex2 = "\\.{2,}";
        String replacement2 = ".";
        new_id = applyRegexTo(new_id, regex2, replacement2);

        // 4. .가 처음이나 마지막에 위치한다면 제거
        new_id = removeFirstFullstop(new_id);
        new_id = removeLastFullstop(new_id);

        // 5. 빈 문자열이라면, "a"를 대입하기
        String defaultId = "a";
        new_id = ifEmptyId(new_id, defaultId);

        // 6. 길이가 16자 이상이면, 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거하기
        // 만약 제거 후 .가 끝에 위치한다면 끝에 위치한 .문자를 제거
        int idMaxLength = 15;
        new_id = limitMaxLength(new_id, idMaxLength);

        // 7. 길이가 2자 이하라면, 마지막 문자를 길이가 3이 될 때까지 반복해서 끝에 붙이기
        int idMinLength = 3;
        new_id = limitMinLength(new_id, idMinLength);

        return new_id;
    }

    private String fastFilter(String new_id) {
        StringBuilder tmp = new StringBuilder();
        for (int i = 0; i < new_id.length(); i++) {
            if (
                    ('a' <= new_id.charAt(i) && new_id.charAt(i) <= 'z')
                        || ('0' <= new_id.charAt(i) && new_id.charAt(i) <= '9')
                        || new_id.charAt(i) == '-' || new_id.charAt(i) == '_' || new_id.charAt(i) == '.') {

                tmp.append(new_id.charAt(i));
            }
        }
        return tmp.toString();
    }

    private String toLowerCase(String s) {
        return s.toLowerCase();
    }

    private String applyRegexTo(String s, String regex, String replacement) {
        return s.replaceAll(regex, replacement);
    }
    private String removeFirstFullstop(String s) {
        if (s.startsWith("."))
            s = s.substring(1);
        return s;
    }

    private String removeLastFullstop(String s) {
        if (s.endsWith("."))
            s = s.substring(0, s.length()-1);
        return s;
    }

    private String ifEmptyId(String s, String defaultId) {
        if (s.length() == 0)
            s = defaultId;
        return s;
    }

    private String limitMinLength(String s, int l) {
        StringBuilder tmp = new StringBuilder(s);
        while (tmp.length() < l) {
            tmp.append(tmp.charAt(tmp.length()-1));
        }
        return tmp.toString();
    }

    private String limitMaxLength(String s, int l) {
        if (s.length() > l)
            s = s.substring(0, l);
        return removeLastFullstop(s);
    }
}
