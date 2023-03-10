package problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P_1085 implements Problem {

    /*
    문제
    한수는 지금 (x, y)에 있다.
    직사각형은 각 변이 좌표축에 평행하고, 왼쪽 아래 꼭짓점은 (0, 0), 오른쪽 위 꼭짓점은 (w, h)에 있다.
    직사각형의 경계선까지 가는 거리의 최솟값을 구하는 프로그램을 작성하시오.

    입력
    첫째 줄에 x, y, w, h가 주어진다.

    출력
    첫째 줄에 문제의 정답을 출력한다.

    제한
    1 ≤ w, h ≤ 1,000
    1 ≤ x ≤ w-1
    1 ≤ y ≤ h-1
    x, y, w, h는 정수
     */

    @Override
    public void exec() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String inputString = bufferedReader.readLine();

        StringTokenizer xywhTokenizer = new StringTokenizer(inputString);

        int x = Integer.parseInt(xywhTokenizer.nextToken());
        int y = Integer.parseInt(xywhTokenizer.nextToken());
        int w = Integer.parseInt(xywhTokenizer.nextToken());
        int h = Integer.parseInt(xywhTokenizer.nextToken());

        int widmin = (w-x)<x ? (w-x) : x;
        int heimin = (h-y)<y ? (h-y) : y;

        int distanceMin = widmin<heimin ? widmin : heimin;

        System.out.println(distanceMin);

    }
}
