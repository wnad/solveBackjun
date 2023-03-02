package problem;

import java.io.*;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P_10811 implements Problem{

    /*
    문제
    도현이는 바구니를 총 N개 가지고 있고, 각각의 바구니에는 1번부터 N번까지 번호가 순서대로 적혀져 있다.
    바구니는 일렬로 놓여져 있고, 가장 왼쪽 바구니를 1번째 바구니, 그 다음 바구니를 2번째 바구니, ...,
    가장 오른쪽 바구니를 N번째 바구니라고 부른다.
    도현이는 앞으로 M번 바구니의 순서를 역순으로 만들려고 한다. 도현이는 한 번 순서를 역순으로 바꿀 때,
    순서를 역순으로 만들 범위를 정하고, 그 범위에 들어있는 바구니의 순서를 역순으로 만든다.
    바구니의 순서를 어떻게 바꿀지 주어졌을 때, M번 바구니의 순서를 역순으로 만든 다음,
    바구니에 적혀있는 번호를 가장 왼쪽 바구니부터 출력하는 프로그램을 작성하시오.

    입력
    첫째 줄에 N (1 ≤ N ≤ 100)과 M (1 ≤ M ≤ 100)이 주어진다.
    둘째 줄부터 M개의 줄에는 바구니의 순서를 역순으로 만드는 방법이 주어진다.
    방법은 i j로 나타내고,
    왼쪽으로부터 i번째 바구니부터 j번째 바구니의 순서를 역순으로 만든다는 뜻이다. (1 ≤ i ≤ j ≤ N)
    도현이는 입력으로 주어진 순서대로 바구니의 순서를 바꾼다.

    출력
    모든 순서를 바꾼 다음에, 가장 왼쪽에 있는 바구니부터 바구니에 적혀있는 순서를 공백으로 구분해 출력한다.
     */

    public void exec() throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer nmTokenizer = new StringTokenizer(bufferedReader.readLine());
        int basketNumber = Integer.parseInt(nmTokenizer.nextToken());
        int basketInverseNumber = Integer.parseInt(nmTokenizer.nextToken());

        int[] basket = new int[basketNumber];

        initialBasket(basket);

        for (int count = 0; count<basketInverseNumber; count++) {

            StringTokenizer flTokenizer = new StringTokenizer(bufferedReader.readLine());
            int firstBasketNumber = Integer.parseInt(flTokenizer.nextToken());
            int lastBasketNumber = Integer.parseInt(flTokenizer.nextToken());

            int[] dupBasket = duplicateBasket(basket, firstBasketNumber, lastBasketNumber);
            int[] invBasket = inverseBasket(dupBasket);

            copyBasket(basket, invBasket, firstBasketNumber, lastBasketNumber);

        }

        printBasket(basket);

    }


    public void initialBasket (int[] basket) {
        for (int i=0; i<basket.length; i++) {
            basket[i] = i+1;
        }
    }

    public int[] duplicateBasket (int[] basket, int first ,int last) {
        int basketLength = last - first + 1;
        int duplicatedBasket[] = new int[basketLength];

        for (int dupPointer = 0; dupPointer<basketLength; dupPointer++) {
            duplicatedBasket[dupPointer] = basket[dupPointer + first - 1];
        }

        return duplicatedBasket;
    }

    public int[] inverseBasket (int[] basket) {
        int basketLength = basket.length;
        int inversedBasket[] = new int[basketLength];

        for (int invPointer = 0; invPointer<basketLength; invPointer++) {
            inversedBasket[invPointer] = basket[basketLength-1-invPointer];
        }

        return inversedBasket;
    }

    public void copyBasket (int[] basket, int[] toCopyBasket, int first ,int last) {
        int basketLength = last - first + 1;

        for (int copyPointer = 0; copyPointer<basketLength; copyPointer++) {
            basket[copyPointer+first-1] = toCopyBasket[copyPointer];
        }

    }

    public static void printBasket(int[] basket) throws IOException{

        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int basketLength = basket.length;

        for (int i =0; i<basketLength; i++) {
            bufferedWriter.write(basket[i]+" ");
        }

        bufferedWriter.flush();
        bufferedWriter.close();
    }


}
