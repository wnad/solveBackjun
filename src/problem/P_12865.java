package problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;

public class P_12865 implements Problem {

    /**
     * Problem 12865: 평범한 배낭
     *
     * 1. 문제 요약
     *    - N 개의 물건, 가방에 넣을 수 있는 무게 K
     *    - 물건은 W 만큼의 무게와 V의 가치를 가진다.
     *    - 입력:
     *          - N K (0 ≤ N ≤ 100 / 0 ≤ K ≤ 100,000)
     *          - W V (0 ≤ W ≤ 100,100 /  0 ≤ V ≤ 1,000)
     *    - 출력 : 가방에 넣을 수 있는 가치합의 최댓값
     *
     * 2. 접근 아이디어
     *    1) DP 로 해결
     *    2) 새로운 아이템 Item(w,v) 가 있을 때
     *      2-1) 가방 무게가 i 일때, 최대의 가치 dp[i]
     *      2-2) 점화식 dp[i] = max(dp[i], dp[i-w] + v)
     *    3) dp[K] 의 값 출력
     *
     *
     * 3. 시간·공간 복잡도
     *    - 시간 : O(N*K)
     *    - 공간 : O(K)
     *
     * 4. 회고
     *    - 처음에 단위 무게별 가치순으로 정렬해서 가치가 높은 물건 순으로 배낭을 넣으려고했다.
     *    - 단위 무게별 가치가 동일한 물건을 넣는 부분에서 모순 발생
     *    - dp 로 가방 무게별 최대의 가치를 계산하는 방식으로 풀이
     *
     */

    public static List<String> input = List.of(
            "4 7\n" +
                    "6 13\n" +
                    "4 8\n" +
                    "3 6\n" +
                    "5 12"
    );

    public static List<String> output = List.of(
            "14"
    );


    @Override
    public void exec() throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // dp[i] = 무게 i 일때 얻을 수 있는 최대 가치
        int[] dp = new int[K + 1];

        for (int i = 1; i <= N; i++) {

            StringBuilder sb = new StringBuilder();
            st = new StringTokenizer(br.readLine());
            int W = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());

            // 같은 물건을 여러번 추가되지 않게하기위해 역순으로 계산
            for (int j=K; j>=W; j--) {
                dp[j] = Math.max(dp[j], dp[j-W] + V);
            }
        }

        System.out.print(dp[K]);
    }

}
