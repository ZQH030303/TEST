package test;

import java.util.ArrayList;
import java.util.Scanner;
class Element{
    int number;
    int number2;
    int pointNumber;
    String name;
    String id;
    Element(){
        number = 0;
        number2 = 0;
        pointNumber = 0;
        name = "%";
        id = "%";
    }
    Element(int n,int n2,int p,String na,String i){
        number = n;
        number2 = n2;
        pointNumber = p;
        name = na;
        id = i;
    }
    Element(Element e){
        this.number = e.number;
        this.number2 = e.number2;
        this.pointNumber = e.pointNumber;
        this.name = e.name;
        this.id = e.id;
    }
    int getNumber(){
        return number;
    }
    int getNumber2(){
        return number2;
    }
    int getPointNumber(){
        return pointNumber;
    }
    String getName(){
        return name;
    }
    String getId(){
        return id;
    }
    boolean checkName(String na){
        if(na.equals(name)){
            return true;
        }
        return false;
    }
    boolean checkId(String i){
        if(i.equals(id)){
            return true;
        }
        return false;
    }
}
/** @author 朱启煌 */
public class Test20180903 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n,m,m1,j;
        n = sc.nextInt();
        m = sc.nextInt();
        m1 = m;
        ArrayList<Element> list = new ArrayList<>();
        sc.nextLine();
        int number2 = 0;
        int notePointNumber = -1;
        for(int k = 0; k < n;k++){
            String s;
            int pointNumber = 0;
            int number = k + 1;
            s = sc.nextLine();
            for(j = 0;j < s.length();j++){
                char ch = s.charAt(j);
                if(ch == '.'){
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
            for(j = 0; j < s2.length; j++){
                s3 +=s2[j];
            }
            String[] s4 = s3.split(" ");
            String name = s4[0];
            String id = "%";
            name = name.toLowerCase();
            if(s4.length == 2){
                id = s4[1];
            }
            Element e = new Element(number,number2,pointNumber,name,id);
            list.add(e);
        }
        while(m1-- > 0){
            String o;
            o = sc.nextLine();
            int sum = 0,li = 0;
            int[] line = new int[n];
            String[] o2 = o.split(" ");
            if(o2.length == 1){
                int place = o2[0].indexOf("#");
                if(place == -1){
                    o2[0] = o2[0].toLowerCase();
                    for(int k = 0;k < list.size(); k++){
                        Element e = list.get(k);
                        if(e.checkName(o2[0])){
                            sum++;
                            line[li] = e.number;
                            li++;
                        }
                    }
                }
                else{
                    for(int k = 0;k < list.size(); k++){
                        Element e = list.get(k);
                        if(e.checkId(o2[0])){
                            sum++;
                            line[li] = e.number;
                            li++;
                        }
                    }
                }
            }
            else{
                ArrayList<Element> list2 = new ArrayList<>();
                for(int k = 0; k < list.size(); k++){
                    Element e = new Element(list.get(k));
                    list2.add(e);
                }
                int[] flag = new int[o2.length-1];
                for(int p = 0;p < o2.length-1; p++){
                    flag[p] = 0;
                }
                int start = -1;
                int point = -1;
                int point2 = -1;
                for(int p = 0; p < o2.length-1; p++){
                    int place = o2[p].indexOf("#");
                    if(place == -1){
                        o2[p] = o2[p].toLowerCase();
                        out1:for(int k = start+1;k < list2.size(); k++){
                            Element e = list2.get(k);
                            if(e.checkName(o2[p]) && (list2.get(k).pointNumber > point) && (list2.get(k).number2 > point2)){
                                flag[p] = 1;
                                list2.get(k).name = "%";
                                start = k;
                                point = list2.get(k).pointNumber;
                                point2 = list2.get(k).number2;
                                break out1;
                            }
                        }
                    }
                    else{
                        out2:for(int k = start+1;k < list2.size(); k++){
                            Element e = list2.get(k);
                            if(e.checkId(o2[p]) && (list2.get(k).pointNumber > point) && (list2.get(k).number2 > point2)){
                                flag[p] = 1;
                                list2.get(k).id = "%";
                                start = k;
                                point = list2.get(k).pointNumber;
                                point2 = list2.get(k).number2;
                                break out2;
                            }
                        }
                    }
                }
                int result = 1;
                for(int p = 0;p < o2.length-1; p++){
                    if(flag[p] == 0){
                        result = 0;
                    }
                }
                if(result == 0){
                    sum = 0;
                }
                else{
                    int place = o2[o2.length-1].indexOf("#");
                    if(place == -1){
                        o2[o2.length-1] = o2[o2.length-1].toLowerCase();
                        for(int k = start+1;k < list2.size(); k++){
                            Element e = list2.get(k);
                            if(e.checkName(o2[o2.length-1])  && (list2.get(k).pointNumber > point) && (list2.get(k).number2 > point2)){
                                sum++;
                                line[li] = e.number;
                                li++;
                            }
                        }
                    }
                    else{
                        for(int k = start+1;k < list2.size(); k++){
                            Element e = list2.get(k);
                            if(e.checkId(o2[o2.length-1])  && (list2.get(k).pointNumber > point) && (list2.get(k).number2 > point2)){
                                sum++;
                                line[li] = e.number;
                                li++;
                            }
                        }
                    }
                }
            }
            System.out.print(sum + " ");
            for(li = 0; li < sum; li++){
                System.out.print(line[li]);
                if(li != sum-1){
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
