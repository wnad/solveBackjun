package problem;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P_10814 implements Problem {

    /*

문제
온라인 저지에 가입한 사람들의 나이와 이름이 가입한 순서대로 주어진다.
이때, 회원들을 나이가 증가하는 순으로, 나이가 같으면 먼저 가입한 사람이 앞에 오는 순서로 정렬하는 프로그램을 작성하시오.

입력
첫째 줄에 온라인 저지 회원의 수 N이 주어진다. (1 ≤ N ≤ 100,000)

둘째 줄부터 N개의 줄에는 각 회원의 나이와 이름이 공백으로 구분되어 주어진다.
나이는 1보다 크거나 같으며, 200보다 작거나 같은 정수이고,
이름은 알파벳 대소문자로 이루어져 있고, 길이가 100보다 작거나 같은 문자열이다. 입력은 가입한 순서로 주어진다.

출력
첫째 줄부터 총 N개의 줄에 걸쳐 온라인 저지 회원을 나이 순, 나이가 같으면 가입한 순으로 한 줄에 한 명씩 나이와 이름을 공백으로 구분해 출력한다.

예제 입력 1
3
21 Junkyu
21 Dohyun
20 Sunyoung

예제 출력 1
20 Sunyoung
21 Junkyu
21 Dohyun

     */

    @Override
    public void exec() throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        // 1. 회원 수 입력
        int userAmount = Integer.parseInt(bufferedReader.readLine());


        // 2. 회원 리스트 저장
        List<Person> userList = new ArrayList<>();
        for (int i=0; i<userAmount; i++) {
            StringTokenizer info = new StringTokenizer(bufferedReader.readLine());
            userList.add(new Person(Integer.parseInt(info.nextToken()), info.nextToken()));
        }

        bufferedReader.close();

        // 3. 회원 리스트 나이순으로 정렬
        Collections.sort(userList);


        // 4. 정렬된 회원을 출력
        StringBuilder output = new StringBuilder();
        for (Person user : userList) {
            output.append(user);
        }
        System.out.println(output);


    }

    static class Person implements Comparable<Person>{
        int age;        // 나이
        String name;    // 이름

        public Person(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        public String toString(){
            return age+" "+name+"\n";
        }

        @Override
        public int compareTo(Person other) {
            return this.age - other.age;
        }
    }
}
