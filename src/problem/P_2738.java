package problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P_2738 implements Problem {

    /*
    문제
    N*M크기의 두 행렬 A와 B가 주어졌을 때, 두 행렬을 더하는 프로그램을 작성하시오.

    입력
    첫째 줄에 행렬의 크기 N 과 M이 주어진다. 둘째 줄부터 N개의 줄에 행렬 A의 원소 M개가 차례대로 주어진다.
    이어서 N개의 줄에 행렬 B의 원소 M개가 차례대로 주어진다. N과 M은 100보다 작거나 같고, 행렬의 원소는 절댓값이 100보다 작거나 같은 정수이다.

    출력
    첫째 줄부터 N개의 줄에 행렬 A와 B를 더한 행렬을 출력한다. 행렬의 각 원소는 공백으로 구분한다.
     */

    @Override
    public void exec() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String inputString = bufferedReader.readLine();

        StringTokenizer nmTokenizer = new StringTokenizer(inputString);
        int row = Integer.parseInt(nmTokenizer.nextToken());
        int column = Integer.parseInt(nmTokenizer.nextToken());

        int[][] firstMatrix = new int[row][column];
        int[][] secondMatrix = new int[row][column];

        for (int i=0; i<row; i++) {
            StringTokenizer elementTokenizer = new StringTokenizer(bufferedReader.readLine());

            for (int j=0; j<column; j++) {
                int element = Integer.parseInt(elementTokenizer.nextToken());
                firstMatrix[i][j] = element;
            }

        }

        for (int i=0; i<row; i++) {
            StringTokenizer elementTokenizer = new StringTokenizer(bufferedReader.readLine());

            for (int j=0; j<column; j++) {
                int element = Integer.parseInt(elementTokenizer.nextToken());
                secondMatrix[i][j] = element;
            }

        }

        addPrintMatrix(firstMatrix, secondMatrix, row, column);

    }

    public static void addPrintMatrix(int[][] firstMatrix, int[][] secondMatrix, int row, int column) {

        for (int i=0; i<row; i++) {
            for (int j=0; j<column; j++) {
                System.out.print((firstMatrix[i][j] + secondMatrix[i][j]) + " ");
            }
            System.out.println();
        }

    }

}
