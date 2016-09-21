package Model;
import handler.HandleChessBoard;
import handler.PointChange;
import interactive.Client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.io.Serializable;
import java.util.*;
import java.util.List;

/**
 * Created by ${Xueyunlong} on 2016/4/12.
 * 画板。在其上绘制棋盘&对话框
 */
public class MyPanel extends JPanel {
    //加载棋盘
    public static ChessBoard chessBoard = new ChessBoard();

    //棋盘控制权
    public static boolean power = true;
    Dimension screenSize =Toolkit.getDefaultToolkit().getScreenSize();
    int WINDOWSWIDTH = (int) screenSize.getWidth();
    int WINDOWSLENGHT = (int) screenSize.getHeight();
    public MyPanel() throws IOException {
        //初始化画板
        initPanel();
    }

    //初始化画板
    public void initPanel(){

        this.setLayout(new GridLayout(1,1));

        chessBoard.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //先判断你是否拥有棋盘控制权
                if(power == true) {
                    //得到点击点的坐标
                    Point point = e.getPoint();
                    System.out.println(point.x + "" + point.y);
                    //在点击点上绘制图片
                    if (point.x >= 30 && point.y >= 30 && point.x<=570 && point.y <= 570) {
                        // 对坐标进行微调
                        point = new ChessPoint().weitiao(point);
                        //绘制白色棋子
                        chessBoard.paintCilcle(chessBoard.getGraphics(), point, 30, 30,2);
                        //对棋盘进行判局，提子
                        java.util.List list = new HandleChessBoard().handleChessBoard(chessBoard);


                        for (Object point1:list) {
                            System.out.println("正在提子");
                            //将要返回的坐标点list转换成绘制图片模块能够识别的绘制坐标点
                            point1 = PointChange.changePoint((Point) point1);
                            //提子的算法已经实现，在控制台已经将结果显示了

                            /*问题：怎么移除已经画在chessboard上的棋子？想着在要提子的坐标上重新绘制一个半径为0的圆，可是原来画过的圆不能消失。。
                            * 要修改的两个地方：移除界面上的棋子，移除存储中棋子
                            *
                            * */
                            chessBoard.paintCilcle(chessBoard.getGraphics(), (Point) point1, 0, 0,0);
                        }
                        try {
                            Client.send(chessBoard);
                            System.out.println("发送数据结束");
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }

                        //将控制权交给对手
                        power = false;
                    }
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        this.add(chessBoard);
    }
}
