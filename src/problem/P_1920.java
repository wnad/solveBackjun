package problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class P_1920 implements Problem {

    /**
     * Problem 1920: 수 찾기
     *
     * 1. 문제 요약
     *    - N 개의 정수가 주어질 때, X 라는 수가 존재하는지 찾기
     *    - 입력: 첫째 줄에 자연수 N (1 ≤ N ≤ 100,000), 다음 줄에 N개의 정수들 A[N]
     *    - 입력: 다음 줄에 자연수 M (1 ≤ M ≤ 100,000), 다음 줄에 M개의 정수들 X[M]
     *    - A[N] 중에 X[M] 이 존재하면 1, 아니면 0
     *    - M 수의 존재 여부 출력
     *
     * 2. 접근 아이디어
     *    1) A[N] 을 정렬
     *    2) 이진 탐색으로 X[M] 이 있는지 탐색
     *
     * 3. 시간·공간 복잡도
     *    - 시간: 정렬 O(N log N) / 이진 탐색 O(M log N)
     *    - 공간: O(N) (입력 배열)
     *
     * 4. 회고
     *    - 여러개의 수 사이에서 특정 수가 있는지 찾으려면 이진탐색이 적절하다.
     *    - 이진 탐색을 하기 위해 정렬이 필요하다.
     */

    public static List<String> input = List.of(
            "5\n" +"4 1 5 2 3\n" +"5\n" +"1 3 7 9 5"
    );

    public static List<String> output = List.of(
            "1\n" +"1\n" +"0\n" +"0\n" +"1"
    );

    @Override
    public void exec() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];

        StringTokenizer a = new StringTokenizer(br.readLine());

        for (int i=0; i<N; i++) {
            A[i] = Integer.parseInt(a.nextToken());
        }

        // 정렬
        Arrays.sort(A);

        int M = Integer.parseInt(br.readLine());
        int [] X = new int[M];

        StringTokenizer x = new StringTokenizer(br.readLine());

        for (int i=0; i<M; i++) {
            X[i] = Integer.parseInt(x.nextToken());
        }

        StringBuilder result = new StringBuilder();

        for (int num : X) {
            result.append(binarySearch(A, num) ? "1" : "0").append("\n");
        }

        result.deleteCharAt(result.length()-1);

        System.out.print(result);

    }


    public static boolean binarySearch(int[] sortedArray, int target) {

        int start = 0;
        int end = sortedArray.length-1;

        int mid;

        while (start<=end) {
            mid = (start + end)/2;

            if (sortedArray[mid] == target) {
                return true;
            } else {
                if (sortedArray[mid]<target) {
                    start = mid+1;
                } else {
                    end = mid-1;
                }
            }
        }

        return false;
    }

}
