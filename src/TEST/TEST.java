package TEST;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


public class TEST {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, m, m1, j;
        n = sc.nextInt();
        m = sc.nextInt();
        m1 = m;
        ArrayList<Element> list = new ArrayList<>();
        sc.nextLine();
        int number2 = 0;
        int notePointNumber = -1;
        for (int k = 0; k < n; k++) {
            String s;
            int pointNumber = 0;
            int number = k + 1;
            s = sc.nextLine();
            for (j = 0; j < s.length(); j++) {
                char ch = s.charAt(j);
                if (ch == '.') {
                    pointNumber++;
                }
            }
            if(pointNumber > notePointNumber){
                number2 += 1;
            }
            else if(pointNumber < notePointNumber){
                number2 -= 200;
            }
            String[] s2 = s.split("\\.");
            String s3 = "";
            for (j = 0; j < s2.length; j++) {
                s3 += s2[j];
            }
            String[] s4 = s3.split(" ");
            String name = s4[0];
            String id = "%";
            name = name.toLowerCase();
            if (s4.length == 2) {
                id = s4[1];
            }
            System.out.println(name + " " + id);
            Element e = new Element(number,number2,pointNumber, name, id);
            list.add(e);
        }
        for (int k = 0; k < list.size(); k++) {
            System.out.println(list.get(k).getName());
        }
        ArrayList<Element> list2 = new ArrayList<>();
        for(int k = 0; k < list.size(); k++){
            Element e = new Element(list.get(k));
            list2.add(e);
        }
        list2.get(2).name = "zqh";
        for (int k = 0; k < list2.size(); k++) {
            list2.get(k).name = "zqh";
        }
        for (int k = 0; k < list2.size(); k++) {
            System.out.println(list2.get(k).getName());
        }
        for (int k = 0; k < list.size(); k++) {
            System.out.println(list.get(k).getName());
        }
    }
}
