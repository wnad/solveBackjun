package problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;

public class P_11005 implements Problem {

    /*

    문제
    10진법 수 N이 주어진다. 이 수를 B진법으로 바꿔 출력하는 프로그램을 작성하시오.
    10진법을 넘어가는 진법은 숫자로 표시할 수 없는 자리가 있다. 이런 경우에는 다음과 같이 알파벳 대문자를 사용한다.
    A: 10, B: 11, ..., F: 15, ..., Y: 34, Z: 35

    입력
    첫째 줄에 N과 B가 주어진다. (2 ≤ B ≤ 36) N은 10억보다 작거나 같은 자연수이다.

    출력
    첫째 줄에 10진법 수 N을 B진법으로 출력한다.

     */

    public static List<String> output = List.of(
            "ZZZZZ"
    );

    public static List<String> input = List.of(
            "60466175 36"
    );


    @Override
    public void exec() throws Exception {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer input = new StringTokenizer(br.readLine());


        // 주어진 숫자
        int N = Integer.parseInt(input.nextToken());

        // B 진법
        int B = Integer.parseInt(input.nextToken());

        StringBuilder result = new StringBuilder();


        // 1. N이 0이 될때까지 반복
        while (0<N) {

            // 2. N 을 B로 나누기
            int remain = N%B;

            // 0~9 사이라면
            if (remain<10) {
                result.append(remain);
            } else {
                // 10 이상이라면
                // 10 -> 'A' = 65
                result.append((char) (remain+'A'-10));
            }

            N/=B;

        }

        // 역순으로 변경
        System.out.print(result.reverse());

    }
}
