package TEST;

import java.util.HashMap;
import java.util.Scanner;
class File{
    int kind;
    String name;
    int size;
    int sonNumber;
    int kidNumber;
    int limitSonNumber;
    int limitKidNumber;
    public File(){
        kind = 1;
        name = "//";
        sonNumber = 0;
        kidNumber = 0;
        limitSonNumber = 0;
        limitKidNumber = 0;
        size = 0;
    }
    public File(String str, int k, int s){
        name = str;
        kind = k;
        size = s;
    }
    public void creat(String str, int k, int s){
        name = str;
        kind = k;
        size = s;
    }
}
class FileSystem{
    int kids;
    int limitKids;
    HashMap<String,File> total = new HashMap<>('1');
    public FileSystem(){
        kids = 0;
        limitKids = 0;
    }
    public void createRoot(){
        File f = new File();
        f.creat("/", 1, 0);
        total.put("/",f);
    }
    public String creat(String path1,int size1){
        String[] path = path1.split("/");
        int i,j;
        String t = "/";
        for(i = 0;i < path.length;i++){
            File father = new File();
            father = total.get(t);
            t += "/";
            t += path[i];
            File grandfather = new File();
            String t2 = "/";
            for(j = 0;j < i;j++){
                t2 += "/";
                t2 += path[j];
                grandfather = total.get(t2);
                if(grandfather.kidNumber + size1 >= grandfather.limitKidNumber && grandfather.limitKidNumber != 0){
                    return "N";
                }
            }
            if(!total.containsKey(t)){
                if(i != path.length - 1){
                    if(father.kidNumber + size1 >= father.limitKidNumber && father.limitKidNumber !=0){
                        return "N";
                    }
                    else{
                        File f = new File();
                        f.creat(t,1,0);
                        total.put(t,f);
                        father.kidNumber += size1;
                    }
                }
                else if(i == path.length - 1){
                    if((father.sonNumber + size1 >= father.limitSonNumber && father.limitSonNumber !=0) || (kids + size1 >= limitKids && limitKids != 0)){
                        return "N";
                    }
                    else{
                        File f = new File();
                        f.creat(t,0,size1);
                        total.put(t,f);
                        father.sonNumber += size1;
                        father.kidNumber += size1;
                        kids += size1;
                    }
                }
            }
            else{
                File f = new File();
                f = total.get(t);
                if(i != path.length - 1){
                    if(f.kind == 0){
                        return "N";
                    }
                }
                else if(i == path.length - 1){
                    if(f.kind == 1){
                        return "N";
                    }
                    else{
                        if((father.sonNumber + size1 >= father.limitSonNumber && father.limitSonNumber !=0) || (kids + size1 >= limitKids && limitKids != 0)){
                            return "N";
                        }
                        else{
                            File f2 = new File();
                            f2.creat(t,0,size1);
                            kids -= total.get(t).size;
                            total.replace(t,f2);
                            father.sonNumber += size1;
                            father.kidNumber += size1;
                            kids += size1;
                        }
                    }
                }
            }
        }
        return "Y";
    }
    public String remove(String path1){
        if(!total.containsKey(path1)){
            return "N";
        }
        String[] path = path1.split("/");
        int i,sum = path.length;

        return "Y";
    }
    public String quota(String path1, int size1, int size2){
        return "Y";
    }
}

/** @author 朱启煌 */
public class Test20201203 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        FileSystem fs = new FileSystem();
        fs.createRoot();
        HashMap<String,File> all = new HashMap<>(1);
        while (n-- > 0){
            String order;
            order = sc.next();
            if(order.equals("C")){
                String path = sc.next();
                int size = sc.nextInt();
                System.out.println(fs.creat(path,size));
            }
            else if(order.equals("R")){
                String path = sc.next();
                System.out.println(fs.remove(path));
            }
            else if(order.equals("Q")){
                String path = sc.next();
                int size1 = sc.nextInt();
                int size2 = sc.nextInt();
                System.out.println(fs.quota(path,size1,size2));
            }
            else{
                System.out.println("N");
            }
        }
    }
}
