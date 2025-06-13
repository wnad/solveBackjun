package problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class P_2933 implements Problem {

    /**
     * Problem 2933: 미네랄
     *
     * 1. 문제 요약
     *    - 동굴은 R행 C열로 나타낼 수 있으며, R×C칸으로 이루어져 있다. 각 칸은 비어있거나 미네랄을 포함하고 있으며, 네 방향 중 하나로 인접한 미네랄이 포함된 두 칸은 같은 클러스터이다.
     *    - 창영과 상근이 왼쪽과 오른쪽에서 번갈아가며 막대를 던지고 막대가 미네랄을 만나면 미네랄이 파괴되고 멈춘다.
     *    - 떠있는 남은 클러스터는 바닥으로 떨어진다. 클러스터의 모양은 변하지 않는다.
     *    - 동굴에 있는 미네랄의 모양과 두 사람이 던진 막대의 높이가 주어진다. 모든 막대를 던지고 난 이후에 미네랄 모양을 구하는 프로그램을 작성하시오.
     *    - 입력 :
     *      - 첫째 줄에 동굴의 크기 R과 C가 주어진다. (1 ≤ R,C ≤ 100)
     *      - 다음 R개 줄에는 C개의 문자가 주어지며, '.'는 빈 칸, 'x'는 미네랄을 나타낸다.
     *      - 다음 줄에는 막대를 던진 횟수 N이 주어진다. (1 ≤ N ≤ 100)
     *      - 마지막 줄에는 막대를 던진 높이가 주어지며, 공백으로 구분되어져 있다. 모든 높이는 1과 R사이이며, 높이 1은 행렬의 가장 바닥, R은 가장 위를 의미한다. 첫 번째 막대는 왼쪽에서 오른쪽으로 던졌으며, 두 번째는 오른쪽에서 왼쪽으로, 이와 같은 식으로 번갈아가며 던진다.
     *      - 공중에 떠 있는 미네랄 클러스터는 없으며, 두 개 또는 그 이상의 클러스터가 동시에 떨어지는 경우도 없다. 클러스터가 떨어질 때, 그 클러스터 각 열의 맨 아래 부분 중 하나가 바닥 또는 미네랄 위로 떨어지는 입력만 주어진다.
     *    - 출력 :
     *      - 입력 형식과 같은 형식으로 미네랄 모양을 출력한다.
     *
     *
     * 2. 접근 아이디어
     *    1) shutting 이후 바닥부터 동굴 탐색
     *    2) 모든 미네랄을 탐색 완료시 shutting 반복
     *    3) 클러스터 발견시 최소 하강 수 구해서 떨어뜨리기(fall)
     *
     * 3. 시간·공간 복잡도
     *    - 시간 : O(NRC)
     *    - 공간 : O(RC)
     *
     * 4. 회고
     *    - BFS 탐색을 활용하면 어렵지 않았던 문제고 문제를 이해하는데 시간이 걸렸었다.
     *    - 처음에 상단부터 탐색을 하려고 층마다 칸 개수를 따로 저장할까 고려했지만, 너무 복잡해져서 간단히 구현하려고 했다.
     *
     */

    public static List<String> input = List.of(
            "5 6\n" +
                    "......\n" +
                    "..xx..\n" +
                    "..x...\n" +
                    "..xx..\n" +
                    ".xxxx.\n" +
                    "1\n" +
                    "3",
            "8 8\n" +
                    "........\n" +
                    "........\n" +
                    "...x.xx.\n" +
                    "...xxx..\n" +
                    "..xxx...\n" +
                    "..x.xxx.\n" +
                    "..x...x.\n" +
                    ".xxx..x.\n" +
                    "5\n" +
                    "6 6 4 3 1",
            "7 6\n" +
                    "......\n" +
                    "......\n" +
                    "xx....\n" +
                    ".xx...\n" +
                    "..xx..\n" +
                    "...xx.\n" +
                    "....x.\n" +
                    "2\n" +
                    "6 4"
    );

    public static List<String> output = List.of(
            "......\n" +
                    "......\n" +
                    "..xx..\n" +
                    "..xx..\n" +
                    ".xxxx.",
            "........\n" +
                    "........\n" +
                    "........\n" +
                    "........\n" +
                    ".....x..\n" +
                    "..xxxx..\n" +
                    "..xxx.x.\n" +
                    "..xxxxx.",
            "......\n" +
                    "......\n" +
                    "......\n" +
                    "......\n" +
                    "..xx..\n" +
                    "xx.xx.\n" +
                    ".x..x."
    );

    static int R,C,N, mineralCount;

    static boolean[][] map;

    static Queue<int[]> queue;

    static boolean[][] visited;

    static int[][] directions = {{0,1}, {0,-1}, {-1,0}, {1,0}};


    @Override
    public void exec() throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer rc = new StringTokenizer(br.readLine());

        // 동굴 높이 R, 너비 C
        R = Integer.parseInt(rc.nextToken());
        C = Integer.parseInt(rc.nextToken());

        map = new boolean[R][C];

        mineralCount = 0;

        // 동굴 맵 입력
        for (int i=R; 0<i; i--) {
            String floor = br.readLine();

            for (int j=0; j<C; j++) {
                if (floor.charAt(j)=='x') {
                    map[i-1][j] = true;
                    mineralCount++;
                }
            }
        }

        // 던지는 횟수 N
        N = Integer.parseInt(br.readLine());

        // 던지는 높이 큐
        StringTokenizer shuttingHeights = new StringTokenizer(br.readLine());

        for (int i=0; i<N; i++) {
            int h = Integer.parseInt(shuttingHeights.nextToken())-1;

            // 막대 던지기
            shutting(h, i);
        }

        StringBuilder result = new StringBuilder();

        for (int r=R-1; 0<=r; r--) {
            for (int c=0; c<C; c++) {
                result.append(map[r][c] ? "x" : ".");
            }

            if (r!=0) {
                result.append("\n");
            }
        }

        System.out.print(result);

    }

    // 막대 던지기
    static void shutting(int r, int index) {

        int target = -1;

        // 막대에 맞은 미네랄 좌표 탐색
        if (index%2 == 0) {
            for (int i=0; i<C; i++) {
                if(map[r][i]) {
                    target=i;
                    break;
                }
            }
        } else {
            for (int i=C-1; 0<=i; i--) {
                if(map[r][i]) {
                    target=i;
                    break;
                }
            }
        }

        // 막대가 미네랄을 맞췄을 때
        if (target!=-1) {

            // . 으로 초기화
            map[r][target] = false;

            mineralCount--;

            // bfs 탐색
            bfs();
        }
    }

    // 클러스터가 있는지 탐색
    static void bfs() {

        queue = new LinkedList<>();
        visited = new boolean[R][C];

        int visitedCount = 0;

        // 바닥에 붙어있는 미네랄 큐에 넣기
        for (int c=0; c<C; c++) {
            if (map[0][c]) {
                queue.add(new int[]{0, c});
                visited[0][c] = true;
                visitedCount++;
            }
        }

        while(!queue.isEmpty()) {

            // 처음 좌표 꺼내서 방문
            int[] cur = queue.poll();

            // 인접좌표 탐색후 큐에 넣기
            for (int[] dir : directions) {
                int nr = cur[0] + dir[0];
                int nc = cur[1] + dir[1];

                // 맵 안에 있는 좌표인지 확인
                if (nr<0 || R<=nr || nc<0 || C<=nc) {
                    continue;
                }

                // 탐색 칸이 미네랄이고 방문을 하지 않았으면 이동
                if (map[nr][nc] && !visited[nr][nc]) {

                    // 다음 방문 큐에 넣기
                    queue.add(new int[]{nr,nc});

                    // 방문 처리
                    visited[nr][nc] = true;

                    visitedCount++;
                }
            }
        }

        // 미네랄 개수와 방문한 개수가 다르면, 클러스터 떨구기
        if (mineralCount!=visitedCount) {
            fall();
        }
    }

    static void fall() {

        // 클러스터 담을 리스트
        ArrayList<int[]> clusters = new ArrayList<>();

        // 클러스터 최하단 층 저장 리스트
        int[] lowestMinerals = new int[C];
        Arrays.fill(lowestMinerals, -1);

        for (int r=0; r<R; r++) {
            for (int c=0; c<C; c++) {
                // 방문하지 않은 미네랄이라면
                if (!visited[r][c] && map[r][c]) {
                    // 클러스터에 좌표 추가
                    clusters.add(new int[]{r,c});

                    // 떨어질거라 좌표 초기화
                    map[r][c] = false;

                    // 클러스터 최하단 저장
                    if (lowestMinerals[c]==-1) {
                        lowestMinerals[c] = r;
                    }
                }
            }
        }

        // 맵 최대가 100 이므로 101 으로 설정
        int minDownCount = 101;


        // 클러스터를 얼마나 내릴지 계산
        for (int c=0; c<C; c++) {

            // 클러스터 최하단 미네랄이 없으면 스킵
            if (lowestMinerals[c]==-1 ) {
                continue;
            }

            // c행 r
            int bottomRow = lowestMinerals[c];

            // 떨어질 칸수
            int drop = 0;

            while (0 <= bottomRow - drop - 1) {

                if(map[bottomRow - drop - 1][c]) {
                    break;
                }

                drop++;
            }

            minDownCount = Math.min(minDownCount, drop);

        }

        // 클러스터 떨어지게 맵 수정
        if (minDownCount != 101) {
            for (int[] cluster : clusters) {
                map[cluster[0]-minDownCount][cluster[1]] = true;
            }
        }
    }
}
