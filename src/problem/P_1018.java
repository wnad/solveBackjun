package problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
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

    public static List<String> input = List.of(
            "8 8\n" + "WBWBWBWB\n" + "BWBWBWBW\n" + "WBWBWBWB\n" + "BWBBBWBW\n" + "WBWBWBWB\n" + "BWBWBWBW\n" + "WBWBWBWB\n" + "BWBWBWBW",
            "10 13\n" + "BBBBBBBBWBWBW\n" + "BBBBBBBBBWBWB\n" + "BBBBBBBBWBWBW\n" + "BBBBBBBBBWBWB\n" + "BBBBBBBBWBWBW\n" + "BBBBBBBBBWBWB\n" + "BBBBBBBBWBWBW\n" + "BBBBBBBBBWBWB\n" + "WWWWWWWWWWBWB\n" + "WWWWWWWWWWBWB",
            "8 8\n" + "BWBWBWBW\n" + "WBWBWBWB\n" + "BWBWBWBW\n" + "WBWBWBWB\n" + "BWBWBWBW\n" + "WBWBWBWB\n" + "BWBWBWBW\n" + "WBWBWBWB",
            "9 23\n" + "BBBBBBBBBBBBBBBBBBBBBBB\n" + "BBBBBBBBBBBBBBBBBBBBBBB\n" + "BBBBBBBBBBBBBBBBBBBBBBB\n" + "BBBBBBBBBBBBBBBBBBBBBBB\n" + "BBBBBBBBBBBBBBBBBBBBBBB\n" + "BBBBBBBBBBBBBBBBBBBBBBB\n" + "BBBBBBBBBBBBBBBBBBBBBBB\n" + "BBBBBBBBBBBBBBBBBBBBBBB\n" + "BBBBBBBBBBBBBBBBBBBBBBW",
            "10 10\n" + "BBBBBBBBBB\n" + "BBWBWBWBWB\n" + "BWBWBWBWBB\n" + "BBWBWBWBWB\n" + "BWBWBWBWBB\n" + "BBWBWBWBWB\n" + "BWBWBWBWBB\n" + "BBWBWBWBWB\n" + "BWBWBWBWBB\n" + "BBBBBBBBBB",
            "8 8\n" + "WBWBWBWB\n" + "BWBWBWBW\n" + "WBWBWBWB\n" + "BWBBBWBW\n" + "WBWBWBWB\n" + "BWBWBWBW\n" + "WBWBWWWB\n" + "BWBWBWBW",
            "11 12\n" + "BWWBWWBWWBWW\n" + "BWWBWBBWWBWW\n" + "WBWWBWBBWWBW\n" + "BWWBWBBWWBWW\n" + "WBWWBWBBWWBW\n" + "BWWBWBBWWBWW\n" + "WBWWBWBBWWBW\n" + "BWWBWBWWWBWW\n" + "WBWWBWBBWWBW\n" + "BWWBWBBWWBWW\n" + "WBWWBWBBWWBW"
            );
    public static List<String> output = List.of(
            "1", "12", "0", "31", "0", "2", "15");

    @Override
    public void exec() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer NM = new StringTokenizer(br.readLine());

        // N x M 크기의 보드
        int N = Integer.parseInt(NM.nextToken());
        int M = Integer.parseInt(NM.nextToken());

        boolean[][] board = new boolean[N][M];

        String readRow;

        // 보드판 칠하기
        for (int row=0; row<N; row++) {
            readRow = br.readLine();
            for (int col=0; col<M; col++) {
                // 흑(false) 백(true)
                board[row][col] = readRow.charAt(col)=='W';
            }
        }

        // 최소 교환 개수는 최대인 64개(8x8)로 설정
        int min = 64;

        // 8x8 체크판을 돌면서 계산
        for (int row=0; row<=N-8; row++) {
            for (int col=0; col<=M-8; col++) {
                min = Math.min(min, getCheckerCount(board, row, col));
            }
        }

        System.out.print(min);
    }

    // 시작 좌표에서 8x8 보드 최솟값 반환
    private static int getCheckerCount(boolean[][] board, int row, int col) {

        int first = 0, second = 0;
        boolean isSameStart, color;

        for (int i=row; i<row+8; i++) {
            for (int j=col; j<col+8; j++) {
                // (i+j)가 짝수면 첫칸과 동일, 홀수면 첫칸과 반대
                isSameStart = (i+j)%2 == 0;
                color = board[i][j];

                // 흑-백 체스판은 서로 반대여서 색 구분없이 계산
                if (color == isSameStart) {
                    first++;
                } else {
                    second++;
                }
            }
        }

        // 둘 중 작은 값 반환
        return Math.min(first, second);
    }
}
