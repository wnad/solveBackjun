import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder output = new StringBuilder();

        while (true) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            int c = Integer.parseInt(input[2]);

            if (a == 0 && b == 0 && c == 0) {
                break;
            }

            output.append(isTriangle(a, b, c)).append("\n");
        }

        output.deleteCharAt(output.length() - 1);

        System.out.print(output);
    }

    public static String isTriangle(int a, int b, int c) {

        int[] arr = {a, b, c};
        Arrays.sort(arr);

        // 삼각형 조건 미부합
        if (arr[0] + arr[1] <= arr[2]) {
            return "Invalid";
        }

        // 가장 긴 변 == 가장 작은 변 이면 정삼각형
        if (arr[0] == arr[2]) {
            return "Equilateral";
        }

        // 두변의 길이가 같으면 이등변 삼각형
        if (arr[0] == arr[1] || arr[1] == arr[2]) {
            return "Isosceles";
        }

        // 세변이 다른 삼각형
        return "Scalene";
    }
}