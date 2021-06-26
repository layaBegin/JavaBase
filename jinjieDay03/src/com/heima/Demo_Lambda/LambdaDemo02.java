package com.heima.Demo_Lambda;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class LambdaDemo02 {
    public static void main(String[] args) {
        JFrame win = new JFrame("我是窗口");
        JButton btn = new JButton("我是大按钮");
        win.add(btn);
        /*btn.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showConfirmDialog(win,"点击成功");
            }
        });*/
       /* btn.addActionListener((e)-> {
                JOptionPane.showConfirmDialog(win,"点击成功");

        });
*/
        btn.addActionListener( e -> JOptionPane.showConfirmDialog(win,"点击成功"));

        win.setSize(500,300);
        win.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        win.setLocationRelativeTo(null);
        win.setVisible(true);
    }
}
