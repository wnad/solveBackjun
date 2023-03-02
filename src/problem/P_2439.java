package problem;

import java.util.Scanner;

public class P_2439 implements Problem{

    /*
    문제
    첫째 줄에는 별 1개, 둘째 줄에는 별 2개, N번째 줄에는 별 N개를 찍는 문제

    하지만, 오른쪽을 기준으로 정렬한 별(예제 참고)을 출력하시오.

    입력
    첫째 줄에 N(1 ≤ N ≤ 100)이 주어진다.

    출력
    첫째 줄부터 N번째 줄까지 차례대로 별을 출력한다.
     */

    public void exec(){
        Scanner s = new Scanner(System.in);

        int N = s.nextInt();

        for (int i=1; i<N+1; i++){

            for (int blank = 0; blank < N-i; blank++){
                System.out.print(" ");
            }

            for (int star = 0; star<i; star++){
                System.out.print("*");
            }

            System.out.print("\n");

        }
    }
}
