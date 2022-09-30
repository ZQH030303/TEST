package TEST;

import java.util.Objects;
import java.util.Scanner;

class Actor{
    private String name;
    private int work_num,kind_num,kind_name_num;
    private String[] work = new String[500];
    private String[] kind = new String[500];
    private String[] kind_name = new String[500];
    public Actor(){
        work_num = 0;
        kind_num = 0;
        kind_name_num = 0;
    }
    public void set(Scanner sc){
        int i;
//        Scanner sc = new Scanner(System.in);
        name = sc.next();
        work_num = sc.nextInt();
        for(i = 0;i < work_num;i++){
            work[i] = sc.next();
        }
        kind_num = sc.nextInt();
        for(i = 0;i < kind_num;i++){
            kind[i] = sc.next();
        }
        kind_name_num = sc.nextInt();
        for(i = 0;i < kind_name_num;i++){
            kind_name[i] = sc.next();
        }
    }
    public boolean judge(String ex_name,String ex_work,String ex_kind,String ex_kind_name){
        if(Objects.equals(ex_name, name)){
            for(int i = 0;i < work_num;i++){
                if(Objects.equals(work[i], ex_work) || Objects.equals(work[i], "*")){
                    for(int j = 0;j < kind_num;j++){
                        if(Objects.equals(kind[j], ex_kind) || Objects.equals(kind[j], "*")){
                            if(kind_name_num == 0){
                                return true;
                            }
                            for(int k = 0;k < kind_name_num;k++){
                                if(Objects.equals(kind_name[k], ex_kind_name)){
                                    return true;
                                }
                            }
                            return false;
                        }
                    }
                    return false;
                }
            }
            return false;
        }
        else{
            return false;
        }
    }
}
class Link{
    private String name;
    private int user_num;
    private String[][] user = new String[2][500];
    public Link(){}
    public void set(Scanner sc){
        int i;
        String flag;
//        Scanner sc = new Scanner(System.in);
        name = sc.next();
        user_num = sc.nextInt();
        for(i = 0;i < user_num;i++){
            flag = sc.next();
            user[0][i] = sc.next();
        }
    }
    public String getName(String user_name){
        int i;
        for(i = 0;i < user_num;i++){
            if(Objects.equals(user_name, user[0][i])){
                return name;
            }
        }
        return "NO_find";
    }
}
/** @author 朱启煌 */
public class Test20220603 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n,m,p;
        n=sc.nextInt();
        m=sc.nextInt();
        p=sc.nextInt();
        int i;
        Actor[] actors = new Actor[n];
        Link[] links = new Link[m];
        for(i = 0;i < n;i++){
            actors[i] = new Actor();
            actors[i].set(sc);
        }
        for(i = 0;i < m;i++){
            links[i] = new Link();
            links[i].set(sc);
        }
        for(i = 0;i < p;i++){
            String name;
            name = sc.next();
            int group_num,flag=0;
            group_num = sc.nextInt();
            String[] group = new String[group_num];
            int j;
            for(j = 0;j < group_num;j++){
                group[j] = sc.next();
            }
            String work,kind,kind_name;
            work = sc.next();
            kind = sc.next();
            kind_name = sc.next();
            out: for(j = 0;j < m;j++){
                String actor_name = links[j].getName(name);
                if(!Objects.equals(actor_name, "NO_find")){
                    for(int k = 0;k < n;k++){
                        if(actors[k].judge(actor_name,work,kind,kind_name)){
                            flag=1;
                            break out;
                        }
                    }
                }
            }
            out2: for(int x = 0;x < group_num;x++) {
                for (j = 0; j < m; j++) {
                    String actor_name = links[j].getName(group[x]);
                    if (!Objects.equals(actor_name, "NO_find")) {
                        for (int k = 0; k < n; k++) {
                            if (actors[k].judge(actor_name, work, kind, kind_name)) {
                                flag=1;
                                break out2;
                            }
                        }
                    }
                }
            }
            System.out.println(flag);
        }
    }
}
