package problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.List;
import java.util.StringTokenizer;

public class P_2745 implements Problem {

    /*

    - 문제

    B진법 수 N이 주어진다. 이 수를 10진법으로 바꿔 출력하는 프로그램을 작성하시오.

    10진법을 넘어가는 진법은 숫자로 표시할 수 없는 자리가 있다. 이런 경우에는 다음과 같이 알파벳 대문자를 사용한다.
    A: 10, B: 11, ..., F: 15, ..., Y: 34, Z: 35

    입력
    첫째 줄에 N과 B가 주어진다. (2 ≤ B ≤ 36)
    B진법 수 N을 10진법으로 바꾸면, 항상 10억보다 작거나 같다.

    출력
    첫째 줄에 B진법 수 N을 10진법으로 출력한다.

     */

    public static List<String> input = List.of(
            "ZZZZZ 36"
    );

    public static List<String> output = List.of(
            "60466175"
    );

    @Override
    public void exec() throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        // 변환하고 싶은 B진법의 수
        String N = input[0];

        // B진법
        int B = Integer.parseInt(input[1]);

        /*

        0~9 까지는 숫자로
        그 이후는 A~Z 는 따로 연산

         */

        int result = 0;

        for (int i=0; i<N.length(); i++) {

            // i번째 숫자
            char num = N.charAt(i);

            int value;

            if ('0'<=num && num<='9') {
                // 0~9 까지의 숫자라면
                value = num-'0';
            } else {
                // 'A' ~ 'Z' 까지의 숫자라면
                value = num-'A'+ 10;
            }

            result = result * B + value;
        }

        System.out.print(result);
    }
}
