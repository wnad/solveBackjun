package problem;

import java.util.List;

import static problem.Read.readInt;

public class P_1012 implements Problem {

    /*
    문제
    차세대 영농인 한나는 강원도 고랭지에서 유기농 배추를 재배하기로 하였다.
    농약을 쓰지 않고 배추를 재배하려면 배추를 해충으로부터 보호하는 것이 중요하기 때문에, 한나는 해충 방지에 효과적인 배추흰지렁이를 구입하기로 결심한다.
    이 지렁이는 배추근처에 서식하며 해충을 잡아 먹음으로써 배추를 보호한다.
    특히, 어떤 배추에 배추흰지렁이가 한 마리라도 살고 있으면 이 지렁이는 인접한 다른 배추로 이동할 수 있어, 그 배추들 역시 해충으로부터 보호받을 수 있다.
    한 배추의 상하좌우 네 방향에 다른 배추가 위치한 경우에 서로 인접해있는 것이다.

    한나가 배추를 재배하는 땅은 고르지 못해서 배추를 군데군데 심어 놓았다.
    배추들이 모여있는 곳에는 배추흰지렁이가 한 마리만 있으면 되므로 서로 인접해있는 배추들이 몇 군데에 퍼져있는지 조사하면 총 몇 마리의 지렁이가 필요한지 알 수 있다.
    예를 들어 배추밭이 아래와 같이 구성되어 있으면 최소 5마리의 배추흰지렁이가 필요하다.
    0은 배추가 심어져 있지 않은 땅이고, 1은 배추가 심어져 있는 땅을 나타낸다.

    1	1	0	0	0	0	0	0	0	0
    0	1	0	0	0	0	0	0	0	0
    0	0	0	0	1	0	0	0	0	0
    0	0	0	0	1	0	0	0	0	0
    0	0	1	1	0	0	0	1	1	1
    0	0	0	0	1	0	0	1	1	1

    입력
    입력의 첫 줄에는 테스트 케이스의 개수 T가 주어진다.
    그 다음 줄부터 각각의 테스트 케이스에 대해 첫째 줄에는 배추를 심은 배추밭의 가로길이 M(1 ≤ M ≤ 50)과 세로길이 N(1 ≤ N ≤ 50),
    그리고 배추가 심어져 있는 위치의 개수 K(1 ≤ K ≤ 2500)이 주어진다.
    그 다음 K줄에는 배추의 위치 X(0 ≤ X ≤ M-1), Y(0 ≤ Y ≤ N-1)가 주어진다.
    두 배추의 위치가 같은 경우는 없다.

    출력
    각 테스트 케이스에 대해 필요한 최소의 배추흰지렁이 마리 수를 출력한다.

    예제 입력 1
    2
    10 8 17
    0 0
    1 0
    1 1
    4 2
    4 3
    4 5
    2 4
    3 4
    7 4
    8 4
    9 4
    7 5
    8 5
    9 5
    7 6
    8 6
    9 6
    10 10 1
    5 5

    예제 출력 1
    5
    1

    예제 입력 2
    1
    5 3 6
    0 2
    1 2
    2 2
    3 2
    4 2
    4 0

    예제 출력 2
    2
     */

    /*
    조건 : 양배추가 인접해 있다면 하나의 지렁이가 해충을 커버할 수 있다.
    해결 : 인접해있는 양배추의 영역의 개수 만큼 지렁이가 필요하다.
     */


    // 예제 입출력
    public static List<String> input = List.of(
            "2\n" + "10 8 17\n" + "0 0\n" + "1 0\n" +"1 1\n" +"4 2\n" +"4 3\n" +"4 5\n" +"2 4\n" +"3 4\n" +"7 4\n" +"8 4\n" +"9 4\n" +"7 5\n" +"8 5\n" +"9 5\n" +"7 6\n" +"8 6\n" +"9 6\n" +"10 10 1\n" +"5 5",
            "1\n" +"5 3 6\n" +"0 2\n" +"1 2\n" +"2 2\n" +"3 2\n" +"4 2\n" +"4 0");
    public static List<String> output = List.of(
            "5\n" +"1",
            "2");


    static int T, M, N, K;
    static int[][] cabbageMap;
    static boolean[][] visitMap;
    static int count;
    static int[] dx = { 0, -1, 0, 1 };
    static int[] dy = { 1, 0, -1, 0 };

    @Override
    public void exec() throws Exception {

        // testcase 수 입력
        T = readInt();

        StringBuilder output = new StringBuilder();

        while(T-- > 0) {

            M = readInt();
            N = readInt();
            K = readInt();
            count = 0;

            cabbageMap = new int[M][N];
            visitMap = new boolean[M][N];

            // 배추 위치 좌표 입력.
            for (int i=0; i<K; i++) {
                cabbageMap[readInt()][readInt()]++;
            }

            for (int x = 0; x < M; x++) {
                for (int y = 0; y < N; y++) {
                    if (cabbageMap[x][y] == 1 && !visitMap[x][y]) {
                        // 양배추가 붙어있는 영역을 visit 으로 표시해서 중복을 방지.
                        dfs(x, y);
                        count++;
                    }
                }
            }

            output.append(count).append('\n');

        }

        System.out.print(output.toString().trim());
    }

    // 인접해있는 배추를 방문
    static void dfs(int x, int y) {
        // 처음 지렁이가 방문
        visitMap[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int cx = x + dx[i];
            int cy = y + dy[i];

            // 현재 좌표가 맞는 좌표인지
            if (cx >= 0 && cy >= 0 && cx < M && cy < N) {
                // 지렁이가 움직일 수 있는 상하좌우 좌표에 지렁이가 방문하지 않은 좌표에 양배추가 있을 경우 dfs 를 다시 재귀 호출
                if (!visitMap[cx][cy] && cabbageMap[cx][cy] == 1) {
                    dfs(cx, cy);
                }
            }
        }
    }
}
