package Model;

import java.awt.*;
import java.io.Serializable;

/**
 * Created by ${Xueyunlong} on 2016/4/15.
 */
public class ChessPoint implements Serializable {
    //棋子坐标
    private Point point;
    //棋子状态:0 null ;1 black;2 white
    private int state;

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }


    /*
    对坐标进行微调
    * */
    public Point weitiao(Point point){
        if(point.x%30>=15)
            point.x = point.x-point.x%30 +30-15;
        else
            point.x = point.x-point.x%30-15;
        if(point.y%30>=15)
            point.y = point.y-point.y%30 +30-15;
        else
            point.y = point.y-point.y%30-15;
        return point;

    }


}
