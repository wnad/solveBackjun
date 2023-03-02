package problem;

import java.util.Scanner;

public class P_10950 implements Problem {

    /*
    문제
    두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.

    입력
    첫째 줄에 테스트 케이스의 개수 T가 주어진다.
    각 테스트 케이스는 한 줄로 이루어져 있으며,
    각 줄에 A와 B가 주어진다. (0 < A, B < 10)

    출력
    각 테스트 케이스마다 A+B를 출력한다.
    */

    public void exec(){
        Scanner s = new Scanner(System.in);

        int T = s.nextInt();                            // 테스트 케이스 개수 T

        for (int i=0; i<T; i++){                        // for 문 조건
            int A = s.nextInt();
            int B = s.nextInt();
            System.out.println(A+B);                    // 입력받은 테스트 케이스 덧셈 수행후 출력
        }
    }
}
