package programmers.level1.number_string_and_english;

public class Solution {

    /*
        풀이
        한글자씩 체크하며 해당 숫자가 맞는지 확인해본다.
        O(n)

        모두 확인하기 전에 두번째 글자까지만 확인해도 숫자를 판단할 수 있다.
        두번째 글자까지만 확인하고 숫자로 바꾼다.

        한글자씩 순회하는데 숫자면 숫자.
        영어면 두번째 글자까지 확인 후 숫자로 바꾸고 다음 인덱스만큼 증가시켜준다.
     */
    public int solution(String s) {
        String[] nums = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isAlphabetic(c)) {
                char c2 = s.charAt(i + 1);
                for (int j = 0; j < nums.length; j++) {
                    if (c == nums[j].charAt(0) && c2 == nums[j].charAt(1)) {
                        sb.append(j);
                        i += nums[j].length() - 1;
                        break;
                    }
                }
            } else {
                sb.append(c);
            }
        }
        return Integer.parseInt(sb.toString());
    }
}