package problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class P_1427 implements Problem {


    /**
     * Problem 1427: 소트인사이드
     *
     * 1. 문제 요약
     *    - 숫자 N 의 각 자리수를 내림차순으로 정렬
     *    - 입력: 첫째 줄에 N (1 ≤ N ≤ 1,000,000,000)
     *
     * 2. 접근 아이디어
     *    1) 입력 값을 String 로 넣는다.
     *    2) 입력 숫자의 각 자리수를 (Char) 배열에 넣는다.
     *    3) 아스키 코드를 숫자로 변환 (char - '0')
     *    4) 배열을 정렬해서 역순으로 반환한다.
     *
     * 3. 시간·공간 복잡도
     *    - 시간: O(N log N)
     *    - 공간: O(N) (입력 배열)
     *
     * 4. 회고
     *    - 변환할 때 자료형 고민을 했는데, 형 변환보다 char 이용해서 사용하는 방법이 좋았던 것 같다.
     *    - 역정렬을 하기 보단 정렬하고 역순으로 출력
     */

    public static List<String> input = List.of(
            "2143",
            "999998999",
            "61423",
            "500613009"
    );

    public static List<String> output = List.of(
            "4321",
            "999999998",
            "64321",
            "965310000"
    );

    @Override
    public void exec() throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String N = br.readLine();

        int size = N.length();

        int[] nums = new int[size];

        for (int i=0; i<size; i++) {
            // char 니까 (아스키) 숫자로 변환
            nums[i] = N.charAt(i) - '0';
        }

        Arrays.sort(nums);

        StringBuilder result = new StringBuilder();

        for (int i=0; i<size; i++) {
            result.append(nums[size-i-1]);
        }

        System.out.print(result);
    }
}
