package com.web.listener;

import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * @author anyun
 * @date 2017/6/19
 * @time 15:22
 * @description
 */
public class ListenerDemo1 {

    public static void main(String[] args) {
        Frame f = new Frame();
        f.setSize(400, 400);
        f.setVisible(true);

        f.addWindowListener(new WindowListener(){

            public void windowActivated(WindowEvent e) {

            }

            public void windowClosed(WindowEvent e) {

            }

            /**
             * 当window窗体关闭时就会WindowListener这个监听器监听到，
             * 监听器就会调用windowClosing方法处理window窗体关闭时的动作
             */
            public void windowClosing(WindowEvent e) {
                //通过事件对象e来获取事件源对象
                Frame f = (Frame) e.getSource();
                System.out.println(f+"窗体正在关闭");
                f.dispose();
            }

            public void windowDeactivated(WindowEvent e) {

            }

            public void windowDeiconified(WindowEvent e) {

            }

            public void windowIconified(WindowEvent e) {

            }

            public void windowOpened(WindowEvent e) {

            }
        });
    }
}
