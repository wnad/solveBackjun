package problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P_1018 implements Problem {

    /*
    문제
    지민이는 자신의 저택에서 MN개의 단위 정사각형으로 나누어져 있는 M×N 크기의 보드를 찾았다.
    어떤 정사각형은 검은색으로 칠해져 있고, 나머지는 흰색으로 칠해져 있다. 지민이는 이 보드를 잘라서 8×8 크기의 체스판으로 만들려고 한다.

    체스판은 검은색과 흰색이 번갈아서 칠해져 있어야 한다.
    구체적으로, 각 칸이 검은색과 흰색 중 하나로 색칠되어 있고, 변을 공유하는 두 개의 사각형은 다른 색으로 칠해져 있어야 한다.
    따라서 이 정의를 따르면 체스판을 색칠하는 경우는 두 가지뿐이다. 하나는 맨 왼쪽 위 칸이 흰색인 경우, 하나는 검은색인 경우이다.

    보드가 체스판처럼 칠해져 있다는 보장이 없어서, 지민이는 8×8 크기의 체스판으로 잘라낸 후에 몇 개의 정사각형을 다시 칠해야겠다고 생각했다.
    당연히 8*8 크기는 아무데서나 골라도 된다. 지민이가 다시 칠해야 하는 정사각형의 최소 개수를 구하는 프로그램을 작성하시오.

    입력
    첫째 줄에 N과 M이 주어진다. N과 M은 8보다 크거나 같고, 50보다 작거나 같은 자연수이다.
    둘째 줄부터 N개의 줄에는 보드의 각 행의 상태가 주어진다. B는 검은색이며, W는 흰색이다.

    출력
    첫째 줄에 지민이가 다시 칠해야 하는 정사각형 개수의 최솟값을 출력한다.
     */

    @Override
    public void exec() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String inputString = bufferedReader.readLine();

        StringTokenizer numberTokenizer = new StringTokenizer(inputString);

        int N = Integer.parseInt(numberTokenizer.nextToken());
        int M = Integer.parseInt(numberTokenizer.nextToken());

        int[][] nmBoard = new int[N][M];

        for (int row=0; row<N; row++) {
            String inputBoard = bufferedReader.readLine();
            for (int column=0; column<M; column++){
                String color = String.valueOf(inputBoard.charAt(column));
                nmBoard[row][column] =  (color.equals("B")) ? 0 : 1;
            }
        }

        minCheck(nmBoard, N, M);
    }

    public static void minCheck(int[][] originBoard, int N, int M) {
        int minCheck = N * M;

        for (int wid=0; wid<N-7; wid++) {
            for (int len=0; len<M-7; len++) {
                int check = countChecker(originBoard, wid, len);
                if (check<minCheck) {
                    minCheck = check;
                }
            }
        }

        System.out.println(minCheck);
    }


    public static int countChecker(int[][] originBoard, int row, int column) {      // 검정, 하양 시작 바꾸는 횟수 비교

        int black = 0;
        int white = 1;

        int blackstart = colorCounter(originBoard, row, column, black);
        int whitestart = colorCounter(originBoard, row, column, white);

        return smallerthan(blackstart, whitestart);
    }

    public static int smallerthan (int numberA, int numberB) {          // 최솟값 구하기
        int min = 0;

        if (numberA==numberB) {
            min = numberA;
        }

        if (numberA < numberB) {
            min = numberA;
        }

        if (numberB < numberA) {
            min = numberB;
        }

        return min;


    }

    public static int colorCounter(int[][] originBoard, int row, int column, int startcolor) {  // 처음 체스판 색깔에 맞게 칠해야하는 개수 세는 함수
        int start = 0;
        int cursor = startcolor;

        for (int i=0; i<8; i++) {
            for (int j=0; j<8; j++) {

                if(i==0 && j==0){
                    if (originBoard[row+i][column+j] != startcolor) start += 1;
                    j++;
                }

                if (originBoard[row+i][column+j] != cursor) {
                    cursor = reverseCheck(cursor);
                    continue;
                }

                if (originBoard[row+i][column+j] == cursor) {
                    cursor = reverseCheck(cursor);
                    start += 1;
                }

            }
            cursor = reverseCheck(cursor);

        }

        return start;

    }

    public static int reverseCheck(int cursor) {        // 체크 바꾸는 함수
        int returnCheck = 0;

        if (cursor == 0)
            returnCheck = 1;

        if (cursor == 1)
            returnCheck = 0;

        return returnCheck;
    }
}
