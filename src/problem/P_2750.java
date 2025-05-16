package problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class P_2750 implements Problem {

    /**
     * Problem 2750: 수 정렬하기
     *
     * 1. 문제 요약
     *    - N개의 수를 오름차순으로 정렬하여 한 줄에 하나씩 출력
     *    - 입력: 첫째 줄에 N (1 ≤ N ≤ 1,000), 둘째 줄에 N개의 정수
     *
     * 2. 접근 아이디어
     *    1) 입력 값을 int 로 넣는다.
     *    2) 입력을 숫자별로 분리하고 배열에 넣는다
     *    3) 배열을 정렬해서 반환한다.
     *
     * 3. 시간·공간 복잡도
     *    - 시간: O(N log N)
     *    - 공간: O(N) (입력 배열)
     *
     * 4. 회고
     *    - Java 기본 라이브러리 sort 사용법 확인
     */


    public static List<String> input = List.of(
            "5\n" + "5\n" + "2\n" + "3\n" + "4\n" + "1"
    );

    public static List<String> output = List.of(
            "1\n" + "2\n" + "3\n" + "4\n" + "5"
    );

    @Override
    public void exec() throws Exception {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 수 N
        int N = Integer.parseInt(br.readLine());

        // 입력 저장할 배열 선언
        int[] array = new int[N];

        for (int i=0; i<N; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }

        // 정렬
        Arrays.sort(array);


        // 정렬된 수 출력
        StringBuilder result = new StringBuilder();

        for (int num : array) {
            result.append(num).append("\n");
        }

        result.deleteCharAt(result.length() - 1);

        System.out.print(result);
    }
}
