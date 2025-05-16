import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String N = br.readLine();

        int size = N.length();

        int[] nums = new int[size];

        for (int i=0; i<size; i++) {
            // char 니까 (아스키) 숫자로 변환
            nums[i] = N.charAt(i) - '0';
        }

        Arrays.sort(nums);

        StringBuilder result = new StringBuilder();

        for (int i=0; i<size; i++) {
            result.append(nums[size-i-1]);
        }

        System.out.print(result);
    }
}