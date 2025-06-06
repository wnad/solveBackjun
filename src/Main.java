import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

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

    public static void main(String[] args) throws IOException {

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