package problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class P_3197 implements Problem {


    /**
     * Problem 3197: 백조의 호수
     *
     * 1. 문제 요약
     *    - 빙판이 주어진다. 시간이 지날때마다 빙판이 녹는다.
     *    - 두 백조가 만날 수 있는 시간 계산
     *    - 입력:
     *          - R과 C가 주어진다. 단, 1 ≤ R, C ≤ 1500.
     *          - 다음 R개의 줄에는 각각 길이 C의 문자열이 하나씩 주어진다.
     *          - '.'은 물 공간, 'X'는 빙판 공간, 'L'은 백조가 있는 공간으로 나타낸다.
     *    - 출력 : 첫째 줄에 문제에서 주어진 걸리는 날을 출력한다.
     *
     * 2. 접근 아이디어
     *    1) BFS 탐색을 통해 다음날 얼음이 녹는 부분 파악
     *    2) 얼음이 녹았을 때, 백조가 만날 수 있는 지 판단
     *
     *
     * 3. 시간·공간 복잡도
     *    - 시간 : O(Nlog N)
     *    - 공간 : O(N)
     *
     * 4. 회고
     *    - 처음에는 BFS 탐색을 통해 물공간 탐색후 백조 위치 비교, 얼음 녹이는 BFS 탐색후 반복
     *    - 이런 식으로 해결했는데 타임아웃이 발생했다.
     *    - 한번 탐색할때, 다음에 갈 수 있는 얼음을 큐에 저장후, 저장된 큐부터 탐색을 하면 전체 탐색을 하지 않아도 되서 효율적이다.
     *    - 탐색을 할때, 탐색의 범위를 줄여보는 생각을 가져보자.
     */

    public static List<String> input = List.of(
            "10 2\n" +
                    ".L\n" +
                    "..\n" +
                    "XX\n" +
                    "XX\n" +
                    "XX\n" +
                    "XX\n" +
                    "XX\n" +
                    "XX\n" +
                    "..\n" +
                    ".L",
            "4 11\n" +
                    "..XXX...X..\n" +
                    ".X.XXX...L.\n" +
                    "....XXX..X.\n" +
                    "X.L..XXX...",
            "8 17\n" +
                    "...XXXXXX..XX.XXX\n" +
                    "....XXXXXXXXX.XXX\n" +
                    "...XXXXXXXXXXXX..\n" +
                    "..XXXXX.LXXXXXX..\n" +
                    ".XXXXXX..XXXXXX..\n" +
                    "XXXXXXX...XXXX...\n" +
                    "..XXXXX...XXX....\n" +
                    "....XXXXX.XXXL..."
    );

    public static List<String> output = List.of(
        "3",
            "2", "2"
    );

    static int R, C;

    static char[][] map;

    static int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    // 현재 물인 부분
    static Queue<int[]> waterQue = new LinkedList<>();

    // 현재 백조가 탐색할 수 있는 큐
    static Queue<int[]> swanQue = new LinkedList<>();

    // 탐색중 갈수 없는 얼음 -> 다음 날 녹을 얼음큐
    static Queue<int[]> nextWaterQue = new LinkedList<>();

    // 탐색중 주변에 갈수 없는 얼음 -> 다음날 갈 수 있는 백조 탐색 큐
    static Queue<int[]> nextSwanQue = new LinkedList<>();

    static int[] swan1, swan2;

    static boolean[][] waterVisited;
    static boolean[][] swanVisited;


    @Override
    public void exec() throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        waterVisited = new boolean[R][C];
        swanVisited = new boolean[R][C];

        List<int[]> swans = new ArrayList<>();

        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = line.charAt(j);

                if (map[i][j] == 'L') {
                    swans.add(new int[]{i, j});
                    map[i][j] = '.';  // 백조 위치도 물로 처리
                }

                if (map[i][j] == '.') {
                    waterQue.offer(new int[]{i, j});
                    waterVisited[i][j] = true;
                }
            }
        }

        br.close();

        swan1 = swans.get(0);
        swan2 = swans.get(1);

        // 백조 시작점 추가
        swanQue.offer(swan1);

        // 백조 시작 위치 방문 추가
        swanVisited[swan1[0]][swan1[1]] = true;

        int days = 0;

        while(true) {
            if (moveSwan()) break;
            meltIce();
            days++;
        }

        System.out.print(days);
    }

    static boolean moveSwan() {

        // 1) swanQue 에 방문할 좌표가 있을때까지 반복
        while (!swanQue.isEmpty()) {

            // 1-1) 현재 탐색할 좌표 꺼내오기
            int[] cur = swanQue.poll();

            // 1-2) 1번 백조 좌표 현위치
            int r = cur[0];
            int c = cur[1];

            // 1-3) 백조가 만났을 경우 true 반환
            if (r == swan2[0] && c == swan2[1]) {
                return true;
            }

            // 1-4) 상하좌우 탐색
            for (int[] dir : directions) {

                // 1) 다음 좌표 계산
                int nr = r+dir[0];
                int nc = c+dir[1];

                // 2) 탐색 예외 처리
                // 2-1) 맵 안에 존재 하는지
                if (nr < 0 || nc < 0 || nr >= R || nc >= C) { continue; }

                // 2-2) 탐색한 곳이 아닌지
                if (swanVisited[nr][nc]) { continue; }

                // 3) 방문후 방문 처리
                swanVisited[nr][nc] = true;

                // 3-1) 물이면 swanQue 에 추가 (백조가 갈 수 있으니까)
                if (map[nr][nc] == '.') {
                    swanQue.offer(new int[]{nr, nc});
                } else if (map[nr][nc] == 'X') {
                    // 3-2) 얼음이면 nextSwanQue 에 추가 (다음날 갈 수 있으니까)
                    nextSwanQue.offer(new int[]{nr, nc});
                }
            }
        }

        // 2) 탐색이 종료되면 (모든 물을 방문했다면)

        // 2-1) nextSwanQue 를 다음날 방문할 swanQue 로 설정
        swanQue = nextSwanQue;

        // 2-2) nextSwanQue 초기화
        nextSwanQue = new LinkedList<>();

        // 2-3) false 반환 (백조가 만나지 못했으므로)
        return false;
    }

    static void meltIce() {
        // 1) waterQue 가 있을 때까지 반복
        while(!waterQue.isEmpty()) {
            // 1-1) 현위치 물 좌표 꺼내기
            int[] cur = waterQue.poll();

            int r = cur[0];
            int c = cur[1];

            // 1-2) 좌표 탐색
            for (int[] dir : directions) {
                int nr = r+dir[0];
                int nc = c+dir[1];

                // 1) 방문 예외처리
                // 1-1) 맵 안에 있는지
                if (nr < 0 || nc < 0 || nr >= R || nc >= C) {
                    continue;
                }

                // 1-2) 방문한 물은 아닌지
                if (waterVisited[nr][nc]) {
                    continue;
                }

                // 2) 얼음 녹이기
                if (map[nr][nc] == 'X') {
                    // 2-1) 맵 바꾸기
                    map[nr][nc] = '.';

                    // 2-2) 방문 처리
                    waterVisited[nr][nc] = true;

                    // 2-3) nextWaterQue 에 추가
                    nextWaterQue.offer(new int[]{nr, nc});
                }

            }
        }

        // 2) nextWaterQue 를 waterQue 로 설정
        waterQue = nextWaterQue;

        // 3) nextWaterQue 초기화
        nextWaterQue = new LinkedList<>();
    }
}
