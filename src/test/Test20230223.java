package test;

import java.util.ArrayList;

/** @author 朱启煌 */
public class Test20230223 {
    public static void main(String[] args) {
        ArrayList<String> list1 = new ArrayList<>();
        list1.add("关羽");
        list1.add("张飞");
        list1.add("赵云");
        list1.add("马超");
        list1.add("黄忠");
        list1.add("关平");
        list1.add("张星彩");
        list1.add("关兴");
        list1.add("张苞");

        ArrayList<String> list2 = new ArrayList<>();
        for (String name : list1) {
            if(name.startsWith("张")){
                list2.add(name);
            }
        }
        System.out.println(list2);
        int[] arr = {1,2,3,4,5};


        try {
            System.out.println(2/0);
            System.out.println(arr[10]);
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("索引越界");
        }

        System.out.println("看看我执行了吗");
    }
}
