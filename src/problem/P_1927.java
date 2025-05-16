package problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.PriorityQueue;

public class P_1927 implements Problem {

    /**
     * Problem 1927: 최소 힙
     *
     * 1. 문제 요약
     *    - 최소 힙을 이용하여 배열에 자연수 x를 넣고, 가장 작은 값을 출력후 배열에서 제거하는 연산
     *    - 입력: 첫째 줄에 연산의 개수 N (1 ≤ N ≤ 100,000)
     *    - 입력이 자연수면 배열에 추가, 0이면 가장 작은 값을 출력하고 제거
     *    - 비어있을 때 출력하면 0 출력
     *
     * 2. 접근 아이디어
     *    1) PriorityQueue 를 사용해서 최소힙 구조 이용
     *    2) 입력 값을 0과 자연수로 분리
     *    3) 입력에 맞게 배열 연산 수행
     *
     * 3. 시간·공간 복잡도
     *    - 시간: O(N log N)
     *    - 공간: O(N) (입력 배열)
     *
     * 4. 회고
     *    - 최소 힙을 이용하기 위해 PriorityQueue 사용
     *    - 역정렬을 하기 보단 정렬하고 역순으로 출력
     */

    public static List<String> input = List.of(
            "9\n" +"0\n" +"12345678\n" +"1\n" +"2\n" +"0\n" +"0\n" +"0\n" +"0\n" +"32"
    );

    public static List<String> output = List.of(
            "0\n" +"1\n" +"2\n" +"12345678\n" +"0"
    );

    @Override
    public void exec() throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        PriorityQueue<Integer> minHip = new PriorityQueue<>();

        StringBuilder result = new StringBuilder();

        // 연산 횟수
        int N = Integer.parseInt(br.readLine());

        // 입력 받는 자연수
        int num;

        while (N-- > 0) {
            num = Integer.parseInt(br.readLine());

            // 0이면 출력, 없을 경우 예외처리
            if (num==0) {
                if (minHip.isEmpty()) {
                    result.append(0).append("\n");
                } else {
                    result.append(minHip.poll()).append("\n");
                }
            } else {
                minHip.add(num);
            }
        }

        result.deleteCharAt(result.length() -1);

        System.out.print(result);
    }
}
