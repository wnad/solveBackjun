package problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

public class P_1463 implements Problem {

    public static List<String> input = List.of(
            "2", "10"
    );
    public static List<String> output = List.of(
            "1", "3");


    // dp[i] 를 1로 만드는데 필요한 연산 횟수 카운트 배열
    private static int[] dp;

    @Override
    public void exec() throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        br.close();

        // 정수 X에 사용할 수 있는 연산
        // 1. X가 3으로 나누어 떨어지면, 3으로 나눈다.
        // 2. X가 2로 나누어 떨어지면, 2로 나눈다.
        // 3. 1을 뺀다.


        // dp 문제는 2가지 방법으로 푼다.
        // top-down, bottom-up
        // 3가지 연산을 수행하면서 가장 최소 연산 횟수로 1을 만들 수 있는지 찾기

        dp = new int[N+1];

        System.out.print(topDown(N, dp));

    }

    private static int topDown(int num, int[] dp) {

        // 1이면 연산횟수가 필요없다.
        if (num==1) {
            return 0;
        }

        // 3번 연산 (-1)
        // 이전 num-1 값에 +1 (3번연산) 수행횟수 더하기
        dp[num] = topDown(num-1, dp) + 1;


        // 1번 연산 (/3)
        // 숫자 num 의 최소 연산값 ( dp[num-1]+1 (3번연산) 과 dp[num/3]+1 (1번 연산) 중의 최솟값 )
        if (num%3==0) {
            dp[num] = Math.min(dp[num], topDown(num/3, dp)+1);
        }


        // 2번 연산 (/2)
        // 숫자 num 의 최소 연산값 ( dp[num-1]+1 (3번연산) 과 dp[num/3]+1 (1번 연산) (존재 시) 와 dp[num/2]+1 (2번 연산) 중의 최솟값 )
        if (num%2==0) {
            dp[num] = Math.min(dp[num], topDown(num/2, dp)+1);
        }

        return dp[num];
    }


    // 2. bottom-up (1 -> N)
    private static int bottomUp(int num, int[] dp) {
        for (int i=2; i<=num; i++) {
            // 3번 연산 (+1)
            // 숫자 1은 연산 횟수가 0, 2는 dp[1] + 1 -> -1 의 연산을 했기때문에
            // 이전 i 값에 +1 (3번연산) 수행횟수 더하기
            dp[i] = dp[i-1] + 1;

            // 2번 연산 (*2)
            // 숫자 i 의 최소 연산값 ( dp[i-1]+1 (3번연산) 과 dp[i/2]+1 (2번 연산) 중의 최솟값 )
            if (i%2==0) {
                dp[i] = Math.min(dp[i], dp[i/2]+1);
            }

            // 1번 연산 (*3)
            // 숫자 i 의 최소 연산값 ( dp[i-1]+1 (3번연산) 과 dp[i/2]+1 (2번 연산) (존재시) 와 dp[i/3]+1 (1번 연산) 중의 최솟값 )
            if (i%3==0) {
                dp[i] = Math.min(dp[i], dp[i/3]+1);
            }
        }

        return dp[num];
    }


    /*
    문제
    정수 X에 사용할 수 있는 연산은 다음과 같이 세 가지 이다.

    X가 3으로 나누어 떨어지면, 3으로 나눈다.
    X가 2로 나누어 떨어지면, 2로 나눈다.
    1을 뺀다.

    정수 N이 주어졌을 때, 위와 같은 연산 세 개를 적절히 사용해서 1을 만들려고 한다.
    연산을 사용하는 횟수의 최솟값을 출력하시오.

    입력
    첫째 줄에 1보다 크거나 같고, 10^6보다 작거나 같은 정수 N이 주어진다.

    출력
    첫째 줄에 연산을 하는 횟수의 최솟값을 출력한다.
     */
}
