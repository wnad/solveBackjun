package problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;

public class P_4153 implements Problem {

    /*
    문제
    과거 이집트인들은 각 변들의 길이가 3, 4, 5인 삼각형이 직각 삼각형인것을 알아냈다.
    주어진 세변의 길이로 삼각형이 직각인지 아닌지 구분하시오.

    입력
    입력은 여러개의 테스트케이스로 주어지며 마지막줄에는 0 0 0이 입력된다.
    각 테스트케이스는 모두 30,000보다 작은 양의 정수로 주어지며, 각 입력은 변의 길이를 의미한다.

    출력
    각 입력에 대해 직각 삼각형이 맞다면 "right", 아니라면 "wrong"을 출력한다.

    예제 입력 1
    6 8 10
    25 52 60
    5 12 13
    0 0 0

    예제 출력 1
    right
    wrong
    right
     */

    public static List<String> input = List.of("6 8 10\n25 52 60\n5 12 13\n0 0 0");
    public static List<String> output = List.of("right\nwrong\nright\n");

    @Override
    public void exec() throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int sideA;
        int sideB;
        int sideC;

        StringBuilder output = new StringBuilder();

        while (true) {
            StringTokenizer side = new StringTokenizer(bufferedReader.readLine());

            sideA = Integer.parseInt(side.nextToken());
            sideB = Integer.parseInt(side.nextToken());
            sideC = Integer.parseInt(side.nextToken());

            if (sideA ==  0 && sideB ==  0 && sideC ==  0) break;

            if (sideA > sideC) {
                int temp = sideA;
                sideA = sideC;
                sideC = temp;
            }
            if (sideB > sideC) {
                int temp = sideB;
                sideB = sideC;
                sideC = temp;
            }

            if (Math.pow(sideA, 2) + Math.pow(sideB, 2) == Math.pow(sideC, 2)) {
                output.append("right\n");
            } else {
                output.append("wrong\n");
            }
        }

        bufferedReader.close();

        System.out.print(output);

    }
}
