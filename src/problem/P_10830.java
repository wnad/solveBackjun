package problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;

public class P_10830 implements Problem {

    /**
     * Problem 10830: 행렬 제곱
     *
     * 1. 문제 요약
     *    - 크기가 N*N인 행렬 A가 주어진다. 이때, A의 B제곱을 구하는 프로그램을 작성하시오.
     *    - 수가 매우 커질 수 있으니, A^B의 각 원소를 1,000으로 나눈 나머지를 출력한다.
     *    - 입력 :
     *      - 첫째 줄에 행렬의 크기 N과 B가 주어진다. (2 ≤ N ≤  5, 1 ≤ B ≤ 100,000,000,000)
     *      - 둘째 줄부터 N개의 줄에 행렬의 각 원소가 주어진다. 행렬의 각 원소는 1,000보다 작거나 같은 자연수 또는 0이다.
     *    - 출력 :
     *      - 첫째 줄부터 N개의 줄에 걸쳐 행렬 A를 B제곱한 결과를 출력한다.
     *
     *
     * 2. 접근 아이디어
     *    1) 행렬의 제곱을 계산
     *    2) 제곱이 조 단위의 숫자까지 가기 때문에 지수 분할로 접근
     *    3) 행렬의 곱셈 구현
     *
     * 3. 시간·공간 복잡도
     *    - 시간 : O(N^3)
     *    - 공간 : O(N^2)
     *
     * 4. 회고
     *    - 분할 계산법을 접한 후에 풀어서 크게 문제는 없었다.
     *    - 문제 조건을 제대로 확인하고 풀자.
     *      - 1000으로 나눈 나머지를 출력해야해서 기존 1000인 요소는 0으로 나와야한다.
     *      - 그래서 1000 일때 예외 처리를 적용해야한다.
     *
     */

    public static List<String> input = List.of(
            "2 5\n" +
                    "1 2\n" +
                    "3 4",
            "3 3\n" +
                    "1 2 3\n" +
                    "4 5 6\n" +
                    "7 8 9",
            "5 10\n" +
                    "1 0 0 0 1\n" +
                    "1 0 0 0 1\n" +
                    "1 0 0 0 1\n" +
                    "1 0 0 0 1\n" +
                    "1 0 0 0 1"
    );

    public static List<String> output = List.of(
            "69 558\n" +
                    "337 406",
            "468 576 684\n" +
                    "62 305 548\n" +
                    "656 34 412",
            "512 0 0 0 512\n" +
                    "512 0 0 0 512\n" +
                    "512 0 0 0 512\n" +
                    "512 0 0 0 512\n" +
                    "512 0 0 0 512"
    );

    static int[][] base;

    static int N, M;

    @Override
    public void exec() throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer nm = new StringTokenizer(br.readLine());

        // 행렬의 크기
        N = Integer.parseInt(nm.nextToken());

        // 행렬의 M 제곱
        M = Integer.parseInt(nm.nextToken());

        base = new int[N][N];

        for (int i=0; i<N; i++) {
            StringTokenizer str = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++) {
                // 1000 으로 나눈 나머지를 출력
                // 기존 원소가 1000 이면 0으로 처리
                base[i][j] = Integer.parseInt(str.nextToken())%1000;
            }
        }

        br.close();

        int[][] result = powMatrix(M);

        StringBuilder sb = new StringBuilder();

        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {

                sb.append(result[i][j]);

                if (j!=N-1) {
                    sb.append(' ');
                } else if (i!=N-1) {
                    sb.append('\n');
                }
            }
        }

        System.out.print(sb);
    }

    // 행렬 제곱 함수
    static int[][] powMatrix(int expo) {

        int[][] result;

        // 지수가 1인 경우 base 를 반환
        if (expo==1) {
            return base;
        }

        // 제곱을 절반으로 나누기
        int[][] temp = powMatrix(expo/2);

        result = multipleMatrix(temp, temp);

        // 지수가 2의 배수가 아니라면
        if (expo%2==1) {
            result = multipleMatrix(result, base);
        }

        return result;
    }


    // 행렬 곱셈 함수
    static int[][] multipleMatrix(int[][] M1, int[][] M2) {

        int[][] M3 = new int[N][N];

        // M3[i][j]
        for (int i=0; i< N; i++) {
            for (int j=0; j<N; j++) {

                for (int k=0; k<N; k++) {

                    // M3[i][j]
                    M3[i][j] += M1[i][k]*M2[k][j];
                    M3[i][j] %= 1000;
                }
            }
        }

        return M3;
    }
}
