package problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P_1260  implements Problem {

    /*
    문제
    그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램을 작성하시오.
    단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고, 더 이상 방문할 수 있는 점이 없는 경우 종료한다. 정점 번호는 1번부터 N번까지이다.

    입력
    첫째 줄에 정점의 개수 N(1 ≤ N ≤ 1,000), 간선의 개수 M(1 ≤ M ≤ 10,000), 탐색을 시작할 정점의 번호 V가 주어진다.
    다음 M개의 줄에는 간선이 연결하는 두 정점의 번호가 주어진다.
    어떤 두 정점 사이에 여러 개의 간선이 있을 수 있다. 입력으로 주어지는 간선은 양방향이다.

    출력
    첫째 줄에 DFS를 수행한 결과를, 그 다음 줄에는 BFS를 수행한 결과를 출력한다. V부터 방문된 점을 순서대로 출력하면 된다.
     */

    public static List<String> input = List.of(
            "4 5 1\n" +"1 2\n" +"1 3\n" +"1 4\n" +"2 4\n" +"3 4",
            "5 5 3\n" + "5 4\n" +"5 2\n" +"1 2\n" +"3 4\n" +"3 1",
            "1000 1 1000\n" + "999 1000"
            );

    public static List<String> output = List.of("1 2 4 3\n" + "1 2 3 4",
            "3 1 2 5 4\n" + "3 1 4 2 5",
            "1000 999\n" + "1000 999"
    );

    @Override
    public void exec()  throws IOException {

        // 수의 개수 N 입력 받기
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer inputString = new StringTokenizer(bufferedReader.readLine());

        int node = Integer.parseInt(inputString.nextToken());
        int edge = Integer.parseInt(inputString.nextToken());
        int startNode = Integer.parseInt(inputString.nextToken());

        // 그래프 저장할 LinkedList 생성
        LinkedList<Integer>[] edges = new LinkedList[node+1];

        Queue<int[]> queue = new LinkedList<>();

        // 간선 정보 저장
        for (int i = 0; i < edge; i++) {
            StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
            addEdge(edges, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        bufferedReader.close();

        // 그래프 정렬
        for (LinkedList<Integer> edgeList : edges) {
            if (edgeList != null) {
                Collections.sort(edgeList);
            }
        }

        StringBuilder result = new StringBuilder();

        // DFS 수행
        DFS(edges, startNode, result);

        // BFS 수행
        BFS(edges, startNode, result);

        System.out.print(result);

    }

    // 간선 정보 저장
    public void addEdge(LinkedList<Integer>[] edges, int start, int end) {
        if (edges[start] == null) {
            edges[start] = new LinkedList<>();
        }

        if (edges[end] == null) {
            edges[end] = new LinkedList<>();
        }

        // edges 에 양방향 정보 저장
        edges[start].add(end);
        edges[end].add(start);
    }

    // DFS 수행
    // 하나만 판다
    public void DFS(LinkedList<Integer>[] edges, int start, StringBuilder result) {

        boolean[] visited = new boolean[edges.length];
        Stack<Integer> stack = new Stack<>();

        stack.push(start);
        while (!stack.isEmpty()) {
            int current = stack.pop();
            if (!visited[current]) {
                visited[current] = true;
                result.append(current).append(" ");
                for (int i = edges[current].size() - 1; i >= 0; i--) {
                    int next = edges[current].get(i);
                    if (!visited[next]) {
                        stack.push(next);
                    }
                }
            }
        }
        result.deleteCharAt(result.length() - 1).append("\n");
    }

    // 여러개를 하나씩 본다
    public void BFS(List<Integer>[] edges, int start, StringBuilder result) {

        boolean[] visited = new boolean[edges.length];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        while (!queue.isEmpty()) {
            int current = queue.poll();
            result.append(current).append(" ");
            for (int neighbor : edges[current]) {
                if (!visited[neighbor]) {
                    queue.add(neighbor);
                    visited[neighbor] = true;
                }
            }
        }
        result.deleteCharAt(result.length()-1);
    }
}
