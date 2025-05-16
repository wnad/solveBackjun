package problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

public class P_11726 implements Problem {

    private static int[] dp;

    @Override
    public void exec() throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        br.close();

        dp = new int[n+1];

        dp[1] = 1;
        dp[2] = 2;

        System.out.print(bottomUp(n));
    }

    private static int topDown(int num) {
        if (num==1) return 1;
        if (num==2) return 2;

        return topDown(num-1) + topDown(num-2);
    }

    private static int bottomUp(int num) {

        if (num==1) return 1;
        if (num==2) return 2;

        for (int i=3; i<=num; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[num];
    }

    public static List<String> input = List.of(
            "2", "9"
    );
    public static List<String> output = List.of(
            "2","55"
    );


    /*
    문제
    2×n 크기의 직사각형을 1×2, 2×1 타일로 채우는 방법의 수를 구하는 프로그램을 작성하시오.

    아래 그림은 2×5 크기의 직사각형을 채운 한 가지 방법의 예이다.



    입력
    첫째 줄에 n이 주어진다. (1 ≤ n ≤ 1,000)

    출력
    첫째 줄에 2×n 크기의 직사각형을 채우는 방법의 수를 10,007로 나눈 나머지를 출력한다.
     */
}
