package problem;

import java.util.List;

import static problem.Read.readInt;

public class P_1074 implements Problem {

    /*
    문제
    한수는 크기가 2N × 2N인 2차원 배열을 Z모양으로 탐색하려고 한다.
    예를 들어, 2×2배열을 왼쪽 위칸, 오른쪽 위칸, 왼쪽 아래칸, 오른쪽 아래칸 순서대로 방문하면 Z모양이다.

    N > 1인 경우, 배열을 크기가 2^N-1 × 2^N-1로 4등분 한 후에 재귀적으로 순서대로 방문한다.
    다음 예는 22 × 22 크기의 배열을 방문한 순서이다.

    N이 주어졌을 때, r행 c열을 몇 번째로 방문하는지 출력하는 프로그램을 작성하시오.

    다음은 N=3일 때의 예이다.

    입력
    첫째 줄에 정수 N, r, c가 주어진다.

    출력
    r행 c열을 몇 번째로 방문했는지 출력한다.

    제한
    1 ≤ N ≤ 15
    0 ≤ r, c < 2N

    예제 입력 1
    2 3 1
    예제 출력 1
    11

    예제 입력 2
    3 7 7
    예제 출력 2
    63

    예제 입력 3
    1 0 0
    예제 출력 3
    0

    예제 입력 4
    4 7 7
    예제 출력 4
    63

    예제 입력 5
    10 511 511
    예제 출력 5
    262143

    예제 입력 6
    10 512 512
    예제 출력 6
    786432

     */

    // 예제 입출력
    public static List<String> input = List.of(
            "2 3 1",
            "3 7 7",
            "1 0 0",
            "4 7 7",
            "10 511 511",
            "10 512 512");
    public static List<String> output = List.of(
            "11",
            "63",
            "0",
            "63",
            "262143",
            "786432");

    static int quadrant;

    static int N, r, c, preorder, pow;

    // Z 모양으로 4등분해서 순서를 정한다.
    // 2사분면, 1사분면, 3사분면, 4사분면
    // N:1
    // N:2 (1,3) -> 2사분면(+8) | 4사분면(+3)
    // N:3 (5,2) -> 1사분면(+16) | 3사분면(+8) | 1사분면(+1)

    @Override
    public void exec() throws Exception {

 
        N = readInt();

        // y좌표
        r = readInt();

        // x좌표
        c = readInt();

        System.out.print(findOrder(N,c,r));

    }

    // 순서 계산하는 메서드
    public static int findOrder(int N, int x, int y) {

        if (N==0) {
            return 0;
        }

        quadrant = calculateQuadrant(N,x,y);
        preorder = (int) Math.pow(2, 2*(N-1));

        switch (quadrant) {
            case 1:
                return 1 * preorder + findOrder(N-1, x - (int) Math.pow(2,N-1), y);
            case 2:
                return 0 * preorder + findOrder(N-1, x, y);
            case 3:
                return 2 * preorder + findOrder(N-1, x, y - (int) Math.pow(2,N-1));
            case 4:
                return 3 * preorder + findOrder(N-1, x - (int) Math.pow(2,N-1), y - (int) Math.pow(2,N-1));
            default:
                return -1;
        }
    }

    public static int calculateQuadrant(int N, int x, int y) {

        pow = (int) Math.pow(2, N-1);

        // 1사분면
        if (pow<=x && y<pow) {
            return 1;
        }

        // 2사분면
        if (x<pow && y<pow) {
            return 2;
        }

        // 3사분면
        if (x<pow && pow<=y) {
            return 3;
        }

        // 4사분면
        if (pow<=x && pow<=y) {
            return 4;
        }

        return -1;
    }
}
