package problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;

public class P_2869 implements Problem {

    /*
    문제
    땅 위에 달팽이가 있다. 이 달팽이는 높이가 V미터인 나무 막대를 올라갈 것이다.
    달팽이는 낮에 A미터 올라갈 수 있다. 하지만, 밤에 잠을 자는 동안 B미터 미끄러진다. 또, 정상에 올라간 후에는 미끄러지지 않는다.
    달팽이가 나무 막대를 모두 올라가려면, 며칠이 걸리는지 구하는 프로그램을 작성하시오.

    입력
    첫째 줄에 세 정수 A, B, V가 공백으로 구분되어서 주어진다. (1 ≤ B < A ≤ V ≤ 1,000,000,000)

    출력
    첫째 줄에 달팽이가 나무 막대를 모두 올라가는데 며칠이 걸리는지 출력한다.

    예제 입력 1
    2 1 5

    예제 출력 1
    4

    예제 입력 2
    5 1 6

    예제 출력 2
    2

    예제 입력 3
    100 99 1000000000

    예제 출력 3
    999999901
     */

    public static List<String> input = List.of("2 1 5", "5 1 6", "100 99 1000000000");
    public static List<String> output = List.of("4", "2", "999999901");

    @Override
    public void exec() throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer ABV = new StringTokenizer(bufferedReader.readLine());

        int dayA = Integer.parseInt(ABV.nextToken());
        int nightB = Integer.parseInt(ABV.nextToken());
        int treeC = Integer.parseInt(ABV.nextToken());

        bufferedReader.close();

        // dayA * n - nightB * (n-1) >= treeC 를 만족하는 가장 작은 n 을 찾아라

        // (dayA - nightB) * n + nightB >= treeC
        // dayA - nightB * n >= treeC - nightB
        // n >= treeC - nightB / dayA - nightB

        int day = (treeC - nightB) / (dayA - nightB);
        if ( (treeC - nightB) % (dayA - nightB) != 0) {
            day++;
        }

        System.out.print(day);

    }


}
