package problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import dataStructure.Queue;

public class P_1966 implements Problem {

    /*
    문제
    여러분도 알다시피 여러분의 프린터 기기는 여러분이 인쇄하고자 하는 문서를 인쇄 명령을 받은 ‘순서대로’, 즉 먼저 요청된 것을 먼저 인쇄한다.
    여러 개의 문서가 쌓인다면 Queue 자료구조에 쌓여서 FIFO - First In First Out - 에 따라 인쇄가 되게 된다.
    하지만 상근이는 새로운 프린터기 내부 소프트웨어를 개발하였는데, 이 프린터기는 다음과 같은 조건에 따라 인쇄를 하게 된다.

    현재 Queue의 가장 앞에 있는 문서의 ‘중요도’를 확인한다.
    나머지 문서들 중 현재 문서보다 중요도가 높은 문서가 하나라도 있다면, 이 문서를 인쇄하지 않고 Queue의 가장 뒤에 재배치 한다.
    그렇지 않다면 바로 인쇄를 한다.
    예를 들어 Queue에 4개의 문서(A B C D)가 있고, 중요도가 2 1 4 3 라면 C를 인쇄하고, 다음으로 D를 인쇄하고 A, B를 인쇄하게 된다.

    여러분이 할 일은, 현재 Queue에 있는 문서의 수와 중요도가 주어졌을 때, 어떤 한 문서가 몇 번째로 인쇄되는지 알아내는 것이다.
    예를 들어 위의 예에서 C문서는 1번째로, A문서는 3번째로 인쇄되게 된다.

    입력
    첫 줄에 테스트케이스의 수가 주어진다. 각 테스트케이스는 두 줄로 이루어져 있다.

    테스트케이스의 첫 번째 줄에는 문서의 개수 N(1 ≤ N ≤ 100)과, 몇 번째로 인쇄되었는지 궁금한 문서가 현재 Queue에서 몇 번째에 놓여 있는지를 나타내는 정수 M(0 ≤ M < N)이 주어진다.
    이때 맨 왼쪽은 0번째라고 하자. 두 번째 줄에는 N개 문서의 중요도가 차례대로 주어진다.
    중요도는 1 이상 9 이하의 정수이고, 중요도가 같은 문서가 여러 개 있을 수도 있다.

    출력
    각 테스트 케이스에 대해 문서가 몇 번째로 인쇄되는지 출력한다.

    예제 입력 1
    3
    1 0
    5
    4 2
    1 2 3 4
    6 0
    1 1 9 1 1 1

    예제 출력 1
    1
    2
    5
     */

    @Override
    public void exec() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        // 1. 테스트 케이스 수 입력
        int testcase = Integer.parseInt(bufferedReader.readLine());


        // 2. 각 테스트 케이스 처리
        for (int i = 0; i < testcase; i++) {
            StringTokenizer nmTokenizer = new StringTokenizer(bufferedReader.readLine());

            // 2-1. 문서의 개수와 찾고자 하는 문서의 번호 입력
            int documentCnt = Integer.parseInt(nmTokenizer.nextToken());
            int findDocument = Integer.parseInt(nmTokenizer.nextToken());

            // 2-2. 각 문서의 중요도 입력
            StringTokenizer queueTokenizer = new StringTokenizer(bufferedReader.readLine());
            int[] priorities = new int[documentCnt];
            for (int j = 0; j < documentCnt; j++) {
                priorities[j] = Integer.parseInt(queueTokenizer.nextToken());
            }

            // 2-3. 몇 번째로 출력되는지 반환하여 출력
            System.out.println(findPrintOrder(documentCnt, findDocument, priorities));
        }
    }

    // 문서의 인쇄 순서를 찾는 메서드
    static int findPrintOrder(int documentCount, int findDocument, int[] priorities) {

        // 1. Queue 자료구조 생성
        Queue<Document> queue = new Queue<>();

        // 2. Queue 에 Document (인덱스, 중요도) 추가
        for (int i=0; i<documentCount; i++) {
            queue.add(new Document(i,priorities[i]));
        }

        // 3. 필요 변수 선언
        int printCnt = 0;   // 출력 횟수
        boolean canPrint;   // 출력 가능 여부


        // 4. queue 가 빌때까지 반복
        while(!queue.isEmpty()) {

            // 5. 가장 앞에 있는 문서 꺼내기
            Document curDoc = queue.poll();
            canPrint = true;


            // 6. queue 에 있는 문서를 보면서 현재 문서보다 높은 중요도를 가진 문서가 있으면 출력불가
            for (Document doc : queue) {
                if(doc.priority > curDoc.priority) {
                    canPrint = false;
                    break;
                }
            }


            // 7-1. 출력할 수 없으면 queue 의 가장 뒤로 문서를 추가
            if (!canPrint) {
                queue.add(curDoc);
            }

            // 7-2. 출력할 수 있으면 현재 문서를 출력
            if (canPrint) {
                printCnt++;

                // 8. 현재 문서의 인덱스와 찾고 있는 문서가 같다면 출력 횟수 반환
                if (curDoc.index == findDocument) {
                    return printCnt;
                }
            }

        }

        return -1; // 예외 처리
    }


    // 문서 구조 클래스
    static class Document {
        int index; // 문서의 인덱스
        int priority; // 문서의 중요도

        public Document(int index, int priority) {
            this.index = index;
            this.priority = priority;
        }
    }
}