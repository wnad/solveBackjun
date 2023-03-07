package problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P_2444 implements Problem{

    /*
    문제
    예제를 보고 규칙을 유추한 뒤에 별을 찍어 보세요.

    입력
    첫째 줄에 N(1 ≤ N ≤ 100)이 주어진다.

    출력
    첫째 줄부터 2×N-1번째 줄까지 차례대로 별을 출력한다.
     */

    @Override
    public void exec() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String inputString = bufferedReader.readLine();

        int n = Integer.parseInt(inputString);

        for (int i = 1; i <= n; i++) {
            String outputString = "";
            for (int j = 1; j <= n-i; j++) {
                outputString += " ";
            }
            for (int j = 1; j <= 2*i-1; j++) {
                outputString += "*";
            }
            System.out.println(outputString);
        }

        for (int i = n-1; i >= 1; i--) {
            String outputString = "";
            for (int j = 1; j <= n-i; j++) {
                outputString += " ";
            }
            for (int j = 1; j <= 2*i-1; j++) {
                outputString += "*";
            }
            System.out.println(outputString);
        }
    }
}
