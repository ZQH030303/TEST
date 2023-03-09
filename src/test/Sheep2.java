package test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

/** @author 朱启煌 */
class Place2{
    int newX;
    int newY;
    int empty;
    Place2(){
        newX = 0;
        newY = 600;
        empty = 0;
    }
}
public class Sheep2 extends JFrame {
    JFrame jFrame = new JFrame("羊了个羊");
    JButton[] btn = new JButton[72];
    JButton removeFunction = new JButton("上移");
    JButton repealFunction = new JButton("撤销");
    JButton disorganizeFunction = new JButton("打乱");
    int[] btnKind = new int[72];
    int[] btnCondition = new int[72];
    Place2[] p = new Place2[7];
    Icon[] icons = new Icon[8];
    final int[] x0 = {0};
    final int[] x0Num = {-1,-1,-1};
    final int[] x1 = {0};
    final int[] x1Num = {-1,-1,-1};
    final int[] x2 = {0};
    final int[] x2Num = {-1,-1,-1};
    final int[] x3 = {0};
    final int[] x3Num = {-1,-1,-1};
    final int[] x4 = {0};
    final int[] x4Num = {-1,-1,-1};
    final int[] x5 = {0};
    final int[] x5Num = {-1,-1,-1};
    final int[] x6 = {0};
    final int[] x6Num = {-1,-1,-1};
    final int[] x7 = {0};
    final int[] x7Num = {-1,-1,-1};
    final int[] sum = {0};
    int nowNumber;
    int nowX;
    int nowY;
    void setIcons(){
        icons[0] = new ImageIcon("D:\\TEST\\imgs\\brush.png");
        icons[1] = new ImageIcon("D:\\TEST\\imgs\\carrot.png");
        icons[2] = new ImageIcon("D:\\TEST\\imgs\\corn.png");
        icons[3] = new ImageIcon("D:\\TEST\\imgs\\fire.png");
        icons[4] = new ImageIcon("D:\\TEST\\imgs\\fork.png");
        icons[5] = new ImageIcon("D:\\TEST\\imgs\\grass.png");
        icons[6] = new ImageIcon("D:\\TEST\\imgs\\milk.png");
        icons[7] = new ImageIcon("D:\\TEST\\imgs\\shear.png");
//        icons[8] = new ImageIcon("D:\\TEST\\imgs\\straw.png");
    }
    void remove(){
        sum[0] --;
        sum[0] --;
        sum[0] --;
        int flag = -1;
        out :for(int j = 0; j < 7; j++){
            if(p[j].empty == 1){
                for(int i = 0; i < 72; i++){
                    if(p[j].newX == btn[i].getX() && p[j].newY == btn[i].getY()){
                        p[j].empty = 0;
                        flag = i;
                        break out;
                    }
                }
            }
        }
        if(flag != -1){
            btn[flag].setBounds(120,500,60,60);
            btnCondition[flag] = 0;
            if(btnKind[flag] == 0){
                x0[0]--;
            }
            if(btnKind[flag] == 1){
                x1[0]--;
            }
            if(btnKind[flag] == 2){
                x2[0]--;
            }
            if(btnKind[flag] == 3){
                x3[0]--;
            }
            if(btnKind[flag] == 4){
                x4[0]--;
            }
            if(btnKind[flag] == 5){
                x5[0]--;
            }
            if(btnKind[flag] == 6){
                x6[0]--;
            }
            if(btnKind[flag] == 7){
                x7[0]--;
            }
        }
        flag = -1;
        out2 :for(int j = 0; j < 7; j++){
            if(p[j].empty == 1){
                for(int i = 0; i < 72; i++){
                    if(p[j].newX == btn[i].getX() && p[j].newY == btn[i].getY()){
                        p[j].empty = 0;
                        flag = i;
                        break out2;
                    }
                }
            }
        }
        if(flag != -1){
            btn[flag].setBounds(185,500,60,60);
            btnCondition[flag] = 0;
            if(btnKind[flag] == 0){
                x0[0]--;
            }
            if(btnKind[flag] == 1){
                x1[0]--;
            }
            if(btnKind[flag] == 2){
                x2[0]--;
            }
            if(btnKind[flag] == 3){
                x3[0]--;
            }
            if(btnKind[flag] == 4){
                x4[0]--;
            }
            if(btnKind[flag] == 5){
                x5[0]--;
            }
            if(btnKind[flag] == 6){
                x6[0]--;
            }
            if(btnKind[flag] == 7){
                x7[0]--;
            }
        }
        flag = -1;
        out3 :for(int j = 0; j < 7; j++){
            if(p[j].empty == 1){
                for(int i = 0; i < 72; i++){
                    if(p[j].newX == btn[i].getX() && p[j].newY == btn[i].getY()){
                        p[j].empty = 0;
                        flag = i;
                        break out3;
                    }
                }
            }
        }
        if(flag != -1){
            btn[flag].setBounds(250,500,60,60);
            btnCondition[flag] = 0;
            if(btnKind[flag] == 0){
                x0[0]--;
            }
            if(btnKind[flag] == 1){
                x1[0]--;
            }
            if(btnKind[flag] == 2){
                x2[0]--;
            }
            if(btnKind[flag] == 3){
                x3[0]--;
            }
            if(btnKind[flag] == 4){
                x4[0]--;
            }
            if(btnKind[flag] == 5){
                x5[0]--;
            }
            if(btnKind[flag] == 6){
                x6[0]--;
            }
            if(btnKind[flag] == 7){
                x7[0]--;
            }
        }
    }
    void disorganize(){
        Random random = new Random();
        for (int i = 71; i >= 0; i--) {
            int p1 = random.nextInt(i + 1);
            int p2 = i;
            JButton btnT = btn[p1];
            btn[p1] = btn[p2];
            btn[p2] = btnT;

            int btnKindT = btnKind[p1];
            btnKind[p1] = btnKind[p2];
            btnKind[p2] = btnKindT;

            int btnConditionT = btnCondition[p1];
            btnCondition[p1] = btnCondition[p2];
            btnCondition[p2] = btnConditionT;
        }
    }
    void arrange(){
        int i = 0;
        int x = 20,y = 30;
        while(i < 24){
            if(btnCondition[i] != 1){
                btn[i].setBounds(x,y,60,60);
                jFrame.getLayeredPane().add(btn[i],new Integer(Integer.MIN_VALUE+4));
                if(x == 370){
                    x = 20;
                    y += 80;
                }
                else{
                    x += 70;
                }
            }
            i++;
        }
        x = 20;
        y = 20;
        while(i < 48){
            if(btnCondition[i] != 1){
                btn[i].setBounds(x,y,60,60);
                jFrame.getLayeredPane().add(btn[i],new Integer(Integer.MIN_VALUE+3));
                if(x == 370){
                    x = 20;
                    y += 80;
                }
                else{
                    x += 70;
                }
            }
            i++;
        }
        x = 20;
        y = 10;
        while(i < 72){
            if(btnCondition[i] != 1){
                btn[i].setBounds(x,y,60,60);
                jFrame.getLayeredPane().add(btn[i],new Integer(Integer.MIN_VALUE+2));
                if(x == 370){
                    x = 20;
                    y += 80;
                }
                else{
                    x += 70;
                }
            }
            i++;
        }
    }
    void arrange2(){
        int x = 185;
        int y = 10;
        int floor = 1;
        int now = 0;
        for(floor = 1; floor <= 7; floor++){
            int t = x;
            for(int i = now; i < floor + now; i++){
                if(btnCondition[i] != 1) {
                    btn[i].setBounds(x,y,60,60);
                    x += 60;
                }
            }
            x = t - 30;
            y += 60;
            now = floor + now;
        }
        x = 185;
        y = 10;
        now = 28;
        for(floor = 1; floor <= 7; floor++){
            int t = x;
            for(int i = now; i < floor + now; i++){
                if(btnCondition[i] != 1) {
                    btn[i].setBounds(x,y,60,60);
                    x += 60;
                }
            }
            x = t - 30;
            y += 60;
            now = floor + now;
        }
        int i = 56;
        while(i < 64){
            if(btnCondition[i] != 1){
                btn[i].setBounds(60,10,60,60);
            }
            i++;
        }
        while(i < 72){
            if(btnCondition[i] != 1){
                btn[i].setBounds(320,10,60,60);
            }
            i++;
        }
    }
    public Sheep2() {
        //生成草地背景
        ImageIcon bg = new ImageIcon("D:\\TEST\\imgs\\grassBackground.png");
        JLabel la = new JLabel(bg);
        la.setSize(bg.getIconWidth(),bg.getIconHeight());
        jFrame.getLayeredPane().add(la,new Integer(Integer.MIN_VALUE));

        //设置窗口大小
        jFrame.setBounds(500, 10, 465, 800);
        jFrame.setLocationRelativeTo(null);
        JPanel pane = (JPanel) jFrame.getContentPane();
        pane.setOpaque(false);
        pane.setLayout(null);

        //生成收纳槽背景和功能（最多收纳7张牌）
        JLabel groove = new JLabel();
        Icon icon = new ImageIcon("D:\\TEST\\imgs\\grooveBackground.png");
        groove.setIcon(icon);
        pane.add(groove);
        groove.setBounds(10,558,440,150);
        jFrame.getLayeredPane().add(groove,new Integer(Integer.MIN_VALUE+1));
        for(int i = 0; i < 7; i++){
            p[i] = new Place2();
            p[i].newX = 58*i+25;
            p[i].newY = 600;
            p[i].empty = 0;
        }

//        JButton removeFunction = new JButton();
//        JButton repealFunction = new JButton();
//        JButton disorganizeFunction = new JButton();


        //设置图片并打乱图片数组
        setIcons();
        Random random = new Random();
        for (int i = 7; i >= 0; i--) {
            int p1 = random.nextInt(i + 1);
            int p2 = i;
            Icon iconT = icons[p1];
            icons[p1] = icons[p2];
            icons[p2] = iconT;

        }

        //把8个图片分给72个按钮
        for (int i = 0; i < 9; i++) {
            btn[i] = new JButton();
            btn[i].setContentAreaFilled(false);
            btn[i].setIcon(icons[0]);
            btnKind[i] = 0;
            btnCondition[i] = 0;
            pane.add(btn[i]);
        }
        for (int i = 9; i < 18; i++) {
            btn[i] = new JButton();
            btn[i].setContentAreaFilled(false);
            btn[i].setIcon(icons[1]);
            btnKind[i] = 1;
            btnCondition[i] = 0;
            pane.add(btn[i]);
        }
        for (int i = 18; i < 27; i++) {
            btn[i] = new JButton();
            btn[i].setContentAreaFilled(false);
            btn[i].setIcon(icons[2]);
            btnKind[i] = 2;
            btnCondition[i] = 0;
            pane.add(btn[i]);
        }
        for (int i = 27; i < 36; i++) {
            btn[i] = new JButton();
            btn[i].setContentAreaFilled(false);
            btn[i].setIcon(icons[3]);
            btnKind[i] = 3;
            btnCondition[i] = 0;
            pane.add(btn[i]);
        }
        for (int i = 36; i < 45; i++) {
            btn[i] = new JButton();
            btn[i].setContentAreaFilled(false);
            btn[i].setIcon(icons[4]);
            btnKind[i] = 4;
            btnCondition[i] = 0;
            pane.add(btn[i]);
        }
        for (int i = 45; i < 54; i++) {
            btn[i] = new JButton();
            btn[i].setContentAreaFilled(false);
            btn[i].setIcon(icons[5]);
            btnKind[i] = 5;
            btnCondition[i] = 0;
            pane.add(btn[i]);
        }
        for (int i = 54; i < 63; i++) {
            btn[i] = new JButton();
            btn[i].setContentAreaFilled(false);
            btn[i].setIcon(icons[6]);
            btnKind[i] = 6;
            btnCondition[i] = 0;
            pane.add(btn[i]);
        }
        for (int i = 63; i < 72; i++) {
            btn[i] = new JButton();
            btn[i].setContentAreaFilled(false);
            btn[i].setIcon(icons[7]);
            btnKind[i] = 7;
            btnCondition[i] = 0;
            pane.add(btn[i]);
        }
//        for (int i = 72; i < 81; i++) {
//            btn[i] = new JButton();
//            btn[i].setContentAreaFilled(false);
//            btn[i].setIcon(icons[8]);
//            pane.add(btn[i]);
//        }

        //打乱81个按钮
        disorganize();

        //排列81个按钮位置
        arrange2();

        int width = icons[0].getIconWidth();
        int height = icons[0].getIconHeight();
        for (int z = 0; z < 72; z++) {
            int finalI = z;
            btn[z].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    int newX = 0;
                    int flag = 1;
                    for(int i = 0; i < 7; i++){
                        if(p[i].empty == 0){
                            newX = p[i].newX;
                            p[i].empty = 1;
                            flag = 0;
                            break;
                        }
                    }
                    if(flag == 1){
                        int n = JOptionPane.showConfirmDialog(Sheep2.this,"很遗憾，槽位已满，你需要复活吗","提示",JOptionPane.YES_NO_OPTION);
                        if(n == JOptionPane.YES_OPTION) {
                            remove();
                        }
                        else{
                            System.exit(0);
                        }
                    }
                    else{
                        nowNumber = finalI;
                        nowX = btn[finalI].getX();
                        nowY = btn[finalI].getY();
                        btn[finalI].setBounds(newX,600,width,60);
                        btnCondition[finalI] = 1;
                        if(btnKind[finalI] == 0){
                            x0Num[x0[0]] = finalI;
                            x0[0]++;
                            if(x0[0] == 3){
                                x0[0] = 0;
                                for(int i = 0; i < 3; i++){
                                    for(int j = 0; j < 7; j++){
                                        if(p[j].newX == btn[x0Num[i]].getX()){
                                            p[j].empty = 0;
                                            break;
                                        }
                                    }
                                    btn[x0Num[i]].setBounds(1000,1000,60,60);
                                }
                            }
                            sum[0]++;
                            if(sum[0] == 72){
                                JOptionPane.showMessageDialog(Sheep2.this, "恭喜你成功过关");
                            }
                        }
                        if(btnKind[finalI] == 1){
                            x1Num[x1[0]] = finalI;
                            x1[0]++;
                            if(x1[0] == 3){
                                x1[0] = 0;
                                for(int i = 0; i < 3; i++){
                                    for(int j = 0; j < 7; j++){
                                        if(p[j].newX == btn[x1Num[i]].getX()){
                                            p[j].empty = 0;
                                            break;
                                        }
                                    }
                                    btn[x1Num[i]].setBounds(1000,1000,60,60);
                                }
                            }
                            sum[0]++;
                            if(sum[0] == 72){
                                JOptionPane.showMessageDialog(Sheep2.this, "恭喜你成功过关");
                            }
                        }
                        if(btnKind[finalI] == 2){
                            x2Num[x2[0]] = finalI;
                            x2[0]++;
                            if(x2[0] == 3){
                                x2[0] = 0;
                                for(int i = 0; i < 3; i++){
                                    for(int j = 0; j < 7; j++){
                                        if(p[j].newX == btn[x2Num[i]].getX()){
                                            p[j].empty = 0;
                                            break;
                                        }
                                    }
                                    btn[x2Num[i]].setBounds(1000,1000,60,60);
                                }
                            }
                            sum[0]++;
                            if(sum[0] == 72){
                                JOptionPane.showMessageDialog(Sheep2.this, "恭喜你成功过关");
                            }
                        }
                        if(btnKind[finalI] == 3){
                            x3Num[x3[0]] = finalI;
                            x3[0]++;
                            if(x3[0] == 3){
                                x3[0] = 0;
                                for(int i = 0; i < 3; i++){
                                    for(int j = 0; j < 7; j++){
                                        if(p[j].newX == btn[x3Num[i]].getX()){
                                            p[j].empty = 0;
                                            break;
                                        }
                                    }
                                    btn[x3Num[i]].setBounds(1000,1000,60,60);
                                }
                            }
                            sum[0]++;
                            if(sum[0] == 72){
                                JOptionPane.showMessageDialog(Sheep2.this, "恭喜你成功过关");
                            }
                        }
                        if(btnKind[finalI] == 4){
                            x4Num[x4[0]] = finalI;
                            x4[0]++;
                            if(x4[0] == 3){
                                x4[0] = 0;
                                for(int i = 0; i < 3; i++){
                                    for(int j = 0; j < 7; j++){
                                        if(p[j].newX == btn[x4Num[i]].getX()){
                                            p[j].empty = 0;
                                            break;
                                        }
                                    }
                                    btn[x4Num[i]].setBounds(1000,1000,60,60);
                                }
                            }
                            sum[0]++;
                            if(sum[0] == 72){
                                JOptionPane.showMessageDialog(Sheep2.this, "恭喜你成功过关");
                            }
                        }
                        if(btnKind[finalI] == 5){
                            x5Num[x5[0]] = finalI;
                            x5[0]++;
                            if(x5[0] == 3){
                                x5[0] = 0;
                                for(int i = 0; i < 3; i++){
                                    for(int j = 0; j < 7; j++){
                                        if(p[j].newX == btn[x5Num[i]].getX()){
                                            p[j].empty = 0;
                                            break;
                                        }
                                    }
                                    btn[x5Num[i]].setBounds(1000,1000,60,60);
                                }
                            }
                            sum[0]++;
                            if(sum[0] == 72){
                                JOptionPane.showMessageDialog(Sheep2.this, "恭喜你成功过关");
                            }
                        }
                        if(btnKind[finalI] == 6){
                            x6Num[x6[0]] = finalI;
                            x6[0]++;
                            if(x6[0] == 3){
                                x6[0] = 0;
                                for(int i = 0; i < 3; i++){
                                    for(int j = 0; j < 7; j++){
                                        if(p[j].newX == btn[x6Num[i]].getX()){
                                            p[j].empty = 0;
                                            break;
                                        }
                                    }
                                    btn[x6Num[i]].setBounds(1000,1000,60,60);
                                }
                            }
                            sum[0]++;
                            if(sum[0] == 72){
                                JOptionPane.showMessageDialog(Sheep2.this, "恭喜你成功过关");
                            }
                        }
                        if(btnKind[finalI] == 7){
                            x7Num[x7[0]] = finalI;
                            x7[0]++;
                            if(x7[0] == 3){
                                x7[0] = 0;
                                for(int i = 0; i < 3; i++){
                                    for(int j = 0; j < 7; j++){
                                        if(p[j].newX == btn[x7Num[i]].getX()){
                                            p[j].empty = 0;
                                            break;
                                        }
                                    }
                                    btn[x7Num[i]].setBounds(1000,1000,60,60);
                                }
                            }
                            sum[0]++;
                            if(sum[0] == 72){
                                JOptionPane.showMessageDialog(Sheep2.this, "恭喜你成功过关");
                            }
                        }
                    }
                }
            });
        }

        pane.add(removeFunction);
        removeFunction.setBounds(10,700,60,60);
        pane.add(repealFunction);
        repealFunction.setBounds(185,700,60,60);
        pane.add(disorganizeFunction);
        disorganizeFunction.setBounds(360,700,60,60);
        //上移
        removeFunction.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                remove();
            }
        });
        //撤销
        repealFunction.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sum[0]--;
                for(int j = 0; j < 7; j++){
                    if(p[j].newX == btn[nowNumber].getX()){
                        p[j].empty = 0;
                        break;
                    }
                }
                btn[nowNumber].setBounds(nowX,nowY,60,60);
                btnCondition[nowNumber] = 0;
                if(btnKind[nowNumber] == 0){
                    x0[0]--;
                }
                if(btnKind[nowNumber] == 1){
                    x1[0]--;
                }
                if(btnKind[nowNumber] == 2){
                    x2[0]--;
                }
                if(btnKind[nowNumber] == 3){
                    x3[0]--;
                }
                if(btnKind[nowNumber] == 4){
                    x4[0]--;
                }
                if(btnKind[nowNumber] == 5){
                    x5[0]--;
                }
                if(btnKind[nowNumber] == 6){
                    x6[0]--;
                }
                if(btnKind[nowNumber] == 7){
                    x7[0]--;
                }
            }
        });
        //打乱
        disorganizeFunction.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                disorganize();
                arrange();
            }
        });

        jFrame.setVisible(true);
        jFrame.setResizable(true);
    }

    public static void main(String[] args) {
        new Sheep2();
    }
}
