package Gui;

import Model.MyPanel;
import interactive.Client;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * Created by ${Xueyunlong} on 2016/4/12.
 */
public class MainFrame extends JFrame {
    private JPanel contentPane;//创建面板
    Dimension screenSize =Toolkit.getDefaultToolkit().getScreenSize();
    int WINDOWSWIDTH = (int) screenSize.getWidth();
    int WINDOWSLENGHT = (int) screenSize.getHeight();
        public MainFrame() throws IOException {
            this.setTitle("客户端");//设置标题名字
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//默认退出
            //获取当前屏幕的大小
            System.out.println(screenSize);
            //设置窗体的大小
            //设置窗体的大小
            this.setBounds(WINDOWSWIDTH/6,WINDOWSLENGHT/10, WINDOWSWIDTH/6+390, WINDOWSLENGHT-WINDOWSLENGHT/8);
            //初始化默认面板
            this.contentPane= new JPanel();
            this.contentPane.setBackground(Color.gray);
            //设置布局NULL
            this.contentPane.setLayout(null);

            //创建按钮
            JButton button1,button2,button3,button4,button5,button6;
            button1=new JButton("");
            button1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                }
            });
            button2 = new JButton("");
            button3 = new JButton("");
            button4 = new JButton("");
            button5 = new JButton("");
            button6 = new JButton("");

            this.contentPane.add(button1);
            this.contentPane.add(button2);
            this.contentPane.add(button3);
            this.contentPane.add(button4);
            this.contentPane.add(button5);
            this.contentPane.add(button6);
            button1.setBounds(0,0, this.getWidth()/6,(int) (screenSize.getHeight()/15));
            button2.setBounds(this.getWidth()/6,0, this.getWidth()/6,(int) (screenSize.getHeight()/15));
            button3.setBounds(this.getWidth()/3,0, this.getWidth()/6,(int) (screenSize.getHeight()/15));
            button4.setBounds(this.getWidth()/2,0, this.getWidth()/6,(int) (screenSize.getHeight()/15));
            button5.setBounds(this.getWidth()-this.getWidth()/3,0, this.getWidth()/6,(int) (screenSize.getHeight()/15));
            button6.setBounds(this.getWidth()-this.getWidth()/6,0, this.getWidth()/6,(int) (screenSize.getHeight()/15));
            this.add(this.contentPane);
            this.setVisible(true);

            //初始化棋盘&&对话面板
            MyPanel myPanel;
            myPanel = new MyPanel();
            myPanel.setBackground(Color.LIGHT_GRAY);

            //将棋盘&&对话面板添加到默认面板
            this.contentPane.add(myPanel);
            myPanel.setBounds(0, (int) (screenSize.getHeight()/15),this.getWidth(),this.getHeight()-(int) (screenSize.getHeight()/15));

        }
        public static void main(String[]args) throws IOException {
            MainFrame example=new MainFrame();
            //开始对局
            try {
                Client.link();
                Client.getData();

            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }

    }
