package problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P_1978 implements Problem{


    /*
    문제
    주어진 수 N개 중에서 소수가 몇 개인지 찾아서 출력하는 프로그램을 작성하시오.

    입력
    첫 줄에 수의 개수 N이 주어진다. N은 100이하이다. 다음으로 N개의 수가 주어지는데 수는 1,000 이하의 자연수이다.

    출력
    주어진 수들 중 소수의 개수를 출력한다.
     */

    @Override
    public void exec() throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int testcase = Integer.parseInt(bufferedReader.readLine());

        int prime = 0;


        StringTokenizer primeTokenizer = new StringTokenizer(bufferedReader.readLine());

        for (int i=0; i<testcase; i++) {
            int N = Integer.parseInt(primeTokenizer.nextToken());

            if (isPrime(N)) prime++;

        }

        System.out.println(prime);

    }

    public static boolean isPrime(int number) {

        if (number==1) return false;

        for(int i=2; i*i<=number; i++){
            if(number % i == 0) return false;
        }

        return true;
    }
}
