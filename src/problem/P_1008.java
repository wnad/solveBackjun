package problem;


import java.util.Scanner;

public class P_1008 implements Problem {

    /*
    문제
    두 정수 A와 B를 입력받은 다음, A/B를 출력하는 프로그램을 작성하시오.

    입력
    첫째 줄에 A와 B가 주어진다. (0 < A, B < 10)

    출력
    첫째 줄에 A/B를 출력한다. 실제 정답과 출력값의 절대오차 또는 상대오차가 10-9 이하이면 정답이다.
     */

    public void exec(){
        Scanner s = new Scanner(System.in); // 스캐너

        double InputNumberA = s.nextDouble();
        double InputNumberB = s.nextDouble();

        System.out.print(InputNumberA/InputNumberB);

    }

}
