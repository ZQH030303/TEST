package test;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class TEST extends JFrame {
    public TEST() {
        setBounds(100, 100, 500, 300);// 设置窗体的位置及大小
        setDefaultCloseOperation(EXIT_ON_CLOSE);// 设置窗体的关闭方式

        Container c = getContentPane();// 获取窗体容器
        c.setLayout(new GridLayout(3, 2, 5, 5));// 设置布局为网格布局，三行两列，水平间距为5，垂直间距也为5

        JButton btn[] = new JButton[6];
        for (int i = 0; i < btn.length; i++) {
            btn[i] = new JButton();
            c.add(btn[i]);
        }

        btn[0].setText("不可点击");// 设置按钮文本
        btn[0].setEnabled(false);// 设置按钮为不可用

        btn[1].setText("有背景色");// 设置按钮文本
        btn[1].setBackground(Color.GREEN);// 设置按钮背景颜色

        btn[2].setText("没有边框");// 设置按钮文本
        btn[2].setBorderPainted(false);// 设值按钮无边框

        btn[3].setText("自定义边框");// 设置按钮文本
        btn[3].setBorder(BorderFactory.createLineBorder(Color.RED, 5));// 设置边框颜色和粗细

        Icon icon = new ImageIcon("images/Background.png");// 获取图片对象
        btn[4].setIcon(icon);// 设置按钮图片
        btn[4].setToolTipText("中国·绵阳·越王楼");// 鼠标悬停提示

        btn[5].setText("可触发事件");// 设置按钮文本
        btn[5].addActionListener(new ActionListener() {// (添加事件监听)添加一个ActionListener的匿名内部类
            public void actionPerformed(ActionEvent e) {// 监听出发的方法
                JOptionPane.showMessageDialog(TEST.this, "当前按钮已经被点击"); // 弹出一个小对话框
            }
        });

        setVisible(true);// 设置窗体为可见
    }

    public static void main(String[] args) {

        new TEST();

    }

}