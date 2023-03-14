package problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P_1929 implements Problem {

    /*
    문제
    M이상 N이하의 소수를 모두 출력하는 프로그램을 작성하시오.

    입력
    첫째 줄에 자연수 M과 N이 빈 칸을 사이에 두고 주어진다.
    (1 ≤ M ≤ N ≤ 1,000,000) M이상 N이하의 소수가 하나 이상 있는 입력만 주어진다.

    출력
    한 줄에 하나씩, 증가하는 순서대로 소수를 출력한다.
     */

    @Override
    public void exec() throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer nmTokenizer = new StringTokenizer(bufferedReader.readLine());

        int M = Integer.parseInt(nmTokenizer.nextToken());
        int N = Integer.parseInt(nmTokenizer.nextToken());

        StringBuilder result = new StringBuilder();

        for (int i=M; i<=N; i++) {
            if (isPrime(i)) result.append(i + "\n");
        }

        System.out.println(result);

    }

    public static boolean isPrime(int number) {

        if (number==1) return false;

        for (int i=2; i<=Math.sqrt(number); i++) {
            if (number%i==0) return false;
        }

        return true;
    }

}
