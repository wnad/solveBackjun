package problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

public class P_11401 implements Problem {

    /**
     * Problem 11401: 이힝 계수 3
     *
     * 1. 문제 요약
     *    - 자연수 N 과 정수 K 가 주어졌을 때, 이항 계수 (NK) 를 1,000,000,007로 나눈 나머지를 구하는 프로그램을 작성하시오.
     *    - NCK = N! / ((N-K)!k!)
     *    - NCk mod 1,000,000,007 ?
     *
     * 2. 접근 아이디어
     *    1) 팩토리얼 계산 후 나머지 계산 (수가 너무 커져서 포기)
     *    2) 모듈러 연산을 활용
     *    3) 지수 분할 방법 활용
     *
     * 3. 시간·공간 복잡도
     *    - 시간 : O(N)
     *    - 공간 : O(N)
     *
     * 4. 회고
     *    - 이항 계수와 모듈러 연산을 오랜만에 들어서 문제에 적용하기 어려웠다.
     *    - 현재 문제와 같이 큰 수에 대한 연산을 할 때에는 지수에 분할을 적용해서 작은 수부터 계산하는 방식을 적용해야겠다.
     */

    public static List<String> input = List.of(
            "5 2"
    );

    public static List<String> output = List.of(
            "10"
    );

    static final int P = 1000000007;
    static long[] factorials;

    @Override
    public void exec() throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");

        int N = Integer.parseInt(str[0]);
        int K = Integer.parseInt(str[1]);

        factorials = new long[N+1];

        factorials[0] = 1;
        for (int i=1; i<=N; i++) {
            factorials[i] = factorials[i-1]*i % P;
        }

        // 분자 N!
        long number = factorials[N];

        // 분모 (N-K)!K! mod P
        long denom = factorials[K]*factorials[N-K]%P;

        // 분모의 역원
        long inverseDenom = inverse(denom, P-2)%P;

        System.out.print(number * inverseDenom % P);

    }

    // base^expo % P
    // 역원 구하기
    static long inverse(long base, long expo) {

        // expo 가 1일 경우 바로 base % P 계산
        if (expo == 1) {
            return base % P;
        }

        // expo 절반에 해당하는 A^(expo/2) 를 구하기
        long temp = inverse(base, expo/2);


        // expo 가 홀수일 경우 base 를 한번 더 곱해줘야한다.
        // base^5 = base^2 * base^2 * base
        if (expo%2 == 1) {
            // base^expo%P * base%P
            return (temp*temp%P) * base%P;
        }

        return temp*temp % P;
    }
}
