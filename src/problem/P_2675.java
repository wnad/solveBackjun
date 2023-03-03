package problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P_2675 implements Problem {

    /*
    문제
    문자열 S를 입력받은 후에, 각 문자를 R번 반복해 새 문자열 P를 만든 후 출력하는 프로그램을 작성하시오.
    즉, 첫 번째 문자를 R번 반복하고, 두 번째 문자를 R번 반복하는 식으로 P를 만들면 된다.
    S에는 QR Code "alphanumeric" 문자만 들어있다.

    QR Code "alphanumeric" 문자는 0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ\$%*+-./: 이다.

    입력
    첫째 줄에 테스트 케이스의 개수 T(1 ≤ T ≤ 1,000)가 주어진다.
    각 테스트 케이스는 반복 횟수 R(1 ≤ R ≤ 8), 문자열 S가 공백으로 구분되어 주어진다.
    S의 길이는 적어도 1이며, 20글자를 넘지 않는다.

    출력
    각 테스트 케이스에 대해 P를 출력한다.
     */

    @Override
    public void exec() throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(bufferedReader.readLine());

        for (int count = 0; count<testCase; count++) {
            StringTokenizer rsTokenizer = new StringTokenizer(bufferedReader.readLine());
            int R = Integer.parseInt(rsTokenizer.nextToken());
            String inputString = rsTokenizer.nextToken();

            repeatPrint(R,inputString);

        }

    }

    public static void repeatPrint(int count, String inputString){
        int stringLength = inputString.length();

        for (int stringCount=0; stringCount<stringLength; stringCount++) {
            for (int repeatCount=0; repeatCount<count; repeatCount++) {
                System.out.print(inputString.charAt(stringCount));
            }
        }

        System.out.println();

    }


}
