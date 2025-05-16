package problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

public class P_9095 implements Problem {

    // 1 -> 1
    // 2 -> 1+1, 2
    // 3 -> 1+1+1, 2+1 ,, 1+2 ,, 3
    // 4 -> 1+1+1+1, 2+1+1, 1+2+1, 3+1 ,, 1+1+2, 2+2 ,, 1+3
    // 5 -> dp[4](+1) + dp[3](+2) + dp[2](+3)
    // ...
    // N -> dp[N-1] + dp[N-2] + dp[N-3]


    // dp[n] 은 n을 1,2,3 의 합으로 나타낼 수 있는 가짓수 저장 배열
    private static int[] dp;

    @Override
    public void exec() throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스 수
        int T = Integer.parseInt(br.readLine());

        // 입력받은 n 중 가장 큰 n 저장 변수
        int max = 0;

        int[] list = new int[T];

        for (int i = 0; i < list.length; i++) {
            list[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, list[i]);
        }

        br.close();

        // dp 배열 선언
        dp = new int[max+1];

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        // dp 계산
        topDown(max);

        StringBuilder sb = new StringBuilder();

        // 이미 계산된 dp 배열에서 필요한 n의 값을 꺼내서 출력
        for (int n : list) {
            sb.append(dp[n]).append("\n");
        }

        sb.deleteCharAt(sb.length()-1);

        System.out.print(sb);

    }

    private static int topDown(int n) {

        if (n==1) return 1;
        if (n==2) return 2;
        if (n==3) return 4;

        if (3<n) {
            dp[n] = topDown(n-1) + topDown(n-2) + topDown(n-3);
        }

        return dp[n-1] + dp[n-2] + dp[n-3];
    }


    private static void bottomUp(int n) {
        if (3<n) {
            for (int i = 4; i <= n; i++) {
                dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
            }
        }
    }

    public static List<String> input = List.of(
            "3\n" +
                    "4\n" +
                    "7\n" +
                    "10"
    );
    public static List<String> output = List.of(
            "7\n" +
                    "44\n" +
                    "274");

    /*
    문제
    정수 4를 1, 2, 3의 합으로 나타내는 방법은 총 7가지가 있다.
    합을 나타낼 때는 수를 1개 이상 사용해야 한다.

    1+1+1+1
    1+1+2
    1+2+1
    2+1+1
    2+2
    1+3
    3+1
    정수 n이 주어졌을 때, n을 1, 2, 3의 합으로 나타내는 방법의 수를 구하는 프로그램을 작성하시오.

    입력
    첫째 줄에 테스트 케이스의 개수 T가 주어진다. 각 테스트 케이스는 한 줄로 이루어져 있고, 정수 n이 주어진다. n은 양수이며 11보다 작다.

    출력
    각 테스트 케이스마다, n을 1, 2, 3의 합으로 나타내는 방법의 수를 출력한다.
     */

}
