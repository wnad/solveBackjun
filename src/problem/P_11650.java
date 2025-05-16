package problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class P_11650 implements Problem {

    /*
문제
2차원 평면 위의 점 N개가 주어진다.
좌표를 x좌표가 증가하는 순으로, x좌표가 같으면 y좌표가 증가하는 순서로 정렬한 다음 출력하는 프로그램을 작성하시오.

입력
첫째 줄에 점의 개수 N (1 ≤ N ≤ 100,000)이 주어진다.
둘째 줄부터 N개의 줄에는 i번점의 위치 xi와 yi가 주어진다. (-100,000 ≤ xi, yi ≤ 100,000)
좌표는 항상 정수이고, 위치가 같은 두 점은 없다.

출력
첫째 줄부터 N개의 줄에 점을 정렬한 결과를 출력한다.

예제 입력 1
5
3 4
1 1
1 -1
2 2
3 3

예제 출력 1
1 -1
1 1
2 2
3 3
3 4

     */

    @Override
    public void exec() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        // 1. 점의 개수 입력
        int pointNumber = Integer.parseInt(bufferedReader.readLine());

        // 2. 점 리스트 선언
        List<Point> pointList = new LinkedList<>();

        // 3. 입력받은 점을 리스트에 저장
        for (int i=0; i< pointNumber; i++) {
            StringTokenizer pointToken = new StringTokenizer(bufferedReader.readLine());
            pointList.add(new Point(Integer.parseInt(pointToken.nextToken()), Integer.parseInt(pointToken.nextToken())));
        }

        bufferedReader.close();

        // 4. x 좌표 기준으로 오름차순 정렬하고, x 좌표가 같으면 y 좌표로 오름차순 정렬
        Collections.sort(pointList);

        // 5. 정렬된 점을 출력
        StringBuilder output = new StringBuilder();
        for (Point point : pointList) {
            output.append(point);
        }
        System.out.println(output);
    }

    static class Point implements Comparable<Point>{
        int x; // 점의 x 좌표
        int y; // 점의 x 좌표

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        // x 좌표가 같으면 y 좌표로 정렬, 그렇지 않으면 x 좌표로 정렬
        @Override
        public int compareTo(Point other) {
            if (this.x == other.x) {
                return this.y - other.y;
            }
            return this.x - other.x;
        }

        @Override
        public String toString(){
            return x+" "+y+"\n";
        }
    }
}
