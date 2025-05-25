package problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class P_5073 implements Problem {

    /**
     * Problem 5073: 삼각형과 세 변
     *
     * 1. 문제 요약
     *    - 삼각형의 분류
     *      - Equilateral :  세 변의 길이가 모두 같은 경우
     *      - Isosceles : 두 변의 길이만 같은 경우
     *      - Scalene : 세 변의 길이가 모두 다른 경우
     *    - 삼각형의 조건을 만족하지 못하는 경우에는 'Invalid'
     *    - 입력: A B C (0 ≤ A, B, C ≤ 1,000)
     *    - 마지막 줄은 0 0 0
     *    - 출력 : 삼각형의 조건에 맞게 분류 출력
     *
     * 2. 접근 아이디어
     *    1) 삼각형의 조건 : 가장 긴 변 보다 다른 두변의 합이 커야한다.
     *    2) 변 길이를 정렬해서 계산
     *
     * 3. 시간·공간 복잡도
     *    - O(N)
     *    - O(N)
     *
     * 4. 회고
     *    - 삼각형의 조건에 맞춰 처리
     *
     */

    public static List<String> input = List.of(
            "7 7 7\n" +
                    "6 5 4\n" +
                    "3 2 5\n" +
                    "6 2 6\n" +
                    "0 0 0"
    );

    public static List<String> output = List.of(
            "Equilateral\n" +
                    "Scalene\n" +
                    "Invalid\n" +
                    "Isosceles"
    );


    @Override
    public void exec() throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder output = new StringBuilder();

        while (true) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            int c = Integer.parseInt(input[2]);

            if (a == 0 && b == 0 && c == 0) {
                break;
            }

            output.append(isTriangle(a, b, c)).append("\n");
        }

        br.close();

        output.deleteCharAt(output.length() - 1);

        System.out.print(output);
    }

    public static String isTriangle(int a, int b, int c) {

        int[] arr = {a, b, c};
        Arrays.sort(arr);

        // 삼각형 조건 미부합
        if (arr[0] + arr[1] <= arr[2]) {
            return "Invalid";
        }

        // 가장 긴 변 == 가장 작은 변 이면 정삼각형
        if (arr[0] == arr[2]) {
            return "Equilateral";
        }

        // 두변의 길이가 같으면 이등변 삼각형
        if (arr[0] == arr[1] || arr[1] == arr[2]) {
            return "Isosceles";
        }

        // 세변이 다른 삼각형
        return "Scalene";
    }
}
