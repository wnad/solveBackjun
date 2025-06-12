import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] base;

    static int N, M;

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer nm = new StringTokenizer(br.readLine());

        // 행렬의 크기
        N = Integer.parseInt(nm.nextToken());

        // 행렬의 M 제곱
        M = Integer.parseInt(nm.nextToken());

        base = new int[N][N];

        for (int i=0; i<N; i++) {
            StringTokenizer str = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++) {
                base[i][j] = Integer.parseInt(str.nextToken())%1000;
            }
        }

        br.close();

        int[][] result = powMatrix(M);

        StringBuilder sb = new StringBuilder();

        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {

                sb.append(result[i][j]);
                if (j < N - 1) sb.append(' ');
            }
            if (i < N - 1) sb.append('\n');
        }

        System.out.print(sb);

    }
    // 행렬 제곱 함수
    static int[][] powMatrix(int expo) {

        int[][] result;

        // 지수가 1인 경우 base 를 반환
        if (expo==1) {
            return base;
        }

        // 제곱을 절반으로 나누기
        int[][] temp = powMatrix(expo/2);

        result = multipleMatrix(temp, temp);

        // 지수가 2의 배수가 아니라면
        if (expo%2==1) {
            result = multipleMatrix(result, base);
        }

        return result;
    }


    // 행렬 곱셈 함수
    static int[][] multipleMatrix(int[][] M1, int[][] M2) {

        int[][] M3 = new int[N][N];

        // M3[i][j]
        for (int i=0; i< N; i++) {
            for (int j=0; j<N; j++) {

                for (int k=0; k<N; k++) {

                    // M3[i][j]
                    M3[i][j] += M1[i][k]*M2[k][j];
                    M3[i][j] %= 1000;
                }
            }
        }

        return M3;
    }
}