package problem;

import java.util.Scanner;

public class P_14681 implements Problem{

    public void exec(){
        Scanner s = new Scanner(System.in);

        int x = s.nextInt();
        int y = s.nextInt();

        if(0<x && 0<y){
            System.out.println(1);
        } else if (x<0 && 0<y) {
            System.out.println(2);
        } else if (x<0 && y<0) {
            System.out.println(3);
        } else if (0<x && y<0) {
            System.out.println(4);
        }
    }


}
