package problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P_9086 implements Problem {

    /*
    문제
    문자열을 입력으로 주면 문자열의 첫 글자와 마지막 글자를 출력하는 프로그램을 작성하시오.

    입력
    입력의 첫 줄에는 테스트 케이스의 개수 T(1 ≤ T ≤ 10)가 주어진다. 각 테스트 케이스는 한 줄에 하나의 문자열이 주어진다.
    문자열은 알파벳 A~Z 대문자로 이루어지며 알파벳 사이에 공백은 없으며 문자열의 길이는 1000보다 작다.

    출력
    각 테스트 케이스에 대해서 주어진 문자열의 첫 글자와 마지막 글자를 연속하여 출력한다.
     */

    @Override
    public void exec() throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(bufferedReader.readLine());

        for (int count = 0; count < testCase; count++) {
            String inputString = bufferedReader.readLine();

            int stringLength = inputString.length();

            if (stringLength==1)
                System.out.println(inputString.charAt(0) +""+ inputString.charAt(0));

            if (stringLength>1)
                System.out.println(inputString.charAt(0) +""+ inputString.charAt(stringLength-1) );
        }

    }
}
