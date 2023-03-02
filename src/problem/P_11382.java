package problem;
import java.util.Scanner;
public class P_11382 implements Problem{

    /*

    문제
    꼬마 정민이는 이제 A + B 정도는 쉽게 계산할 수 있다. 이제 A + B + C를 계산할 차례이다!

    입력
    첫 번째 줄에 A, B, C (1 ≤ A, B, C ≤ 10^12)이 공백을 사이에 두고 주어진다.

    출력
    A+B+C의 값을 출력한다.

    */

    public void exec(){
        Scanner s = new Scanner(System.in); // 입력받기위해 스캐너를 가져온다

        long InputNumberA = s.nextLong(); // 숫자의 범위가 10^12 이므로 long 으로 저장한다.
        long InputNumberB = s.nextLong();
        long InputNumberC = s.nextLong();

        System.out.println(InputNumberA+InputNumberB+InputNumberC); // A+B+C 를 출력한다.
    }


}