package handler;

import Model.ChessBoard;
import Model.ChessPoint;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Created by ${Xueyunlong} on 2016/4/18.
 */


//1 黑，2 白，3 禁止落子，0 空
public class HandleChessBoard {
    static List<Point> list = new ArrayList<>();
    /*定义处理棋盘的函数，能够通过传入的棋盘来判断该棋盘哪方获得胜利
    * */
    public List handleChessBoard(ChessBoard chessBoard){
        //获取棋盘内存储棋盘状态的map
        HashMap map = chessBoard.getChessMap();
        //将map转换成数组
        int[][] s = new int[19][19];
        s = map2Array(map);
        for(int i=0;i<19;i++) {
            for (int j = 0; j < 19; j++) {
                System.out.print(s[j][i] + ",");
            }
            System.out.println("\n");
        }
        //得到提过子的数组，返回一个需要修改坐标的list
        List list  = handleArrray(s);
        //对提过子的棋盘进行重绘

        for(int i=0;i<19;i++) {
            for (int j = 0; j < 19; j++) {
                System.out.print(s[j][i] + ",");
            }
            System.out.println("\n");
        }
        //先进行判断输赢，否则将提过子的数组转换成map，并将map中移除的坐标的棋子移除（通过重绘：待议）
        return list;
    }
    /*
    *  将map转换成数组
    *  params：Map
    *  return:int[][]
    * */
    public int[][] map2Array(Map map){
        int[][] s = new int[19][19];
        //初始化棋盘数组，赋值为0，表示棋盘为空
        for(int i=0;i<19;i++)
            for(int j=0;j<19;j++)
                s[i][j]=0;
        //得到map中的key
        Set points = map.keySet();
        if(points != null) {
            Iterator iterator = points.iterator( );
            while(iterator.hasNext( )) {
                Object key1 = (String) iterator.next( );
                ChessPoint chessPoint = (ChessPoint) map.get(key1);
                String key = key1.toString();
                //将棋盘坐标转换成数组坐标
                //加上15除以30就行
                String[] strings = key.split(",");
                int x = (Integer.parseInt(strings[0])+15)/30;
                int y = (Integer.parseInt(strings[1])+15)/30;
                //通过坐标，将棋盘抽象为数组
                s[x-1][y-1] = chessPoint.getState();
            }
        }
        return s;
    }

    //对数组进行处理，返回需要修改坐标的list
    public List handleArrray(int[][] s) {

        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                // 先判断数组当前位置是否有棋子
                if (s[i][j] == 0 || s[i][j] == 3) continue;
                List list = f(s, i, j);
            }
        }
        return list;
    }
    //x，y当前棋子坐标
    public static List f(int a[][],int x,int y)
    {
        int cx[]={0,0,1,-1};
        int cy[]={1,-1,0,0};
        Point p = new Point(x,y);
        boolean[][] vis=new boolean [19][19];
        for(int i=0;i<19;i++)
            for(int j=0;j<19;j++)
                vis[i][j]=false;
        //将棋子坐标放入队列中
        Queue<Point> queue = new LinkedList<Point>();
        queue.offer(p);
        //vis[][]：true标识当前位置已被遍历过
        vis[x][y]=true;
        boolean flag=false;
        while((p=queue.poll())!=null){
            //得到当前棋子的上下左右各个位置
            for(int i=0;i<4;i++){

                int xx=p.x+cx[i];
                int yy=p.y+cy[i];
                //超出棋盘界限时，跳出当前循环
                if(xx<0||xx>=19||yy<0||yy>=19) continue;
                //已被遍历，跳出当前循环
                if(vis[xx][yy]) continue;
                //当前位置为空，不能落子，或者与原子颜色不同，跳出循环
                if(a[xx][yy]!=0&&a[xx][yy]!=3&&a[xx][yy]!=a[x][y]) continue;
                //修改vis[][]。标识当前位置遍历
                if(a[xx][yy]==0||a[xx][yy]==3) {
                    flag=true;
                    continue;
                }
                //当前位置与原子颜色相同，新建棋子坐标，修改标识位，并放进队列中
                Point q = new Point(xx,yy);
                vis[xx][yy]=true;
                queue.offer(q);
            }
        }
        if(!flag)
        {
            Point pp = new Point(x,y);
            Point temp = new Point();
            queue.offer(pp);
            int mark=a[x][y];
            a[x][y]=3;
            temp.x = x;temp.y = y;
            //将原子加入列表中
            list.add(temp);
            while((p=queue.poll())!=null){
                for(int i=0;i<4;i++){
                    int xx=p.x+cx[i];
                    int yy=p.y+cy[i];
                    if(xx<0||xx>=19||yy<0||yy>=19) continue;
                    if(a[xx][yy]!=mark) continue;
                    Point q = new Point(xx,yy);
                    queue.offer(q);
                    a[xx][yy]=3;
                    temp.x = xx;
                    temp.y = yy;
                    //将原子连通的所有子加入到list中
                    list.add(temp);
                }
            }
        }
        return list;
    }
}
