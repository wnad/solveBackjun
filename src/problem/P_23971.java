package problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

public class P_23971 implements Problem {


    /**
     * Problem 23971: ZOAC 4
     *
     * 1. 문제 요약
     *    - 강의실 거리두기 조건을 만족하는 최대 수용 가능 인원
     *    - 한 명씩 앉을 수 있는 테이블이 행마다 W개씩 H행에 걸쳐 있을 때, 모든 참가자는 세로로 N칸 또는 가로로 M칸 이상 비우고 앉아야 한다.
     *    - 즉, 다른 모든 참가자와 세로줄 번호의 차가 N보다 크거나 가로줄 번호의 차가 M보다 큰 곳에만 앉을 수 있다.
     *    - 입력: H, W, N, M (0 ≤ H, W, N, M ≤ 50,000)
     *
     * 2. 접근 아이디어
     *    1) 최대 인원은 가장 밀접하게 붙어있는 자리수
     *    2) 처음부터 시작해서 가로 세로 최대인원 구하기
     *    2-1) X 좌표는 1 / (M+1)+1 / 2*(M+1)+1 / ... / (K-1)*(M+1)+1
     *    3) W 보다 작은 가장 큰 K 찾기
     *
     * 3. 시간·공간 복잡도
     *
     * 4. 회고
     *    - BFS 를 고민했으나 최대 인원수는 조건에 맞게 정해져있어 규칙 찾아 해결
     *
     */

    public static List<String> input = List.of(
            "5 4 1 1"
    );

    public static List<String> output = List.of(
            "6"
    );

    @Override
    public void exec() throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        // H, W, N, M 입력
        int H = Integer.parseInt(input[0]);
        int W = Integer.parseInt(input[1]);
        int N = Integer.parseInt(input[2]);
        int M = Integer.parseInt(input[3]);

        // 가로 몇 명 앉을수 있는지
        int width = ((W-1) / (M+1))+1;

        // 세로 몇 명 앉을 수 있는지
        int height = ((H-1) / (N+1))+1;

        System.out.print(width * height);
    }
}
