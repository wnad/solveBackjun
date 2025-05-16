package problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class P_11724 implements Problem {


    static boolean[] visited;

    @Override
    public void exec() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int nodes = read();
        int edges = read();

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i <= nodes; i++) {
            graph.add(new ArrayList<>());
        }

        visited = new boolean[nodes+1];
        int count = 0;

        int u,v;

        while(edges-->0) {
            u = read();
            v = read();

            // 그래프에 간선 추가
            graph.get(u).add(v);
            graph.get(u).add(v);
        }

        br.close();

        for (int i=1; i<=nodes; i++) {
            if (!visited[i]) {
                BFS(graph, i);
                count++;
            }
        }

        System.out.print(count);
    }

    private static void BFS(List<List<Integer>> graph, int start) {

        // 탐색할 큐 선언
        LinkedList<Integer> queue = new LinkedList<>();

        // 시작 노드 방문후 큐 삽입
        visited[start] = true;
        queue.add(start);

        int curNode;

        // 큐가 빌때까지 반복
        while(!queue.isEmpty()) {
            // 큐의 Poll
            curNode = queue.poll();

            // 인접 노드 탐색
            for (int neighbor : graph.get(curNode)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
    }

    static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

    public static List<String> input = List.of(
            "6 5\n" +
                    "1 2\n" +
                    "2 5\n" +
                    "5 1\n" +
                    "3 4\n" +
                    "4 6",
            "6 8\n" +
                    "1 2\n" +
                    "2 5\n" +
                    "5 1\n" +
                    "3 4\n" +
                    "4 6\n" +
                    "5 4\n" +
                    "2 4\n" +
                    "2 3"
    );

    public static List<String> output = List.of(
            "2", "1"
    );


    /*
    문제
    방향 없는 그래프가 주어졌을 때, 연결 요소 (Connected Component)의 개수를 구하는 프로그램을 작성하시오.

    입력
    첫째 줄에 정점의 개수 N과 간선의 개수 M이 주어진다. (1 ≤ N ≤ 1,000, 0 ≤ M ≤ N×(N-1)/2)
    둘째 줄부터 M개의 줄에 간선의 양 끝점 u와 v가 주어진다. (1 ≤ u, v ≤ N, u ≠ v)
    같은 간선은 한 번만 주어진다.

    출력
    첫째 줄에 연결 요소의 개수를 출력한다.
     */
}
