package Model;


import javax.swing.*;
import java.awt.*;
import java.io.Serializable;
import java.util.*;
import java.util.List;

/**
 * Created by ${Xueyunlong} on 2016/4/12.
 */
public class ChessBoard extends JPanel implements Serializable {
    private static final long serialVersionUID = 5120588179366104594L ;
    //棋盘格子宽度（正方形）
    private int width = 30;
    //计数器
    private int count = 1;

    public List<ChessPoint> getChessPoints() {
        return chessPoints;
    }

    public void setChessPoints(List<ChessPoint> chessPoints) {
        this.chessPoints = chessPoints;
    }

    public HashMap<String, ChessPoint> getChessMap() {
        return chessMap;
    }

    public void setChessMap(HashMap<String, ChessPoint> chessMap) {
        this.chessMap = chessMap;
    }

    //棋盘单向格子数量
    private int size;
    //通过列表记录棋盘的所有棋子：棋子的存放顺序，以用来棋子的回退
    public java.util.List<ChessPoint> chessPoints = new ArrayList<>();
    //通过Map记录棋盘状态：各个棋子的位置以及颜色，以用来判断棋盘上的点能否放置棋子
    public HashMap<String ,ChessPoint> chessMap = new HashMap<String ,ChessPoint>();

    public ChessBoard(){
    this.setBackground(Color.LIGHT_GRAY);
    }
    /*
    画线
    * */
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        /*
        * drawLine()，从两个坐标点（x1,y1）（x2,y2）绘制一条直线
        *
        * */
        //画横线
        int x = 0;
        int x1 = 30;
        int y1 = 30;
        int x2 = this.getWidth();
        int y2 = this.getHeight();
        for(;x<=18;x++,y1+=width) {
            g.drawLine(x1, y1, 570, y1);
        }
        //画竖线
        x = 0;
        x1 = 30;
        y1 = 30;
        x2 = this.getWidth();
        y2 = this.getHeight();
        for(;x<=18;x++,x1+=width) {
            g.drawLine(x1,y1,x1,570);
        }   }
    /*绘制棋子
    * */
    public void paintCilcle(Graphics g,Point point,int width,int height, int state) {
        /*
        * state:1 绘制黑色棋子；2 绘制白色棋子
        *
        * */
        if (state == 1) {
            g.setColor(Color.black);
            ChessPoint chessPoint = new ChessPoint();
            chessPoint.setPoint(point);
            chessPoint.setState(1);
            g.fillOval(point.x, point.y, width, height);
        } else if (state == 2) {
            g.setColor(Color.white);
            ChessPoint chessPoint = new ChessPoint();
            chessPoint.setPoint(point);
            chessPoint.setState(2);
            //在list中存放棋子对象
            this.chessPoints.add(chessPoint);
            //在map保存棋盘状态
            this.chessMap.put(point.x + "," + point.y, chessPoint);
            g.fillOval(point.x, point.y, width, height);
        }else if( state == 3){
            //应该显示提示信息：该坐标系不能落子（提子之后的位置不能再落子）
        }else if(state == 0){
            //移除提过的棋子
            g.setColor(Color.white);
            ChessPoint chessPoint = new ChessPoint();
            chessPoint.setPoint(point);
            chessPoint.setState(2);
            //在list中移除棋子对象
            //在chessMap中移除棋子
            this.chessMap.remove(point.x+","+point.y);
            g.fillOval(point.x, point.y, width, height);
        }
    }
}
