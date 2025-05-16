package problem;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class P_11651 implements Problem {

    /*
    문제
    2차원 평면 위의 점 N개가 주어진다.
    좌표를 y좌표가 증가하는 순으로, y좌표가 같으면 x좌표가 증가하는 순서로 정렬한 다음 출력하는 프로그램을 작성하시오.

    입력
    첫째 줄에 점의 개수 N (1 ≤ N ≤ 100,000)이 주어진다.
    둘째 줄부터 N개의 줄에는 i번점의 위치 xi와 yi가 주어진다. (-100,000 ≤ xi, yi ≤ 100,000)
    좌표는 항상 정수이고, 위치가 같은 두 점은 없다.

    출력
    첫째 줄부터 N개의 줄에 점을 정렬한 결과를 출력한다.

    예제 입력 1
    5
    0 4
    1 2
    1 -1
    2 2
    3 3

    예제 출력 1
    1 -1
    1 2
    2 2
    3 3
    0 4

     */

    public static List<String> input = List.of("5\n" + "0 4\n" + "1 2\n" + "1 -1\n" + "2 2\n" + "3 3");
    public static List<String> output = List.of("1 -1\n" + "1 2\n" + "2 2\n" + "3 3\n" + "0 4");

    @Override
    public void exec() throws Exception {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bufferedReader.readLine());
        int x, y;

        ArrayList<Point> points = new ArrayList<>(N);

        while(N-- > 0) {
            StringTokenizer xy = new StringTokenizer(bufferedReader.readLine());
            x = Integer.parseInt(xy.nextToken());
            y = Integer.parseInt(xy.nextToken());

            points.add(new Point(x,y));
        }

        bufferedReader.close();

        Collections.sort(points);

        StringBuilder output = new StringBuilder();

        for (Point p : points) {
            output.append(p.x).append(" ").append(p.y).append("\n");
        }

        System.out.print(output.toString().trim());


    }

    static class Point implements Comparable<Point>{

        int x;      // x좌표
        int y;      // y좌표

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        // y 좌표를 기준으로 오름차순으로 정렬, y 좌표가 동일하다면 x 좌표 오름차순으로 정렬
        @Override
        public int compareTo(Point p) {
            if (this.y == p.y) {
                return this.x - p.x;
            }
            return this.y - p.y;
        }
    }

}
