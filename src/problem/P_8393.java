package problem;

import java.util.Scanner;

public class P_8393 implements Problem{

    /*
    문제
    n이 주어졌을 때, 1부터 n까지 합을 구하는 프로그램을 작성하시오.

    입력
    첫째 줄에 n (1 ≤ n ≤ 10,000)이 주어진다.

    출력
    1부터 n까지 합을 출력한다.
     */

    public void exec(){
        Scanner s = new Scanner(System.in);         // 스캐너 생성

        int N = s.nextInt();

        int SUM = 0;                                // 합 변수 생성


        for (int i = 1; i<=N; i++){                 // i <= N 까지 SUM에 i 를 더함
            SUM = SUM + i;
        }

        System.out.println(SUM);                    // SUM 출력
    }
}
