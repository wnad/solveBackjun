package problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P_11050 implements Problem {

    /*
    문제
    자연수 N 과 정수 K 가 주어졌을 때 이항 계수를 구하는 프로그램을 작성하시오.

    입력
    첫째 줄에 N과 K 가 주어진다. (1 ≤ N ≤ 10, 0 ≤ K ≤ N)

    출력
    이항계수를 출력한다.

    예제 입력 1
5 2

    예제 출력 1
10
     */

    @Override
    public void exec() throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        // 1. 자연수 N 과 정수 K 입력받기.
        StringTokenizer input = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(input.nextToken());
        int K = Integer.parseInt(input.nextToken());

        bufferedReader.close();

        // 2. 계산한 이항계수 출력하기
        System.out.println(calculateBinomialCoefficient(N,K));

    }

    private static int calculateBinomialCoefficient(int N, int K) {
        int numerator = 1;
        int denominator = 1;

        // 1. N! 계산
        for (int i = 1; i <= N; i++) {
            numerator *= i;
        }

        // 2. K! 계산
        for (int i = 1; i <= K; i++) {
            denominator *= i;
        }

        // 3. K!(N-K)! 계산
        for (int i = 1; i <= N - K; i++) {
            denominator *= i;
        }

        // 4. 이항계수 계산
        return numerator / denominator;
    }
}
