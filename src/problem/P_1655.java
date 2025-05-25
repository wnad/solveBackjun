package problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class P_1655 implements Problem {

    /**
     * Problem 1655: 가운데를 말해요
     *
     * 1. 문제 요약
     *    - 정수를 입력받을 때마다 입력받았던 숫자의 중간 값을 출력
     *    - 입력 받은 수가 짝수개 이면 중간 수중 작은 값을 출력
     *    - 입력:
     *          - 정수의 개수 N (0 ≤ N 100,000)
     *          - (0 ≤ 입력 정수 ≤ 100,000)
     *    - 출력 : 현재까지 입력받은 수의 중간 값을 출력
     *
     * 2. 접근 아이디어
     *    1) 힙을 두개 사용
     *    2) lower, upper 힙을 사용해서 두 힙의 개수의 차이가 1 이하이도록 설정
     *      2-1) lower 는 역정렬을 해서 최댓값을 찾기 쉽게 설정
     *    3) lower 의 MAX, upper 의 MIN 값을 찾아서 중간값 출력
     *
     *
     * 3. 시간·공간 복잡도
     *    - 시간 : O(Nlog N)
     *    - 공간 : O(N)
     *
     * 4. 회고
     *    - 처음에 트리 구조를 생각하다 최소힙을 사용해보려고 생각
     *    - 힙은 끝값을 찾기 쉽지만 중간값을 찾으려면 log N 의 시간이 소요되므로 힙을 두개로 쪼개서 삽입, 탐색 진행
     *
     */

    public static List<String> input = List.of(
            "7\n" +
                    "1\n" +
                    "5\n" +
                    "2\n" +
                    "10\n" +
                    "-99\n" +
                    "7\n" +
                    "5"
    );

    public static List<String> output = List.of(
            "1\n" +
                    "1\n" +
                    "2\n" +
                    "2\n" +
                    "2\n" +
                    "2\n" +
                    "5"
    );

    // 작은 힙에는 최댓값을 출력해야하기 때문에 역정렬
    private static PriorityQueue<Integer> lowerHip = new PriorityQueue<>(Collections.reverseOrder());
    private static PriorityQueue<Integer> upperHip = new PriorityQueue<>();


    @Override
    public void exec() throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringBuilder output = new StringBuilder();

        while(N-->0) {
            // 입력받은 숫자 힙에 넣기
            add(Integer.parseInt(br.readLine()));

            // 중간값 출력
            output.append(getMedian()).append("\n");
        }

        output.deleteCharAt(output.length() -1);

        System.out.print(output);
    }


    public static void add(int x) {

        // 입력받은 숫자 힙에 넣기
        if (lowerHip.isEmpty() || x<= lowerHip.peek()) {
            lowerHip.add(x);
        } else {
            upperHip.add(x);
        }

        // 힙 크기 조정 (중간값을 위해)
        if (lowerHip.size() > upperHip.size() + 1) {
            upperHip.add(lowerHip.poll());
        }

        if (upperHip.size() > lowerHip.size() + 1) {
            lowerHip.add(upperHip.poll());
        }

    }

    public static int getMedian() {

        // upper 가 많은 경우 upper 의 최솟값 출력
        if (lowerHip.size()<upperHip.size()) {
            return upperHip.peek();
        }

        // 그 외에는 lower 의 최댓값 출력
        return lowerHip.peek();
    }
}
