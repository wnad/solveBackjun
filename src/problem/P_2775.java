package problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P_2775 implements Problem{

    /*

    문제
    평소 반상회에 참석하는 것을 좋아하는 주희는 이번 기회에 부녀회장이 되고 싶어 각 층의 사람들을 불러 모아 반상회를 주최하려고 한다.
    이 아파트에 거주를 하려면 조건이 있는데, “a층의 b호에 살려면 자신의 아래(a-1)층의 1호부터 b호까지 사람들의 수의 합만큼 사람들을 데려와 살아야 한다” 는 계약 조항을 꼭 지키고 들어와야 한다.
    아파트에 비어있는 집은 없고 모든 거주민들이 이 계약 조건을 지키고 왔다고 가정했을 때, 주어지는 양의 정수 k와 n에 대해 k층에 n호에는 몇 명이 살고 있는지 출력하라.
    단, 아파트에는 0층부터 있고 각층에는 1호부터 있으며, 0층의 i호에는 i명이 산다.

    입력
    첫 번째 줄에 Test case의 수 T가 주어진다.
    그리고 각각의 케이스마다 입력으로 첫 번째 줄에 정수 k, 두 번째 줄에 정수 n이 주어진다

    출력
    각각의 Test case에 대해서 해당 집에 거주민 수를 출력하라.

    제한
    1 ≤ k, n ≤ 14

    예제 입력 1
    2
    1
    3
    2
    3

    예제 출력 1
    6
    10

     */

    @Override
    public void exec() throws IOException {

        // 테스트 케이스 수 T 입력 받기
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bufferedReader.readLine());


        // 0 층 i 호 = i 명 거주
        // 1 층 i 호 = 0(1) + 0(2) + ... + 0(i) 명
        // 2 층 i 호 = 1(1) + 1(2) + ... + 1(i) 명
        // k 층 n 호 = (K-1)(1) + (k-1)(2) + ... + (k-1)(n) 명

        // T 만큼 반복
        for (int i = 0; i < T; i++) {
            // 첫번째 k, 두번째 n 입력 받기 (k층에 n호에 몇명이 살고 있는지)
            int k = Integer.parseInt(bufferedReader.readLine());
            int n = Integer.parseInt(bufferedReader.readLine());

            // k층의 n호에 거주하는 사람 수 계산
            int result = calculateNk(k, n);

            System.out.println(result);
        }

        bufferedReader.close();

    }

    public static int calculateNk(int k, int n) {
        // 0층의 경우, n호에는 n명이 거주
        if (k == 0) return n;

        // 현재 층의 호실에 거주하는 사람들의 수 계산
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += calculateNk(k - 1, i);
        }
        return sum;
    }


}
