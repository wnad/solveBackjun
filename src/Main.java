import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

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