package problem;

import java.util.Scanner;
public class P_2588 implements Problem{

    /*
    문제
    (세 자리 수) × (세 자리 수)는 다음과 같은 과정을 통하여 이루어진다.



    (1)과 (2)위치에 들어갈 세 자리 자연수가 주어질 때 (3), (4), (5), (6)위치에 들어갈 값을 구하는 프로그램을 작성하시오.

    입력
    첫째 줄에 (1)의 위치에 들어갈 세 자리 자연수가, 둘째 줄에 (2)의 위치에 들어갈 세자리 자연수가 주어진다.

    출력
    첫째 줄부터 넷째 줄까지 차례대로 (3), (4), (5), (6)에 들어갈 값을 출력한다.
     */

    public void exec(){
        Scanner s = new Scanner(System.in);

        int A = s.nextInt();
        int B = s.nextInt();

        int B1 = B/100;
        int B2 = (B-B1*100)/10;
        int B3 = B-B1*100-B2*10;

        System.out.println(A*B3);
        System.out.println(A*B2);
        System.out.println(A*B1);
        System.out.println(A*B);
    }
}
