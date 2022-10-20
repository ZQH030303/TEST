package test2;


import java.util.LinkedList;
import java.util.Scanner;

/** @author 朱启煌 */
public class Experiment01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int i;
        LinkedList<Integer> list = new LinkedList<>();
        for(i = 1; i <= n; i++){
            list.add(i);
        }
        while(m-- > 0){
            int number,order,place = 0;
            number = sc.nextInt();
            order = sc.nextInt();
            for(i = 0; i < list.size(); i++){
                if(number == list.get(i)){
                    place = i;
                    list.remove(i);
                }
            }
            list.add(place+order,number);
        }
        for(i = 0; i < list.size(); i++){
            System.out.print(list.get(i));
            if(i != n-1){
                System.out.print(" ");
            }
        }
    }
}
