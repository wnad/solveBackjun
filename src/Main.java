import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int R,C,N, mineralCount;

    static boolean[][] map;

    static Queue<int[]> queue;

    static boolean[][] visited;

    static int[][] directions = {{0,1}, {0,-1}, {-1,0}, {1,0}};

    public static void main(String[] args) throws IOException {

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

        br.close();

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