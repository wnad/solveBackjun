package problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P_11720 implements Problem {

    /*
    문제
    N개의 숫자가 공백 없이 쓰여있다. 이 숫자를 모두 합해서 출력하는 프로그램을 작성하시오.

    입력
    첫째 줄에 숫자의 개수 N (1 ≤ N ≤ 100)이 주어진다. 둘째 줄에 숫자 N개가 공백없이 주어진다.

    출력
    입력으로 주어진 숫자 N개의 합을 출력한다.
     */

    @Override
    public void exec() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int numberLength = Integer.parseInt(bufferedReader.readLine());

        int numberSum = 0;

        String inputNumber = bufferedReader.readLine();

        for (int count = 0; count<numberLength; count++) {
            char numberToChar = inputNumber.charAt(count);
            int charToInt = Character.getNumericValue(numberToChar);

            numberSum += charToInt;
        }

        System.out.println(numberSum);
    }
}
