package problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P_10818 implements Problem{

    /*
    문제
    N개의 정수가 주어진다. 이때, 최솟값과 최댓값을 구하는 프로그램을 작성하시오.

    입력
    첫째 줄에 정수의 개수 N (1 ≤ N ≤ 1,000,000)이 주어진다.
    둘째 줄에는 N개의 정수를 공백으로 구분해서 주어진다.
    모든 정수는 -1,000,000보다 크거나 같고, 1,000,000보다 작거나 같은 정수이다.

    출력
    첫째 줄에 주어진 정수 N개의 최솟값과 최댓값을 공백으로 구분해 출력한다.
     */

    public void exec() throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());


        String array[] = br.readLine().split(" ");

        int MIN = Integer.valueOf(array[0]);
        int MAX = Integer.valueOf(array[0]);

        for (int i = 0; i<N; i++){
            if( Integer.valueOf(array[i]) < MIN){
                MIN = Integer.valueOf(array[i]);
            }
            if( MAX < Integer.valueOf(array[i]) ){
                MAX = Integer.valueOf(array[i]);
            }
        }

        System.out.println(MIN + " " + MAX);


    }
}
