package test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

/** @author 朱启煌 */
class Place{
    int newX;
    int empty;
    Place(){
        newX = 0;
        empty = 0;
    }
    void set(int n,int e){
        newX = n;
        empty = e;
    }
}
public class Sheep extends JFrame {
    public Sheep() {
        JFrame jFrame = new JFrame("羊了个羊");

        ImageIcon bg = new ImageIcon("D:\\TEST\\imgs\\grassBackground.png");
        JLabel la = new JLabel(bg);
        la.setSize(bg.getIconWidth(),bg.getIconHeight());
        jFrame.getLayeredPane().add(la,new Integer(Integer.MIN_VALUE));

        jFrame.setBounds(500, 10, 465, 800);
        jFrame.setLocationRelativeTo(null);
        JPanel pane = (JPanel) jFrame.getContentPane();
        pane.setOpaque(false);
        pane.setLayout(null);

        JLabel groove = new JLabel();
        Icon icon = new ImageIcon("D:\\TEST\\imgs\\grooveBackground.png");
        groove.setIcon(icon);
        pane.add(groove);
        groove.setBounds(10,558,440,150);
        jFrame.getLayeredPane().add(groove,new Integer(Integer.MIN_VALUE+1));

        JButton[] btn = new JButton[18];
        Icon[] icons = new Icon[3];
        Icon[] icons2 = new Icon[3];
        icons[0] = new ImageIcon("D:\\TEST\\imgs\\grass.png");
        icons[1] = new ImageIcon("D:\\TEST\\imgs\\corn.png");
        icons[2] = new ImageIcon("D:\\TEST\\imgs\\carrot.png");
        icons2[0] = new ImageIcon("D:\\TEST\\imgs\\grass2.png");
        icons2[1] = new ImageIcon("D:\\TEST\\imgs\\corn2.png");
        icons2[2] = new ImageIcon("D:\\TEST\\imgs\\carrot2.png");
        Random random = new Random();
        for (int i = 2; i >= 0; i--) {
            int p1 = random.nextInt(i + 1);
            int p2 = i;
            Icon iconT = icons[p1];
            icons[p1] = icons[p2];
            icons[p2] = iconT;

            iconT = icons2[p1];
            icons2[p1] = icons2[p2];
            icons2[p2] = iconT;
        }

        for (int i = 0; i < 6; i++) {
            btn[i] = new JButton();
            btn[i].setContentAreaFilled(false);
            btn[i].setIcon(icons[0]);
            pane.add(btn[i]);
        }
        for (int i = 6; i < 12; i++) {
            btn[i] = new JButton();
            btn[i].setContentAreaFilled(false);
            btn[i].setIcon(icons[1]);
            pane.add(btn[i]);
        }
        for (int i = 12; i < 18; i++) {
            btn[i] = new JButton();
            btn[i].setContentAreaFilled(false);
            btn[i].setIcon(icons[2]);
            pane.add(btn[i]);
        }
        JLabel[] label = new JLabel[9];
        for (int i = 0; i < 3; i++) {
            label[i] = new JLabel("小草");
            label[i].setIcon(icons2[0]);
            pane.add(label[i]);
        }
        for (int i = 3; i < 5; i++) {
            label[i] = new JLabel("玉米");
            label[i].setIcon(icons2[1]);
            pane.add(label[i]);
        }
        for (int i = 5; i < 9; i++) {
            label[i] = new JLabel("萝卜");
            label[i].setIcon(icons2[2]);
            pane.add(label[i]);
        }
//        btn[12].setBounds(90,20,60,60);
//        btn[6].setBounds(210,20,60,60);
//        btn[13].setBounds(330,20,60,60);
//        btn[14].setBounds(90,160,60,60);
//        btn[3].setBounds(210,160,60,60);
//        btn[7].setBounds(330,160,60,60);
//        btn[4].setBounds(90,300,60,60);
//        btn[17].setBounds(210,300,60,60);
//        btn[5].setBounds(330,300,60,60);
        int width = icons[0].getIconWidth();
        int height = icons[0].getIconHeight();
        label[5].setBounds(90,31,60,60);
        label[3].setBounds(210,31,60,60);
        label[6].setBounds(330,31,60,60);
        btn[0].setBounds(90,60,width,height);
        btn[10].setBounds(210,60,width,height);
        btn[2].setBounds(330,60,width,height);

        label[7].setBounds(90,171,60,60);
        label[0].setBounds(210,171,60,60);
        label[4].setBounds(330,171,60,60);
        btn[8].setBounds(90,200,width,height);
        btn[15].setBounds(210,200,width,height);
        btn[16].setBounds(330,200,width,height);

//        label[1].setText("-----");
//        label[8].setText("-----");
//        label[2].setText("-----");
        label[1].setBounds(90,334,60,height);
        label[8].setBounds(210,334,60,height);
        label[2].setBounds(330,334,60,height);
        btn[9].setBounds(90,340,width,height);
        btn[1].setBounds(210,340,width,height);
        btn[11].setBounds(330,340,width,height);
        final int[] x = {0};
        final int[] xNum = {-1,-1,-1};
        final int[] y = {0};
        final int[] yNum = {-1,-1,-1};
        final int[] z = {0};
        final int[] zNum = {-1,-1,-1};
        final int[] sum = {0};
        Place[] p = new Place[7];
        for(int i = 0; i < 7; i++){
            p[i] = new Place();
            p[i].newX = 58*i+25;
            p[i].empty = 0;
        }
        btn[0].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int newX = 0;
                for(int i = 0; i < 7; i++){
                    if(p[i].empty == 0){
                        newX = p[i].newX;
                        p[i].empty = 1;
                        break;
                    }
                }
                btn[0].setBounds(newX,600,width,60);
                jFrame.remove(label[5]);
                btn[12].setBounds(90,20,width,height);
                xNum[x[0]] = 0;
                x[0]++;
                if(x[0] == 3){
                    x[0] = 0;
                    for(int i = 0; i < 3; i++){
                        for(int j = 0; j < 7; j++){
                            if(p[j].newX == btn[xNum[i]].getX()){
                                p[j].empty = 0;
                                break;
                            }
                        }
                        btn[xNum[i]].setBounds(1000,1000,60,60);
//                        jFrame.remove(btn[xNum[i]]);
                    }
                }
                sum[0]++;
                if(sum[0] == 18){
                    JOptionPane.showMessageDialog(Sheep.this, "恭喜你成功过关");
                }
            }
        });
        btn[1].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int newX = 0;
                for(int i = 0; i < 7; i++){
                    if(p[i].empty == 0){
                        newX = p[i].newX;
                        p[i].empty = 1;
                        break;
                    }
                }
                btn[1].setBounds(newX,600,width,60);
                jFrame.remove(label[8]);
                btn[17].setBounds(210,300,width,height);
                xNum[x[0]] = 1;
                x[0]++;
                if(x[0] == 3){
                    x[0] = 0;
                    for(int i = 0; i < 3; i++){
                        for(int j = 0; j < 7; j++){
                            if(p[j].newX == btn[xNum[i]].getX()){
                                p[j].empty = 0;
                                break;
                            }
                        }
                        btn[xNum[i]].setBounds(1000,1000,60,60);
//                        jFrame.remove(btn[xNum[i]]);
                    }
                }
                sum[0]++;
                if(sum[0] == 18){
                    JOptionPane.showMessageDialog(Sheep.this, "恭喜你成功过关");
                }
            }
        });
        btn[2].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int newX = 0;
                for(int i = 0; i < 7; i++){
                    if(p[i].empty == 0){
                        newX = p[i].newX;
                        p[i].empty = 1;
                        break;
                    }
                }
                btn[2].setBounds(newX,600,width,60);
                jFrame.remove(label[6]);
                btn[13].setBounds(330,20,width,height);
                xNum[x[0]] = 2;
                x[0]++;
                if(x[0] == 3){
                    x[0] = 0;
                    for(int i = 0; i < 3; i++){
                        for(int j = 0; j < 7; j++){
                            if(p[j].newX == btn[xNum[i]].getX()){
                                p[j].empty = 0;
                                break;
                            }
                        }
                        btn[xNum[i]].setBounds(1000,1000,60,60);
//                        jFrame.remove(btn[xNum[i]]);
                    }
                }
                sum[0]++;
                if(sum[0] == 18){
                    JOptionPane.showMessageDialog(Sheep.this, "恭喜你成功过关");
                }
            }
        });
        btn[3].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int newX = 0;
                for(int i = 0; i < 7; i++){
                    if(p[i].empty == 0){
                        newX = p[i].newX;
                        p[i].empty = 1;
                        break;
                    }
                }
                btn[3].setBounds(newX,600,width,60);
                xNum[x[0]] = 3;
                x[0]++;
                if(x[0] == 3){
                    x[0] = 0;
                    for(int i = 0; i < 3; i++){
                        for(int j = 0; j < 7; j++){
                            if(p[j].newX == btn[xNum[i]].getX()){
                                p[j].empty = 0;
                                break;
                            }
                        }
                        btn[xNum[i]].setBounds(1000,1000,60,60);
//                        jFrame.remove(btn[xNum[i]]);
                    }
                }
                sum[0]++;
                if(sum[0] == 18){
                    JOptionPane.showMessageDialog(Sheep.this, "恭喜你成功过关");
                }
            }
        });
        btn[4].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int newX = 0;
                for(int i = 0; i < 7; i++){
                    if(p[i].empty == 0){
                        newX = p[i].newX;
                        p[i].empty = 1;
                        break;
                    }
                }
                btn[4].setBounds(newX,600,width,60);
                xNum[x[0]] = 4;
                x[0]++;
                if(x[0] == 3){
                    x[0] = 0;
                    for(int i = 0; i < 3; i++){
                        for(int j = 0; j < 7; j++){
                            if(p[j].newX == btn[xNum[i]].getX()){
                                p[j].empty = 0;
                                break;
                            }
                        }
                        btn[xNum[i]].setBounds(1000,1000,60,60);
//                        jFrame.remove(btn[xNum[i]]);
                    }
                }
                sum[0]++;
                if(sum[0] == 18){
                    JOptionPane.showMessageDialog(Sheep.this, "恭喜你成功过关");
                }
            }
        });
        btn[5].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int newX = 0;
                for(int i = 0; i < 7; i++){
                    if(p[i].empty == 0){
                        newX = p[i].newX;
                        p[i].empty = 1;
                        break;
                    }
                }
                btn[5].setBounds(newX,600,width,60);
                xNum[x[0]] = 5;
                x[0]++;
                if(x[0] == 3){
                    x[0] = 0;
                    for(int i = 0; i < 3; i++){
                        for(int j = 0; j < 7; j++){
                            if(p[j].newX == btn[xNum[i]].getX()){
                                p[j].empty = 0;
                                break;
                            }
                        }
                        btn[xNum[i]].setBounds(1000,1000,60,60);
//                        jFrame.remove(btn[xNum[i]]);
                    }
                }
                sum[0]++;
                if(sum[0] == 18){
                    JOptionPane.showMessageDialog(Sheep.this, "恭喜你成功过关");
                }
            }
        });
        btn[6].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int newX = 0;
                for(int i = 0; i < 7; i++){
                    if(p[i].empty == 0){
                        newX = p[i].newX;
                        p[i].empty = 1;
                        break;
                    }
                }
                btn[6].setBounds(newX,600,width,60);
                yNum[y[0]] = 6;
                y[0]++;
                if(y[0] == 3){
                    y[0] = 0;
                    for(int i = 0; i < 3; i++){
                        for(int j = 0; j < 7; j++){
                            if(p[j].newX == btn[yNum[i]].getX()){
                                p[j].empty = 0;
                                break;
                            }
                        }
                        btn[yNum[i]].setBounds(1000,1000,60,60);
//                        jFrame.remove(btn[yNum[i]]);
                    }
                }
                sum[0]++;
                if(sum[0] == 18){
                    JOptionPane.showMessageDialog(Sheep.this, "恭喜你成功过关");
                }
            }
        });
        btn[7].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int newX = 0;
                for(int i = 0; i < 7; i++){
                    if(p[i].empty == 0){
                        newX = p[i].newX;
                        p[i].empty = 1;
                        break;
                    }
                }
                btn[7].setBounds(newX,600,width,60);
                yNum[y[0]] = 7;
                y[0]++;
                if(y[0] == 3){
                    y[0] = 0;
                    for(int i = 0; i < 3; i++){
                        for(int j = 0; j < 7; j++){
                            if(p[j].newX == btn[yNum[i]].getX()){
                                p[j].empty = 0;
                                break;
                            }
                        }
                        btn[yNum[i]].setBounds(1000,1000,60,60);
//                        jFrame.remove(btn[yNum[i]]);
                    }
                }
                sum[0]++;
                if(sum[0] == 18){
                    JOptionPane.showMessageDialog(Sheep.this, "恭喜你成功过关");
                }
            }
        });
        btn[8].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int newX = 0;
                for(int i = 0; i < 7; i++){
                    if(p[i].empty == 0){
                        newX = p[i].newX;
                        p[i].empty = 1;
                        break;
                    }
                }
                btn[8].setBounds(newX,600,width,60);
                jFrame.remove(label[7]);
                btn[14].setBounds(90,160,width,height);
                yNum[y[0]] = 8;
                y[0]++;
                if(y[0] == 3){
                    y[0] = 0;
                    for(int i = 0; i < 3; i++){
                        for(int j = 0; j < 7; j++){
                            if(p[j].newX == btn[yNum[i]].getX()){
                                p[j].empty = 0;
                                break;
                            }
                        }
                        btn[yNum[i]].setBounds(1000,1000,60,60);
//                        jFrame.remove(btn[yNum[i]]);
                    }
                }
                sum[0]++;
                if(sum[0] == 18){
                    JOptionPane.showMessageDialog(Sheep.this, "恭喜你成功过关");
                }
            }
        });
        btn[9].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int newX = 0;
                for(int i = 0; i < 7; i++){
                    if(p[i].empty == 0){
                        newX = p[i].newX;
                        p[i].empty = 1;
                        break;
                    }
                }
                btn[9].setBounds(newX,600,width,60);
                jFrame.remove(label[1]);
                btn[4].setBounds(90,300,width,height);
                yNum[y[0]] = 9;
                y[0]++;
                if(y[0] == 3){
                    y[0] = 0;
                    for(int i = 0; i < 3; i++){
                        for(int j = 0; j < 7; j++){
                            if(p[j].newX == btn[yNum[i]].getX()){
                                p[j].empty = 0;
                                break;
                            }
                        }
                        btn[yNum[i]].setBounds(1000,1000,60,60);
//                        jFrame.remove(btn[yNum[i]]);
                    }
                }
                sum[0]++;
                if(sum[0] == 18){
                    JOptionPane.showMessageDialog(Sheep.this, "恭喜你成功过关");
                }
            }
        });
        btn[10].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int newX = 0;
                for(int i = 0; i < 7; i++){
                    if(p[i].empty == 0){
                        newX = p[i].newX;
                        p[i].empty = 1;
                        break;
                    }
                }
                btn[10].setBounds(newX,600,width,60);
                jFrame.remove(label[3]);
                btn[6].setBounds(210,20,width,height);
                yNum[y[0]] = 10;
                y[0]++;
                if(y[0] == 3){
                    y[0] = 0;
                    for(int i = 0; i < 3; i++){
                        for(int j = 0; j < 7; j++){
                            if(p[j].newX == btn[yNum[i]].getX()){
                                p[j].empty = 0;
                                break;
                            }
                        }
                        btn[yNum[i]].setBounds(1000,1000,60,60);
//                        jFrame.remove(btn[yNum[i]]);
                    }
                }
                sum[0]++;
                if(sum[0] == 18){
                    JOptionPane.showMessageDialog(Sheep.this, "恭喜你成功过关");
                }
            }
        });
        btn[11].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int newX = 0;
                for(int i = 0; i < 7; i++){
                    if(p[i].empty == 0){
                        newX = p[i].newX;
                        p[i].empty = 1;
                        break;
                    }
                }
                btn[11].setBounds(newX,600,width,60);
                jFrame.remove(label[2]);
                btn[5].setBounds(330,300,width,height);
                yNum[y[0]] = 11;
                y[0]++;
                if(y[0] == 3){
                    y[0] = 0;
                    for(int i = 0; i < 3; i++){
                        for(int j = 0; j < 7; j++){
                            if(p[j].newX == btn[yNum[i]].getX()){
                                p[j].empty = 0;
                                break;
                            }
                        }
                        btn[yNum[i]].setBounds(1000,1000,60,60);
//                        jFrame.remove(btn[yNum[i]]);
                    }
                }
                sum[0]++;
                if(sum[0] == 18){
                    JOptionPane.showMessageDialog(Sheep.this, "恭喜你成功过关");
                }
            }
        });
        btn[12].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int newX = 0;
                for(int i = 0; i < 7; i++){
                    if(p[i].empty == 0){
                        newX = p[i].newX;
                        p[i].empty = 1;
                        break;
                    }
                }
                btn[12].setBounds(newX,600,width,60);
                zNum[z[0]] = 12;
                z[0]++;
                if(z[0] == 3){
                    z[0] = 0;
                    for(int i = 0; i < 3; i++){
                        for(int j = 0; j < 7; j++){
                            if(p[j].newX == btn[zNum[i]].getX()){
                                p[j].empty = 0;
                                break;
                            }
                        }
                        btn[zNum[i]].setBounds(1000,1000,60,60);
//                        jFrame.remove(btn[zNum[i]]);
                    }
                }
                sum[0]++;
                if(sum[0] == 18){
                    JOptionPane.showMessageDialog(Sheep.this, "恭喜你成功过关");
                }
            }
        });
        btn[13].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int newX = 0;
                for(int i = 0; i < 7; i++){
                    if(p[i].empty == 0){
                        newX = p[i].newX;
                        p[i].empty = 1;
                        break;
                    }
                }
                btn[13].setBounds(newX,600,width,60);
                zNum[z[0]] = 13;
                z[0]++;
                if(z[0] == 3){
                    z[0] = 0;
                    for(int i = 0; i < 3; i++){
                        for(int j = 0; j < 7; j++){
                            if(p[j].newX == btn[zNum[i]].getX()){
                                p[j].empty = 0;
                                break;
                            }
                        }
                        btn[zNum[i]].setBounds(1000,1000,60,60);
//                        jFrame.remove(btn[zNum[i]]);
                    }
                }
                sum[0]++;
                if(sum[0] == 18){
                    JOptionPane.showMessageDialog(Sheep.this, "恭喜你成功过关");
                }
            }
        });
        btn[14].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int newX = 0;
                for(int i = 0; i < 7; i++){
                    if(p[i].empty == 0){
                        newX = p[i].newX;
                        p[i].empty = 1;
                        break;
                    }
                }
                btn[14].setBounds(newX,600,width,60);
                zNum[z[0]] = 14;
                z[0]++;
                if(z[0] == 3){
                    z[0] = 0;
                    for(int i = 0; i < 3; i++){
                        for(int j = 0; j < 7; j++){
                            if(p[j].newX == btn[zNum[i]].getX()){
                                p[j].empty = 0;
                                break;
                            }
                        }
                        btn[zNum[i]].setBounds(1000,1000,60,60);
//                        jFrame.remove(btn[zNum[i]]);
                    }
                }
                sum[0]++;
                if(sum[0] == 18){
                    JOptionPane.showMessageDialog(Sheep.this, "恭喜你成功过关");
                }
            }
        });
        btn[15].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int newX = 0;
                for(int i = 0; i < 7; i++){
                    if(p[i].empty == 0){
                        newX = p[i].newX;
                        p[i].empty = 1;
                        break;
                    }
                }
                btn[15].setBounds(newX,600,width,60);
                jFrame.remove(label[0]);
                btn[3].setBounds(210,160,width,height);
                zNum[z[0]] = 15;
                z[0]++;
                if(z[0] == 3){
                    z[0] = 0;
                    for(int i = 0; i < 3; i++){
                        for(int j = 0; j < 7; j++){
                            if(p[j].newX == btn[zNum[i]].getX()){
                                p[j].empty = 0;
                                break;
                            }
                        }
                        btn[zNum[i]].setBounds(1000,1000,60,60);
//                        jFrame.remove(btn[zNum[i]]);
                    }
                }
                sum[0]++;
                if(sum[0] == 18){
                    JOptionPane.showMessageDialog(Sheep.this, "恭喜你成功过关");
                }
            }
        });
        btn[16].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int newX = 0;
                for(int i = 0; i < 7; i++){
                    if(p[i].empty == 0){
                        newX = p[i].newX;
                        p[i].empty = 1;
                        break;
                    }
                }
                btn[16].setBounds(newX,600,width,60);
                jFrame.remove(label[4]);
                btn[7].setBounds(330,160,width,height);
                zNum[z[0]] = 16;
                z[0]++;
                if(z[0] == 3){
                    z[0] = 0;
                    for(int i = 0; i < 3; i++){
                        for(int j = 0; j < 7; j++){
                            if(p[j].newX == btn[zNum[i]].getX()){
                                p[j].empty = 0;
                                break;
                            }
                        }
                        btn[zNum[i]].setBounds(1000,1000,60,60);
//                        jFrame.remove(btn[zNum[i]]);
                    }
                }
                sum[0]++;
                if(sum[0] == 18){
                    JOptionPane.showMessageDialog(Sheep.this, "恭喜你成功过关");
                }
            }
        });
        btn[17].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int newX = 0;
                for(int i = 0; i < 7; i++){
                    if(p[i].empty == 0){
                        newX = p[i].newX;
                        p[i].empty = 1;
                        break;
                    }
                }
                btn[17].setBounds(newX,600,width,60);
                zNum[z[0]] = 17;
                z[0]++;
                if(z[0] == 3){
                    z[0] = 0;
                    for(int i = 0; i < 3; i++){
                        for(int j = 0; j < 7; j++){
                            if(p[j].newX == btn[zNum[i]].getX()){
                                p[j].empty = 0;
                                break;
                            }
                        }
                        btn[zNum[i]].setBounds(1000,1000,60,60);
//                        jFrame.remove(btn[zNum[i]]);
                    }
                }
                sum[0]++;
                if(sum[0] == 18){
                    JOptionPane.showMessageDialog(Sheep.this, "恭喜你成功过关");
                }
            }
        });
//        Sheep s = new Sheep();
        jFrame.setVisible(true);
        jFrame.setResizable(true);
    }

    public static void main(String[] args) {
        new Sheep();
    }
}
