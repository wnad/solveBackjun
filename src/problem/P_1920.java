package problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P_1920 implements Problem {

    /*
    문제
    N개의 정수 A[1], A[2], …, A[N]이 주어져 있을 때, 이 안에 X라는 정수가 존재하는지 알아내는 프로그램을 작성하시오.

    입력
    첫째 줄에 자연수 N(1 ≤ N ≤ 100,000)이 주어진다.
    다음 줄에는 N개의 정수 A[1], A[2], …, A[N]이 주어진다. 다음 줄에는 M(1 ≤ M ≤ 100,000)이 주어진다.
    다음 줄에는 M개의 수들이 주어지는데, 이 수들이 A안에 존재하는지 알아내면 된다.
    모든 정수의 범위는 -231 보다 크거나 같고 231보다 작다.

    출력
    M개의 줄에 답을 출력한다. 존재하면 1을, 존재하지 않으면 0을 출력한다.
     */

    @Override
    public void exec() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bufferedReader.readLine());

        int[] nArray = new int[N];

        String nString = bufferedReader.readLine();

        StringTokenizer nstringTokenizer = new StringTokenizer(nString);

        for (int i=0; i<N; i++) {
            int nNumber = Integer.parseInt( nstringTokenizer.nextToken());
            nArray[i] = nNumber;
        }

        Arrays.sort(nArray);

        int M = Integer.parseInt(bufferedReader.readLine());

        String mString = bufferedReader.readLine();

        StringTokenizer mstringTokenizer = new StringTokenizer(mString);

        StringBuilder outputString = new StringBuilder();

        for (int i=0; i<M; i++) {
            int mNumber = Integer.parseInt( mstringTokenizer.nextToken());
            if (binarySearch(nArray, mNumber)>=0){
                outputString.append("1\n");
            } else {
                outputString.append("0\n");
            }
        }

        System.out.println(outputString);

    }


    public static int binarySearch(int[] arr, int value) {

        int firstIndex = 0;
        int lastIndex = arr.length-1;

        while (firstIndex<=lastIndex) {
            int mid = (firstIndex + lastIndex) / 2;

            if (value < arr[mid]) {
                lastIndex = mid-1;
            }

            if (arr[mid] < value) {
                firstIndex = mid+1;
            }

            if (value == arr[mid]) {
                return mid;
            }
        }

        return -1;
    }
}
