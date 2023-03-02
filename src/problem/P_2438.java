package problem;

import java.util.Scanner;

public class P_2438 implements Problem{
    /*
    문제
    첫째 줄에는 별 1개, 둘째 줄에는 별 2개, N번째 줄에는 별 N개를 찍는 문제

    입력
    첫째 줄에 N(1 ≤ N ≤ 100)이 주어진다.

    출력
    첫째 줄부터 N번째 줄까지 차례대로 별을 출력한다.
     */

    public void exec(){
        Scanner s = new Scanner(System.in);

        int N = s.nextInt();

        String str = "";

        for (int i = 0; i<N; i++){

            str = str + "*";
            System.out.println(str);
        }
    }
}
