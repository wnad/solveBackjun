package problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P_10813 implements Problem{

    /*
    문제
    도현이는 바구니를 총 N개 가지고 있고, 각각의 바구니에는 1번부터 N번까지 번호가 매겨져 있다.
    바구니에는 공이 1개씩 들어있고, 처음에는 바구니에 적혀있는 번호와 같은 번호가 적힌 공이 들어있다.
    도현이는 앞으로 M번 공을 바꾸려고 한다.
    도현이는 공을 바꿀 바구니 2개를 선택하고, 두 바구니에 들어있는 공을 서로 교환한다.
    공을 어떻게 바꿀지가 주어졌을 때,
    M번 공을 바꾼 이후에 각 바구니에 어떤 공이 들어있는지 구하는 프로그램을 작성하시오.

    입력
    첫째 줄에 N (1 ≤ N ≤ 100)과 M (1 ≤ M ≤ 100)이 주어진다.
    둘째 줄부터 M개의 줄에 걸쳐서 공을 교환할 방법이 주어진다.
    각 방법은 두 정수 i j로 이루어져 있으며,
    i번 바구니와 j번 바구니에 들어있는 공을 교환한다는 뜻이다. (1 ≤ i ≤ j ≤ N)
    도현이는 입력으로 주어진 순서대로 공을 교환한다.

    출력
    1번 바구니부터 N번 바구니에 들어있는 공의 번호를 공백으로 구분해 출력한다.
     */

    public void exec() throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        String NM = br.readLine();

        StringTokenizer st = new StringTokenizer(NM);
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] basket = new int[N];

        for (int i = 0; i<N; i++){
            basket[i] = (i+1);
        }

        for (int i = 0; i<M; i++){

            StringTokenizer str = new StringTokenizer(br.readLine());

            int BI = Integer.parseInt(str.nextToken())-1;
            int BJ = Integer.parseInt(str.nextToken())-1;

            int tempi = basket[BI];
            int tempj = basket[BJ];

            basket[BI] = tempj;
            basket[BJ] = tempi;

        }

        for (int c = 0; c<N; c++){
            System.out.print(basket[c] + " ");
        }
    }
}
