package problem;

import java.util.Scanner;

public class P_10952 implements Problem {

    /*
    문제
    두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.

    입력
    입력은 여러 개의 테스트 케이스로 이루어져 있다.
    각 테스트 케이스는 한 줄로 이루어져 있으며, 각 줄에 A와 B가 주어진다. (0 < A, B < 10)
    입력의 마지막에는 0 두 개가 들어온다.

    출력
    각 테스트 케이스마다 A+B를 출력한다.
     */
    public void exec(){
        Scanner s = new Scanner(System.in);

        int bool = 0;

        int A = s.nextInt();
        int B = s.nextInt();

        while(bool==0){
            System.out.println(A+B);

            A = s.nextInt();
            B = s.nextInt();

            if(A+B==0){
                bool = 1;
            }
        }

    }
}
