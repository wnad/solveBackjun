package problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class P_2606 implements Problem {

    // 1번 컴퓨터에 연결된 노드에 방문 카운트
    static int count;

    @Override
    public void exec() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int computers = Integer.parseInt(br.readLine());
        int networks = Integer.parseInt(br.readLine());

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i <= computers; i++) {
            graph.add(new ArrayList<>());
        }

        String[] conn;

        // 연결된 컴퓨터들을 그래프에 넣기
        while (networks-->0) {
            conn = br.readLine().split(" ");

            // 양방향 그래프
            graph.get(Integer.parseInt(conn[0])).add(Integer.parseInt(conn[1]));
            graph.get(Integer.parseInt(conn[1])).add(Integer.parseInt(conn[0]));
        }

        br.close();

        // bfs 수행
        count = 0;
        bfs(graph, computers);

        // 1번 컴퓨터에 연결된 컴퓨터 수 반환
        System.out.print(count);

    }

    private static void bfs(List<List<Integer>> graph, int size) {
        // 방문 여부 판단 배열
        boolean[] visited = new boolean[size + 1];

        // 다음 탐색할 노드를 저장하는 큐
        LinkedList<Integer> queue = new LinkedList<>();

        // 1번 컴퓨터를 기준으로 연결되어있는 컴퓨터들을 찾으므로 1번을 start 로 둔다
        visited[1] = true;
        queue.add(1);

        int curNode;

        // 큐가 빌 때까지 반복
        while(!queue.isEmpty()) {
            // 큐의 가장 앞에 있는 노드를 꺼낸다.
            curNode = queue.poll();

            // curNode 에 인접한 모든 노드를 탐색
            for (int neighbor : graph.get(curNode)) {

                // 인접노드에 방문하지 않았다면 방문 표시후 큐에 넣는다.
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);

                    // 방문한 노드 수 추가
                    count++;
                }
            }
        }
    }


    public static List<String> input = List.of(
            "7\n" +
                    "6\n" +
                    "1 2\n" +
                    "2 3\n" +
                    "1 5\n" +
                    "5 2\n" +
                    "5 6\n" +
                    "4 7"
    );

    public static List<String> output = List.of(
            "4"
    );

    /*
    신종 바이러스인 웜 바이러스는 네트워크를 통해 전파된다.
    한 컴퓨터가 웜 바이러스에 걸리면 그 컴퓨터와 네트워크 상에서 연결되어 있는 모든 컴퓨터는 웜 바이러스에 걸리게 된다.

    예를 들어 7대의 컴퓨터가 <그림 1>과 같이 네트워크 상에서 연결되어 있다고 하자.
    1번 컴퓨터가 웜 바이러스에 걸리면 웜 바이러스는 2번과 5번 컴퓨터를 거쳐 3번과 6번 컴퓨터까지 전파되어 2, 3, 5, 6 네 대의 컴퓨터는 웜 바이러스에 걸리게 된다.
    하지만 4번과 7번 컴퓨터는 1번 컴퓨터와 네트워크상에서 연결되어 있지 않기 때문에 영향을 받지 않는다.

    어느 날 1번 컴퓨터가 웜 바이러스에 걸렸다.
    컴퓨터의 수와 네트워크 상에서 서로 연결되어 있는 정보가 주어질 때, 1번 컴퓨터를 통해 웜 바이러스에 걸리게 되는 컴퓨터의 수를 출력하는 프로그램을 작성하시오.

    입력
    첫째 줄에는 컴퓨터의 수가 주어진다.
    컴퓨터의 수는 100 이하인 양의 정수이고 각 컴퓨터에는 1번 부터 차례대로 번호가 매겨진다.
    둘째 줄에는 네트워크 상에서 직접 연결되어 있는 컴퓨터 쌍의 수가 주어진다.
    이어서 그 수만큼 한 줄에 한 쌍씩 네트워크 상에서 직접 연결되어 있는 컴퓨터의 번호 쌍이 주어진다.

    출력
    1번 컴퓨터가 웜 바이러스에 걸렸을 때, 1번 컴퓨터를 통해 웜 바이러스에 걸리게 되는 컴퓨터의 수를 첫째 줄에 출력한다.
     */
}