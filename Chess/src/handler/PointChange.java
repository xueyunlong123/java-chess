package handler;

import java.awt.*;
import java.util.List;
/**
 * Created by ${Xueyunlong} on 2016/4/18.
 */
public class PointChange {
    public static Point changePoint(Point point){
        point.x = (point.x*30 + 15);
        point.y = (point.y*30 + 15);
        return point;
    }
}
