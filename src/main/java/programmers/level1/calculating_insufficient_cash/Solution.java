package programmers.level1.calculating_insufficient_cash;

public class Solution {
    /*
        풀이
        놀이기구를 count번 탔을 때의 비용 cost는
        price * (1 + 2 + ... + count)이므로 등차수열 계산에 의해
        price * (count * (count + 1))/2이다.

        이후 money < cost가 크면 그 차액 cost - money를
        money >= cost 라면 0을 반환한다.

        단, 문제의 조건에서 price, money, count는 2500이 최대값이다.
        여기서 비용 cost를 계산할 때, 2500 * 2500 * 2501 = 15,631,250,000으로
        int의 최대값인 2,147,483,647을 넘겨버리게 된다.
        따라서 계산할 때 long을 추가해주어 계산 결과가 long으로 나오게 해줘야 한다.
     */
    public long solution(int price, int money, int count) {
        long cost = price * (count * (count + 1l)) / 2;
        System.out.println(Integer.MAX_VALUE);
        return money >= cost ? 0 : cost - money;
    }
}