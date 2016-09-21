package test;

import javax.swing.*;
import java.awt.*;
public class Example7_4 extends JFrame{
    public static void main(String args[]){
        GraphicsDemo myGraphicsFrame = new GraphicsDemo();
    }
}
class ShapesPanel extends JPanel{
    public void SharpesPanel(){
        setBackground(Color.white);
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        setBackground(Color.yellow); //背景色为黄色
        g.setXORMode(Color.red); //设置XOR绘图模式,颜色为红色
        g.setColor(Color.green);
        g.fillRect(20, 20, 80, 40); //实际颜色是green + yellow的混合色=灰色
        g.setColor(Color.yellow);
        g.fillRect(60, 20, 80, 40); //后一半是yellow+yellow=read,前一半是yellow+灰色
        g.setColor(Color.green);
        g.fillRect(20, 70, 80, 40); //实际颜色是green+yellow的混合色=灰色.
        g.fillRect(60, 70, 80, 40);
        //前一半是(green+yellow)+gray =背景色,后一半是green+yellow = gray
        g.setColor(Color.green);
        g.drawLine(80, 100, 180, 200); //该直线是green+yellow = gray
        g.drawLine(100, 100, 200, 200); //同上
 /*再绘制部分重叠的直线.原直线中间段是灰色+灰色=背景色,延长部分是green+yellow=gray.*/
        g.drawLine(140, 140, 220, 220);
        g.setColor(Color.yellow); //分析下列直线颜色变化,与早先的力有重叠
        g.drawLine(20, 30, 160, 30);
        g.drawLine(20, 75, 160, 75);
    }
}
class GraphicsDemo extends JFrame{
    public GraphicsDemo(){
        this.getContentPane().add(new ShapesPanel());
        /*this.setTile("基本绘图方法演示");*/
        setSize(300, 300);
        setVisible(true);
    }
}