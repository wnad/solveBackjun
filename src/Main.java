import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 수 N
        int N = Integer.parseInt(br.readLine());

        // 입력 저장할 배열 선언
        int[] array = new int[N];

        for (int i=0; i<N; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }

        // 정렬
        Arrays.sort(array);


        // 정렬된 수 출력
        StringBuilder result = new StringBuilder();

        for (int num : array) {
            result.append(num).append("\n");
        }

        result.deleteCharAt(result.length() - 1);

        System.out.print(result);
    }
}