package test;

/**
 * Created by ${Xueyunlong} on 2016/4/18.
 */

import java.awt.*;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;
public class HChessboardd {
    public static void main(String[] args)
    {
        //棋盘数组
        int [][]a=new int[19][19];
        //初始化棋盘数组
        Scanner sc = new Scanner(System.in);
        for(int i=0;i<19;i++){
            for(int j=0;j<19;j++){
                a[i][j]=sc.nextInt();
            }
        }
        //处理棋盘数组
        solve(a, 0, 0);
        for(int i=0;i<19;i++){
            for(int j=0;j<19;j++){
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void solve(int a[][],int x,int y)
    {
        for(int i=0;i<19;i++){
            for(int j=0;j<19;j++) {
                if (a[i][j] == 0 || a[i][j] == 2) continue;
                f(a, i, j);
            }
        }
    }
    public static void f(int a[][],int x,int y)
    {
        int cx[]={0,0,1,-1};
        int cy[]={1,-1,0,0};
        Point p = new Point(x,y);
        boolean [][]vis=new boolean [19][19];
        for(int i=0;i<19;i++)
            for(int j=0;j<19;j++)
                vis[i][j]=false;
        Queue<Point> queue = new LinkedList<Point>();
        queue.offer(p);
        vis[x][y]=true;
        boolean flag=false;
        while((p=queue.poll())!=null){
            //得到当前棋子的上下左右各个位置
            for(int i=0;i<4;i++){

                int xx=p.x+cx[i];
                int yy=p.y+cy[i];
                if(xx<0||xx>=19||yy<0||yy>=19) continue;
                if(vis[xx][yy]) continue;
                if(a[xx][yy]!=0&&a[xx][yy]!=2&&a[xx][yy]!=a[x][y]) continue;
                if(a[xx][yy]==0||a[xx][yy]==2) {
                    flag=true;continue;
                }
                Point q = new Point(xx,yy);
                vis[xx][yy]=true;
                queue.offer(q);
            }
        }
        if(!flag)
        {
            Point pp = new Point(x,y);
            queue.offer(pp);
            int mark=a[x][y];
            a[x][y]=2;
            while((p=queue.poll())!=null){
                for(int i=0;i<4;i++){
                    int xx=p.x+cx[i];
                    int yy=p.y+cy[i];
                    if(xx<0||xx>=19||yy<0||yy>=19) continue;
                    if(a[xx][yy]!=mark) continue;
                    Point q = new Point(xx,yy);
                    queue.offer(q);
                    a[xx][yy]=2;
                }
            }
        }
    }
}
