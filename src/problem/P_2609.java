package problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P_2609 implements Problem {


    /*

문제
두 개의 자연수를 입력받아 최대 공약수와 최소 공배수를 출력하는 프로그램을 작성하시오.

입력
첫째 줄에는 두 개의 자연수가 주어진다. 이 둘은 10,000이하의 자연수이며 사이에 한 칸의 공백이 주어진다.

출력
첫째 줄에는 입력으로 주어진 두 수의 최대공약수를, 둘째 줄에는 입력으로 주어진 두 수의 최소 공배수를 출력한다.

예제 입력 1
24 18

예제 출력 1
6
72

     */

    @Override
    public void exec() throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer numToken = new StringTokenizer(bufferedReader.readLine());

        int numA = Integer.parseInt(numToken.nextToken());
        int numB = Integer.parseInt(numToken.nextToken());

        bufferedReader.close();

        StringBuilder output = new StringBuilder();

        int gcd = GCD(numA,numB);
        output.append(gcd).append("\n");
        output.append(LCM(numA, numB, gcd)).append("\n");
        System.out.println(output);
    }

    static int GCD(int a, int b) {
        int r;
        while(b != 0) {
            r = a % b;
            a = b;
            b = r;
        }

        return a;
    }

    static int LCM(int a, int b, int gcd) {
        return (a * b) / gcd;
    }


}
