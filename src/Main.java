import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

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