package problem;

import java.util.Arrays;

public class SieveOfEratosthenes {

    // 에라토스테네스 체 알고리즘
    public static boolean[] sieve(int N) {

        // isPrime[n] 값이 n이 소수인지 아닌지 판별할 수 있게 배열 크기를 N+1 로 정의
        boolean[] isPrime = new boolean[N + 1];

        // isPrime 배열을 모두 true 로 초기화
        Arrays.fill(isPrime, true);

        // 0과 1은 소수가 아니므로 false 로 변경
        isPrime[0] = false;
        isPrime[1] = false;

        // 2부터 n의 제곱근까지 반복
        // 자연수 n 까지의 소수는 √n 범위 내에서 판별 가능
        for (int num = 2; num <= Math.sqrt(N); num++) {

            // num 이 소수인 경우, num 의 배수들을 false 로 설정
            if (isPrime[num]) {
                for (int multiple = (int) Math.pow(num, 2); multiple <= N; multiple += num) {
                    isPrime[multiple] = false;
                }
            }
        }

        return isPrime;
    }

    public static void main(String[] args) {

        // 자연수 n 까지의 모든 소수를 구함
        int n = 100;

        // n 이하 자연수를 에라토스테네스 체로 거르기
        boolean[] isPrime = sieve(n);

        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                System.out.print(i + " ");
            }
        }
    }
}
